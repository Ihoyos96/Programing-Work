package MoreExercises;

import java.io.*;
import java.util.*;

class FindRoot {

  static double root(double x, int n) {
	  //
	  // x is the number, n is the nth root of the number
	  // we want to find z, where z^n = x
      // your code goes here
    
    double low = 1;
    double high = x;
    double guess = (low + high) / 2;
    
    while (guess - low >= 0.001){
      
      if (Math.pow(guess, n) > x) {
        high = guess;
      }
      else if (Math.pow(guess, n) < x) {
        low = guess;
      }
      else
        break;
      
      guess = (low + high) / 2;
    }
    // formating
    int result = (int) (guess * 1000);
    return (double)result / 1000;
  }

  public static void main(String[] args) {

	  System.out.println(root(9, 3));
	  System.out.println(Math.pow(1.913, 3));
  }

}
