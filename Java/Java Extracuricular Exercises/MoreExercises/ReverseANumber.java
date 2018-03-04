package MoreExercises;

public class ReverseANumber {

	public static void main(String[] args) {
		
		int num = 926495623;
		
		System.out.println(reverse(num));
	}
	
	public static int reverse(int n) {
		String num = Integer.toString(n);
		StringBuilder sb = new StringBuilder();
		sb.append(num);
		sb.reverse();
		return Integer.parseInt(sb.toString());
	}
}
