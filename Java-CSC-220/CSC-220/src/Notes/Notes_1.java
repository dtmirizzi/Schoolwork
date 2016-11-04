/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Notes;

import java.util.Arrays;

public class Notes_1 {

public static void swap(double[] a, int i, int j){
    double temp= a[i];
    a[i]= a[j];
    a[j]= temp;
}
public static int findMinPos(double[] a, int start){
    int minPos = start;
        for (int i = start + 1; i < a.length; i++) {
            if (a[i] < a[minPos]) {
                minPos = i;

            }
}
        return minPos;
}
public static void selectionSort(double[] a){
for (int i = 0; i < a.length - 1; i++) {
            int minPos = findMinPos(a, i);
            swap(a, i, minPos);
        }
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
    public static void main(String[] args) {
        double[] a= {2,6,4,5,3};
        double[] b= {2,6,4,5,3};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        selectionSort(b);
        System.out.println(Arrays.toString(b));
        double[] c= {2,6,4,5,3};
        Notes.MergeSort.sort(c);
        System.out.println(Arrays.toString(c));
    }
    
}
