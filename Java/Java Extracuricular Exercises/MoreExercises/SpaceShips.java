package MoreExercises;

import java.util.*;

class SpaceShips {
	
	public static void main(String[] args) {
		
		int[] a = {4, 5, 2, 9};
		
		System.out.println(beautifulSubarrays(a, 1));
	}
	
	public static long beautifulSubarrays(int[] a, int m) {
	        if (m == 0)
	            return 0;
	        
	        long barrays = 0;
	        for (int i = 0; i < a.length; i ++){
	            int oddsL = 0;
	            for (int j = i; j < a.length; j ++){
	                if (a[j] % 2 == 1)
	                    oddsL++;
	            }
	            if (oddsL == m)
	                barrays++;
	        }
	        
	        for (int x = a.length; x > 0; x--){
	            int oddsR = 0;
	            for(int y = 0; y < x; y++){
	                if (a[y] % 2 == 1)
	                    oddsR++;
	            }
	            if (oddsR == m)
	                barrays++;
	        }
	        
	        int n = a.length - 1;
	        	int k = 1;
	        while(n != k) {
	        		int oddsM = 0;
	        		for(int start = k; start < n; start++) {
	        			if (a[start] % 2 == 1) {
	        				oddsM++;
	        			}
	        		}
	        		 if (oddsM == m)
	 	                barrays++;
	        		 k++;
	        		 
	        		 for(int start = k; start < n; start++) {
		        			if (a[start] % 2 == 1) {
		        				oddsM++;
		        			}
		        		}
		        		 if (oddsM == m)
		 	                barrays++;
		        	n--;
	        		 
	        		 
	        		 
	        		 
	        }
	        return barrays;
	    }
}