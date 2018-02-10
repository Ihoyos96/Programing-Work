package Exercises;
import java.util.*;

public class EiminationsNeeded {

	public static int numberNeeded(String first, String second) {
        int eliminations = 0;
        int[] letters = new int[26];
        for(char c1 : first.toCharArray()) letters[c1 - 'a']++;
        for(char c2 : second.toCharArray()) letters[c2 - 'a']--;
        for(int val : letters) eliminations += Math.abs(val);
        return eliminations;
    }
  
	public static void main(String[] args) {
		String a = "bhcdjk";
        String b = "aacdgg";
        System.out.println(numberNeeded(a, b));
	}
}
