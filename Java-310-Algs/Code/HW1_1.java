/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc.pkg310.alg;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author dtmirizzi
 */
public class HW1_1 {

    public static void main(String[] args) throws InterruptedException {
	Random rand = new Random();
	double N = 1000;
	int[] die1 = new int[5];
	int[] die2 = new int[5];
	Runnable a = () -> {
	    for (int i = 0; i < N; i++) {
		int temp = rand.nextInt(7) + 1;
		if (temp == 1) {
		    die1[0] = die1[0] + 1;
		}
		if (temp == 2) {
		    die1[1] = die1[1] + 1;
		}
		if (temp == 3 || temp == 4) {
		    die1[2] = die1[2] + 1;
		}
		if (temp == 5) {
		    die1[3] = die1[3] + 1;
		}
		if (temp > 5) {
		    die1[4] = die1[4] + 1;
		}
	    }
	};
	Runnable b = () -> {
	    for (int i = 0; i < N ; i++) {
		int temp = rand.nextInt(7) + 1;
		if (temp == 1) {
		    die2[0] = die2[0] + 1;
		}
		if (temp == 2) {
		    die2[1] = die2[1] + 1;
		}
		if (temp == 3 || temp == 4) {
		    die2[2] = die2[2] + 1;
		}
		if (temp == 5) {
		    die2[3] = die2[3] + 1;
		}
		if (temp > 5) {
		    die2[4] = die2[4] + 1;
		}
	    }
	};
	Thread t1 = new Thread(a);
	Thread t2 = new Thread(b);
	t1.start();
	t2.start();
	t1.join();
	t2.join();
	for(int i=0; i<5; i++){
	    System.out.println(die1[i]/N+ " | "+ die2[i]/N);
	}

    }

}
