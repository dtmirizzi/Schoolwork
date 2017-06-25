/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HW;


/**
 * @author dtmirizzi
 */
public class HW1_4 {

    static double N = 10000;

    public static void main(String[] args) {
	//	make two counter runnables
	HW1_4_2 p1 = new HW1_4_2(N,2);
	HW1_4_2 p2 = new HW1_4_2(N,2);

	//	wrap the runnables in threads
	Thread t1 = new Thread(p1);
	Thread t2 = new Thread(p2);

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

	System.out.println((4*(p1.getCount()+p2.getCount()))/N);

    }

}
