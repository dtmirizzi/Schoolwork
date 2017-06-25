/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc.pkg310.alg;

import java.util.Arrays;
import java.util.Random;

/**
 * @author dtmirizzi
 */
public class HW5 {

    public static void main(String[] args) {
	String[] unsorted = {"zero", "one", "two", "three", "four", "five", "six", "seven",
	    "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
	    "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};
	System.out.println(Arrays.toString(RadixLSD.sort(unsorted,3)));
	
	Random rn= new Random();
	for(int i=0; i<10; i++){
	int[] x= new int[(int)Math.pow(2, (double) i)];
	for(int j=0; j< x.length; j++){
	    x[j]= rn.nextInt();
	}
	Shell.sort(x);
	System.out.print(i+ ", ");
	System.out.println(Shell.cmps+Shell.swaps);
	Shell.reset();
	}
    }

}
