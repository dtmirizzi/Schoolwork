package csc.pkg310.alg;

import java.util.Stack;

public class DFS {

    Stack<Integer> st;
    int vFirst;

    int[][] adjMatrix;
    int[] isVisited = new int[7];

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

    public DFS(int[][] Matrix) {

	this.adjMatrix = Matrix;
	for(int i=0; i<this.isVisited.length;i++){
	    this.isVisited[i]= 0;
	}
	st = new Stack<Integer>();
	int[] node = {0, 1, 2, 3, 4, 5, 6};
	int firstNode = node[0];
	depthFirst(firstNode, 7);

    }

    public void depthFirst(int vFirst, int n) {
	int v, i;

	st.push(vFirst);

	while (!st.isEmpty()) {
	    v = st.pop();
	    if (isVisited[v] == 0) {
		System.out.print((v + 1));
		isVisited[v] = 1;
	    }
	    for (i = 0; i < n; i++) {
		if ((adjMatrix[v][i] == 1) && (isVisited[i] == 0)) { // i used a stack rather then recursion beacuse i only have so much heap
		    st.push(v);
		    isVisited[i] = 1;
		    System.out.print(" " + (i +1));
		    v = i;
		}
	    }
	}
    }
}
