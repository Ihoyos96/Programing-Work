/* Question 7 */

#include <ctime>
#include <iostream>

using namespace std;

int random_in_range(int min, int max) //range : [min, max]
{
	static bool first = true;
	if ( first ){
		srand((int)time(NULL)); //seeding for the first time only!
		first = false;
	}
	return min + rand() % (max - min);
}

int main() {

	int min;
	int max;
	int input;

	cout << "Enter a min of range: ";
	cin >> min;
	cout << "Enter a max of range: ";
	cin >> max;

	int random_integer = random_in_range(min, max);

	cout << "Guess a number between " << min << " and " << max << endl;
	
	for (int i = 0; i < 3; i++){
		cout << "Guess a Number: ";
		cin >> input;
		if (input > random_integer)
			cout << "You went too high! Try again." << endl;
		else if (input == random_integer){
			cout << "You got it!" << endl;
			return 0;
		} else {
			cout << "You went too low! Try again." << endl;
		}
	}
}