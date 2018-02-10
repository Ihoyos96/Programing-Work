package Exercises;

public class oneEditAway {
	public static void main(String[] args) {
		
		System.out.println(oneAway("pale", "pale"));
	}
	
	//Returns true if the two strings are one edit away or zero edits away.
	public static boolean oneAway(String s1, String s2) {
		if (s1.length() == s2.length()) {
			int differences = 0;
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) != s2.charAt(i))
					differences++;
			}
			return (differences == 1 || differences == 0);
		}
		
		
		if (s1.length() != s2.length()) {
			int[] letters = new int[26];
			char[] cs1 = s1.toCharArray();
			char[] cs2 = s2.toCharArray();
			int differences2 = 0;
			for (char letter : cs1) {letters[letter - 'a']++;}
			for (char letter : cs2) {letters[letter - 'a']--;}
			for (int letter : letters) {differences2 += Math.abs(letter);}
			
			return (differences2 == 1);
		}
		return false;		//Never reached, but necessary for function declaration.
	}
}


