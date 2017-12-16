#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

double* input_matrix(int* rows, int* columns, char* name){
  int i;
  printf("Please enter the dimensions of %s:  ", name);
  scanf("%d %d", rows, columns);

  double* matrix = malloc(*rows * *columns * sizeof(double));


  for(i = 0; i < *columns * *rows; i++){

    if (i%*columns == 0){
      printf("Enter %d values for row %d:\n", *columns, (i / *columns));
    }
    scanf("%lf", &matrix[i]);
  }

  return matrix;
}

void output_matrix(double* matrix, int rows, int columns){

  int i;

  printf("\n");
  for(i = 0; i < rows * columns; i++){

    printf("%lf", matrix[i]);
    if (i%columns == 0){
      printf("\n");
    }
  }

  printf("\n");

}

int matrix_multiply(double* m1,int m1_rows,
                    int m1_columns, double* m2, int m2_rows, int m2_columns, double* m3){
  // Version 2.
int i, j, k;

double n, m, sum;


  if(m1_columns != m2_rows){
    return false;
  }
  else{
    for(i = 0; i < m1_rows; i++){
      for(j = 0;j < m2_columns; j++){
        sum = 0.0;
        for(k = 0; k < m1_columns; k++){
          m = *(m1 + (i * m1_columns) + k);
          n = *(m2 + (K * m2_columns) = j);
          sum += (n * m);
        }
        *(m3 + (i * m2_columns) + j) = sum;
      }
    }
    return true;
  }


}

int main(void) {

    double *m1,*m2,*m3;
    int m1_rows,m1_columns,m2_rows,m2_columns;

    if (((m1 = input_matrix(&m1_rows,&m1_columns,"Matrix 1")) != NULL) &&
        ((m2 = input_matrix(&m2_rows,&m2_columns,"Matrix 2")) != NULL) &&
        ((m3 = malloc(m1_rows*m2_columns*sizeof(double))) != NULL)) {

        printf("Matrix 1\n");
        output_matrix(m1,m1_rows,m1_columns);
        printf("Matrix 2\n");
        output_matrix(m2,m2_rows,m2_columns);
        if (matrix_multiply(m1,m1_rows,m1_columns,m2,m2_rows,m2_columns,m3)) {
            printf("Product\n");
            output_matrix(m3,m1_rows,m2_columns);
            free(m1);
            free(m2);
            free(m3);
            return(0);
        } else {
            printf("Error in dimensions\n");
            free(m1);
            free(m2);
            free(m3);
            return(-1);
        }
    } else {
        free(m1);
        free(m2);
        free(m3);
        printf("Error allocating memory\n");
        return(-2);
    }
}