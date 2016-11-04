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

/**
 *
 * @author dtmirizzi
 */
import java.util.Iterator;
public class MyArrayListIt <E> implements Iterator<E> {

	//	the list we are iterating over
	private MyArrayList<E> list;
	private int current;

	public MyArrayListIt(MyArrayList<E> list)
	{
		this.list = list;
		this.current = 0;
	}

	public boolean hasNext()
	{
		return this.current < this.list.size();
	}

	public E next()
	{
		E val = this.list.get(this.current);
		current++;
		return val;
	}

	public void remove()
	{
		// TODO Auto-generated method stub

	}
}
    

