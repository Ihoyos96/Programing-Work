package Exercises;
import java.util.*;

public class Arrays {
	
	
	
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
	
	public static void main(String[] args) {
		
		String[] wordArrayOne = {"hello", "tiny", "world"};
		String[] wordArrayTwo = {"this", "dog", "good"};
		
		System.out.println(merge(wordArrayOne, wordArrayTwo));
		System.out.println(stringBuilder(wordArrayOne));

		
	}
}
