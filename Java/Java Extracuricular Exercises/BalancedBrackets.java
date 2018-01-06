package Exercises;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalancedBrackets {
    
	public static char next(char curr) {
		if (curr == '(')
			return (')');
		if (curr == '{')
			return ('}');
		if (curr == '[')
			return (']');
		return ' ';
	}
	
	public static boolean isOpen(char bracket) {
		if (bracket == '(' || bracket =='{' || bracket =='[') {
			return true;
		}
		return false;
	}
	
    public static boolean isBalanced(String expression) {
        Deque<Character> stack = new ArrayDeque<Character>();
        char[] brackets = new char[expression.length()];
        brackets = expression.toCharArray();
        
        for (int i = 0; i < expression.length(); i++) {
        		if (isOpen(brackets[i]) == true) {
        			stack.push(brackets[i]);
        			continue;
        		}
        		if (stack.isEmpty())
        			return false;
        		
        		if (brackets[i] == next(stack.peek())) {
        			stack.pop();
        		} 
        		else { return false; }
        }
        
        if (stack.peek() != null)
        		return false;
        
        return true;
        
    }
  
    public static void main(String[] args) {
        
    	String br = "({[{}]}))) {}";
    	if (isBalanced(br) == true)
    		System.out.println("Balanced");
    	else
    		System.out.println("Unbalanced");
    }
}
