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
public class Node23Ver3<K extends Comparable, V> {

    KVP<K, V>[] KVpairs;
    Node23Ver3<K, V>[] children;
    

    public Node23Ver3(K key, V value) {
	KVpairs = (KVP<K, V>[]) new KVP[3];
	children = (Node23Ver3<K, V>[]) new Node23Ver3[4];
	KVpairs[0] = new KVP<K, V>(key, value);
    }
    

    public Node23Ver3(KVP<K, V> kvp, Node23Ver3<K, V> left, Node23Ver3<K, V> right) {
	this(kvp.getKey(), kvp.getValue());
	this.setKid(0, left);
	this.setKid(1, right);
    }

    public boolean is3Node() {
	boolean temp = this.KVpairs[1] != null && KVpairs[2] == null && KVpairs[0] != null;
	return temp;
    }

    public boolean is2Node() {
	boolean temp =  KVpairs[1] == null && KVpairs[2] == null && KVpairs[0] != null;
	return temp;
    }

    public boolean is4node() {
	boolean temp =  KVpairs[1] != null && KVpairs[2] != null && KVpairs[0] != null;
	return temp;
    }
    public boolean isEmpty() {
	boolean temp =  KVpairs[1] == null && KVpairs[2] == null && KVpairs[0] == null;
	return temp;
    }
    public boolean isNull() {
	boolean temp = this==null;
	return temp;
    }

    public K getKey(int i) {

	return this.KVpairs[i].getKey();
    }

    public Node23Ver3<K, V> getChild(int i) {
	return children[i];
    }

    public int numberOfK() {
	if (KVpairs[1] == null && KVpairs[2] == null && KVpairs[0] != null) {
	    return 1;
	} else if (this.KVpairs[1] != null && KVpairs[2] == null && KVpairs[0] != null) {
	    return 2;
	} else {
	    return 3;
	}

    }

    public void insert(K key, V value) {
	for (int i = 0; i < numberOfK(); i++) {
	    if (key.compareTo(KVpairs[i].getKey()) < 0) {
		for (int j = 2; j > 0; j--) {
		    KVpairs[j] = KVpairs[j - 1];
		}
		for (int k = 3; k > 0; k--) {
		    children[k] = children[k - 1];
		}
		KVpairs[i] = new KVP(key, value);
		return;
	    }
	    if (key.equals(KVpairs[i].getKey())) {
		KVpairs[i] = new KVP(key, value);
		return;
	    }
	}
	KVpairs[numberOfK()] = new KVP(key, value);
    }

    public void insert(KVP<K, V> input) {
	if(input==null)System.err.println("KVP input is Null");
	else{
	this.insert(input.getKey(), input.getValue());
	}
    }

    public KVP<K, V> getKVP(int i) {
	return KVpairs[i];
    }

    public void setKid(int i, Node23Ver3<K, V> k) {
	children[i] = k;
    }

    public int keyLength() {
	int j = 0;
	for (int i = 0; i < 3; i++) {
	    if (KVpairs[i] != null) {
		j++;
	    }
	}
	return j;
    }

    public V getValue(int i) {
	return this.KVpairs[i].getValue();
    }

}
