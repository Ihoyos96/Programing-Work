//============================================================================
// Name        : Intro.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================
#include "functions.h"
#include <iostream>
#include <stdio.h>
#include <array>
#include <random>
#include <vector>

using namespace std;

int main() {

	// printing and syntax
	/*
	string name;
	cout << "Hello you filthy bastard," << endl ;
	cout << "Go ahead, give me your name." << endl;
	cin >> name;
	cout << name << "!? What kind of crummy name is that!\n";

	cout << "-- Using imported functions --\n" << endl;
	cout << add(1,5) << endl;
	*/

	//Size of data types -- useful to know
	int x;
		cout << "data type (int)s are " << sizeof(x) << " bytes" <<  endl;
	char c;
		cout << "data type (char)s are " << sizeof(c) << " bytes" <<  endl;
	double d;
		cout << "data type (double)s are " << sizeof(d) << " bytes" <<  endl;
	long l;
		cout << "data type (long)s are " << sizeof(l) << " bytes" <<  endl;

	//Imported print function//
	string message = "\nHello World!!!!";
	print(message);

	//Imported parse_match function//


	//One method of retrieving array size//
	/*
	int numArray[] = {1,2,3,4,5,6,7,8,9};
	cout << "Length: " << sizeof(numArray)/sizeof(numArray[0]) << endl;
	*/

	//using std::array to declare and initialize fixed arrays//
	/*
	array<int, 5> myarray = { 9, 7, 5, 3, 1 };
	cout << "length: " << myarray.size() << endl;
	*/

	std::array<int, 10> numArray2; //array declared with std::array library

	cout << endl;

	//Steps to instantiate a URNG: Uniform Random Number Generator
	std::random_device rd; 	//declare random device with a name
	mt19937 mt(rd());		//Select engine, we use mt19937
	uniform_int_distribution<int> dist(0, 99);	//select distribution method, we choose uni_int_distr

	cout << "Random Array: ";
	for(int i = 0; i < numArray2.size(); i++){
		numArray2[i] = dist(mt);
		cout << numArray2[i] << " ";
	}

	cout << endl;


	cout << "numArray: " << endl;
	int numArray[10] = {10,17,2,32,14,15,62,37,36,9};

	int* p;				//pointer to numArray
		p = numArray;	// <------------^

	int temp[10];
	int length = numArray2.size();
	int match = 62;

	//parse_match(numArray, length, match);

	cout << endl;
	cout << (0 + 3)/2 << endl;
	cout << endl;

	//using array library
	array<int, 10> array;


	//********************Using vector library**********************
	cout << endl;
	cout << "--Using vector library--" << endl << endl;

	cout << " Imported vector_match function" << endl;
	vector<int> matchArray {9, 2, 4, 6, 3, 1};
	//vector_match(matchArray, 6, 4);

	cout << endl;
	std::vector<int> intArray { 1,2,3 };  // array declared with std::vector library
	std::cout << "The length is: " << intArray.size() << '\n';

	vector<int> oArray(10);
	cout<< "check1" << endl;
	vector<int>::iterator it;
	cout<< "check2" << endl;

	//populating vector oArray with Uniform Random Number Generator
	for(int l = 0; l < oArray.size(); l++) {
		oArray[l] = dist(mt);
	}

	cout << "oArray contents: ";
		for (auto const &element: oArray)
	        std::cout << element << ' ';

	oArray.resize(20);

	for(int l; l < oArray.size(); l++) {
			oArray[l] = dist(mt);
		}

	cout << "Length of oArray: " << oArray.size() << endl;

	cout << "oArray contents: ";
	for (auto const &element: oArray)
        std::cout << element << ' ';

	cout << endl << endl;


	cout << endl;

	mergeSort(p, temp, 10);
}

