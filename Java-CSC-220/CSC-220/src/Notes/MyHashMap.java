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
import java.util.LinkedList;

//	a hash map storing keys and values
public class MyHashMap<K, V> {

    //	each bucket is an array of KVPs

    private LinkedList<KVP<K, V>>[] bucket;
    private int size;

    public MyHashMap(int M) {
	this.bucket = (LinkedList<KVP<K, V>>[]) new LinkedList[M];
	for (int i = 0; i < M; i++) {
	    bucket[i] = new LinkedList<KVP<K, V>>();
	}
	this.size = 0;
    }

    //	given a key return a bucket index into the bucket array
    public int getBucketNumber(K key) {
	return Math.abs(key.hashCode()) % this.bucket.length;
    }

    public void put(K key, V value) {
	int b = getBucketNumber(key);

	//		check if the key is already in bucket b
	for (KVP<K, V> pair : this.bucket[b]) {
	    if (pair.key.equals(key)) {
		//	change the value stored for this key
		pair.value = value;
		return;
	    }
	}

	//	the key wasn't there so add a new KVP
	KVP<K, V> pair = new KVP<>(key, value);
	this.bucket[b].add(pair);
	size++;
    }

    public V get(K key) {
	int b = getBucketNumber(key);

	//	search bucket b for the key
	for (KVP<K, V> pair : this.bucket[b]) {
	    if (pair.key.equals(key)) {
		return pair.value;
	    }
	}

	//	the key is not in the store
	return null;
    }

    public boolean containsKey(K key) {
	int b = getBucketNumber(key);
	for (KVP<K, V> pair : this.bucket[b]) {
	    if (pair.key.equals(key)) {
		return true;
	    }
	}
	return false;
    }

    public int size() {
	return this.size;
    }

    public boolean isEmpty() {
	if (this.size == 0) {
	    return true;
	} else {
	    return false;
	}
    }

    public void delete(K key) {
	int b = getBucketNumber(key);
	Iterator pair=this.bucket[b].iterator();

	// print list with the iterator
	while (pair.hasNext()) {
	    KVP<K, V> k = (KVP)pair.next();
	    
	    if (k.key.equals(key)){
		
		pair.remove();

		return;
	    }
	   
	    pair.next();
	}
    }
}
