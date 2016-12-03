/*
 * Copyright (C) 2016 dtmirizzi
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package HW.Graphing;


import java.io.IOException;


/**
 * @author dtmirizzi
 */
public class Main {

    
    public static void main(String[] args) throws IOException {
	System.out.println("UD Graph One Test:");
	UndirectedGraph UG1= new UndirectedGraph();
	UG1= UG1.readGraph("/home/dtmirizzi/Notebook16-17/CSC-220/HW/Assignment 5/testData/data1.csv");
	System.out.println(UG1.getNumEdges());
	System.out.println(UG1.getNumVertices());
	UG1.addEdge(1, 2);
	System.out.println(UG1.getNumEdges());
	System.out.println(UG1.getNumVertices());
	System.out.println(UG1.degree(3));
	System.out.println(UG1.isAdjacent(0, 3));
	System.out.println(UG1.isConnected(0, 3));
	System.out.println(UG1.path(0, 3));
	System.out.println(UG1.shortestPath(0, 3));
	
	System.out.println("UD Graph Three Test:");
	UndirectedGraph UG2= new UndirectedGraph();
	UG2= UG2.readGraph("/home/dtmirizzi/Notebook16-17/CSC-220/HW/Assignment 5/testData/data3.csv");
	System.out.println(UG2.getNumEdges());
	System.out.println(UG2.getNumVertices());
	UG2.addEdge(1, 2);
	System.out.println(UG2.getNumEdges());
	System.out.println(UG2.getNumVertices());
	System.out.println(UG2.degree(3));
	System.out.println(UG2.isAdjacent(0, 3));
	System.out.println(UG2.isConnected(0, 3));
	System.out.println(UG2.path(0, 3));
	System.out.println(UG2.shortestPath(0, 3));
	
	System.out.println("D Graph Two Test:");
	DirectedGraph DG1= HW.Graphing.DirectedGraph.readGraph("/home/dtmirizzi/Notebook16-17/CSC-220/HW/Assignment 5/testData/data2.csv");
	System.out.println(DG1.getNumEdges());
	System.out.println(DG1.getNumVertices());
	DG1.addEdge(1, 2);
	System.out.println(DG1.getNumEdges());
	System.out.println(DG1.getNumVertices());
	System.out.println(DG1.inDegree(3));
	System.out.println(DG1.outDegree(3));
	System.out.println(DG1.totalDegree(3));
	System.out.println(DG1.isAdjacent(0, 3));
	System.out.println(DG1.isConnected(0, 3));
	System.out.println(DG1.path(0, 3));
	System.out.println(DG1.shortestPath(0, 3));
	
	System.out.println("D Graph 4 Test:");
	DirectedGraph DG2= HW.Graphing.DirectedGraph.readGraph("/home/dtmirizzi/Notebook16-17/CSC-220/HW/Assignment 5/testData/data4.csv");
	System.out.println(DG2.getNumEdges());
	System.out.println(DG2.getNumVertices());
	DG2.addEdge(1, 2);
	System.out.println(DG2.getNumEdges());
	System.out.println(DG2.getNumVertices());
	System.out.println(DG2.inDegree(3));
	System.out.println(DG2.outDegree(3));
	System.out.println(DG2.totalDegree(3));
	System.out.println(DG2.isAdjacent(0, 3));
	System.out.println(DG2.isConnected(0, 3));
	System.out.println(DG2.path(0, 3));
	System.out.println(DG2.shortestPath(0, 3));
    }

}
