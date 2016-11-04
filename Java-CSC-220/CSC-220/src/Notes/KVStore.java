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
import java.util.LinkedList;

//	a collection of KVPs
public class KVStore<K, V>
{
	private LinkedList<KVP<K, V>> kvps;
	
	public KVStore()
	{
		this.kvps = new LinkedList<>();
	}
	
	public void put(K key, V value)
	{
		//	check if the key is already in the store
		for(KVP<K, V> pair : this.kvps)
		{
			if(pair.key.equals(key))
			{
				//	change the value stored for this key
				pair.value = value;
				return;
			}
		}
		
		//	the key wasn't there so add a new KVP
		KVP<K, V> pair = new KVP<>(key, value);
		this.kvps.add(pair);
	}
	
	public V get(K key)
	{
		for(KVP<K, V> pair : this.kvps)
		{
			if(pair.key.equals(key))
			{
				return pair.value;
			}
		}
		
		//	the key is not in the store
		return null;
	}
	
	public int size()
	{
		return this.kvps.size();
	}
}