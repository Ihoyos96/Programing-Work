package exercise;

import java.lang.reflect.Array;
import java.util.Random;

public class test {
	
	public static void main(String[] args){
	
	String[ ] people = {"Ian", "Marcus", "Woody", "Cubano", "Machie", "Re", "Alejandro"};

	int randomNumQuiz = 1 + (int)(Math.random() * 12);
	int randomNumExercise = 0 + (int)(Math.random() * 9);
	int randomNumPeople = 0 + (int)(Math.random() * 7);
	
	System.out.println("Person: " + people[randomNumPeople] + "\nQuiz: " + randomNumQuiz + "\nExercise: " + randomNumExercise);
	System.out.println(randomNumPeople);
		
	}
}

