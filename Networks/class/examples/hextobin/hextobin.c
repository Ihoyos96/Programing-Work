#include<stdlib.h>
#include<stdio.h>

int main(int argc, char * argv[]) {

	unsigned int ui ;
	sscanf("1f", "%x", &ui) ;
	printf("%d %x\n", ui, ui ) ;
	sscanf("ef", "%x", &ui) ;
	printf("%d %x\n", ui, ui ) ;
	sscanf("01", "%x", &ui) ;
	printf("%d %x\n", ui, ui) ;
	// 
	sscanf("1234", "%4x", &ui ) ;
	printf("%d %4x\n", ui, ui ) ;
	sscanf("1234abcd", "%8x", &ui ) ;
	printf("%d %8x\n", ui, ui ) ;
	return 0 ;
}

