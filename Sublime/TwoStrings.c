#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//-----------------------------------------------------------------------------                                 
#define STRING_LENGTH 200

typedef char String[STRING_LENGTH];
//-----------------------------------------------------------------------------                                 

int main(void) {

  String stringOne;
  String stringTwo;

  //if any letter in stringTwo is found in stringOne, it will be removed from stringOne.                        

  printf("Enter the first string:\n");
  scanf("%s",stringOne);

  printf("Enter the second string: \n");
  scanf("%s", stringTwo);

  int strOneLen = strlen(stringOne);
  int strTwoLen = strlen(stringTwo);

  char s1[strOneLen], s2[strTwoLen];

  strcpy(s1, stringOne);
  strcpy(s2, stringTwo);

  int inThere;

  for (int i=0; i<strOneLen; i++){
    for (int j=0; j<strTwoLen; j++){
      if (s1[i] == s2[j]){
        inThere = 1;
        break;
      }else{
        inThere = 0;
      }
    }
    if (inThere == 0){
      printf("%c", s1[i]);
        }
  }
  printf("%s","\n");

  return(EXIT_SUCCESS);
}
