package Exercises;

import java.util.Arrays;


public class ThreeInOneExtensive {
	
	// Description: 
	//
	// This exercise aims to show how a single 
	// array can be used to implement three stacks.
	//
	// Stack slot allocation is accommodated by incrementing each stacks origin by the
	// the number of stacks implemented in the single array ( 3 in this case ) to get
	// the next available index for that stack.
	//
	// Ex. Stack One begins at 0, its next index is 3, followed by 6, 9, 12, etc..
	//
	// If there were 100 stacks implemented in the same array, each stacks origin would
	// would be incremented by 100 to get the next available index for that
	// stack.
	//
	// Popping mechanics: 
	// Minus #stacks rule for popping, subtract the total number of stacks implemented
	// from the top index to get element below.
	
	// Theory:
	//
	// In theory, infinite stacks can be implemented in a single array. Practically, 
	// implementing too many stacks will result in some memory problems down the line,
	// as the resize function scales them.
	
	
	public static void main(String[] args) {
		
		ThreeStackArray stacks = new ThreeStackArray();
		
		///////////////////////
		//                   //
		//     T e s t s     //
		//                   //
		///////////////////////
		
		stacks.pushS1('a');
		stacks.pushS1('b');
		stacks.pushS1('c');
		stacks.pushS1('d');
		stacks.pushS1('e');
		stacks.printRawArray();
		
		stacks.pushS2('k');
		stacks.pushS2('l');
		stacks.pushS2('n');
		stacks.printRawArray();
		
		stacks.pushS3('x');
		stacks.pushS3('y');
		stacks.printRawArray();
		
		System.out.println();
		
		stacks.printS1();
		stacks.printS2();
		stacks.printS3();
		
		System.out.println("Peak S1: " + stacks.peakS1());
		System.out.println("Peak S2: " + stacks.peakS2());
		System.out.println("Peak S3: " + stacks.peakS3());
		
		System.out.println("Pop S1: " + stacks.popS1());
		System.out.println("Pop S1: " + stacks.popS1());
		System.out.println("Pop S1: " + stacks.popS1());
		System.out.println("Pop S2: " + stacks.popS2());
		System.out.println("Pop S3: " + stacks.popS3());

		System.out.println("Peak S1: " + stacks.peakS1());
		System.out.println("Peak S2: " + stacks.peakS2());
		System.out.println("Peak S3: " + stacks.peakS3());
		System.out.println();
		
		stacks.printS1();
		stacks.printS2();
		stacks.printS3();
		
	}
	
}

class ThreeStackArray{
	
	char[] array;
	
	int topS1;	// Stack One Identifier:		S1
	int topS2;	// Stack Two Identifier:		S2
	int topS3;	// Stack Three Identifier:	S3
	
	public ThreeStackArray() {
		this.array = new char[12];
		this.topS1 = 0;
		this.topS2 = 1;
		this.topS3 = 2;
	}
	
	public void resize() {
		
		// Get size of current array
		int size = array.length;
		
		// Store elements in temp array
		char[] temp = array;
		
		// Define new, 2x larger array;
		array = new char[2*size];
		
		// Copy old elements into new array
		array = Arrays.copyOf(temp, array.length);
	}
	
/////////////////////////////////////////////////////////////////////////////////////////
							   // 					  //
							   //    Print Methods    //
							   //                     //
////////////////////////////////////////////////////////////////////////////////////////
	
	public void printRawArray() {
														// This method prints the one
		System.out.println(Arrays.toString(array));      // encompassing array in
														// standard [x, y, z] format
	}
	
	public void printS1() {
		
		int index = topS1;
		
		System.out.println("Stack S1:\t" + array[index]);
		index -= 3;
		
		while (index >= 0) {
			System.out.println("\t\t" + array[index]);
			index -= 3;
		}
		
		System.out.println();
		return;
	}
	
	public void printS2() {
		
		int index = topS2;
		
		System.out.println("Stack S2:\t" + array[index]);
		index -= 3;
		
		while (index >= 1) {
			System.out.println("\t\t" + array[index]);
			index -= 3;
		}
		
		System.out.println();
		return;
	}
	
	public void printS3() {
		
		int index = topS3;
		
		System.out.println("Stack S3:\t" + array[index]);
		index -= 3;
		
		while (index >= 2) {
			System.out.println("\t\t" + array[index]);
			index -= 3;
		}
		
		System.out.println();
		return;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////
							   //                     //
							   //   isEmpty Methods   //
							   //                     //
/////////////////////////////////////////////////////////////////////////////////////////

	
	public boolean S1isEmpty() {
		
		if (array[topS1] == 0)
			return true;
		else
			return false;
		
	}
	
	public boolean S2isEmpty() {
		
		if (array[topS2] == 0)
			return true;
		else
			return false;
		
	}
	
	public boolean S3isEmpty() {
		
		if (array[topS3] == 0)
			return true;
		else
			return false;
		
	}
	
////////////////////////////////////////////////////////////////////////////////////////
								 //                //
								 //  Push Methods  //
								 //                //
////////////////////////////////////////////////////////////////////////////////////////
	
	
	public void pushS1(char data) {
		
		if (S1isEmpty()) {
			array[topS1] = data;
			return;
		}
		
		topS1 += 3;
		
		if (topS1 > array.length - 1)
			resize();
		
		array[topS1] = data;
		return;
		
	}
	
	public void pushS2(char data) {
		
		if (S2isEmpty()) {
			array[topS2] = data;
			return;
		}
		
		topS2 += 3;
		
		if (topS2 > array.length - 1)
			resize();
		
		array[topS2] = data;
		return;
		
	}
	
	public void pushS3(char data) {
		
		if (S3isEmpty()) {
			array[topS3] = data;
			return;
		}
		
		topS3 += 3;
		
		if (topS3 > array.length - 1)
			resize();
		
		array[topS3] = data;
		return;
		
	}
	
/////////////////////////////////////////////////////////////////////////////////////////
							 	  //               //
							 	  //  Pop Methods  //
							 	  //               //
/////////////////////////////////////////////////////////////////////////////////////////
	
	public char popS1() {
		
		if (S1isEmpty())
			return 0;
		
		char data = array[topS1];
		array[topS1] = 0;
		
		if (topS1 != 0)
			topS1 -= 3;
		
		return data;
		
	}
	
	public char popS2() {
		
		if (S2isEmpty())
			return 0;
		
		char data = array[topS2];
		array[topS2] = 0;
		
		if (topS2 != 1)
			topS2 -= 3;
		
		return data;
		
	}
	
	public char popS3() {
		
		if (S3isEmpty())
			return 0;
		
		char data = array[topS3];
		array[topS3] = 0;
		
		if (topS3 != 2)
			topS3 -= 3;
		
		return data;
		
	}
	
////////////////////////////////////////////////////////////////////////////////////////
								 //                //
								 //  Peak Methods  //
								 //                //
////////////////////////////////////////////////////////////////////////////////////////
	
	public char peakS1() {
		return array[topS1];
	}
	
	public char peakS2(){
		return array[topS2];
	}
	
	public char peakS3() {
		return array[topS3];
	}
}
