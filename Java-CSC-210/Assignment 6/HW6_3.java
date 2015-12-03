package HW;
// @author dtmirizzi

import java.util.Arrays;


public class HW6_3 {

    public static int swaps, cmps;

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

    public static double[] random(int N) {
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
        for (int i = 1; i < a.length; i++) {
            int j = i;
            while (j != 0 && lessThan(a, j-1, j)) {
                swap(a, j, j - 1);
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int operations = 0;
        double[] a;
        int N = 10000  ;
        for (int i = 0; i < 100; i++) {
            cmps = 0;
            swaps = 0;
            a = random(N);
                selectionSort(a);
                operations = operations + cmps + swaps;
                        
        }
        System.out.println("Selection Sort avg operations: " + (operations / N) + " When N: " + N);
        operations = 0;
        for (int i = 0; i < 100; i++) {
            cmps = 0;
            swaps = 0;
            a = random(N);

            insertionSort(a);
            operations = operations + cmps + swaps;

        }

        System.out.println("Insertion sort avg operations: " + (operations * 1.0 / N) + " When N: " + N);
    }

}
