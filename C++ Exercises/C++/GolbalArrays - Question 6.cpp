/*   Question 6   */

#include <iostream>
#include <stdio.h>

using namespace std;

int *arr = new int[10];

/* 
Using a global array we can access the array from our function and count
the occurences for the asked number.
*/
void search(int n){
	int count = 0;
	for (int i = 0; i < 10; i++)
		if (arr[i] == n)
			count = count + 1;
	cout << "There are " << count << " occurences of the number " << n << " in the array." << endl;
}

int main() {

	for (int i = 0; i < 10; i++){                               
		std::cout << "Enter a number: ";
	    std::cin  >> arr[i];
	}
	int num;
	cout << "Enter number to find: ";
	cin >> num;
	search(num);
	return 0;
}






