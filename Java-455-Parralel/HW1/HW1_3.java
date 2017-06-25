/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HW;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dtmirizzi
 */
public class HW1_3 {

    static AtomicInteger landsIn = new AtomicInteger(0);
    static Random rand = new Random();
    static double R = .5;
    static double N = 100000;

    public static void main(String[] args) {
	// Create Runnables (Using Lambda)
	Runnable r1,r2;
	r1 = () -> {
	    for (int i = 0; i < N/2; i++) {
		double x = rand.nextDouble() - .5, y = rand.nextDouble() - .5;
		if ((x * x + y * y) < R * R) {
		    landsIn.incrementAndGet();
		}
	    }
	};
	r2 = () -> {
	    for (int i = 0; i < N/2; i++) {
		double x = rand.nextDouble() - .5, y = rand.nextDouble() - .5;
		if ((x * x + y * y) < R * R) {
		    landsIn.incrementAndGet();
		}
	    }
	};
	//Make the Threads
	Thread t1 = new Thread(r1);
	Thread t2 = new Thread(r2);
	
	//	start the threads
	t1.start();
	t2.start();

	//	wait for the two threads to finish
	try {
	    t1.join();
	    t2.join();
	} catch (InterruptedException ex) {
	    //	
	}

	System.out.println((4*landsIn.intValue())/N);
    }

}
