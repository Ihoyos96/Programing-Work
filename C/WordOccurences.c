#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void){
  
  char haystack[] = "The world is yours, it is not mine.";
  char needle[] = "is";
  char* source = haystack;
  char* target;

  while((target=strstr(source, needle)) != NULL){
    
    if(target == NULL){
      break;
    }
    int targetIndex = target - source;
    int targetSegment = strlen(needle);

    //printf("%d\n", targetSegment);
    //printf("%d\n", targetIndex);
    
    int i;
    for(i = 1; i<=targetSegment; i++){
      //free(&haystack[targetIndex + i]);
      //&haystack[targetIndex + i] = malloc(sizeof(char));
      strcpy(&haystack[targetIndex + i], "x");
    }
    printf("%s", haystack);
  }

  // printf("\n");
  //printf("%d\n", targetIndex);

  return(0);

}
