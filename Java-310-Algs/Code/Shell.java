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
public class Shell {
    
    public Shell(){
	
    }

    public static int cmps=0;
     public static int swaps=0;
    
    public static void sort(int[] a) {
        int n = a.length;

        
        int h = 1;
        while (h < n/3) h = 3*h + 1; // interval set to 3x+1 for N4/3 time

        while (h >= 1) {

            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exch(a, j, j-h);
                }
            }
            h /= 3;
        }
    }

    private static boolean less(int v, int w) {
	cmps++;
        return v < w;
    }

    private static void exch(int[] a, int i, int j) {
	swaps++;
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void reset(){
	cmps=0;
	swaps=0;
    }

}
