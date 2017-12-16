/*
** name: mradius-client
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


int mradius_client( struct Params * params ) {

	RadiusPacket * radius;

	int sockfd;
	int numbytes;
	int bytes_sent;
	struct sockaddr_in their_addr;
	struct hostent * he;
	char buf[MAXMSGLEN];
	unsigned int addr_len;
	MD5_CTX context;
	unsigned char result[16];
	unsigned char password[16];
	int i;

	if(params->otp) {

		numbytes = 28 + strlen(params->uname);
		radius = malloc(numbytes);

		*((short *)radius->code) = htons(1);
		*((long  *)radius->length) = htons(numbytes);

		if(params->no_randomness != 0) {
			*((short *)radius->indentifier) = htons(0);
			for(i = 0; i < 16; i++) {
				(radius->authenticator)[i] = htons(i + 1);
			}
		} else {
			FILE* fp;
			fp = fopen("/dev/urandom", "r");
			fread(radius->indentifier, sizeof(short), 1, fp);
			fread(radius->authenticator, sizeof(char), 16, fp);
			fclose(fp);
		}

		*((short *)radius->attributes) = htons(1);
		*((short *)(radius->attributes + 2)) = htons(strlen(params->uname));
		strcpy(radius->attributes + 4, params->uname);


		if((sockfd = socket(AF_INET, SOCK_DGRAM, 0)) == -1) {
			perror("socket");
			exit(1);
		}

		if((he = gethostbyname(params->host)) == NULL) {
			perror("gethostbyname");
			exit(1);
		}

		their_addr.sin_family = AF_INET;
		their_addr.sin_port = htons((short)params->port);
		their_addr.sin_addr = *((struct in_addr *)he->h_addr);
		memset(&(their_addr.sin_zero), '\0', 8);

		if((bytes_sent=sendto(sockfd, radius, numbytes, 0,
				(struct sockaddr *)&their_addr, sizeof(struct sockaddr)) ) == -1) {
			perror("sendto");
			exit(1);
		}

		MD5_Init(&context);
		MD5_Update(&context, radius, numbytes);
		MD5_Update(&context, params->shared_key, strlen(params->shared_key));
		MD5_Final(result, &context);

		if((numbytes = recvfrom(sockfd, buf, MAXMSGLEN - 1, 0,
				(struct sockaddr *)&their_addr, &addr_len)) == -1 ) {
			perror("recvfrom");
			exit(1);
		}

		buf[numbytes] = '\0';
		radius = (RadiusPacket *)buf;

		if(memcmp(result, radius->authenticator, 16) != 0) {
			printf("NO - mismatch\n");
			exit(EXIT_SUCCESS);
		}

		int offset, max;
		char *message;
		unsigned char old_password[SHA_DIGEST_LENGTH];
		unsigned char sha_buf[SHA_DIGEST_LENGTH] ;
		unsigned char *sha;
		RadiusPacket *reply;

		reply = malloc(numbytes + 4 + 2 * MD5_DIGEST_LENGTH);
		memcpy(reply, radius, numbytes);


		MD5_Init(&context);
		MD5_Update(&context, radius, bytes_sent);
		MD5_Update(&context, params->shared_key, strlen(params->shared_key));
		MD5_Final((unsigned char *)reply->authenticator, &context);

		*((short *)reply->code) = htons(RFC2865_ACC_REQ);
		*((int *)reply->length) = htonl(numbytes + 40);

		int i;

		// do send stuff
		message = strndup(reply->attributes + 8 + strlen(params->uname), 40);

		for(i = 0; i < 20; i++) {
			sscanf(message + (i * 2), "%02x", (unsigned int *)&old_password[i]) ;
		}

		max = 100000;
		sha = SHA1((unsigned char *) params->upass, strlen(params->upass), sha_buf) ;
		sha = SHA1( sha_buf, SHA_DIGEST_LENGTH, NULL ) ;
		while(memcmp(sha, old_password, SHA_DIGEST_LENGTH) != 0 && max > 0) {
			memcpy( sha_buf, sha, SHA_DIGEST_LENGTH ) ;
			sha = SHA1( sha_buf, SHA_DIGEST_LENGTH, NULL ) ;
			max--;
		}

		// sha_buf now contains i - 1 password
		*((short *)((char *)reply + numbytes)) = htons(RFC2865_ATT_U_PASS);
		*((short *)((char *)reply + numbytes + 2)) = htons(2 * MD5_DIGEST_LENGTH);
	
		char buffer[32];
		char md5hash[16];

		memset(&buffer, 0, 32);
		memcpy(buffer, sha_buf, 20);

		MD5_Init(&context);
		MD5_Update(&context, params->shared_key, strlen(params->shared_key));
		MD5_Update(&context, reply->authenticator, MD5_DIGEST_LENGTH);
		MD5_Final((unsigned char *)reply + numbytes + 4, &context);

		for(i = 0; i < MD5_DIGEST_LENGTH; i++) {
			((unsigned char *)reply + numbytes + 4)[i] ^= buffer[i]; 
		}

		MD5_Init(&context);
		MD5_Update(&context, params->shared_key, strlen(params->shared_key));
		MD5_Update(&context, ((unsigned char *)reply + numbytes + 4), MD5_DIGEST_LENGTH);
		MD5_Final((unsigned char *)reply + numbytes + 20, &context);

		for(i = 16; i <  32; i++) {
			((unsigned char *)reply + numbytes + 4)[i] ^= buffer[i]; 
		}

		if ((bytes_sent=sendto(sockfd, reply, numbytes + 4 + 2 * MD5_DIGEST_LENGTH, 0,
				(struct sockaddr *)&their_addr, sizeof(struct sockaddr)) ) == -1 ) {
			perror("sendto") ;
			exit(1) ;
		}

		MD5_Init(&context);
		MD5_Update(&context, params->shared_key, strlen(params->shared_key));
		MD5_Update(&context, reply, bytes_sent);
		MD5_Final(md5hash, &context);


		// wait for response
		if ((numbytes=recvfrom(sockfd, buf, MAXMSGLEN-1, 0,
				(struct sockaddr *)&their_addr, &addr_len)) == -1 ) {
			perror("recvfrom") ;
			exit(1) ;
		}

		buf[numbytes] = '\0';
		radius = (RadiusPacket *)buf;

		if (memcmp(radius->authenticator, md5hash, MD5_DIGEST_LENGTH) != 0) {
			printf("NO\n");
			exit(EXIT_SUCCESS);
		}

		if(ntohs(*(short *)radius->code) == RFC2865_ACC_ACC) {
			printf("YES\n");
			exit(EXIT_SUCCESS);
		}
		if(ntohs(*(short *)radius->code) == RFC2865_ACC_REJ) {
			printf("NO\n");
			exit(EXIT_SUCCESS);
		}

	} else {
		numbytes = 48 + strlen(params->uname);
		radius = malloc(numbytes);

		*((short *)radius->code) = htons(1);
		*((long  *)radius->length) = htons(numbytes);

		if(params->no_randomness != 0) {
			*((short *)radius->indentifier) = htons(0);
			for(i = 0; i < 16; i++) {
				(radius->authenticator)[i] = htons(i + 1);
			}
		} else {
			FILE* fp;
			fp = fopen("/dev/urandom", "r");
			fread(radius->indentifier, sizeof(short), 1, fp);
			fread(radius->authenticator, sizeof(char), 16, fp);
			fclose(fp);
		}


		*((short *)radius->attributes) = htons(1);
		*((short *)(radius->attributes + 2)) = htons(strlen(params->uname));
		strcpy(radius->attributes + 4, params->uname);

		*((short *)(radius->attributes + strlen(params->uname) + 4)) = htons(2);
		*((short *)(radius->attributes + strlen(params->uname) + 6)) = htons(16);

		MD5_Init(&context);
		MD5_Update(&context, params->shared_key, strlen(params->shared_key));
		MD5_Update(&context, radius->authenticator, 16);
		MD5_Final(result, &context);


		MD5_Init(&context);
		MD5_Update(&context, params->upass, strlen(params->upass));
		MD5_Final(password, &context);

		for(i = 0; i < 16; i ++) {
			(radius->attributes + strlen(params->uname) + 8)[i] = password[i] ^ result[i];
		}

		if((sockfd = socket(AF_INET, SOCK_DGRAM, 0)) == -1) {
			perror("socket");
			exit(1);
		}

		if((he = gethostbyname(params->host)) == NULL) {
			perror("gethostbyname");
			exit(1);
		}

		their_addr.sin_family = AF_INET;
		their_addr.sin_port = htons((short)params->port);
		their_addr.sin_addr = *((struct in_addr *)he->h_addr);
		memset(&(their_addr.sin_zero), '\0', 8);

		if((bytes_sent=sendto(sockfd, radius, numbytes, 0,
				(struct sockaddr *)&their_addr, sizeof(struct sockaddr)) ) == -1) {
			perror("sendto");
			exit(1);
		}

		MD5_Init(&context);
		MD5_Update(&context, radius, bytes_sent);
		MD5_Update(&context, params->shared_key, strlen(params->shared_key));
		MD5_Final(result, &context);


		if((numbytes = recvfrom(sockfd, buf, MAXMSGLEN - 1, 0,
				(struct sockaddr *)&their_addr, &addr_len)) == -1 ) {
			perror("recvfrom");
			exit(1);
		}

		buf[numbytes] = '\0';
		radius = (RadiusPacket *)buf;

		if(memcmp(result, radius->authenticator, 16) == 0 && ntohs(*((short *)radius->code)) == 2) {
			printf("YES\n");
		} else {
			printf("NO\n");
		}
	}

	return 0 ; 
}
