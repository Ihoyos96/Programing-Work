package Exercises;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalancedBracketsEfficient {
    
	
    public static boolean isBalanced(String expression) {
        Deque<Character> stack = new ArrayDeque<Character>();
        char[] brackets = new char[expression.length()];
        brackets = expression.toCharArray();
        
        for (char c : brackets) {
        		if ( c == '(') stack.push(')');
        		else if ( c == '[') stack.push(']');
        		else if ( c == '{') stack.push('}');
        		else {
        			if (stack.isEmpty() || c != stack.peek())
        				return false;
        			stack.pop();
        		}
        }
        return stack.isEmpty();
    }
  
    public static void main(String[] args) {
    
    	String br = "({[{}]})()";
    	if (isBalanced(br) == true)
    		System.out.println("Balanced");
    	else
    		System.out.println("Unbalanced");
    }
}
