/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HW;

import java.util.LinkedList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author dtmirizzi
 */
public class HW2_4 {

    static ExecutorService pool;
    static LinkedList<Future<int[][]>> list = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
	int[] a = new int[1000];
	int k = 10;
	for (int i = 0; i < a.length; i++) {
	    a[i] = a.length - i;
	}

	System.out.println("Sol: " + Select(k, a));
    }

    public static int Select(int k, int[] a) throws InterruptedException, ExecutionException {
	return Select(k, a, 0, a.length - 1);
    }

    private static int Select(int k, int[] a, int lo, int hi) throws InterruptedException, ExecutionException {
	pool = Executors.newFixedThreadPool(2);
	int at = a[lo];
	int gap = (hi - lo) / 2;
	if (gap != 0) {
	    for (int i = 0; i < 1; i++) {
		final int I = i;
		list.add(pool.submit(() -> {
		    int start = lo + I * gap;
		    int tempStart = start;
		    int end = start + gap - 1;
		    int tempEnd = end;
		    int v = at;
		    while (true) {
			while (tempStart < end && (a[tempStart++] < v)) {
			    if (tempStart == end) {
				break;
			    }
			}

			while (tempEnd > start && (a[tempEnd--] < v)) {
			    if (tempEnd == start) {
				break;
			    }
			}
			if (tempStart >= tempEnd) {
			    break;
			}
			Swap(a, tempStart, tempEnd);
		    }
		    int[][] ret = new int[2][];
		    int[] ret1 = new int[tempEnd - start];
		    int[] ret2 = new int[end - tempEnd + 1];

		    for (int z = 0; z < ret1.length; z++) {
			ret1[z] = a[start + z];
		    }
		    for (int z = 0; z < ret2.length; z++) {
			ret2[z] = a[tempEnd + z];
		    }
		    ret[0] = ret1;
		    ret[1] = ret2;
		    return ret;
		}));
	    }

	    list.add(pool.submit(() -> {
		int start = lo * gap;
		int tempStart = start;
		int end = hi;
		int tempEnd = end;
		int v = at;
		while (true) {
		    while ((a[tempStart++] < v)) {
			if (tempStart == end) {
			    break;
			}
		    }
		    while ((a[tempEnd--] > v)) {
			if (tempEnd == start) {
			    break;
			}
		    }
		    if (tempStart >= tempEnd) {
			break;
		    }
		    Swap(a, tempStart, tempEnd);
		}
		int[][] ret = new int[2][];
		int[] ret1 = new int[tempEnd - start];
		int[] ret2 = new int[end - tempEnd + 1];

		for (int z = 0; z < tempEnd - start; z++) {
		    ret1[z] = a[start + z];
		}
		for (int z = 0; z < end - (tempEnd + 1); z++) {
		    ret2[z] = a[start + z];
		}
		ret[0] = ret1;
		ret[1] = ret2;
		return ret;
	    }));
	    int[][] ret = new int[2][];
	    int[][][] temp = new int[2][][];
	    int it = 0;
	    for (int i = 0; i < 2; i++) {
		temp[i] = list.pollFirst().get();
		it = it + temp[i][0].length;
	    }
	    ret[0] = new int[it];
	    for (int i = 0, track = 0; i < 2; i++) {
		for (int j = 0; j < temp[i][0].length; j++, track++) {
		    ret[0][track] = temp[i][0][j];
		}
	    }
	    ret[1] = new int[it];
	    for (int i = 0, track = 0; i < 2; i++) {
		for (int j = 0; j < temp[i][1].length; j++, track++) {
		    ret[1][track] = temp[i][1][j];
		}
	    }

	    if (it == k) {
		return a[lo];
	    } else if (it > k) {
		return Select(k, ret[0], 0, ret[0].length - 1);
	    } else {
		return Select(k - (it + 1), ret[1], 1, ret[1].length - 1);
	    }
	} else {
	    return HW.HW2_3.findKthSmallest(a, k);
	}
    }

    private static void Swap(int[] a, int tempStart, int tempEnd) {
	int swap = a[tempStart];
	a[tempStart] = tempEnd;
	a[tempEnd] = swap;
    }

}
