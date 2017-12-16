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


	numbytes = 48 + strlen(params->username);
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
	*((short *)(radius->attributes + 2)) = htons(strlen(params->username));
	strcpy(radius->attributes + 4, params->username);

	*((short *)(radius->attributes + strlen(params->username) + 4)) = htons(2);
	*((short *)(radius->attributes + strlen(params->username) + 6)) = htons(16);

	MD5_Init(&context);
	MD5_Update(&context, params->shared_key, strlen(params->shared_key));
	MD5_Update(&context, radius->authenticator, 16);
	MD5_Final(result, &context);


	MD5_Init(&context);
	MD5_Update(&context, params->password, strlen(params->password));
	MD5_Final(password, &context);

	for(i = 0; i < 16; i ++) {
		(radius->attributes + strlen(params->username) + 8)[i] = password[i] ^ result[i];
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

	if(memcmp(result, radius->authenticator, 16) == 0 && ntohs(*((short *)radius->code)) == 2) {
		printf("YES\n");
	} else {
		printf("NO\n");
	}

	return 0 ; 
}
