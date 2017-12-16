package Class317;

import java.util.*;
import java.io.*;
import java.math.*;

public class MyMergeSort {
	
	private int[] array;
    private int[] tempMergArr;
    private int length;

	public static void main (String[] args){
	
		int[] numArray = new int[10];
		for (int i = 0; i < (numArray.length); i++){
			numArray[i] = (int) (Math.random()*10);
		}
		System.out.print("Unsorted: ");
		for(int i = 0; i < numArray.length; i++){
			System.out.print(numArray[i] + " ");
		}
		
		MyMergeSort mms = new MyMergeSort();
        mms.sort(numArray);
        
        System.out.print("\nSorted:   ");
        for(int i = 0; i < numArray.length; i++){
			System.out.print(numArray[i] + " ");
		}
        
        wiggleArange(numArray);
        System.out.print("\nWiggled:  ");
        for(int i = 0; i < numArray.length; i++){
			System.out.print(numArray[i] + " ");
		}
        
	}
	
	public static void wiggleArange(int[] numArray){
		
		int[] tempArray = new int[numArray.length];
		int median = findKthLargest(numArray, (numArray.length + 1) / 2);
		int index = 0;
		int start = 0;
		int end = tempArray.length - 1;
		System.arraycopy( numArray, 0, tempArray, 0, numArray.length );
		
		
		
		
		/*
		while (tempArray[start] < tempArray[end]  ){
			if(!(numArray[index] > numArray.length)){
				numArray[index] = tempArray[start];
				index++;
			}
			if(!(numArray[index] > numArray.length)){
				numArray[index] = tempArray[end];
				index++;
				start++;
				end--;
			}
		}
		*/
	}
	
	public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }
	
	private void doMergeSort(int lowerIndex, int higherIndex) {
        
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
	
	private void mergeParts(int lowerIndex, int middle, int higherIndex) {
		 
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
 
    }
	
}