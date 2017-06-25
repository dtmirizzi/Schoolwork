/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc.pkg310.alg;

/**
 * @author dtmirizzi
 */
public class FiniteAuto {

    public static void main(String[] args) {
	String s1 = "hello";
	String s2 = "_whatsUp";
	String s3 = "14life";
	System.out.println(isVar(s1));
	System.out.println(isVar(s2));
	System.out.println(isVar(s3));

    }

    public static boolean isVar(String s) {
	int state = 0; //0 is first letter 1 is repeat 2 is trap
	for (char c : s.toCharArray()) {
	    if (state == 0) {
		if ((c <= 90 && c >= 65 || c <= 122 && c >= 97 || c == 95 || c == 37)) {
		    state = 1;
		} else {
		    state = 2;
		}
	    }
	    if (state == 1) {
		if ((c <= 90 && c >= 65 || c <= 122 && c >= 97 || c <= 57 && c >= 48 || c == 95 || c == 37)) {
		    state = 1;
		} else {
		    state = 2;
		}
	    }
	    if (state == 2) {
		return false;
	    }
	}

	return true;
    }

}
