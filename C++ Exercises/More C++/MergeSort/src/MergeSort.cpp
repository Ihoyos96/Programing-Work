//============================================================================
// Name        : MergeSort.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <array>
using namespace std;

void m_sort(int[], int[], int, int);

void merge(int[], int[], int, int, int);

void mergeSort(int numbers[], int temporary[], int array_size){

	m_sort(numbers, temporary, 0, array_size - 1);
}

void m_sort(int numbers[],int temporary[], int left, int right){

	int middle;

	if (right > left){

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
