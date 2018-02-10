package MoreExercises;

public class UniquePaths2 {

	public static void main(String[] args) {
		
		int[][] map = new int[4][4];
		map[1][1] = 1;
		map[1][2] = 0;
		for(int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(uniquePaths(map));
		
	}
	
	public static int uniquePaths(int[][] map) {
		
		if(map.length == 0) return 0;
		if (map[0][0] == 1) return 0;
		
		int rows = map.length;
		int cols = map[0].length;
		
		for (int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				
				if (map[i][j] == 1) 
					map[i][j] = 0;
				else if (i == 0 && j == 0)
					map[i][j] = 1;
				else if (i == 0)
					map[i][j] = map[i][j - 1];
				else if (j == 0)
					map[i][j] = map[i - 1][j];
				else
					map[i][j] = map[i - 1][j] + map[i][j -1];
			}
		}
		return map[rows - 1][cols - 1];
		
	}
}
