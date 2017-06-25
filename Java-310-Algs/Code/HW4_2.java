/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csc.pkg310.alg;

import java.util.Random;
import static csc.pkg310.alg.insertionSort.insertionSort;

/**
 * @author dtmirizzi
 */
public class HW4_2 {

    
    public static void main(String[] args) {
        int[] a= new int[1000];
	for (int i=0; i<a.length;i++){
	    a[i]= a.length-i; 
	}
	insertionSort(a);
	System.out.println("best case Compairs:" +insertionSort.cmps+insertionSort.swaps);
	insertionSort.reset();
	
	int sum=0;
	for(int i=0; i<100; i++){
	shuffle(a);
	insertionSort(a);
	sum= sum+ insertionSort.cmps+insertionSort.swaps;
	insertionSort.reset();
	}
	System.out.println("avg case:"+sum/100);
	
	for (int i=0; i<a.length;i++){
	    a[i]= i; 
	}
	insertionSort(a);
	System.out.println("worst case:" +(insertionSort.cmps+insertionSort.swaps));
	insertionSort.reset();

	}

	static void shuffle(int[] ar) {
		Random rn = new Random();
		for (int i = 0; i < ar.length - 1; ++i) {
			int j = rn.nextInt(ar.length - i) + i;
			// Simple swap
			int a = ar[j];
			ar[j] = ar[i];
			ar[i] = a;
		}

    }

}
