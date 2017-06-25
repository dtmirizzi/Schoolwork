/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc.pkg310.alg;

import java.util.Arrays;
import java.util.Random;

/**
 * @author dtmirizzi
 */
public class HW6 {

    public static void main(String[] args) {
	System.out.println("Merge:");
	for (int i = 10; i < 1000000; i = i * 10) {
	    double[] x = randomFill(i);
	    MergeSort.sort(x);
	    System.out.println(i + ", " + (MergeSort.comps + MergeSort.cps));
	    MergeSort.comps = 0;
	    MergeSort.cps = 0;
	}

	System.out.println();

	System.out.println("Quick random:");
	for (int i = 10; i < 1000000; i = i * 10) {
	    int[] x = randomFillints(i);
	    QuickSort st = new QuickSort(x, 0);
	    st.sort();
	    System.out.println(i + ", " + (st.cmps + st.swaps) + isSorted(st.sequence));
	    st.cmps =0;
	    st.swaps=0;
	}

	System.out.println();
	System.out.println("quick left:");
	for (int i = 10; i < 1000000; i = i * 10) {
	    int[] x = randomFillints(i);
	    QuickSort st = new QuickSort(x, 1);
	    st.sort();
	    System.out.println(i + ", " + (st.cmps + st.swaps) + isSorted(st.sequence));
	    st.cmps =0;
	    st.swaps=0;

	}
	
	System.out.println();
	System.out.println("quick right:");
	for (int i = 10; i < 1000000; i = i * 10) {
	    int[] x = randomFillints(i);
	    QuickSort st = new QuickSort(x, 2);
	    st.sort();
	    System.out.println(i + ", " + (st.cmps + st.swaps) + isSorted(st.sequence));
	    st.cmps =0;
	    st.swaps=0;

	}
	
	System.out.println();
	System.out.println("quick left presort:");
	for (int i = 10; i < 100000; i = i * 10) {
	    int[] x= new int[i];
	    for(int j=0; j<i; j++){
		x[j]=j;
	    }
	    QuickSort st = new QuickSort(x, 2);
	    st.sort();
	    System.out.println(i + ", " + (st.cmps + st.swaps) + isSorted(st.sequence));
	    st.cmps =0;
	    st.swaps=0;

	}
	System.out.println();
	System.out.println("quick left revsort:");
	for (int i = 10; i < 100000; i = i * 10) {
	    int[] x= new int[i];
	    for(int j=0; j<i; j++){
		x[j]=x.length-j;
	    }
	    QuickSort st = new QuickSort(x, 2);
	    st.sort();
	    System.out.println(i + ", " + (st.cmps + st.swaps) + isSorted(st.sequence));
	    st.cmps =0;
	    st.swaps=0;

	}

	
    }

    public static double[] randomFill(int N) {
	int i;
	Random rn = new Random(10);
	double[] b = new double[N];
	for (i = 0; i < N; i++) {
	    b[i] = rn.nextDouble() * 1000;
	}
	return b;
    }

    public static int[] randomFillints(int N) {
	int i;
	Random rn = new Random(10);
	int[] b = new int[N];
	for (i = 0; i < N; i++) {
	    b[i] = rn.nextInt() * 1000;
	}
	return b;
    }

    public static boolean isSorted(int[] a) {
	boolean Sorted = true;
	for (int i = 1; i < a.length; i++) {
	    if (a[i - 1] > a[i]) {
		Sorted = false;
		break;
	    }
	}
	return Sorted;
    }

}
