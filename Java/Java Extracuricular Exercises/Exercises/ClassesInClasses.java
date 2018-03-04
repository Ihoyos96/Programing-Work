package Exercises;

public class ClassesInClasses {
	
	public static void main (String[] args) {
		Agent agent = new Agent(7);
		
		agent.salute();
	}
}

class Agent{
	String message = "Hello agent ";
	Identifier code;
	
	public Agent(int data) {
		code = new Identifier(data);
	}
	
	public void salute() {
		System.out.println(message + code.data);
	}
	
	class Identifier{
		int data;
		
		public Identifier(int data) {
			this.data = data;
		}
	}
}
