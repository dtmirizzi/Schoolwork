/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc.pkg310.alg;

import java.util.Arrays;

/**
 *
 * @author d10
 */
public class Regression {

    public static void main(String[] args) {
	double[] x= new double[10];
	double[] y= new double[10];
	x[0]=0;
	y[0]=0;
	for(int i=1; i<x.length;i++)
	{
	    x[i]=i;
	    y[i]= 3*i*i+2*i+4;
	}
	double[][] z= Regression(x,y,2); 
	for(int i=0;i<z.length;i++){
	    System.out.println(Arrays.toString(z[i]));
	}

    }


    private static double[][] Regression(double[] x, double[] y, int Deg) {
	
	double[][] O= makeO(x,y,Deg);
	double[][] Q= makeU(x,Deg);
	double[][] Q2=pad(Q);
	double[][] Q3= getInverse(Gauss.GaussJordan(Q2));
	double[][] Out=  multiply(Q3,O);
	
	return Out;
    }
    private static double[][] pad(double[][] x){
	double[][] out = new double[x.length][x[0].length+1];
	for(int i= 0;i<x.length;i++){
	    for(int j=0;j<x[i].length;j++){
		out[i][j]= x[i][j];
		out[i][j+1]=0;
	    }
	}
	return out; 
    }

    private static double[][] makeO(double[] x, double[] y, int Deg) {
	double[][] o = new double[Deg + 1][1];

	for (int i = 0; i < o.length; i++) {
	    double sum = 0;
	    for (int j = 0; j < x.length && j < y.length; j++) {
		sum += y[j] * Math.pow(x[j], i);
	    }
	    o[i][0] = sum;
	}
	double sum = 0;
	for (int j = 0; j < x.length && j < y.length; j++) {
	    sum += y[j];
	}
	o[0][0]=sum;
	return o;
    }

    private static double[][] makeU(double[] x, int Deg) {
	double[][] u = new double[Deg + 1][Deg+1];
	for(int i=0; i<u.length;i++){
	    for(int j=0; j<u[i].length;j++){
		u[i][j]=0;
	    }
	}
	int Colum = 0;
	for (int i = 0; i < u.length; i++) {
	    for (int j = 0; j < u[i].length; j++) {
		double sum = 0;
		for (int k = 0; k < x.length; k++) {
		    sum += Math.pow(x[k], j + Colum);
		}
		u[i][j] = sum;
	    }
	    Colum++;
	}
	u[0][0] = x.length;

	return u;
    }

    public static double[][] multiply(double[][] a, double[][] b) {
	int m1 = a.length;
	int n1 = a[0].length;
	int m2 = b.length;
	int n2 = b[0].length;
	if (n1 != m2) {
	    System.out.println("Not Compatable MAtrix Sizes");
	}
	double[][] c = new double[m1][n2];
	for (int i = 0; i < m1; i++) {
	    for (int j = 0; j < n2; j++) {
		for (int k = 0; k < n1; k++) {
		    c[i][j] += a[i][k] * b[k][j];
		}
	    }
	}
	return c;
    }
        //Removes solutions from Gauss 
    public static double[][] getInverse(double[][] a) {
	double[][] b = new double[a.length][a[0].length - 1];
	for (int i = 0; i < a.length; i++) {
	    for (int j = 0; j < a[0].length - 1; j++) {
		b[i][j] = a[i][j];
	    }
	}
	return b;
    }

}
