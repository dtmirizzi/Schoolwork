/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HW;

import java.util.Random;

/**
 * @author dtmirizzi
 */
public class HW1_2 {

    
    public static void main(String[] args) {
        double n= 1000000, in=0;
	double R=.5;
	Random rand= new Random(9);
	for(int i=0;i<n; i++){
	    double x=rand.nextDouble()-.5, y=rand.nextDouble()-.5;
	    if((x*x+y*y)<R*R){
		in++;
	    }
	}
	System.out.println((4*in)/n);
    }

}
