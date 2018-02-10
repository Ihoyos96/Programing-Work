package Exercises;

public class FizzBuzz {
	
	public static void main(String[] args) {
		
		System.out.println(fizzBuzz(5));
		System.out.println(fizzBuzz(3));
		System.out.println(fizzBuzz(15));
		System.out.println(fizzBuzz(7));
		System.out.println(fizzBuzz(1));
		System.out.println(fizzBuzz(4));
		
		
		
		
	}
	
	public static String fizzBuzz(int n) {
		if (n % 15 == 0)
			return "FizzBuzz";
		if (n % 3 == 0)
			return "Fizz";
		if (n % 5 == 0)
			return "Buzz";
		return String.valueOf(n);
	}
}
