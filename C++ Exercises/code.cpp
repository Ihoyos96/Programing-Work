#include <iostream>

using namespace std;

void digitize(int x, bool y)

/*
The if statement is first to be hit and check the value of y for either true or false.
If True will enter into the Most to Least significant break down of the int. If
the boolean value is not true, meaning the if statemen is jumped, the else handles
the breakdown from Least to Most significant i.e. reverse order.

The int breakdown in the first case, is done by recursively calling the function
and passing x divided by 10 as the new parameter until we reach the first Most
significant digit,
*/
{
  if (y == true) {
    if(x >= 10)
      digitize((x / 10), true);

    //int digit = x % 10;

    cout << x << '\n';
  }
  else {
  
    int reversed = 0;

    while(x != 0){
      reversed = reversed * 10 + x % 10;
      x = x / 10;
    }
    
    digitize(reversed, true);


  }
}
/*

*/
void reverse(int x) {
  int result = 0;
  if(x != 0){
    result = result + x % 10;
    x = x / 10;
    cout << result;
    reverse(x);
  }
}


int main() {
  digitize(1798, true);
  digitize(1798, false);
  reverse(1987);
  cout << endl;

}
