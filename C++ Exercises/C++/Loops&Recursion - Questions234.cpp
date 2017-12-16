#include <iostream>

using namespace std;


////////////////////
/*   Question 2   */
////////////////////


/*
Simple for lop looks at every value less than x, thus the i = x - 1,
And prints any value that itself modulo x (the orignal input value)
Equals zero; a divisor.
*/
void printdivisor(int x){
	for(int i = x-1; i > 0; i--){
		if (x%i == 0) {
			cout << i << endl;
		}
	}
}

void sumdivisor(int x){
	/*
	The for loop looks at every number, 'i', less than x, starting at x - 1,
	By decrementation, thus the i-- .
	If 'x', the original input given, modulo 'i' equals zero, it means that it
	Is a proper divisor, so it is added toour sum variable. At the end the sum
	Variable is outputed to the console. 
	*/
	int sum = 0;
	for(int i = x-1; i > 0; i--){
		if (x%i == 0) {
			sum = sum + i;
		}
	}
	cout << sum << endl;
}

void allperfect(int a, int b){
	/* The if statements allow from proper bounding of the for loops,
	   The same code is inside both if statements, but with different ranges
	*/

	/* The first for loop runs through all the values in between the decided range
	   The nested for loop sums up the divisors for each number i.
	   The if statement at the bottom compare the sum to the original value for
	   Which we are finding its divisors. If they are equal, then it is a perfect
	   Number and prints it. 
	*/
	if (a > b){
		for (int j = b+1; j < a; j++){
			int sum = 0;
			for(int i = j-1; i > 0; i--){
				if (j%i == 0) {
					sum = sum + i;
				}
			}
			if (sum == j)
				cout << sum << endl;
		}
	}
	if (b > a){
		for (int j = a+1; j < b; j++){
			int sum = 0;
			for(int i = j-1; i > 0; i--){
				if (j%i == 0) {
					sum = sum + i;
				}
			}
			if (sum == j)
				cout << sum << endl;
		}
	}
}




////////////////////
/*   Question 3   */
////////////////////


void printZeros(int x){
	/* 
Simple recursion, recursively calls function x times and on return from
Each call prints a zero.
*/ 
	if (x > 1)
		printZeros(x-1);
	cout << 0;
}


void printZPattern(int x){
	/*
Prints zeros x times, then while the function parameter hold a value greater
Than one, recursively calls the function with a decrement of one, which then 
prints zeros x-1 time etc..
*/
	for (int i = 0; i < x; i++)
		cout << 0;
	cout << endl;
	if (x > 1){
		printZPattern(x-1);
	}
}

/*
In order to produce a mirror effect, several modifications would have to be
Made. First a second parameter would be needed in order to pass a limit value
Through to each recursive call. A frist for loop would run the decrement process
Printing X many zero's, and X - 1 zeros on recursion, until the start value
Equals the end value. This is then the midway point, at which position we print an
Additional zero, and the function returns. The second for loop is now activated and
From bottom to top X zeros are printed and X + 1 zeros on each subsequent answer
To the previous function calls.
*/

void printZPattern2(int start, int end){
	/*
In order to produce a mirror effect, several modifications would have to be
Made. First a second parameter would be needed in order to pass a limit value
Through to each recursive call. A frist for loop would run the decrement process
Printing X many zero's, and X - 1 zeros on recursion, until the start value
Equals the end value. This is then the midway point, at which position we print an
Additional zero, and the function returns. The second for loop is now activated and
From bottom to top X zeros are printed and X + 1 zeros on each subsequent answer
To the previous function calls.
*/
	if (start == (end+1)) {
		cout << 0 << endl;
		return;
	}
	for (int i=0; i<start; i++)
		cout << 0;
	cout << endl;
	printZPattern2(start-1, end);
	for (int i=0; i<start; i++)
		cout << 0;
	cout << endl;


}

int myfib (int n){
	return n;			//This is a test function, for compiling means.
}



////////////////////
/*   Question 4   */
////////////////////


/*
All of these emplore simple recursion techniques
*/
void myfibseries(int n){
	if (n>1)
		myfibseries(n-1);
	if (n == 1){
		cout << myfib(1);
		return;
	}
	cout << ", " << myfib(n);

}

void myfibseriesR(int n){
	if (n == 1){
		cout << myfib(1);
		return;
	}
	cout << myfib(n) << ", ";
	myfibseriesR(n-1);
}

int myfibsum(int n){
	int sum;
	if (n>1)
		sum = myfib(n) + myfibsum(n-1);
	if (n==1)
		sum = myfib(1);
	return sum;
}

////////////////////
/*      TESTS     */
////////////////////

int main() {
  printdivisor(1986);
  cout << endl;
  sumdivisor(1986);
  cout << endl;
  allperfect(2, 12);
  cout << endl;
  printZeros(4);
  cout << endl;
  cout << endl;
  printZPattern(4);
  cout << endl;
  cout << endl;
  printZPattern2(4, 0);
  cout << endl;
  myfibseries(9);
  cout << endl;
  myfibseriesR(9);
  cout << endl;
  cout << endl;
  cout << myfibsum(9);
  cout << endl;

}