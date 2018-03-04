package Exercises;
import java.util.*;

public class ArraysExercises {
	
	
	
	public static ArrayList<String> merge(String[] words, String[] more){
		ArrayList<String> sentence = new ArrayList<String>();
		for (String w : words) sentence.add(w);
		for (String w : more) sentence.add(w);
		return sentence;
	}
	
	//String Builder: without StringBuilder
	public static String stringBuilder(String [] words) {
		String s = "";
		for(String w : words) s = s + " " +  w;
		return s;
	}
	
	//String Builder: using StringBuilder
	public static String stringBuilderTwo(String[] words) {
		StringBuilder sentence = new StringBuilder();
		for (String w : words) sentence.append(w);
		return sentence.toString();
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
	
	public static void main(String[] args) {
		
	
		
		for (int i = 0; i < 10; i++) {
			if (i == 2)
				continue;
			System.out.print(i + " ");
		}
			
		String[] wordArrayOne = {"hello", "tiny", "world"};
		String[] wordArrayTwo = {"this", "dog", "good"};
		
		System.out.println(merge(wordArrayOne, wordArrayTwo));
		System.out.println(stringBuilder(wordArrayOne));
		
		
		char[] letters = {'a','a','d','b','f','c','b','b','c','c','c','c','c','c','c','c','c','c','f'};
		
		
		ArrayList<Character> cp = new ArrayList<Character>();
		int count = 1;
		System.out.println(letters.length);
		
		for (int i = 1; i < letters.length; i++) {
			if (letters[i - 1] == letters[i])
				count++;
			else {
				cp.add(letters[i - 1]);
				for (char c : Integer.toString(count).toCharArray())
					cp.add(c);
				count = 1;
			}
			if (i == letters.length - 1) {
				cp.add(letters[i]);
				for (char c : Integer.toString(count).toCharArray())
					cp.add(c);
			}
		}
		
		System.out.println(cp);
		
		////////////--------------//////////////
		// String Compression Approach
		
		ArrayList<Character> reps = new ArrayList<Character>();
		int[] alphabet = new int[26];
		for (char letter : letters) {alphabet[letter - 'a'] ++;}
		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i] > 0) {
				reps.add((char)(i + 'a'));
				for (char c : Integer.toString(alphabet[i]).toCharArray())
					reps.add(c);
			}
		}
		System.out.println(Arrays.toString(letters));
		System.out.println(reps);
		System.out.println();
		System.out.println();
		//---------------------------------//
		
		
		
		int index = 0;
		int limit = 0;
		int pr = 1;
		
		int[] nums = {2,3,4,5};
		int[] product = new int[nums.length];
		
		while (true) {
			if (index == nums.length)
				index = 0;
			if (index == limit) {
				limit++;
				index = limit + 1;
			}
				
				
			pr *= nums[index];
			index++;
		}
		
	}
}
