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
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author dtmirizzi
 */
public class UndirectedGraph {

    private IAdjacencies list;
    private static boolean notDirected=false;

    public UndirectedGraph() {
	this.list = null;
    }

    public UndirectedGraph(IAdjacencies l) {
	this.list = l;
    }

    public static UndirectedGraph readGraph(String fileName) throws IOException {
	AdjacencyList listR = new AdjacencyList();
	listR= listR.read(fileName, notDirected);
	UndirectedGraph G = new UndirectedGraph(listR);
	return G;
    }

    public void addEdge(int v, int w) {
	list.addAdj(v, w, notDirected);
    }

    public int getNumVertices() {
	return list.size();
    }

    public int getNumEdges() {
	return list.numOfEdges(notDirected);
    }

    public Collection<Integer> getAdjacent(int v) {
	return list.adj(v);
    }

    public boolean isAdjacent(int v, int w) {
	return list.isAdj(v, w);
    }

    public int degree(int v) {
	return list.degree(v,notDirected);
    }

    public boolean isConnected(int v, int w) {
	DFS search = new DFS(list);
	search.dfs(v);
	return search.getVisted(w);
    }

    public List<Integer> path(int v, int w) {
	DFS search = new DFS(list);
	search.dfs(v);
	LinkedList<Integer> listl = new LinkedList();
	if (!search.getVisted(w)) {
	    System.out.println("Not connected");
	    return null;
	}

	int[] edgeTo = search.getedgeTo();
	listl.add(w);
	for (int temp = edgeTo[w]; temp != v; temp = edgeTo[temp]) {
	    listl.add(temp);
	}
	listl.add(v);
	return flipList(listl);
    }

    public List<Integer> shortestPath(int v, int w) {
	BFS search = new BFS(list);
	search.bfs(v);
	LinkedList<Integer> listl = new LinkedList();
	if (!search.getVisted(w)) {
	    System.out.println("Not connected");
	    return null;
	}

	int[] edgeTo = search.getedgeTo();
	listl.add(w);
	for (int temp = edgeTo[w]; temp != v; temp = edgeTo[temp]) {
	    listl.add(temp);
	}
	listl.add(v);
	return flipList(listl);
    }
    private LinkedList flipList(LinkedList<Integer> listl){
	LinkedList<Integer> listR = new LinkedList();
	for(int w:listl){
	    listR.addFirst(w);
	}
	return listR;
    }

}
