package com.dynamicprogramming.example.dynamicprogramming;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFSGraph {

	private int V; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency Lists

	// Constructor
	DFSGraph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	public static void main(String[] args) {
		DFSGraph g = new DFSGraph(5); 
        
        g.addEdge(1, 0); 
        g.addEdge(0, 2); 
        g.addEdge(2, 1); 
        g.addEdge(0, 3); 
        g.addEdge(1, 4); 
              
        System.out.println("Following is the Depth First Traversal"); 
        g.DFS(0); 
	}

	private void DFS(int s) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[V];
		stack.push(s);
		while (!stack.isEmpty()) {
			int i = stack.pop();
			if (visited[i] == false) {
				System.out.println(i);
				visited[i] = true;
			}
			Iterator<Integer> it = adj[i].listIterator();
			while (it.hasNext()) {
				int item = (Integer) it.next();
				if (!visited[item]) {
					stack.push((item));
				}
			}
		}
	}

}
