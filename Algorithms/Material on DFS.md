# DepthFirstSearch (DFS)

[Depth First Traversal (or Search)](http://en.wikipedia.org/wiki/Depth-first_search)  for a graph is similar to  [Depth First Traversal of a tree.](https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/)  The only catch here is, unlike trees, graphs may contain cycles, a node may be visited twice. To avoid processing a node more than once, use a boolean visited array.

  **Example:**

> **Input:**  n = 4, e = 6  
> 0 -> 1, 0 -> 2, 1 -> 2, 2 -> 0, 2 -> 3, 3 -> 3  
> **Output:** DFS from vertex 1 : 1 2 0 3
-  **Approach:**  Depth-first search is an algorithm for traversing or searching tree or graph data structures. The algorithm starts at the root node (selecting some arbitrary node as the root node in the case of a graph) and explores as far as possible along each branch before backtracking. So the basic idea is to start from the root or any arbitrary node and mark the node and move to the adjacent unmarked node and continue this loop until there is no unmarked adjacent node. Then backtrack and check for other unmarked nodes and traverse them. Finally, print the nodes in the path.
-  **Algorithm:**
    1.  Create a recursive function that takes the index of the node and a visited array.
    2.  Mark the current node as visited and print the node.
    3.  Traverse all the adjacent and unmarked nodes and call the recursive function with the index of the adjacent node.


*Implementation*

        // C++ program to print DFS traversal from
    // a given vertex in a given graph
    #include <bits/stdc++.h>
    using namespace std;
    
    // Graph class represents a directed graph
    // using adjacency list representation
    class Graph
    {
    public:
    	map<int, bool> visited;
    	map<int, list<int>> adj;
    
    	// function to add an edge to graph
    	void addEdge(int v, int w);
    
    	// DFS traversal of the vertices
    	// reachable from v
    	void DFS(int v);
    };
    
    void Graph::addEdge(int v, int w)
    {
    	adj[v].push_back(w); // Add w to v’s list.
    }
    
    void Graph::DFS(int v)
    {
    	// Mark the current node as visited and
    	// print it
    	visited[v] = true;
    	cout << v << " ";
    
    	// Recur for all the vertices adjacent
    	// to this vertex
    	list<int>::iterator i;
    	for (i = adj[v].begin(); i != adj[v].end(); ++i)
    		if (!visited[*i])
    			DFS(*i);
    }
    
    // Driver code
    int main()
    {
    	// Create a graph given in the above diagram
    	Graph g;
    	g.addEdge(0, 1);
    	g.addEdge(0, 2);
    	g.addEdge(1, 2);
    	g.addEdge(2, 0);
    	g.addEdge(2, 3);
    	g.addEdge(3, 3);
    
    	cout << "Following is Depth First Traversal"
    			" (starting from vertex 2) \n";
    	g.DFS(2);
    
    	return 0;
    }



**Complexity Analysis:**

-   **Time complexity:** O(V + E), where V is the number of vertices and E is the number of edges in the graph.
-   **Space Complexity:**  O(V).  
    Since an extra visited array is needed of size V.

**Handling Disconnected Graph**

-   **Solution:**  This will happen by handling a corner case.  
    The above code traverses only the vertices reachable from a given source vertex. All the vertices may not be reachable from a given vertex, as in a Disconnected graph. To do a complete DFS traversal of such graphs, run DFS from all unvisited nodes after a DFS.  
    _The recursive function remains the same._
-   **Algorithm:**
    1.  Create a recursive function that takes the index of the node and a visited array.
    2.  Mark the current node as visited and print the node.
    3.  Traverse all the adjacent and unmarked nodes and call the recursive function with the index of the adjacent node.
    4.  Run a loop from 0 to the number of vertices and check if the node is unvisited in the previous DFS, call the recursive function with the current node.


