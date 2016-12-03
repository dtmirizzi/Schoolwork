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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;




/**
 *
 * @author dtmirizzi
 */
public class AdjacencyList implements IAdjacencies{

    private LinkedList<Integer>[] vertices;
    
    public AdjacencyList(){
	this.vertices=null;
    }

    public AdjacencyList(int size) {
	this.vertices = new LinkedList[size];
	for(int i=0;i<size;i++){
	    this.vertices[i]=new LinkedList();
	}
    }

    public static AdjacencyList read(String fileName, boolean directed) throws FileNotFoundException, IOException {
	File file = new File(fileName);
	BufferedReader reader=null;
	if (file.exists()) {
	    reader = new BufferedReader(new FileReader(file));
	} else {
	    System.out.println("file does not exist");
	    return null;
	}
	String FirstLine =reader.readLine();
	int size = Integer.parseInt(FirstLine);
	AdjacencyList list= new AdjacencyList(size);
	if (!directed) {
	    for(int i=0; i<size; i++){
		String line =reader.readLine();
		if(line==null)return list;
		String[] pair= new String[2];
		pair = line.split(",");
		list.addAdj(Integer.parseInt(pair[0]),Integer.parseInt(pair[1]));
		list.addAdj(Integer.parseInt(pair[1]),Integer.parseInt(pair[0]));
	    }
	    
	} else {
	    for(int i=0; i<size; i++){
		String line =reader.readLine();
		if(line==null)return list;
		String[] pair = line.split(",");
		list.addAdj(Integer.parseInt(pair[0]),Integer.parseInt(pair[1]));
	    }

	}

	return list;
    }
    public int size(){
	return vertices.length;
    }
    public Iterable<Integer> adjIt(int v){
	return vertices[v];
    }
    public void addAdj(int node, int adj, boolean directed){
	if(node>=vertices.length||node<0){
	    System.err.println("Node not Found");
	    return;
	}
	if(adj>=vertices.length|| adj<0){
	    System.err.println("Adj not Found");
	    return;
	}
	vertices[node].add(adj);
	if(!directed){
	    vertices[adj].add(node);
	}
	
    }
    public void addAdj(int node, int adj){
	vertices[node].add(adj);
    }
    public Collection<Integer> adj(int v){
	return vertices[v];
    }
    public boolean isAdj(int node, int adj){
	for(int w:vertices[node]){
	    if(w==adj){
		return true;
	    }
	}
	return false; 
    }
    public int degree(int node, boolean in){
	int deg=0;
	if(in){
	    for(int i=0; i<this.size();i++){
		for(int w :vertices[i] ){
		    if(w==node){
			deg++;
		    }
		}
	    }
	    return deg;
	}
	return vertices[node].size();
    }
    public int numOfEdges(boolean dir){
	int edges = 0;
	for (int i = 0; i < this.size(); i++) {
	    edges = edges + this.degree(i,false);
	}
	if(dir)return edges;
	else return edges/2;
    }

}
