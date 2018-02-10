package Exercises;

import java.util.ArrayList;

public class Bits {

	public static void main(String[] args) {
		
		int n = 43261596;
		System.out.println("00000010100101000001111010011100" + " :Original");
		System.out.println("00111001011110000010100101000000" + " :Reversed");

		String zeroes = "000000";
		String bin = Integer.toBinaryString(n);
		String newBin = String.join("", zeroes, bin);
		System.out.println();
		System.out.println(newBin + " :Test Original");
		
		StringBuilder bits = new StringBuilder();
		bits.append(newBin);
		bits.reverse();
		System.out.println(bits.toString() + " :Test Reversed");
		System.out.println();
		
		System.out.println(Integer.toBinaryString(n));
		System.out.println(reverseBits(43261596));
		
		
		
		// Eliminating every letter 'o' from a sentence and then reversing the sentence.
		// Some Practice in String manipulation
		System.out.println();
		String word = "Gonna go buy some berries!";
		System.out.println(word);
		char[] wordc = word.toCharArray();
		ArrayList<Character> newWord = new ArrayList<Character>();
		for (char c : wordc) {
			if (c != 'o') newWord.add(c);
		}
		
		StringBuilder sb = new StringBuilder();
		for (Character c : newWord) sb.append(c);
		System.out.println(sb.toString());
		sb.reverse();
		System.out.println(sb.toString());
		
		System.out.println();
	}
	
	public static int reverseBits(int n) {
		int result = 0;
		  for (int i = 0; i < 32; ++i) {
		    result = result<<1  | (n & 1);
		    n >>>= 1;
		  }
		return result;  
	}
}
