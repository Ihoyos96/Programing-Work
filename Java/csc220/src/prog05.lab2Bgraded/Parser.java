package prog05;

import java.util.Stack;
import java.util.EmptyStackException;
import java.util.Scanner;
import prog02.UserInterface;
import prog02.GUI;

public class Parser {
  static final String OPERATORS = "()+-*/^";
  static final int[] PRECEDENCE = { -1, -1, 1, 1, 2, 2, 3 };
  String input = null;
  int index = 0;
  Stack<Character> operatorStack = new Stack<Character>();
  Stack<Double> numberStack = new Stack<Double>();
  static UserInterface ui = new GUI();

  boolean atEndOfInput () {
    while (index < input.length() &&
           Character.isWhitespace(input.charAt(index)))
      index++;
    return index == input.length();
  }

  boolean isNumber () {
    return Character.isDigit(input.charAt(index));
  }

  double getNumber () {
    int index2 = index;
    while (index2 < input.length() &&
           (Character.isDigit(input.charAt(index2)) ||
            input.charAt(index2) == '.'))
      index2++;
    double d = 0;
    try {
      d = Double.parseDouble(input.substring(index, index2));
    } catch (Exception e) {
      System.out.println(e);
    }
    index = index2;
    return d;
  }

  char getOperator () {
    char op = input.charAt(index++);
    if (OPERATORS.indexOf(op) == -1)
      System.out.println("Operator " + op + " not recognized.");
    return op;
  }

  String numberStackToString () {
    String s = "numberStack: ";
    Stack<Double> helperStack = new Stack<Double>();
    // EXERCISE
    // Put every element of numberStack into helperStack
    // You will need to use a loop.  What kind?
    // What condition? When can you stop moving elements out of numberStack?
    // What method do you use to take an element out of numberStack?
    // What method do you use to put that element into helperStack.
    while(numberStack.empty() != true){
    	helperStack.push(numberStack.pop());
    }
    // Now put them back, but also add each one to s:
    
    while(helperStack.empty() != true){
    	s = s + " " + (helperStack.peek());
    	numberStack.push(helperStack.pop());
    	
    }
    return s;
  }

  String operatorStackToString () {
    String s = "operatorStack: ";
    Stack<Character> helperStack2 = new Stack<Character>();
    // EXERCISE
    while(operatorStack.empty() != true){
    	helperStack2.push(operatorStack.pop());
    }
    // Now put them back, but also add each one to s:
    
    while(helperStack2.empty() != true){
    	s = s + " " + (helperStack2.peek());
    	operatorStack.push(helperStack2.pop());
    }
    return s;
  }
  
  void displayStacks () {
    ui.sendMessage(numberStackToString() + "\n" +
                   operatorStackToString());
  }
  
  double evaluateOperator (double a, char op, double b){
	  
	  switch (op) {
	  case '+':
		  return a+b;
		  
	  case '-':
		  return a-b;
		  
	  case '*':
		  return (a*b);
		  
	  case '/':
		  return (a/b);
		  
	  case '^':
		  return Math.pow(a, b);
	  
	  default:
		  throw new EmptyStackException();
	  }
  }
  
  void evaluateOperator (){
	  //Pop the top operator from the operator stack.  Pop the top two numbers
	  //from the number stack.  Apply the operator to the numbers, and push
	  //the result on the number stack.
	  
	  while(numberStack.empty() != true){
	    	helperStack.push(numberStack.pop());
	    }

	 
			  
  }
  
  void processOperator (char op){
	  
  }

  double evaluate (String expr) {
    input = expr;
    index = 0;
    while (!operatorStack.empty()) operatorStack.pop();
    while (!numberStack.empty()) numberStack.pop();

    while (!atEndOfInput())
      if (isNumber()) {
        numberStack.push(getNumber());
        displayStacks();
      }
      else {
        operatorStack.push(getOperator());
        displayStacks();
      }

    return 0;
  }

  int precedence (char op) {
    return PRECEDENCE[OPERATORS.indexOf(op)];
  }

  public static void main (String[] args) {
    Parser parser = new Parser();

    while (true) {
      String line = ui.getInfo("Enter arithmetic expression or cancel.");
      if (line == null)
        return;

      try {
        double result = parser.evaluate(line);
        ui.sendMessage(line + " = " + result);
      } catch (Exception e) {
        System.out.println(e);
      }
    }
  }
}
