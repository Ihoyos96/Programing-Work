package MoreExercises;

public class SpiralMatrix {
	
	public static void main(String[] args) {
		int[][] matrix = {	{1,    2,   3,  4,    5},
							{6,    7,   8,  9,   10},
							{11,  12,  13,  14,  15},
							{16,  17,  18,  19,  20}};
		
		spiralCopy(matrix);
	}

	static void spiralCopy(int[][] inputMatrix) {
	    // your code goes here
	    
	    int rows = inputMatrix.length;
	    int cols = inputMatrix[0].length;
	    
	    
	    int indexi = 0;
	    int indexj = 0;
	    
	    int seen = 0;
	    int nodesSeen = 0;
	    
	    while(nodesSeen < (rows*cols) ){
	    
	      for (int i = seen; i < cols; i++){
	        System.out.print(inputMatrix[indexj][i] + ", ");
	        indexi++;
	      }
	      	indexi--;
	      for (int j = indexj + 1; j < rows; j++){
	        System.out.print(inputMatrix[j][indexi] + ", ");
	        indexj++;
	      }
	      indexi--;

	      for (int k = indexi; k >= seen; k--){
	        System.out.print(inputMatrix[indexj][k] + ", ");
	        indexi--;
	      }
	      indexi++;
	      indexj--;

	      for (int l = indexj; l > seen; l--){
	        System.out.print(inputMatrix[l][indexi] + ", ");
	        indexj--;
	      }
	      indexj++;

	      rows--;
	      cols--;
	      seen++;
	    }
	    
	  }
}
