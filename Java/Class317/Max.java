package Class317;

import java.util.*;
import java.io.*;

public class Max {
	
	public static void main (String[] args){
		
		int numbers[] = {3, 4, 13, 55, 19, 2, 27, 7, 90, 117, 52, 34, 3, 9, 13};
		
		int max = numbers[0];
		
		for(int i = 1; i < numbers.length; i++){
			if (max < numbers[i]){
				max = numbers[i];
			}
		}
		
		System.out.print(max);
				
	}

}
