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
import java.util.Arrays;

public class Tree23Ver3<K extends Comparable, V> {

    private Node23Ver3<K, V> root;
    private int ht=0;

    public Tree23Ver3() {
	this.root = null;
    }

    public Tree23Ver3(K key, V value) {
	this.root = new Node23Ver3(key, value);

    }

    public void put(K key, V value) {

	if (root == null) {
	    this.root = new Node23Ver3<K, V>(key, value);
	    return;
	} else if (root.children[0] == null) {
	    root.insert(key, value);
	    moveUp(root);
	    return;
	} else {
	    for (int i = 0; i < root.numberOfK(); i++) {
		if (key.compareTo(root.getKey(i)) < 0) {
		    putR(root.children[i], key, value);
		    fixKids(root, i);
		    moveUp(root);
		    return;
		}
	    }
	    putR(root.children[root.numberOfK()], key, value);
	    fixKids(root, root.numberOfK());
	    moveUp(root);

	}
    }

    private void putR(Node23Ver3 current, K Key, V Value) {

	if (current.children[0] == null) {
	    current.insert(Key, Value);
	} else {
	    for (int i = 0; i < current.numberOfK(); i++) {
		if (Key.compareTo(current.getKey(i)) < 0) {
		    putR(current.children[i], Key, Value);
		    fixKids(current, i);
		    return;
		}
	    }
	    putR(current.children[current.numberOfK()], Key, Value);
	    fixKids(current, current.numberOfK());
	}
    }

    public void moveUp(Node23Ver3<K, V> cur) {
	if (root.is4node()) {
	    Node23Ver3<K, V> newLeft = new Node23Ver3<K, V>(cur.getKVP(0), cur.getChild(0), cur.getChild(1));
	    Node23Ver3<K, V> newRight = new Node23Ver3<K, V>(cur.getKVP(2), cur.getChild(2), cur.getChild(3));
	    root = new Node23Ver3<K, V>(cur.getKVP(1), newLeft, newRight);
	} else {

	}
    }

    public void fixKids(Node23Ver3<K, V> cur, int i) {
	if (cur.children[i].is4node()) {
	    Node23Ver3<K, V> newLeft = new Node23Ver3<K, V>(cur.children[i].getKVP(0), cur.children[i].getChild(0), cur.children[i].getChild(1));
	    Node23Ver3<K, V> newRight = new Node23Ver3<K, V>(cur.children[i].getKVP(2), cur.children[i].getChild(2), cur.children[i].getChild(3));
	    cur.insert(cur.children[i].getKVP(1));
	    cur.setKid(i, newLeft);
	    cur.setKid(i + 1, newRight);

	} else {

	}
    }

    public int depth() {
	int depth = 1;
	int[] d = new int[3];
	for (int i = 0; i < 3; i++) {
	    if (root.children[i] != null) {
		d[i] = depthR(root.children[i]) + depth;
	    }
	}
	for (int i = 0; i < 2; i++) {
	    if (d[i] > depth) {
		depth = d[i];
	    }
	}
	return depth;
    }

    private int depthR(Node23Ver3<K, V> child) {
	int depth = 1;
	int[] d = new int[3];
	for (int i = 0; i < 3; i++) {
	    if (child.children[i] != null) {
		d[i] = depthR(child.children[i]) + depth;
	    }
	}
	for (int i = 0; i < 2; i++) {
	    if (d[i] > depth) {
		depth = d[i];
	    }
	}
	return depth;
    }

    public int size() {
	int size = root.numberOfK();
	for (int i = 0; i < root.numberOfK() + 1; i++) {
	    if (root.children[i] != null) {
		size = size + size(root.children[i]);
	    }
	}
	return size;
    }

    public int size(Node23Ver3<K, V> child) {
	int size = child.numberOfK();
	for (int i = 0; i < child.numberOfK() + 1; i++) {
	    if (child.children[i] != null) {
		size = size + size(child.children[i]);
	    }
	}
	return size;
    }

    public V get(K key) {
	for (int i = 0; i < root.numberOfK(); i++) {
	    if (key.equals(root.getKey(i))) {
		return root.getValue(i);
	    } else if (key.compareTo(root.getKey(i)) < 0) {
		return getR(key, root.children[i]);
	    }
	}
	return getR(key, root.children[root.numberOfK()]);
    }

    public V getR(K key, Node23Ver3<K, V> current) {
	for (int i = 0; i < current.numberOfK(); i++) {
	    if (key.equals(current.getKey(i))) {
		return current.getValue(i);
	    } else if (key.compareTo(current.getKey(i)) < 0) {
		return getR(key, current.children[i]);
	    }
	}
	return getR(key, current.children[current.numberOfK()]);
    }

    public void print() {
	printR(this.root, 0);
    }

    private void printR(Node23Ver3<K, V> current, int level) {
	if (current == null) {
	    return;
	}
	System.out.print(tabN(level)+"{");
	for (int i = 0; i < 3; i++) {
	    if (current.KVpairs[i] == null&&i==2) {
		System.out.print("null");
	    } else if(current.KVpairs[i] == null){
		System.out.print("null, ");
	    }
	    else {
		System.out.print(current.KVpairs[i].toString() + ", ");
	    }

	}
	System.out.println("} |S|= " + current.keyLength());

	for (int i = 0; i < current.keyLength() + 1; i++) {
	    printR(current.children[i], level + 1);
	}
    }

    private String tabN(int n) {
	String result = "";
	for (int i = 0; i < n; i++) {
	    result = result + "\t";
	}
	return result;
    }

}
