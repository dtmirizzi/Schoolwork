
package csc.pkg310.alg;

import java.util.Random;

/**
 *
 * @author dtmirizzi
 */
public class BinarySearch {

    private BinarySearch() {
    }
    public static int cmp=0;
    public static int indexOf(int[] a, int key) {
	int lo = 0;
	int hi = a.length - 1;
	while (lo <= hi) {
	    int mid = lo + (hi - lo) / 2;
	    if (key < a[mid]) {
		cmp++;
		hi = mid - 1;
	    } else if (key > a[mid]) {
		cmp++;
		lo = mid + 1;
	    } else {
		cmp++;
		return mid;
	    }
	}
	return -1;
    }

    public static void main(String[] args) {
	Random rn= new Random();
	int sum=0;
	int[] a = new int[1000];
	for (int i = 0; i < a.length; i++) {
	    a[i] = i;
	}

	int key = 10;
	if (indexOf(a, key) != -1) {
	    System.out.println(key+" is in ops");
	}else
	System.out.println(key + " not in ");
	System.out.println(cmp);
	
	for(int i=0; i<1000; i++){
	key = rn.nextInt(999);
	if (indexOf(a, key) != -1) {
	    sum= cmp+sum;
	    cmp=0;
	}
	}
	System.out.println("avg comps: "+sum/1000.0);
	
    }

}
