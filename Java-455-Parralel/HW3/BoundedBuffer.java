/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HW;

import java.nio.Buffer;
import java.util.*;
import java.util.concurrent.Semaphore;

/**
 *
 * @author dtmirizzi
 */

public class BoundedBuffer<E> {

    private static int BUFFER_SIZE;

    private Semaphore mutex;
    private Semaphore empty;
    private Semaphore full;

    private int count;
    private int in, out;
    private E[] buffer;

    public BoundedBuffer(int bound) {
	this.BUFFER_SIZE= bound;
	
	count = 0;
	in = 0;
	out = 0;

	buffer = (E[]) new Object[BUFFER_SIZE];

	mutex = new Semaphore(1);
	empty = new Semaphore(BUFFER_SIZE);
	full = new Semaphore(0);
    }

    public void put(E item) throws InterruptedException {
	empty.acquire();
	mutex.acquire();

	++count;
	buffer[in] = item;
	in = (in + 1) % BUFFER_SIZE;

	if (count == BUFFER_SIZE) {
	    System.out.println("Producer Entered " + item + " Buffer FULL");
	} else {
	    System.out.println("Producer Entered " + item + " Buffer Size = " + count);
	}

	mutex.release();
	full.release();
    }


    public E take() throws InterruptedException {
	full.acquire();
	mutex.acquire();

	--count;
	E item = buffer[out];
	out = (out + 1) % BUFFER_SIZE;

	if (count == 0) {
	    System.out.println("Consumer Consumed " + item + " Buffer EMPTY");
	} else {
	    System.out.println("Consumer Consumed " + item + " Buffer Size = " + count);
	}

	mutex.release();
	empty.release();

	return item;
    }

}
