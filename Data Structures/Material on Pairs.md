# Pairs

The pair container is a simple container defined in  
**utility**  header consisting of two data elements or objects.

-   The first element is referenced as ‘first’ and the second element as ‘second’ and the order is fixed (first, second).
-   Pair is used to combine together two values which may be different in type. Pair provides a way to store two heterogeneous objects as a single unit.
-   Pair can be assigned, copied and compared. The array of objects allocated in a map or hash_map are of type ‘pair’ by default in which all the ‘first’ elements are unique keys associated with their ‘second’ value objects.
-   To access the elements, we use variable name followed by dot operator followed by the keyword first or second.

**Syntax :**
    ```pair (data_type1, data_type2) Pair_name```

    //CPP program to illustrate pair STL
	#include <iostream>
	#include <utility>
	using namespace std;

	int main()
	{
		pair<int, char> PAIR1;

		PAIR1.first = 100;
		PAIR1.second = 'G';

		cout << PAIR1.first << " ";
		cout << PAIR1.second << endl;

		return 0;
	}

Different ways to initialize pair:

```
pair  g1;         //default
pair  g2(1, 'a');  //initialized,  different data type
pair  g3(1, 10);   //initialized,  same data type
pair  g4(g3);    //copy of g3
g2 = make_pair(1, 'a');
g2 = {1, 'a'};
```
Here are some function for pair template :

-   Operator  `=`  : assign values to a pair.
-   swap : swaps the contents of the pair.
-   make_pair() : create and returns a pair having objects defined by parameter list.
-   Operators( == , != , > , < , <= , >= ) : lexicographically compares two pairs.




