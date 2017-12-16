#include <iostream>
#include <sstream>
#include <string>

using namespace std;



int main(){

	int input;
	int count = 0;
	string item = "";
	double total = 0;
	double taxTotal = (total*0.07)/0.01;
	double tipTotal = (total*0.15)/0.01;
	double tTotal = (total + taxTotal + tipTotal)/0.01;
 
  	cout.precision(2);

	while (input != 99){

		cout << "\t\tWelcome to the Miami Favorites Meal Builder\t" << endl;
		cout << "\t\t===========================================\t" << endl;
		cout << endl;
		cout << "\t\tNewMean (0)\t\t\tQuit (99)\t" << endl;
		cout << "\t\t\t\tAppetizers" << endl;
		cout << endl;	
		cout << "1\tChicken Satay\t\t\t\t\t\t$7.50" << endl;
		cout << "2\tEgyptian Spring Rolls\t\t\t\t\t$6.50" << endl;
		cout << "3\tHumus\t\t\t\t\t\t\t$5.50" << endl;
		cout << "4\tSamboosa\t\t\t\t\t\t$5.50" << endl;
		cout << endl;
		cout << "\t\t\t\tEntrees" << endl;
		cout << endl;
		cout << "5\tShish Tawooq - Chicken Kabaab\t\t\t\t$13.50" << endl;
		cout << "6\tShish Kabaab- Beef Kabaab\t\t\t\t$16.50" << endl;
		cout << "7\tFatta Bel Mooza\t\t\t\t\t\t$17.25" << endl;
		cout << "8\tKoshary - vegetarian\t\t\t\t\t$10.25" << endl;
		cout << "9\tKoshary - with meat sauce\t\t\t\t$12.25" << endl;
		cout << endl;
		cout << "\t\t\t\tDrinks" << endl;
		cout << endl;
		cout << "10\tTea with mint\t\t\t\t\t\t$2.25" << endl;
		cout << "11\tTurkish Coffee\t\t\t\t\t\t$2.25" << endl;
		cout << "12\tSoda\t\t\t\t\t\t\t$2.00" << endl;
		cout << endl;
		cout << "\t\t\t\tDessert" << endl;
		cout << endl;
		cout << "13\tRice Pudding - with rose water\t\t\t\t$6.00" << endl;
		cout << "14\tBamboosa - 2 pieces\t\t\t\t\t$4.50" << endl;
		cout << "15\tMango Pudding\t\t\t\t\t\t$6.00" << endl;
		cout << endl;
		cout << endl;
		cout << "Please enter item[1-15]: ";

		cin >> input;

		switch(input) {
	      case 0 :
	        item.clear();
	        total = 0;
	        taxTotal = 0;
	        tipTotal = 0;
	        tTotal = 0;
	        count = 0;
	        break;
	      case 99 :
	      	exit(0);
	      case 1 :
	        item = item + "1\tChicken Satay\t\t\t\t\t\t$7.50\n";
	        total = total + 7.50;
	        taxTotal = total*0.07;
			tipTotal = total*0.15;
			tTotal = total + taxTotal + tipTotal;
	        count = count + 1;
	        break;
	      case 2 :
	        item = item + "2\tEgyptian Spring Rolls\t\t\t\t\t$6.50\n";
	        total = total + 6.50;
	        taxTotal = total*0.07;
			tipTotal = total*0.15;
			tTotal = total + taxTotal + tipTotal;
	        count = count + 1;
	        break;
	      case 3 :
	        item = item + "3\tHumus\t\t\t\t\t\t\t$5.50\n";
	        total = total + 5.50;
	        taxTotal = total*0.07;
			tipTotal = total*0.15;
			tTotal = total + taxTotal + tipTotal;
	        count = count + 1;
	         break;
	      case 4 :
	      	item = item + "4\tSamboosa\t\t\t\t\t\t$5.50\n";
	      	total = total + 5.50;
	      	taxTotal = total*0.07;
			tipTotal = total*0.15;
			tTotal = total + taxTotal + tipTotal;
	      	count = count + 1;
	      	break;
	      case 5 :
	      	item = item + "5\tShish Tawooq - Chicken Kabaab\t\t\t\t$13.50\n";
	      	total = total + 13.50;
	      	taxTotal = total*0.07;
			tipTotal = total*0.15;
			tTotal = total + taxTotal + tipTotal;
	      	count = count + 1;
	      	break;
	      case 6 :
	      	item = item + "6\tShish Kabaab- Beef Kabaab\t\t\t\t$16.50\n";
	      	total = total + 16.50;
	      	taxTotal = total*0.07;
			tipTotal = total*0.15;
			tTotal = total + taxTotal + tipTotal;
	      	count = count + 1;
	      	break;
	      case 7 :
	      	item = item + "7\tFatta Bel Mooza\t\t\t\t\t\t$17.25\n";
	      	total = total + 17.25;
	      	taxTotal = total*0.07;
			tipTotal = total*0.15;
			tTotal = total + taxTotal + tipTotal;
	      	count = count + 1;
	      	break;
	      case 8 :
	      	item = item + "8\tKoshary - vegetarian\t\t\t\t\t$10.25\n";
	      	total = total + 10.25;
	      	taxTotal = total*0.07;
			tipTotal = total*0.15;
			tTotal = total + taxTotal + tipTotal;
	      	count = count + 1;
	      	break;
	      case 9 :
	      	item = item + "9\tKoshary - with meat sauce\t\t\t\t$12.25\n";
	      	total = total + 12.25;
	      	taxTotal = total*0.07;
			tipTotal = total*0.15;
			tTotal = total + taxTotal + tipTotal;
	      	count = count + 1;
	      	break;
	      case 10 :
	      	item = item + "10\tTea with mint\t\t\t\t\t\t$2.25\n";
	      	total = total + 2.25;
	      	taxTotal = total*0.07;
			tipTotal = total*0.15;
			tTotal = total + taxTotal + tipTotal;

	      	count = count + 1;
	      	break;
	      case 11 :
	      	item = item + "11\tTurkish Coffee\t\t\t\t\t\t$2.25\n";
	      	total = total + 2.25;
	      	taxTotal = total*0.07;
			tipTotal = total*0.15;
			tTotal = total + taxTotal + tipTotal;
	      	count = count + 1;
	      	break;
	      case 12 :
	      	item = item + "12\tSoda\t\t\t\t\t\t\t$2.00\n";
	      	total = total + 2.00;
	      	taxTotal = total*0.07;
			tipTotal = total*0.15;
			tTotal = total + taxTotal + tipTotal;
	      	count = count + 1;
	      	break;
	      case 13 :
	      	item = item + "13\tRice Pudding - with rose water\t\t\t\t$6.00\n";
	      	total = total + 6.00;
	      	taxTotal = total*0.07;
			tipTotal = total*0.15;
			tTotal = total + taxTotal + tipTotal;
	      	count = count + 1;
	      	break;
	      case 14 :
	      	item = item + "14\tBamboosa - 2 pieces\t\t\t\t\t$4.50\n";
	      	total = total + 4.50;
	      	taxTotal = total*0.07;
			tipTotal = total*0.15;
			tTotal = total + taxTotal + tipTotal;
	      	count = count + 1;
	      	break;
	      case 15 :
	      	item = item + "15\tMango Pudding\t\t\t\t\t\t$6.00\n";
	      	total = total + 6.00;
	      	taxTotal = total*0.07;
			tipTotal = total*0.15;
			tTotal = total + taxTotal + tipTotal;
	      	count = count + 1;
	      	break;
	      default :
	         cout << "Invalid Input" << endl;
	    }

		cout.precision(2);
	    cout << "=======================================================================\nYour current meal has ";
		cout << to_string(count); 
		cout << " item(s).\n"; 
		cout << item; 
		cout << "=======================================================================\n";
		cout << "\t\t\t\t\t\tSubtotal =  $";
		cout << total;
		cout << "\n\t\t\t\t\t\tTax =  $";
		cout << taxTotal;
		cout << "\n\t\t\t\t\t\tTip =  $";
		cout << tipTotal;
		cout << "\n\t\t\t\t\t\tTotal =  $";
		cout << tTotal;
		cout << endl;
		cout << endl;
   
	}	
}