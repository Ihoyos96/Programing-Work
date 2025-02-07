/*
 * functions.cpp
 *
 *  Created on: Mar 15, 2017
 *      Author: ianhoyos
 */

#include "functions.h"
#include <array>
#include <vector>
#include <iostream>

using namespace std;

int add(int x, int y){
	return (x + y);
}

void print(string message){
	cout << message << endl;
}

int parse_match(int numArray[], int length, int match){

	for (int i = 0; i < length; i++){
		if (numArray[i] == match){
			cout << match << " found at index " << i << endl;
			return 0;
		}
	}
	cout << match << " not found in the array." << endl;
	return 0;
}

void vector_match(std::vector<int> numArray, int length, int match){

	int size = numArray.size();

	for (int i = 0; i < size; i ++){
		if (numArray[i] == match)
			cout << "\n" << match << " found at index " << i << endl;
		else
			cout << "\n" << "No match found." << endl;
	}
}

//*********************//MERGE SORT//**************************//

void mergeSort(int numbers[], int temporary[], int array_size){

	cout << "Unsorted: ";
	for(int h = 0; h < array_size; h++)
				cout << numbers[h] << " ";

	m_sort(numbers, temporary, 0, array_size - 1);

	cout << endl;
	cout << "Sorted:    ";
	for(int j = 0; j < array_size; j++)
		cout << numbers[j] << " ";


}

void m_sort(int numbers[],int temporary[], int left, int right){

	int middle;

	if (left < right){

		middle = (right + left)/2;

		m_sort(numbers, temporary, left, middle);

		m_sort(numbers, temporary, middle+1, right);

		merge(numbers, temporary, left, middle+1, right);

	}
}

void merge(int numbers[], int temporary[], int left, int middle, int right){

		int i, left_end, number_elements, temporary_position;

		left_end = middle - 1;

		temporary_position = left;

		number_elements = right - left + 1;

		while((left <= left_end) && (middle <= right)){

			if(numbers[left] <= numbers[middle]){

				temporary[temporary_position] = numbers[left];

				temporary_position = temporary_position + 1;

				left = left + 1;

			}

			else{

				temporary[temporary_position] = numbers[middle];

				temporary_position = temporary_position + 1;

				middle = middle + 1;

			}

		}

		while (left <= left_end){

			temporary[temporary_position] = numbers[left];

			left = left + 1;

			temporary_position = temporary_position + 1;
		}

		while (middle <= right){

			temporary[temporary_position] = numbers[middle];

			middle = middle + 1;

			temporary_position = temporary_position + 1;

		}

		for (i = 0; i <= number_elements; i++){

			numbers[right] = temporary[right];

			right = right - 1;
		}
}
//*************************************************************//




