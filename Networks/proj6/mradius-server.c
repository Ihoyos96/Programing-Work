/*
** name: mradius-server
**
** author: 
** created: 30 mar 2017
** last modified:
**
*/

#include<stdio.h>
#include<stdlib.h>
#include<errno.h>
#include<string.h>
#include<fcntl.h>
#include<sys/types.h>
#include<sys/socket.h>
#include<netinet/in.h>
#include<arpa/inet.h>
#include<netdb.h>
#include<assert.h>
#include<unistd.h>
#include<openssl/md5.h>
#include<openssl/sha.h>

#include "mradius.h"


int mradius_server( struct Params * params ) {
	int sockfd;
	struct sockaddr_in my_addr;
	struct sockaddr_in their_addr;
	Node * ll_pwds = parse_pwfile(params->pwfile);

	if((sockfd = socket(AF_INET, SOCK_DGRAM, 0)) == -1) {
		perror("socket");
		exit(1);
	}

	my_addr.sin_family = AF_INET;
	my_addr.sin_port = htons((short)params->port);
	my_addr.sin_addr.s_addr = INADDR_ANY;
	memset(&(my_addr.sin_zero), '\0', 8);

	if(bind(sockfd, (struct sockaddr *)&my_addr,
		sizeof(struct sockaddr)) == -1) {
		perror("bind");
		exit(1);
	}

	while(1) {
		MD5_CTX context;
		Node * user;
		RadiusPacket * radius;
		char buf[MAXMSGLEN];
		unsigned int addr_len;
		char * username;
		int length;
		char * password;
		int code = 2;
		int numbytes;
		int bytes_sent;

		addr_len = sizeof(struct sockaddr);
		if((numbytes = recvfrom(sockfd, buf, MAXMSGLEN - 1, 0,
				(struct sockaddr *)&their_addr, &addr_len)) == -1 ) {
			perror("recvfrom");
			exit(1);
		}
		buf[numbytes] = '\0';

		radius = (RadiusPacket *)buf;

		length = ntohs(*((short *)(radius->attributes + 2)));
		username = strndup(radius->attributes + 4,length);
		user = find_node(ll_pwds, username);

		password = strndup(radius->attributes + length + 8, 16);

		if(user == NULL) {
			printf("user does not exist\n");
			code = 3;
		} else if(numbytes == strlen(username) + 28){
			//otp round 1
			RadiusPacket *new_radius;
			
			// add challenge attribute
			new_radius = malloc(numbytes + 44);
			memcpy(new_radius, radius, numbytes);

			MD5_Init(&context);
			MD5_Update(&context, radius, numbytes);
			MD5_Update(&context, params->shared_key, strlen(params->shared_key));
			MD5_Final((unsigned char *)new_radius->authenticator, &context);
			
			radius = new_radius;

			*((short *)((char *)radius + numbytes)) = htons(RFC2865_ATT_U_REPL);
			*((short *)((char *)radius + numbytes + 2)) = htons(40);
			strncpy((char *)radius + numbytes + 4, user->pass, 40);
			
			// update code and length
			code = RFC2865_ACC_CHA;
			numbytes += 44;



		} else if(numbytes == strlen(username) + 108){
			// otp round 2
			char * password;
			unsigned char new_pass[SHA_DIGEST_LENGTH];
			unsigned char sha_pass[SHA_DIGEST_LENGTH];
			unsigned char old_pass[SHA_DIGEST_LENGTH];
			char buffer[32];
			char old_auth[16];
			int i;

			memcpy(old_auth, radius->authenticator, 16);

			MD5_Init(&context);
			MD5_Update(&context, params->shared_key, strlen(params->shared_key));
			MD5_Update(&context, radius, numbytes);
			MD5_Final((unsigned char *)radius->authenticator, &context);



			password = strndup((char*)radius + 76 + strlen(username), 32);

			MD5_Init(&context);
			MD5_Update(&context, params->shared_key, strlen(params->shared_key));
			MD5_Update(&context, password, 16);
			MD5_Final((unsigned char *)buffer + 16, &context);

			for(i = 16; i <  32 ; i++) {
				buffer[i] ^= password[i]; 
			}

			MD5_Init(&context);
			MD5_Update(&context, params->shared_key, strlen(params->shared_key));
			MD5_Update(&context, old_auth, 16);
			MD5_Final((unsigned char *)buffer, &context);

			for(i = 0; i < 16; i++) {
				buffer[i] ^= password[i];
			}

			memcpy(new_pass, buffer, 20);	

        	SHA1(new_pass, SHA_DIGEST_LENGTH, sha_pass);
			for(i = 0; i < SHA_DIGEST_LENGTH; i++) {
				sscanf((const char *)user->pass + (i * 2), "%02x", (unsigned int *)&old_pass[i]);
			}

			if(memcmp(sha_pass, old_pass, SHA_DIGEST_LENGTH) != 0) {
				code = RFC2865_ACC_REJ;
			} else {
				unsigned char buf[40];
				code = RFC2865_ACC_ACC;
				for(i = 0; i < SHA_DIGEST_LENGTH; i++) {
					sprintf ((char *)buf + (i * 2), "%02x", new_pass[i]);
				}
				user->pass = strndup((const char *)buf, 40);
			}

		} else if(numbytes == strlen(username) + 48) {
			//regular
			unsigned char result[16];
			unsigned char password2[16];
			int i;



			MD5_Init(&context);
			MD5_Update(&context, params->shared_key, strlen(params->shared_key));
			MD5_Update(&context, radius->authenticator, 16);
			MD5_Final(result, &context);

			MD5_Init(&context);
			MD5_Update(&context, radius, numbytes);
			MD5_Update(&context, params->shared_key, strlen(params->shared_key));
			MD5_Final(radius->authenticator, &context);

			MD5_Init(&context);
			MD5_Update(&context, user->pass, strlen(user->pass));
			MD5_Final(password2, &context);

			for(i = 0; i < 16; i++) {
				result[i] = result[i] ^ password2[i];
			}

			if(memcmp(password, result, 16) != 0) {
				code = 3;
			}
		} else {
			code = RFC2865_ACC_REJ;
		}

		*((short *)radius->code) = htons(code);
		*((int *)radius->length) = htonl(numbytes);

		if((bytes_sent=sendto(sockfd, radius, numbytes, 0,
			(struct sockaddr *)&their_addr, sizeof(struct sockaddr)) ) == -1) {
			perror("sendto");
			exit(1);
		}

	}

	return 0 ; 
}
