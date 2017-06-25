/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csc.pkg310.alg;

import java.util.Arrays;

/**
 * @author dtmirizzi
 */
public class HW8 {

    
    public static void main(String[] args) {
	double c[][] = {{2, 7, 1, 5, 70}, {2, 7, 1, 5, 70}, {3, 2, 4, 1, 33}, {8, 1, 5, 3, 56}};
	double b[][] = {{3, 6, 12, 9, 78}, {2, 3, 5, 7, 48}, {1, 7, 2, 3, 27}, {4, 9, 1, 2, 45}};
	double d[][] = {{2, 4, 5, 23}, {1, 5, 3, 16}, {3, 1, 6, 25}};
	double y[][] = {{3, 6, 12, 9}, {2, 3, 5, 7}, {1, 7, 2, 3}, {4, 9, 1, 2 }};
	for(int i=0 ;i<b.length;i++){
		System.out.println(Arrays.toString(b[i]));
	    }
	double[][] a= Gauss.GaussJordan(c);
	double[][] f= Gauss.GaussJordan(b);
	double[][] e= Gauss.GaussJordan(d);
	
	 
	if(!(a==null)){
	    for(int i=0 ;i<a.length;i++){
		System.out.println(Arrays.toString(a[i]));
	    }
	}
	System.out.println("");
	if(!(f==null)){
	    for(int i=0 ;i<f.length;i++){
		System.out.println(Arrays.toString(f[i]));
	    }
	}
	System.out.println("");
	if(!(e==null)){
	    for(int i=0 ;i<e.length;i++){
		System.out.println(Arrays.toString(e[i]));
	    }
	}
	    System.out.println("");
	
	double[][] z=multiply(f,b);
	 for(int i=0 ;i<z.length;i++){
		System.out.println(Arrays.toString(z[i]));
	    }
	 System.out.println("");
//	double[][] y= multiply(d,e);
//	 for(int i=0 ;i<y.length;i++){
//		System.out.println(Arrays.toString(y[i]));
//	    }
	
    }
     // return c = a * b
    public static double[][] multiply(double[][] a, double[][] b) {
        int m1 = a.length;
        int n1 = a[0].length;
        int m2 = b.length;
        int n2 = b[0].length;
        double[][] c = new double[m1][n2-1];
        for (int i = 0; i < m1; i++)
            for (int j = 0; j < n2-1; j++)
                for (int k = 0; k < n1-1; k++)
                    c[i][j] += a[i][k] * b[k][j];
        return c;
    }

}
