/*
** name: ttftp-server.c
**
** author: bjr
** created: 14 feb 2016 by bjr
** last modified:
**
** from extracted from ttftp.c
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

#include "ttftp.h"



int  ttftp_server( int listen_port, int is_noloop ) {

	int sockfd_l;
	int sockfd_s ;
	struct sockaddr_in my_addr;
	struct sockaddr_in their_addr;
	int block_count ;
	
	/*
	 * create a socket to listen for RRQ
	 */

	if ((sockfd_l=socket(AF_INET,SOCK_DGRAM,0))==-1) {
		perror("socket") ;
		exit(1) ;
	}
	
	my_addr.sin_family = AF_INET ;
	my_addr.sin_port = htons((short)listen_port) ;
	my_addr.sin_addr.s_addr = INADDR_ANY ;
	memset(&(my_addr.sin_zero),'\0',8) ;

	
	if (bind(sockfd_l, (struct sockaddr *)&my_addr, 
		sizeof(struct sockaddr)) == -1 ) {
		perror("bind") ;
		exit(1) ;
	}
	
	do {
		struct TftpReq* req;
		unsigned int addr_len ;
		int numbytes ;
		char buf[MAXMSGLEN];
		FILE* fp;
		struct timeval tv;
		fd_set rfds;
		int pid;

		/*
		 * for each RRQ 
		 */

		addr_len = sizeof(struct sockaddr) ;
		if ((numbytes=recvfrom(sockfd_l, buf, MAXMSGLEN-1,0,
			(struct sockaddr *)&their_addr, &addr_len)) == -1 ) {
			perror("recvfrom") ;
			exit(1) ;
		}

		pid = fork();

		if(pid == 0) {
			int tid;
			
			tid = ntohs(their_addr.sin_port);
			
			/*
			 * parse request and open file
			 */
			
			 req = (struct TftpReq*)buf;

			 fp = fopen(req->filename_and_mode, "r");



			/*
			 * create a sock for the data packets
			 */

			 if ((sockfd_s=socket(AF_INET,SOCK_DGRAM,0))==-1) {
				perror("socket") ;
				exit(1) ;
			}

			
			block_count = 1 ;
			while (block_count) { 
				struct TftpData* data;
				struct TftpAck* ack;
				int bytes_sent;
				int datalen;
				int retval;

				data = malloc(TFTP_DATALEN + 4);
				*((short *)data->opcode) = htons(TFTP_DATA);
				*((short *)data->block_num) = htons((short) block_count);

				/*
				 * read from file
				 */

				datalen = fread(data->data, 1, TFTP_DATALEN, fp);
				printf("datalen: %d", datalen);
				
				/*
				 * send data packet
				 */

				 FD_ZERO(&rfds);
				 FD_SET(sockfd_s, &rfds);

				 tv.tv_sec = 10;
				 tv.tv_usec = 0;

				 retval = 0;

				 do {
					if ((bytes_sent=sendto(sockfd_s, data, datalen + 4, 0,
							(struct sockaddr *)&their_addr, sizeof(struct sockaddr)) ) == -1 ) {
						perror("sendto") ;
						exit(1) ;
					}

					retval = select(40, &rfds, NULL, NULL, &tv);
				} while(retval == 0);

				free(data);

				/*
				 * wait for acknowledgement
				 */

				addr_len = sizeof(struct sockaddr) ;
				if ((numbytes=recvfrom(sockfd_s, buf, 4, 0,
						(struct sockaddr *)&their_addr, &addr_len)) == -1 ) {
					perror("recvfrom") ;
					exit(1) ;
				}

				ack = (struct TftpAck*) buf;

				 /* ERRORS */

				 if(ntohs(*((short*)ack->block_num)) != block_count) {

				 	//send error - incorect block num
				 	_exit(1);
				 }

				 if(ntohs(*((short*)ack->opcode)) != TFTP_ACK) {
				 	//send error - illegal opcode
				 	_exit(2);
				 }

				 if(ntohs(their_addr.sin_port) != tid) {
				 	//send error - non terminating
				 	block_count--;
				 }


					
				if(feof(fp)) {
					fclose(fp);
					close(sockfd_s);
					_exit(EXIT_SUCCESS);
				}

				block_count++ ;
			}

		}

	} while (!is_noloop) ;
	return 0 ;
}

