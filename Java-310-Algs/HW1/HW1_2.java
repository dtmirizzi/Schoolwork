/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc.pkg310.alg;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author dtmirizzi
 */
public class HW1_2 {

    public static void main(String[] args) {
	final double N= 100000;
	int[] die1 = {1, 2, 3, 9, 10, 11, 0};
	int[] die2 = {0, 1, 7, 8, 8, 9, 0};
	int[] die3 = {5, 5, 6, 6, 7, 7, 0};
	int[] die4 = {3, 4, 4, 5, 11, 12, 0};
	LinkedList<int[]> dice = new LinkedList<>();
	dice.add(die1);
	dice.add(die2);
	dice.add(die3);
	dice.add(die4);
	Random rand = new Random(8);
	Random rand2 = new Random(6);

	for (int i = 0; i < N; i++) {
	    for (int[] x : dice) {
		for (int[] y : dice) {
		    if (x == y); else {
			int temp = rand.nextInt(5);
			int temp2 = rand2.nextInt(5);
			if (x[temp] > y[temp2]) {
			    x[6] = x[6] + 1;
			}
		    }
		}
	    }
	}
	for (int[] x : dice) {
	    System.out.println((x[6]/N)-1);
	}
    }

}
