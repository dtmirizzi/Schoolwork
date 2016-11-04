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
package Notes;

import java.util.ArrayList;

/**
 *
 * @author dtmirizzi
 * very efficent stack or queue because add remove back with array list, 
 * or you can use a linked list and have an efficent remove front final question!
 * Stacks are useful for reversing string order
 */
public class Stack<E> {
    ArrayList<E> elements;
    public Stack(){
	elements = new ArrayList<E>();
    }
    
    public void push(E element){
	this.elements.add(element);
    }
    public E pop(){
	return this.elements.remove(this.elements.size()-1);
    }
    
    
}
