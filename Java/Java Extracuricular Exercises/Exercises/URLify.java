package Exercises;

import java.util.StringJoiner;

public class URLify {

	public static void main(String[] args) {
		String s = "Home school place";
		System.out.println(urlify(s));
	}
	
	public static String urlify(String s) {
		StringJoiner url = new StringJoiner("%20");
		String[] words = s.split(" ");
		for (String word : words) {url.add(word);}
		return url.toString();
	}
}
