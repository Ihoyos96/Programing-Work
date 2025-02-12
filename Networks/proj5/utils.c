/*
** name: utils
**
** author: 
** created: 30 mar 2017
** last modified:
**
*/

#include<string.h>
#include<stdlib.h>
#include<stdio.h> 
#include <openssl/md5.h>

#include "mradius.h"

StringPair pa_parse(char * str, int sep) {
        StringPair sp ;
        char * p ;
        sp.first = str ;
        sp.rest = NULL ;
        p = strchr(str,sep) ;
        if (p) {
                *p = '\0' ;
                sp.rest = p+1 ;
        }
        return sp ;
}

Node * new_node( char * user, char * pass, Node * next ) {
	Node * n  ;
	// create a new node and fill out fields as given in argument
	n = malloc(sizeof(char *) * 2 + sizeof(Node *));
	n->user = strdup(user);
	n->pass = strdup(pass);
	n->next = next;
	return n ;
}

void print_nodes( Node * n ) {
	// print all the nodes
	while(n != NULL) {
		printf("%s:%s\n", n->user, n->pass);
		n = n->next;
	}
}

Node * find_node( Node * root, char * user ) {
	Node * n = NULL ;
	while(root != NULL) {
		if(strcmp(root->user, user) == 0) {
			return root;
		}
		root = root->next;
	}
	return n ; // NULL if user not found
}


#define SEP ": \n\t"
#define COMMENT_CHAR '#' 

Node * parse_pwfile( char * filename ) {
	Node * n = NULL ;
	FILE * f ; 
	char s[1024] ;
	char * u ;
	char * p ;

	if (! (f = fopen(filename, "r" )) ) {
		return NULL ;
	}
	
	while ( fgets( s, sizeof(s), f) ) {
	
		u = strtok(s,SEP) ;
		if ( !u ) continue ;
		if ( *u == COMMENT_CHAR ) continue ;
		p = strtok(NULL,SEP) ;
		if ( !p ) continue ;
		n = new_node( u, p, n ) ;
		if (g_verbose) {
			printf("%s:%d: adding (|%s|,|%s|) to linked list\n",__FILE__, __LINE__, u,p) ;
		}
	}
	
    fclose(f) ; 
    return n ; 
}



