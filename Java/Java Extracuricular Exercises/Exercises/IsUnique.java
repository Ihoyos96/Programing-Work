package Exercises;

import java.util.HashSet;

public class IsUnique {

	public static boolean isUnique(String s) {
		HashSet<Character> set = new HashSet<Character>();
		char[] word = new char[s.length()];
		word = s.toCharArray();
		
		for( char c : word) {
			if (!(set.contains(c))) {
				set.add(c);
				continue;
			}
			return false;
		}
		
		return true;
		
	}
	
  
	public static void main(String[] args) {

		String s = "acdag";
		System.out.print(isUnique(s));
	}
}