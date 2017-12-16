#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void){

  char* array[10];

  printf("Enter 10 lines of text, seperate them by pressing enter.");
  array[0] =(int) malloc(sizeof(char));
  int i = 0;
  while((array[i]=getchar())!= NULL){
    *array[i] = (int *)realloc(array[i], sizeof(char));
    if (getchar() == '\n'){
      i++;
      continue;
    } 
  }
}
