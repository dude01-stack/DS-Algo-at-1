# Vectors

A vector is a sequence container class that implements dynamic array, means size automatically changes when appending elements. A vector stores the elements in contiguous memory locations and allocates the memory as needed at run time.

## Difference between vector and array

An array follows static approach, means its size cannot be changed during run time while vector implements dynamic array means it automatically resizes itself when appending elements.

### Syntax

    vector<object type> variable name;
    for example : vector<int> v1;
### Implementation

    // C++ program to illustrate the
	// iterators in vector
	#include <iostream>
	#include <vector>

	using namespace std;

	int main()
	{
		vector<int> g1;

		for (int i = 1; i <= 5; i++)
			g1.push_back(i);

		cout << "Output of begin and end: ";
		for (auto i = g1.begin(); i != g1.end(); ++i)
			cout << *i << " ";

		cout << "\nOutput of cbegin and cend: ";
		for (auto i = g1.cbegin(); i != g1.cend(); ++i)
			cout << *i << " ";

		cout << "\nOutput of rbegin and rend: ";
		for (auto ir = g1.rbegin(); ir != g1.rend(); ++ir)
			cout << *ir << " ";

		cout << "\nOutput of crbegin and crend : ";
		for (auto ir = g1.crbegin(); ir != g1.crend(); ++ir)
			cout << *ir << " ";

		return 0;
	}

### Modifiers
1.  [assign()](https://www.geeksforgeeks.org/vector-assign-in-c-stl/) – It assigns new value to the vector elements by replacing old ones
2.  [push_back()](https://www.geeksforgeeks.org/vectorpush_back-vectorpop_back-c-stl/)  – It push the elements into a vector from the back
3.  [pop_back()](https://www.geeksforgeeks.org/vectorpush_back-vectorpop_back-c-stl/)  – It is used to pop or remove elements from a vector from the back.
4.  [insert()](https://www.geeksforgeeks.org/vector-insert-function-in-c-stl/)  – It inserts new elements before the element at the specified position
5.  [erase()](https://www.geeksforgeeks.org/vectorclear-vectorerase-c-stl/)  – It is used to remove elements from a container from the specified position or range.
6.  [swap()](https://www.geeksforgeeks.org/vectorat-vectorswap-c-stl/)  – It is used to swap the contents of one vector with another vector of same type. Sizes may differ.
7.  [clear()](https://www.geeksforgeeks.org/vectorclear-vectorerase-c-stl/)  – It is used to remove all the elements of the vector container
8.  [emplace()](https://www.geeksforgeeks.org/vector-emplace-function-in-c-stl/)  – It extends the container by inserting new element at position
9.  [emplace_back()](https://www.geeksforgeeks.org/vectoremplace_back-c-stl/)  – It is used to insert a new element into the vector container, the new element is added to the end of the vector.
10.   [size()](https://www.geeksforgeeks.org/vectorempty-vectorsize-c-stl/)  – Returns the number of elements in the vector.
2.  [max_size()](https://www.geeksforgeeks.org/vector-max_size-function-in-c-stl/)  – Returns the maximum number of elements that the vector can hold.
3.  [capacity()](https://www.geeksforgeeks.org/vector-capacity-function-in-c-stl/)  – Returns the size of the storage space currently allocated to the vector expressed as number of elements.
4.  [resize(n)](https://www.geeksforgeeks.org/vector-resize-c-stl/)  – Resizes the container so that it contains ‘n’ elements.
5.  [empty()](https://www.geeksforgeeks.org/vectorempty-vectorsize-c-stl/)  – Returns whether the container is empty.
6.  [shrink_to_fit()](https://www.geeksforgeeks.org/vector-shrink_to_fit-function-in-c-stl/)  – Reduces the capacity of the container to fit its size and destroys all elements beyond the capacity.
7.  [reserve()](https://www.geeksforgeeks.org/using-stdvectorreserve-whenever-possible/) – Requests that the vector capacity be at least enough to contain n elements 


