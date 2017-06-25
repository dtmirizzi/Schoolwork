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
public class BoyerMoore {
    private int[] Skipper;     
    private String pat;      
    
    
    public BoyerMoore(String pat) {	
	this.pat = pat;
	Skipper = new int[256];
	for (int c = 0; c < 256; c++) {
	    Skipper[c] = -1;
	}
	for (int j = 0; j < pat.length(); j++) {
	    Skipper[pat.charAt(j)] = j;
	}
    }

    public int search(String txt) {
	int m = pat.length();
	int n = txt.length();
	int skip;
	for (int i = 0; i <= n - m; i += skip) {
	    skip = 0;
	    System.out.println(txt.charAt(i)+" at Slide Index of: "+i);
	    for (int j = m - 1; j >= 0; j--) {
		if (pat.charAt(j) != txt.charAt(i + j)) {
		    skip = Math.max(1, j - Skipper[txt.charAt(i + j)]);
		    break;
		}
		System.out.println(txt.charAt(i+j)+" : "+ pat.charAt(j));
	    }
	    
	    if (skip == 0) {
		return i;    // found
	    }
	}
	return -1;          // not found
    }

}
