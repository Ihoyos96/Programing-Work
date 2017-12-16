#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

//-----------Definitions--------------//                                                                  

#define ARRAY_LENGTH 16
#define MATRIX_DIMENSION 4

//--------------------------------//                                                                  

typedef char matrix[MATRIX_DIMENSION][MATRIX_DIMENSION];


int main(void){

	int i, j;
	int index = 0;
	int array_counter;
	char input[ARRAY_LENGTH];
	matrix islands;

  	printf("Enter a 4x4 Row-by-Row Island Matrix : ");
  	scanf("%s", input);

  	for(i = 0; i <= 3; i++){
  		array_counter = i;

  		for(j = 0; j <= 3; j++){

  		islands[array_counter][j] = input[index];
  		index++;

  		}
  	}


  oneDegree(matrix)

}

int oneDegree(char matrix[]){

	int i, j;

	 for(i = 0; i <= 3; i++){
  		

  		for(j = 0; j <= 3; j++){
  			if(strcmp(matrix[i][j], "L")){
  				//how to store a matrix position into a group to cross check with other positions....   ?
  			}

  		}
  	}
}




