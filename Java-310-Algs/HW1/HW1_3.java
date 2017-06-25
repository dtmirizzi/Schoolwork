/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csc.pkg310.alg;

/**
 * @author dtmirizzi
 */
public class HW1_3 {

    
    public static void main(String[] args) {
	int N=1000;
        //A 
	int ASum=0;
	for(int i=0; i<N;i++){
	    ASum= ASum+ (i*3)+7;
	}
	//b
	int bSum=0;
	for(int i=0; i<N;i++){
	    bSum= bSum+ (i*i)-2*i;
	}
	//c
	int cSum=0;
	for(int i=7; i<N;i++){
	    cSum= cSum+ (i);
	}
	//d
	int dSum=0;
	for(int i=5; i<N;i++){
	    dSum= dSum+ (2*(i*i))+1;
	}
	//e
	int eSum=0;
	for(int i=0; i<N;i++){
	    eSum= (int) ((int) eSum+ Math.pow(6, i));
	}
	//f
	int fSum=0;
	for(int i=7; i<N;i++){
	    fSum= (int) ((int) fSum+ Math.pow(4, i));
	}
	
    }

}
