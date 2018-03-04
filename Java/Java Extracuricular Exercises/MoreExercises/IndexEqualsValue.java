package MoreExercises;

public class IndexEqualsValue {
	
	public static void main(String[] args) {
		
		int[] arr = {0, 3};
		
		System.out.println(indexEqualsValueSearch(arr));
		
	}

	public static int indexEqualsValueSearch(int[] arr) {
	    // your code goes here
	    // O(n) brute force approach.
	    /**
	    for (int i = 0; i < arr.length; i++){
	      if (arr[i] == i)
	        return i;
	    }
	    return (-1);
	    **/
	    // if value is less than index: look at right side <- if match exists we haven't found it yet
		// if value is greater than index: look at left side
		int high = arr.length - 1;
	    int low = 0;

	    while (low <= high){
	      int mid = ((low + high)/2);

	      if (arr[mid] < mid)
	        low = mid + 1;
	      else if (arr[mid] > mid)
	        high = mid - 1;
	      else 
	        return mid;
	    }

	    return -1;
	  }
	
}
