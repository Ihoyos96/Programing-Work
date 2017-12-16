#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

//-------------TypeDefinitions-------------------------------------------------        \
                                                                                        
typedef int* IntPointer;
typedef int FiveIntArray[5];
typedef int* FivePointerArray[5];

//-----------------------------------------------------------------------------        \
                                                                                        
int initialize(FiveIntArray fiveInts, FivePointerArray fivePoint){

  srand(getpid());

  int i;

  for (i = 0; i < 5; i++){
    fiveInts[i] = (rand() % 9);
    fivePoint[i] = &fiveInts[i];
  }

  return 0;
}

int sort(FiveIntArray A){
  int i;
  int sorted = 0;

  while (sorted == 0){
    sorted = 1;
    for (i = 0; i < 4; i++){
      if (A[i] > A[i+1]){
        int temp = A[i+1];
        A[i+1] = A[i];
        A[i] = temp;
        sorted = 0;
      }
    }
  }
  return 0;
}

int sortPointers(FivePointerArray A){
  int i;
  int sorted = 0;
  while (sorted == 0){
    sorted = 1;
    for (i = 0; i < 4; i++){
      if ((*A[i]) > *(A[i+1])){
        int *temp = A[i+1];
        A[i+1] = A[i];
        A[i] = temp;
        sorted = 0;
      }
    }
  }
  return 0;
}

int main(void) {

  FiveIntArray fiveInts;
  FivePointerArray fivePoint;
  initialize(fiveInts, fivePoint);

  int i;
  int j;
  int k;
  int l;

  printf("%s", "---- Initalized array of integers ----\n");
  for (j = 0; j < 5; j++){
    printf("%d", j);
    printf("%s", " : ");
    printf("%d", fiveInts[j]);
    printf("%s", "\n");
  }

  printf("%s", "---- Array of pointers ----\n");
  for (i = 0; i < 5; i++){
    printf("%d", i);
    printf("%s", " : ");
    printf("%d", *fivePoint[i]);
    printf("%s", "\n");
  }

  sort(fiveInts);
  sortPointers(fivePoint);

  printf("%s", "---- Sorted array of integers ---- \n");
  for (k = 0; k < 5; k++){
    printf("%d", k);
    printf("%s", " : ");
    printf("%d", fiveInts[k]);
    printf("%s", "\n");
  }

  printf("%s", "---- Sorted array of pointers ---- \n");
  for (l = 0; l < 5; l++){
    printf("%d", l);
    printf("%s", " : ");
    printf("%d", *fivePoint[l]);
    printf("%s", "\n");
  }

  return(EXIT_SUCCESS);
}