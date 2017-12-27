#include <iostream>
#include <cmath>

using namespace std;

/*
The use of a parent function comes in handy here, the parent function serves as
An interceptor, to extract variable values we may need. In this case we use
A parent function to extract the value of count. To calculate the number of 
Total moves we raise 2 to the power of count, as we know from previous 
observations of this exercise. We then simply print out the total moves 
Before the steps start printing out themselves.
*/
//prototype
void moveDisks(int count, int needle1, int needle3, int needle2);

void moveDisksParent(int count, int needle1, int needle3, int needle2);
//main
int main()
{
	cout << "Moves for 3 disk problem." << endl;
	moveDisksParent(9, 1, 3, 2);
	return 0;
}
//tower of hanoi
void moveDisksParent(int count, int needle1, int needle3, int needle2){
	cout << "Total moves to be made: " << pow(2, count) << endl;
	moveDisks(9, 1, 3, 2);
}
void moveDisks(int count, int needle1, int needle3, int needle2)
{	
	if (count > 0){
		moveDisks(count - 1, needle1, needle2, needle3);
		cout << "Move disk " << count << " from " << needle1 << " to " << needle3 << "." << endl;
		moveDisks(count - 1, needle2, needle3, needle1);
	}
}