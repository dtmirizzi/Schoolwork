/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HW;

import java.util.Random;

/**
 *
 * @author dtmirizzi
 */
public class HW1_4_2 implements Runnable {

    private int count = 0;
    final private int numOfThreads;
    final private double N;
    final private double R=.5;
    final private Random rand= new Random();

    public HW1_4_2(double N, int numOfThreads) {
	this.N = N;
	this.numOfThreads = numOfThreads;
    }

    @Override
    public void run() {
	for (int i = 0; i < N / numOfThreads; i++) {
	    double x = rand.nextDouble() - .5, y = rand.nextDouble() - .5;
	    if ((x * x + y * y) < R * R) {
		count++;
	    }
	}
    }

    public int getCount() {
	return count;
    }
}
