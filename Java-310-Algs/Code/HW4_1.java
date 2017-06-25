/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csc.pkg310.alg;

import static csc.pkg310.alg.BubbleSort.BubbleSort;
import java.util.Random;

/**
 * @author dtmirizzi
 */
public class HW4_1 {

    
    
public static void main(String[] args) {
	int[] a= new int[100];
	for (int i=0; i<a.length;i++){
	    a[i]= a.length-i; 
	}
	BubbleSort(a);
	System.out.println("worst case:" +BubbleSort.cmps);
	BubbleSort.reset();
	
	int sum=0;
	for(int i=0; i<100; i++){
	shuffle(a);
	BubbleSort(a);
	sum= sum+ BubbleSort.cmps;
	BubbleSort.reset();
	}
	System.out.println("avg case:"+sum/100);
	
	for (int i=0; i<a.length;i++){
	    a[i]= i; 
	}
	BubbleSort(a);
	System.out.println("best case:" +BubbleSort.cmps);
	BubbleSort.reset();

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
