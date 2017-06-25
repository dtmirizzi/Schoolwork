/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc.pkg310.alg;

/**
 * @author dtmirizzi
 */
public class Patterns {

    public static void main(String[] args) {
	KMP a = new KMP("ababbc");
	KMP b = new KMP("abcabc");
	KMP c = new KMP("cbcbbaca");
	KMP d = new KMP("bbabbcac");
	System.out.println("KMP:");
	System.out.println("Pattern starts at index: " + a.search("fwdababcdasdf"));
	System.out.println("");
	System.out.println("BM: ");
	BoyerMoore bm = new BoyerMoore("abcd");
	System.out.println("Pattern starts at index: " + bm.search("afcabcdcbs"));

    }

}
