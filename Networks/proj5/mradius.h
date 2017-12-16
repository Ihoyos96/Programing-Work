
#define USAGE_MESSAGE "usage: mradius [-vR -k key -p port] ( -h host user pwd | pwd-file )" 
#define DEFAULT_PORT  1812
#define DEFAULT_SHARED_KEY "pa55word0" 

#define MAXMSGLEN 1000

extern int g_verbose ;
extern int g_norandomness ;

typedef struct {
        char * first;
        char * rest ;
} StringPair ;

typedef struct Node {
	char * user ;
	char * pass ;
	struct Node * next ;
} Node ;

struct Params {
	char * host ;
	int port ;
	int no_randomness ;
	/* add more parameters here, if needed */
	char * username;
	char * password;
	char * shared_key;
} ;

typedef struct {
	char code[2];
	char indentifier[2];
	char length[4];
	char authenticator[16];
	char attributes[];
} RadiusPacket;

StringPair pa_parse(char * str, int sep) ;

Node * new_node( char * user, char * pass , Node * next ) ; 
Node * find_node( Node * root, char * user ) ;
Node * parse_pwfile( char * filename ) ;
void print_nodes( Node * n ) ;

int mradius_client( struct Params * params ) ;
int mradius_server( struct Params * params, Node * ll_pwds ) ;
