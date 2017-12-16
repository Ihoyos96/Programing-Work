package Class317;
import java.util.*;
import java.io.*;
import java.io.*
;public class Solution {
	
	public static void main (String[] args){
		
		String g = " a    ba    ";
		
		System.out.print(reverseWords(g));
	}
	
	public static String reverseWords(String s){
		//If I did not know the length of the string (i.e. the amount of words)
		//then I'd make a function increaseSize() to dynamically increase the 
		//size of the array as I see new words. Easy fix implemented, parses
		//string once to identify how many words in the string (size of words array).
		
		//Normalize the string
		s = s.replaceAll("\\s+"," ");
		//--------------------
		
		//Identifies the amount of words in the string------
		int size = 0;
		for(int k = 0; k <= s.length(); k++){
			if(k == s.length() || s.charAt(k) == ' ')
				size++;
		}
		//--------------------------------------------------
		
		
		//Initialize variables
		String[] words = new String[size];
		String reversedString = "";
		String emptyString = "";
		String word = "";
		int counter = 0;
		char delimiter = ' ';
		//--------------------
		
		//parse string and put each word seen into words array.
		for(int i = 0; i <= s.length(); i++){
			if (i == s.length() || s.charAt(i) == delimiter){
				words[counter] = word;
				word = "";
				counter++;
			}
			else{
			word+= s.charAt(i);
			}
		}
		//------------------------------------------------------
		
		/*
		for (int j = 0; j < words.length; j++){
			reversedWord += (words[j] + " ");
		}
		*/
		
		//check for empty string
		if(s.length() == 0 || s == " "){
		    return (emptyString.trim());
		}
		else{
    		for (int j = words.length - 1; j >= 0; j--){
    			reversedString += (words[j] + " ");
    		}
		}
		
		return (reversedString.trim());
        
    }
}