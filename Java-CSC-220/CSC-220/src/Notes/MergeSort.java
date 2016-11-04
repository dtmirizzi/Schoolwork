/*
 * Copyright (C) 2016 P-OWL
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package Notes;

/**
 * @author dtmirizzi
 */
public class MergeSort {
    public static int cps=0;
    public static int comps=0;

    private MergeSort() {}

     private static void merge(double[] a, double[] aux, int lo, int mid, int hi) {
        // precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; 
            cps++;
        }

        // merge back to a[]
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

        // postcondition: a[lo .. hi] is sorted
        assert isSorted(a, lo, hi);
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(double[] a, double[] aux, int lo, int hi) {
        
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(double[] a) {
        double[] aux = new double[a.length];
        sort(a, aux, 0, a.length-1);
        assert isSorted(a);
    }


   /***************************************************************************
    *  Helper sorting function.
    ***************************************************************************/
    
    // is v < w ?
    private static boolean less(double v, double w) {
        comps++;
        return v<(w);
        
    }
        
   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/
    private static boolean isSorted(double[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(double[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }


}
