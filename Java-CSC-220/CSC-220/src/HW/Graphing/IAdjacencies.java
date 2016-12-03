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

import java.util.Collection;

/**
 *
 * @author dtmirizzi
 */
public interface IAdjacencies {
    public int size();
    public Iterable<Integer> adjIt(int v);
    public void addAdj(int node, int adj,boolean directed);
    public Collection<Integer> adj(int v);
    public boolean isAdj(int node, int adj);
    public int degree(int node, boolean in);
    public int numOfEdges(boolean dir);
}
