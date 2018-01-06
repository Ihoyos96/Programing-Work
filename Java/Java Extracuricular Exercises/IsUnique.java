package Exercises;

public class IsUnique {

	public static boolean isUnique(String s) {
		int size = 25;
		Character[] letters = new Character[size];
		
		for(int i = 0;i < s.length(); i++) {
			Character letter = s.charAt(i);
			int index = letter.hashCode() % size;
			if (letters[index] == letter) {
				return false;
			}
			else {
				letters[index] = letter;
			}
		}
		return true;
	}
	
  
	public static void main(String[] args) {

		String s = "acdga";
		System.out.print(isUnique(s));
	}
}