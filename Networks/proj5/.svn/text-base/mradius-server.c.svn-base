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

#include "mradius.h"


int mradius_server( struct Params * params, Node * ll_pwds ) {
	int sockfd;
	struct sockaddr_in my_addr;
	struct sockaddr_in their_addr;

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
		password = strndup(radius->attributes + length + 8, 16);

		user = find_node(ll_pwds, username);
		if(user == NULL) {
			printf("user does not exist\n");
			code = 3;
		} else {
			unsigned char result[16];
			unsigned char password2[16];
			int i;

			MD5_Init(&context);
			MD5_Update(&context, params->shared_key, strlen(params->shared_key));
			MD5_Update(&context, radius->authenticator, 16);
			MD5_Final(result, &context);

			MD5_Init(&context);
			MD5_Update(&context, user->pass, strlen(user->pass));
			MD5_Final(password2, &context);

			for(i = 0; i < 16; i++) {
				result[i] = result[i] ^ password2[i];
			}

			if(memcmp(password, result, 16) != 0) {
				printf("passwords do not match\n");
				code = 3;
			}
		}

		MD5_Init(&context);
		MD5_Update(&context, radius, numbytes);
		MD5_Update(&context, params->shared_key, strlen(params->shared_key));
		MD5_Final(radius->authenticator, &context);

		*((short *)radius->code) = htons(code);

		if((bytes_sent=sendto(sockfd, radius, numbytes, 0,
			(struct sockaddr *)&their_addr, sizeof(struct sockaddr)) ) == -1) {
			perror("sendto");
			exit(1);
		}

	}

	return 0 ; 
}
