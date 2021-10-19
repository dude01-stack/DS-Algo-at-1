
## Greedy Algorithm:

A **greedy** algorithm, as the name suggests, **always makes the choice that seems to be the best at that moment.** This means that it makes a locally-optimal choice in the hope that this choice will lead to a globally-optimal solution.

How do you decide which choice is optimal?

Assume that you have an objective function that needs to be optimized (either maximized or minimized) at a given point. A Greedy algorithm makes greedy choices at each step to ensure that the objective function is optimized. The Greedy algorithm has only one shot to compute the optimal solution so that it never goes back and reverses the decision.

**Greedy algorithms** have some advantages and disadvantages:

- It is quite easy to come up with a greedy algorithm (or even multiple greedy algorithms) for a problem.
- Analyzing the run time for greedy algorithms will generally be much easier than for other techniques (like Divide and conquer). For the Divide and conquer technique, it is not clear whether the technique is fast or slow. This is because at each level of recursion the size of gets smaller and the number of sub-problems increases.
- The difficult part is that for greedy algorithms you have to work much harder to understand correctness issues. Even with the correct algorithm, it is hard to prove why it is correct. Proving that a greedy algorithm is correct is more of an art than a science. It involves a lot of creativity.

**Note:** Most greedy algorithms are not correct. An example is described later in this article.

### Creating a Greedy Algorithm

Being a very busy person, you have exactly T time to do some interesting things and you want to do maximum such things.

You are given an array A of integers, where each element indicates the time a thing takes for completion. You want to calculate the maximum number of things that you can do in the limited time that you have.

This is a simple Greedy-algorithm problem. In each iteration, you have to greedily select the things which will take the minimum amount of time to complete while maintaining two variables currentTime and numberOfThings. To complete the calculation, you must:

Sort the array A in a non-decreasing order.
Select each to-do item one-by-one.
Add the time that it will take to complete that to-do item into currentTime.
Add one to numberOfThings.
Repeat this as long as the currentTime is less than or equal to T.

Let A = {5, 3, 4, 2, 1} and T = 6

After sorting, A = {1, 2, 3, 4, 5}

After the 1st iteration:

currentTime = 1
numberOfThings = 1
After the 2nd iteration:

currentTime is 1 + 2 = 3
numberOfThings = 2
After the 3rd iteration:

currentTime is 3 + 3 = 6
numberOfThings = 3
After the 4th iteration, currentTime is 6 + 4 = 10, which is greater than T. Therefore, the answer is 3.

### Implementation:
```
    #include <iostream>
    #include <algorithm>

    using namespace std;
    const int MAX = 105;
    int A[MAX];

    int main()
    {
        int T, N, numberOfThings = 0, currentTime = 0;
        cin >> N >> T;
        for(int i = 0;i < N;++i)
            cin >> A[i];
        sort(A, A + N);
        for(int i = 0;i < N;++i)
        {
            currentTime += A[i];
            if(currentTime > T)
                break;
            numberOfThings++;
        }
        cout << numberOfThings << endl;
        return 0;
    }
```

### Some Common Problems on Greedy Algorthim:

1. [Activity Selection Problem](https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/) <br>
2. [Graph Coloring Problem](https://www.techiedelight.com/greedy-coloring-graph/) <br>
3. [Distribute Candy Problem](https://www.interviewbit.com/problems/distribute-candy/) <br>
4. [Coin Change Problem](https://www.codesdope.com/course/algorithms-greedy-algorithm/) <br>
5. [Single Source Shortest Path Problem](https://www.techiedelight.com/single-source-shortest-paths-dijkstras-algorithm/)



