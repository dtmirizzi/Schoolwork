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
//	key-value pair with keys of type K, and values of type V
public class KVP<K, V>
{
	public K key;
	public V value;
	
	public KVP(K key, V value)
	{
		this.key = key;
		this.value = value;
	}
	public K getKey(){
	    return this.key;
	}
	public V getValue(){
	    return this.value;
	}

    @Override
    public String toString() {
	return "KVP{" + "key=" + key + ", value=" + value + '}';
    }
	
}
