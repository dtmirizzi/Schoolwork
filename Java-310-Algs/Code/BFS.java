/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc.pkg310.alg;

import java.util.Queue;

public class BFS {

    Queue<Integer> queue;
    int vFirst;

    int[][] adjMatrix;


    /**
     * @param args
     */
    public static void main(String[] args) {
	int[][] adjMatrix
		= {{0, 1, 0, 1, 0, 0, 0},
		{1, 0, 0, 0, 1, 0, 1},
		{0, 0, 0, 1, 0, 1, 1},
		{0, 0, 1, 0, 0, 1, 0},
		{0, 1, 0, 1, 0, 1, 1},
		{0, 0, 1, 0, 1, 0, 0},
		{0, 1, 1, 0, 1, 0, 0}};
	int[][] adjMatrix2
		= {{0, 0, 0, 1, 1, 0, 0},
		{0, 0, 1, 1, 0, 0, 0},
		{0, 1, 0, 1, 0, 0, 0},
		{1, 1, 1, 0, 0, 0, 0},
		{1, 0, 0, 0, 0, 1, 0},
		{0, 0, 0, 0, 1, 0, 1},
		{0, 0, 0, 1, 0, 1, 0}};
	int[][] adjMatrix3
		= {{0, 1, 0, 1, 1, 0, 0},
		{0, 0, 1, 1, 0, 0, 1},
		{0, 0, 0, 1, 0, 0, 0},
		{0, 0, 0, 0, 0, 1, 1},
		{0, 0, 0, 1, 0, 0, 0},
		{0, 0, 0, 0, 1, 0, 0},
		{0, 0, 0, 0, 0, 1, 0}};
	int[][] adjMatrix4
		= {{0, 1, 0, 1, 1, 0, 0},
		{0, 0, 1, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 1},
		{0, 1, 1, 0, 0, 1, 1},
		{0, 0, 0, 1, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 1},
		{0, 0, 0, 0, 0, 0, 0}};

	new DFS(adjMatrix);
	System.out.println("");
	new DFS(adjMatrix2);
	System.out.println("");
	new DFS(adjMatrix3);
	System.out.println("");
	new DFS(adjMatrix4);
	System.out.println("");

    }

    public BFS(int[][] Matrix) {

	this.adjMatrix = Matrix;
	int[] node = {0, 1, 2, 3, 4, 5, 6};
	bfs(Matrix, 7);

    }

    public void bfs(int adjacency_matrix[][], int source) {
	int number_of_nodes = adjacency_matrix[source].length - 1;

	int[] visited = new int[number_of_nodes + 1];
	int i, element;

	visited[source] = 1;
	queue.add(source);

	while (!queue.isEmpty()) {
	    element = queue.remove();
	    i = element;
	    System.out.print(i + "\t");
	    while (i <= number_of_nodes) {
		if (adjacency_matrix[element][i] == 1 && visited[i] == 0) {
		    queue.add(i);
		    visited[i] = 1;
		}
		i++;
	    }
	}
    }
}
