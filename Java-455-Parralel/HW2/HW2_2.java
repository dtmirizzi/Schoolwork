/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HW;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * @author dtmirizzi
 */
public class HW2_2 {

    static int N = 100; // the size of the array
    static int M = 10;
    static int n = Runtime.getRuntime().availableProcessors();
    static int[] a = new int[N];

    public static void main(String[] args) {
	int[] a = new int[N];
	Random r = new Random();
	Future<int[]>[] futures = new Future[4];

	for (int i = 0; i < a.length; i++) {
	    a[i] = Math.abs(r.nextInt(10) % M);
	}

	ExecutorService pool = Executors.newFixedThreadPool(n);
	HW2_2_Call temp = new HW2_2_Call(a, 0, (int) (N / 4.0), M);
	futures[0] = pool.submit(temp);
	temp = new HW2_2_Call(a, (int) (N / 4.0), (int) (2 * N / 4.0), M);
	futures[1] = pool.submit(temp);
	temp = new HW2_2_Call(a, (int) (2 * N / 4.0), (int) (3 * N / 4.0), M);
	futures[2] = pool.submit(temp);
	temp = new HW2_2_Call(a, (int) (3 * N / 4.0), a.length, M);
	futures[3] = pool.submit(temp);

	int[] count = new int[M];
	int[] x= new int[M];
	for (int i = 0; i < futures.length; i++) {
	    try {
		    x= futures[i].get();
		} catch (InterruptedException ex) {
		} catch (ExecutionException ex) {
		}
	    for (int j = 0; j < count.length; j++) {
		count[j]=x[j]+count[j];
	    }
	}

	int sum = 0;
	for (int i = 0; i < count.length; i++) {
	    sum += count[i];
	}
	if (sum != a.length) {
	    System.out.println("It didn't work! : " + sum + " : "
		    + a.length);
	}
	// only print these for small arrays
	for (int i = 0; i < count.length; i++) {
	    System.out.println(i + " has count : " + count[i]);
	}
	pool.shutdown();

    }

}
