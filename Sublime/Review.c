#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

#typedef char[] Topic;
#typedef char[] Subtopic;
#typedef char[] Example;

    CSC-322 Review


Topic theBasics()

	•	Declarations give information abut something; like data types.

	•	Definitions reserve space/generates code.

	•	Variable Names - Don’t begin variable names with underscores, as names beginning with underscores as often used for library routines and may clash.

	•	Prototypes provide information about the arguments and the return type.
			
	Two accepted implementations of prototypes:

	void OutputTableRow(int Fahrenheit,float Celcius); // This example includes argument declarations.

	void OutputTableRow(int,float); //This example does not include argument declarations.




=====================================================================================================
Example involving prototypes
=====================================================================================================

//----Fahrenheit-Celsius table
//-----------------------------------------------------------------------------
#include <stdio.h>
#include <stdlib.h>

#define LOWER 0     //----lower limit of table
#define UPPER 300   //----upper limit        				<== Constant declarations
#define STEP 20     //----step size         
//-----------------------------------------------------------------------------
void OutputTableRow(int Fahrenheit,float Celcius);
float FahrenheitToCelsius(int Fahrenheit);
//-----------------------------------------------------------------------------
int main(void) {

    int Fahrenheit;
    float Celcius;

    for (Fahrenheit = LOWER; Fahrenheit <= UPPER; 
Fahrenheit = Fahrenheit+STEP) {
        Celcius = FahrenheitToCelsius(Fahrenheit);
        OutputTableRow(Fahrenheit,Celcius);
    }

    return(EXIT_SUCCESS);
}
//-----------------------------------------------------------------------------
void OutputTableRow(int Fahrenheit,float Celcius) {

    printf("%4d %6.1f\n",Fahrenheit,Celcius);
}
//-----------------------------------------------------------------------------
float FahrenheitToCelsius(int Fahrenheit) {

    float Result;

    Result = (5.0/9.0)*(Fahrenheit-32);
    return(Result);
}
//-----------------------------------------------------------------------------


======================================================================================================

======================================================================================================


    Subtopic Functions(){}; 

    A function definition:

    <function type> <name>(<argument declarations>) {
         <local variable definitions>
         <statements>
         [return[(<return value>)]]
    }



    Subtopic A(function definition){};

    //////////////////////////////////
    //This is a function definition.//
    //////////////////////////////////

    float FahrenheitToCelsius(int Fahrenheit) {

        float Result;

        Result = (5.0/9.0)*(Fahrenheit-32);
        return(Result);
    }


    •   The definition of a function that has been declared, must match exactly on type, name, number of 
        arguments, argument names if given, and argument type.

    •   The argument names are not optional here.



    Subtopic Returning(){}; 

    •   Functions may exit at any point via a return statement. Multiple return statements are ok.

    •   Functions whose type is void may exit via a return statement with no <return value>. 
          Such functions may also fall of the end.

    •   Functions whose type is not void, must return a value via a return(<expression>) statement. 
         The return value need not be in ()s. The expression will be converted to the appropriate type, 
          as per the type conversion rules (see later);

    •   The call to a function may ignore the returned value.


    Subtopic Functions(char continued){};

    •   char Functions( char may( char not( char be(nested)))).
    
    •   Functions may be used recursively.
    
    •   If a function is not declared before its use, it is given a default declaration of int <name>(void). 
        It is much better to be explicit always. (Be thorough);






Topic Arguments(){};

•   Actual arguments are converted to their formal types, according to conversion rules.

•   A call to a function of 0 arguments must have ()s.

•   Array names represent the address of the first element thus an array is passed by reference. All other types are passed by value;

    Subtopic Passing(non-arrays by *reference){};

    An example of passing non-arrays by reference
    
        #include <stdio.h>
        #include <stdlib.h>
        //-----------------------------------------------------------------------------
        void Swap(int *This,int *WithThis) {

            int Temporary;

            Temporary = *This;
            *This = *WithThis;
            *WithThis = Temporary;
        }
        //-----------------------------------------------------------------------------
        int main(void) {

            int I1,I2;

            I1 = 1;
            I2 = 2;
            printf("Before : %d %d\n",I1,I2);

            Swap(&I1,&I2);
            printf("After  : %d %d\n",I1,I2);

            return(EXIT_SUCCESS);
        }
        //-----------------------------------------------------------------------------





















