package MoreExercises;

import java.util.*;

public class SentenceReverse {
	
	public static void main(String[] args) {
		
		char[] arr = {'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};
	
		String s = "hello";
		char c = 'c';
		String n = Character.toString(c);
		System.out.println(n);
		s = String.join("", s, n);
		System.out.println(s);
		
		System.out.println(reverseWords(arr));
	}

	static char[] reverseWords(char[] arr) {
	    // your code goes here
	    char[] reversed = new char[arr.length];
	    ArrayList<String> list = new ArrayList<String>();
	    StringBuilder sb = new StringBuilder();
	    if (arr.length == 0 || arr.length == 1)
	      return arr;
	    
	    for(int i = 0; i < arr.length; i++){
	      if (arr[i] == ' '){
	        list.add(sb.toString());
	        sb = new StringBuilder();
	        continue;
	      }
	      if (i == arr.length - 1){
	        sb.append(arr[i]);
	        list.add(sb.toString());
	        break;
	      }
	        
	      sb.append(arr[i]);
	    }
	    
	    //
	    // StringJoiner approach to reverse: much cleaner, more elegant.
	    //
	    
	    StringJoiner sj = new StringJoiner(" ");
	    for (int i = list.size() - 1; i >= 0; i--){sj.add(list.get(i));}
	    reversed = sj.toString().toCharArray();
	    
	    
	    /**
	    //Brute force approach to reversing the words and converting to char array
	    int count = 0;
	    for (int j = list.size() - 1; j >= 1; j--){
	      char[] word = list.get(j).toCharArray();
	      
	      for(int k = 0; k < word.length; k ++){
	        reversed[count] = word[k];
	        count ++;
	      }
	      reversed[count] = ' ';
	      count++;
	    }
	    
	    char[] word = list.get(0).toCharArray();
	    for(int k = 0; k < word.length; k ++){
	        reversed[count] = word[k];
	        count ++;
	      }
	    */
	    
	    return reversed;
	   
	  }
}
