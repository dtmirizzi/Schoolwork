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
public class RadixLSD {

    public static String[] sort(String[] a,int resolution) {
        int n = a.length;
        int R = 256;  
        String[] aux = new String[n];

        for (int d = resolution-1; d >= 0; d--) {

            int[] count = new int[R+1];
            for (int i = 0; i < n; i++)
                count[a[i].charAt(d) + 1]++;

            for (int r = 0; r < R; r++)
                count[r+1] += count[r];

            for (int i = 0; i < n; i++)
                aux[count[a[i].charAt(d)]++] = a[i];

            for (int i = 0; i < n; i++)
                a[i] = aux[i];
        }
	return a;
    }

}
