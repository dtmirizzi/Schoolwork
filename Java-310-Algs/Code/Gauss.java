/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc.pkg310.alg;

import java.util.Arrays;

/**
 *
 * @author dtmirizzi
 */
public class Gauss {

    public static double[][] GaussJordan(double[][] a) {
	double[][] i= new double[a.length][a[0].length];
	for(int k=0;k<i.length;k++){
	    for(int j=0; j<i[k].length;j++){
		i[k][j]=0;
		if(k==j){
		    i[k][j]=1;
		}
	    }
	}
	for (int j = 0; j < a.length; j++) {

	    double pivot = a[j][j];

	    if (pivot == 0) {
		boolean found = false;
		for (int z = j + 1; z < a.length; z++) {
		    if (a[z][j] != 0) {
			double[] temp = a[z];
			a[z] = a[j];
			a[j] = temp;
			break;
		    }
		}
		if (!found) {
		    System.out.println("Singularity");
		    return null;
		}
	    }

	    for (int z = 0; z < a[0].length; z++) {
		a[j][z] /= pivot;
		i[j][z] /=pivot;
	    }

	    for (int m = 0; m < a.length; m++) {

		if (j != m) {
		    double newPivot = a[m][j];
		    for (int z = 0; z < a[j].length; z++) {
			a[m][z] = a[m][z] - (a[j][z] * newPivot);
			i[m][z]= a[m][z] -(i[j][z]*newPivot);
		    }
		}
	    }
	}
	return i;
    }
}
