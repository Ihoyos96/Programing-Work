package Exercises;
import java.math.*;

public class checkPermutation {

	public static void main(String[] args) {
		
		String s1 = "garbage";
		String s2 = "garageb";
		System.out.println(isPermutation(s1, s2));
		System.out.println(isPermutation("elocastic", "staceloic"));
		System.out.println(isPermutation("arramaba", "carramba"));
	}
	
	public static boolean isPermutation(String s1, String s2) {
		
		char[] cs1 = s1.toCharArray();
		char[] cs2 = s2.toCharArray();
		int[] letters = new int[26];
		int letterCount = 0;
		
		for (char letter : cs1) {letters[letter - 'a'] ++;}
		for (char letter : cs2) {letters[letter - 'a'] --;}
		for (int letter : letters) {letterCount += Math.abs(letter);}
		
		return (letterCount == 0);
	}
	
}
