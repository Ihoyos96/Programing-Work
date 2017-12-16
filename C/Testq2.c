#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void){
  int i1 = 27;
  int i2 = 29;

 if(i1++ >= --i2){
   i1++;
 }
 else{
   printf("%d %d", i1, i2);
 }

 printf("%d %d", i1, i2); 

 return(0);
}
