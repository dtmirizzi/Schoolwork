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
public class insertionSort {

    public static int cmps = 0;
    public static int swaps = 0;

    public static void insertionSort(int[] a) {
	int j;
	for (int i = 1; i < a.length; i++) {
	    j = i;
	    while (j != 0 && lessThan(a, j - 1, j)) {
		swap(a, j, j - 1);
		j--;
	    }
	}
    }

    public static boolean lessThan(int[] a, int i, int j) {
	cmps++;
	return a[i] < a[j];
    }

    public static void swap(int[] a, int i, int j) {
	swaps++;
	int temp = a[i];
	a[i] = a[j];
	a[j] = temp;
    }

    public static void reset() {
	cmps = 0;
	swaps = 0;
    }

}
