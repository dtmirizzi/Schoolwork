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
public class HW6_1 {

    public static void main(String[] args) throws IOException {
	UndirectedGraph UG1 = new UndirectedGraph();
	UG1 = UG1.readGraph("/home/dtmirizzi/Notebook16-17/CSC-220/HW/Assignment 6/data.csv");
	System.out.println(UG1.path(0, 12));
	System.out.println(UG1.shortestPath(0, 12));
	
    }

}
