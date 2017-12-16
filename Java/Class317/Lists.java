package Class317;

import java.util.*;
import java.math.*;

public class Lists {

	public static void main (String[] args){
		
		List<Integer> Left = new ArrayList<Integer>();
		List<Integer> Right = new ArrayList<Integer>();
		
		int[] nums = new int[10];
		for (int i = 0; i < (nums.length); i++){
			nums[i] = (int) (Math.random()*10);
		}
		
		for (int j = 0; j < nums.length; j++){
			System.out.print(nums[j] + " ");
		}
		
		int pivot = nums[(nums.length - 1)/2];
		
		for (int i = 0; i < nums.length; i++){
			if (nums[i] >= pivot)
				Right.add(nums[i]);
			if (nums[i] < pivot)
				Left.add(nums[i]);
		}
		
		System.out.print("\nPivot: " + pivot);
		System.out.println("\n" + Right);
		
	}
	
}
