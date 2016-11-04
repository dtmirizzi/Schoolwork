/*
 * Copyright (C) 2016 dtmirizzi
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
package HW;



/**
 * @author dtmirizzi
 */
public class HW1_3 {

    public static int swaps, cmps;

    public static void main(String[] args) {
        double[] a, b;
        cmps = 0;
        swaps = 0;
        int ops = 0;
        int N = 100;

        for (int i = 1; i < 100; i++) {
            a = randomFill(N);
            selectionSort(a);
            ops = cmps + swaps;
        }
        System.out.println("Selction sort Avg Ops: " + ops / 100);
        cmps = 0;
        swaps = 0;
        ops = 0;

        for (int i = 1; i < 100; i++) {
            a = randomFill(N);
            insertionSort(a);
            ops = cmps + swaps;
        }
        System.out.println("Insertion sort Avg Ops: " + ops / 100);
        cmps = 0;
        swaps = 0;
        ops = 0;
        Notes.MergeSort.cps=0;
        Notes.MergeSort.comps=0;
        

        for (int i = 1; i < 100; i++) {
            
            a = randomFill(N);
            Notes.MergeSort.sort(a);
            ops = Notes.MergeSort.cps + Notes.MergeSort.comps;
        }
        System.out.println("Merge sort Avg Ops: " + ops / 100);

//        for (int i = 1; i < 100; i++) {
//            a = randomFill(N);
//            b = randomFill(N);
//            Notes.MergeSort.sort(a);
//            Notes.MergeSort.sort(b);
//            merge(a, b);
//            ops = cmps + swaps;
//        }
//        System.out.println("Merge Avg Ops: " + ops / 100);

    }

    public static double[] merge(double[] a, double[] b) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (a.length != b.length) {
            throw new UnsupportedOperationException("Input arrays are not of the same length:");
        }
        double[] merged = new double[a.length + b.length];
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < b[j]) {
                cmps++;
                merged[i] = a[i];
                swaps++;
            } else {
                merged[i] = b[j];
                ++j;
                swaps++;
            }
        }
        return merged; 
    }

    public static boolean isSorted(double[] a) {
        boolean Sorted = true;
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                Sorted = false;
                break;
            }
        }
        return Sorted;
    }

    public static double[] randomFill(int N) {
        int i;
        double[] b = new double[N];
        for (i = 0; i < N; i++) {
            b[i] = Math.random();
        }
        return b;
    }

    public static void swap(double[] a, int i, int j) {
        swaps++;
        double temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //	find the position of the min in an array of doubles
    //	starting from the given start position
    public static int findMinPos(double[] a, int start) {
        int minPos = start;
        for (int i = start + 1; i < a.length; i++) {
            if (a[i] < a[minPos]) {
                minPos = i;

            }
            cmps++;
        }

        return minPos;
    }

    public static void selectionSort(double[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minPos = findMinPos(a, i);
            swap(a, i, minPos);
        }
    }

    public static boolean lessThan(double[] a, int i, int j) {
        cmps++;
        return a[i] < a[j];
    }

    public static void insertionSort(double[] a) {
        int j;
        for (int i = 1; i < a.length; i++) {
            j = i;
            while (j != 0 && lessThan(a, j - 1, j)) {
                swap(a, j, j - 1);
                j--;
            }
        }
    }

}
