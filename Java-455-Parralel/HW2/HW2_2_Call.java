/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HW;

import java.util.concurrent.Callable;

/**
 *
 * @author dtmirizzi
 */
public class HW2_2_Call implements Callable {
    int[] a; 
    int ran0;
    int ranN;
    int M;
    public HW2_2_Call(int[] Array, int M){
	a=Array;
	ran0=0;
	ranN=a.length;
	this.M=M;
    }
    public HW2_2_Call(int[] Array, int ran0, int ranN,int M){
	a=Array;
	this.ran0=ran0;
	this.ranN= ranN;
	this.M=M;
	
    }
    public int[] call(){
	int[] count= new int[M];
	for(int i=ran0; i<ranN;i++){
	    count[a[i]]++;
	}
	
	return count;
    }
}
