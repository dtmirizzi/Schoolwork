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
public class KMP {

    private int[][] fail;
    private String pat;

    public KMP(String pat) {
	this.pat = pat;
	int m = pat.length();
	fail = new int[256][m];
	fail[pat.charAt(0)][0] = 1;
	System.out.print("fails [");
	for (int x = 0, j = 1; j < m; j++) {
	    
	    for (int c = 0; c < fail.length; c++) {
		fail[c][j] = fail[c][x];  
		
	    }
	   // if(fail[pat.charAt(j)][j]!=0)
		System.out.print(fail[pat.charAt(j)][j]);
	    
	    fail[pat.charAt(j)][j] = j + 1;   
	    x = fail[pat.charAt(j)][x];     
	}
	System.out.print("]");
	System.out.print(" Ag Power arr[");
	for(int i= 0; i<fail.length;i++){
	    for(int j =0; j<fail[i].length;j++){
		if(fail[i][j]==0)  ;
		else System.out.print(fail[i][j]);
	    }
	}
	System.out.println("]");
    }

    public int search(String txt) {

	int m = pat.length();
	int n = txt.length();
	int i, j;
	for (i = 0, j = 0; i < n && j < m; i++) { // once j is higer then the lenght of pat 
	    System.out.println(pat.charAt(j)+" : "+txt.charAt(i));
	    int jtemp=j;
	    j = fail[txt.charAt(i)][j];
	    if(j>jtemp) System.out.println(" -> "+fail[txt.charAt(i)][j-1]);
	    else System.out.println(" <- "+fail[txt.charAt(i)][j]);
	}
	if (j == m) {
	    return i - m;    
	}
	return -1;
    }
}
