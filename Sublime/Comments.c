#include <stdio.h>
#include <stdlib.h>

//CONSTANT DEFINITIONS--------                                                                                  
#define SIGN(x)  ((x) & 01)
#define ONES(y)((1<<(y))-1)
#define BITACTIVE(x,n) SIGN(x >> n)
#define ALLACTIVE(x,y,z) ((((x) >> y) & ONES(z-(y)+1)) == ONES(z-(y)+1))

//MAIN FUNCTION---------------                                                                                  
int main (void) {
  unsigned int i;
  unsigned int bit;
  unsigned int start;
  unsigned int end;

  //---Friendly Message----                                                                                     
  printf("This program will prompt you three times for integer and bit inputs.\n");

  //---First Prompt-----                                                                                        
  printf("Enter an integer : ");

  scanf("%ud", &i);

  printf("%u is %s\n", i, (SIGN(i) ? "Odd" : "Even"));

  //---Second Prompt----                                                                                        
  printf("Enter an integer and a bit number to check : ");

  scanf("%u %d", &i, &bit);

  printf("%u has bit %d %s\n", i, bit, (BITACTIVE(i, bit) ? "On" : "Off"));

  //---Third Prompt-----                                                                                        
  printf("Enter an integer and bits for its start and end : ");

  scanf("%u %u %u", &i, &start, &end);

  printf("%u has %s those bits on\n", i, (ALLACTIVE(i, start, end) ? "all of" : "none of"));

  return 0;
}


