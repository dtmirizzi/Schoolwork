/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc.pkg310.alg;

/**
 *
 * @author dtmirizzi
 */
public class BubbleSort {
    public static int cmps = 0;
    public static int swaps = 0;
    
    public static void reset(){
	cmps = 0;
	swaps = 0;
    }

    public static void BubbleSort(int[] x) {
	boolean swapped = true;
	while (swapped) {
	    swapped = false;
	    for (int i = 1; i < x.length; i++) {
		int temp = 0;
		cmps++;
		if (x[i - 1] > x[i]) {
		    temp = x[i - 1];
		    x[i - 1] = x[i];
		    x[i] = temp;
		    swaps++;
		    swapped = true;
		}
	    }
	}
    }
}
