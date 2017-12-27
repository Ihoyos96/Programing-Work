#include <iostream>

using namespace std;

////////////////////
/*   Question 1   */
////////////////////

/*
  a.  The function whoknows(const it x) takes an int as a parameter an specifies
      it to be a constant int, which means the value of it will not/cannot change. 
      The if statement check to see if the value of x is less than 2, if it is then
      it prints x and exits the function. If the condition in the if statement is 
      not met, then the else clause is called into action. A new constant int 
      variable is declared ‘y’ and given the value of x divided by 2. The function
      whoknows() is then called recursively and passed into its parameter the 
      value of y. When the value of x is finally less than 2 it will trigger the
      if (x<2) and print the value of x. Then exit out of every recursive call 
      and print the results from the modulo divisions as many times as the 
      recursive call was made.

b.  Whoknows(2)
    Output:
    1
    0

Whoknows(15)
    Output:
    1
    1
    1
    1

Whoknows(-3)
    Output:
    -3
*/


    
void digitize(int x, bool y)

/*
The if statement is first to be hit and check the value of y for either true or false.
If True will enter into the Most to Least significant break down of the int. If
the boolean value is not true, meaning the if statemen is jumped, the else handles
the breakdown from Least to Most significant i.e. reverse order.

The int breakdown in the first case, is done by recursively calling the function
and passing x divided by 10 as the new parameter until we reach the first Most
significant digit, modulo cleans the number, and we print it. Then we work backwards
through the recursive calls to do the same to the rest fo the digits. 

The else case first reverses the number using a while loop toparse through the digits
Aand one by one in reverse order add them to a new int by incrementing the previously
added digit ten fold. then once reversed, the rverse function is called, passing it the
reversed number and a now true boolean as parameter, and the first case once again
takes over and strips it one digit at a time.
*/
{
  if (y == true) {
    if(x >= 10)
      digitize((x / 10), true);

    int digit = x % 10;

    cout << digit << '\n';
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
The no loops law applies, and in place of such method we use recursion. 
We define a new int result and so long as the function parameteris no 0
The if statement triggers and the new result int is appended a the least
significant digit of the orignal input by means of modulo division. 
the original input is then divided by 10 to get rid of the least significant
digit and is then passed as the new parameter on the recursive call.
This process will print our the number in reverse.

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
