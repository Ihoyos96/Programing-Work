package Exercises;

import java.util.*;
import java.util.regex.*;

public class CB {
	
    public static void main(String[] args) {
    	
    		System.out.println(minNum(20, 21, 11));
    	
        Scanner sc = new Scanner(System.in);
        Pattern multipleLineComment = Pattern.compile("((?s)\\/\\*.*?\\*\\/|(?-s)\\/\\/.*)");
        
        StringBuilder input = new StringBuilder();
        while (sc.hasNextLine()){
            input.append(sc.nextLine().trim());
            input.append("\n");
        }
        Matcher m1 = multipleLineComment.matcher(input.toString());
        while (m1.find())
            System.out.println(m1.group(1));
    }
	
	
	public static int minNum(int A, int K, int P) {
	        
	        int days = 0;
	         
	        if (P == 0 && K > A)
	        		return 1;
	        
	        days = P/(K - A) + 1;
	        
	        return days;
    }



}
