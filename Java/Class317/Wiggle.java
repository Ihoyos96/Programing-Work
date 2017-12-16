package Class317;

public class Wiggle {

	public static void main (String[] args){

		System.out.print("WTF");
		int[] numArray = new int[6];
		for (int i = 0; i < (numArray.length - 1); i++){
			numArray[i] = (int) Math.random() * 9;
			System.out.println(numArray[i]);
			System.out.println("Hello World!");
		}
	}
}
