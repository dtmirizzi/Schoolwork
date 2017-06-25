/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc.pkg310.alg;

import java.util.Random;

/**
 *
 * @author dtmirizzi
 */
public class QuickSort {

    public static int[] sequence;
    private static int pivoter;
    public static int cmps = 0;
    public static int swaps = 0;

    public QuickSort(int[] x, int y) {
	sequence = x;
	pivoter = y;
    }

    public void sort() {
	QuickSort(0, sequence.length - 1);
    }

    public static void QuickSort(int left, int right) {
	if (right - left <= 0) {
	    return;
	} else {
	    Random rand = new Random();
	    int pivotIndex;
	    if (pivoter == 0) {
		pivotIndex = left + rand.nextInt(right - left + 1);
	    }
	    if (pivoter == 1) {
		pivotIndex = left;
	    } else {
		pivotIndex = right;
	    }
	    swap(pivotIndex, right);

	    int pivot = sequence[right];
	    int partition = partitionIt(left, right, pivot);
	    QuickSort(left, partition - 1);
	    QuickSort(partition + 1, right);
	}
    }

    public static int partitionIt(int left, int right, long pivot) {
	int leftPtr = left - 1;
	int rightPtr = right;
	while (true) {
	    while (sequence[++leftPtr] < pivot) {
		cmps++;
	    }
	    while (rightPtr > 0 && sequence[--rightPtr] > pivot) {
		cmps++;
	    }

	    if (leftPtr >= rightPtr) {
		break;
	    } else {
		swap(leftPtr, rightPtr);
	    }
	}
	swap(leftPtr, right);
	return leftPtr;
    }

    public static void swap(int dex1, int dex2) {
	swaps++;
	int temp = sequence[dex1];
	sequence[dex1] = sequence[dex2];
	sequence[dex2] = temp;
    }
}
