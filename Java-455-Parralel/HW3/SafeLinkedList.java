/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HW;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author dtmirizzi
 */
public class SafeLinkedList {
    private LinkedList l;
    private Lock lk = new ReentrantLock();
    
    public SafeLinkedList(){
	
    }
    
    public void add(Object a){
	lk.lock();
	try {
	    l.add(a);
	} finally {
	    lk.unlock();
	}
    }
    
    public Object remove(){
	lk.lock();
	try {
	    return l.remove();
	} finally {
	    lk.unlock();
	}
    }
     public int size(){
	lk.lock();
	try {
	    return l.size();
	} finally {
	    lk.unlock();
	}
	
    }
}
