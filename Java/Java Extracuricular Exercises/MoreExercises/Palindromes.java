package MoreExercises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Palindromes {
	
	public static void main(String[] args) {
		
		String s = "race car";
		String s2 = "Madam I'm Adam";
		String s3 = "Madam Im Adam";
		System.out.println(palindromes(s));
		System.out.println(palindromes(s2));
		System.out.println(palindromes(s3));
		
	}
	
	static List<String> palindromes(String s) {
		
		/**
		 * Returns a list of every possible palindromic substring in a string.
		 * 
		 * If there are duplicates of the same palindromic substring, only one
		 * instance of it will be added to the list.
		 * 
		 * Letter case does not play a factor as every string is 
		 * transformed to its lower case version for processing.
		 */
		
		HashSet<String> set = new HashSet<String>();
		ArrayList<String> list = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		
		// Stripping the string of spaces
		char[] word = s.toLowerCase().toCharArray();
		for (char letter : word) {
			if (letter == ' ')
				continue;
			sb.append(letter);
		}
		
		String original = sb.toString();
		word = original.toCharArray();
		
		for (int i = 0; i < word.length; i++) {
			for (int j = i + 2; j <= word.length; j++) {
				sb = new StringBuilder();
				String sub = original.substring(i, j);
				sb.append(sub);
				sb.reverse();
				String reversed = sb.toString(); // For debugging purposes //
				if (sub.equals(reversed)) {
					if(!(set.contains(sub))) {
						list.add(sub);
						set.add(sub);
					}
				}
			}
		}
		
		// Added to comply with returning the longest palindromic substring.
		String longest = "";
		for (String p : list) {
			if (p.length() > longest.length())
				longest = p;
		}
		System.out.println("Longest: " + longest);
		
		return list;
		
		
		
	}

}
