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
public class MergeSort {
    public static int cps=0;
    public static int comps=0;


     private static void merge(double[] a, double[] aux, int lo, int mid, int hi) {
        // precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; 
            cps++;
        }

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid){
                a[k] = aux[j++];
                comps++;
                cps++;
            }
            else if (j > hi)     {
                a[k] = aux[i++];
                comps=comps+2;
                cps++;
            }
            else if (less(aux[j], aux[i])){
                a[k] = aux[j++];
                
                cps++;
                
            }
            else     {
                a[k] = aux[i++];
               comps=comps+2;
               cps++;
            }
        }


        assert isSorted(a, lo, hi);
    }

    private static void sort(double[] a, double[] aux, int lo, int hi) {
        
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }


    public static void sort(double[] a) {
        double[] aux = new double[a.length];
        sort(a, aux, 0, a.length-1);
        assert isSorted(a);
    }

    private static boolean less(double v, double w) {
        comps++;
        return v<(w);
        
    }
        

    private static boolean isSorted(double[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(double[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }


}