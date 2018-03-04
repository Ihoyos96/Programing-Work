package MoreExercises;

public class StringRunLengthCompression {
	
	public static void main(String[] args) {
		
		String word = "hhhhhhhhhhhhhhccccccccccccccccccjjjkkkkkkkkkkkkkkkkg";
		String encoded = encode(word);
		System.out.println(encoded);
		System.out.println(decode(encoded));
		
		char x = '9';
		int num = x - '0';
		System.out.println(num);
		
		
		
	}
	
	static String encode(String s) {
		StringBuilder sb = new StringBuilder();
		char[] word = s.toCharArray();
		char current = word[0];
		int index = 0;
		int count = 0;
		for (char c : word) {
			if (c == current) {
				count++;
				index++;
				
				if (index == word.length)
					sb.append(current + Integer.toString(count));
				}
			
				else {
					sb.append(current + Integer.toString(count));
					count = 1;
					current = c;
					index++;
					if (index == word.length)
						sb.append(current + Integer.toString(count));
				}
		}
		return sb.toString();
	}
	
	static String decode(String encoded){

		StringBuilder sb = new StringBuilder();
		StringBuilder sbNum = new StringBuilder();
		char[] array = encoded.toCharArray();
		int index = 0;
		boolean lastWasNum = false;
		char current = array[0];
		// c - '0' > 9
		for (char c : array) {
			if (c - '0' > 9) {// is a letter
				if (lastWasNum == true) {
					int reps = Integer.valueOf(sbNum.toString());
					for(int i = 0; i < reps; i ++) { sb.append(current); }
					sbNum = new StringBuilder();
				}
				current = c;
				lastWasNum = false;
				index++;
			}
			else if ( c - '0' >= 0 && c - '0' <= 9){// is an integer
				if (index == array.length - 1) {
					sbNum.append(c);
					int reps = Integer.valueOf(sbNum.toString());
					for(int i = 0; i < reps; i ++) { sb.append(current); }
					break;
				}
					sbNum.append(c);
					lastWasNum = true;
					index++;
			}
		}
		return sb.toString();
	}
	
}
