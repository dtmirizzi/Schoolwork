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

import Notes.Queue;

/**
 *
 * @author dtmirizzi
 */
public class BFS {

    private IAdjacencies list;
    private boolean[] visted;
    private int[] edgeTo;

    public BFS(IAdjacencies l) {
	this.list = l;
	this.visted = new boolean[l.size()];
	this.edgeTo = new int[l.size()];
    }

    public void bfs(int src) {
	Queue<Integer> q = new Queue<Integer>();
	q.enqueue(src);

	while (!q.isEmpty()) {
	    int v = q.dequeue();
	    for (int w : list.adjIt(v)) {
		if (!visted[w]) {
		    edgeTo[w] = v;
		    visted[w] = true;
		    q.enqueue(w);
		}

	    }
	}
    }

    public void reset(IAdjacencies l) {
	this.list = l;
	this.edgeTo = new int[list.size()];
	this.visted = new boolean[list.size()];
    }

    public boolean getVisted(int a) {
	return visted[a];
    }

    public int getedgeTo(int a) {
	return edgeTo[a];
    }

    public boolean[] getVisted() {
	return visted;
    }

    public int[] getedgeTo() {
	return edgeTo;
    }

}
