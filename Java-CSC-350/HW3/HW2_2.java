/*
 * Copyright (C) 2016 dtmirizzi
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package csc.pkg350.sec;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A program to perform Key Permutation cryptography
 *
 * @author dtmirizzi
 */
public class HW2_2 {

    public static void main(String[] args) {
	String key = "secretkey";
	char[] keyArray = new char[key.length()];
	keyArray = keyGen(key);
	String Input = "AbC dEf GhI jKl MnO pQr StU vWx Yz";
	char[] stringArray = new char[key.length()];
	stringArray = stringToArray(Input);
	//Encode:0 or Decode:1
	int option = 0;
	//System.out.println(keyArray);
	System.out.println("Encode(0) or Decode(1):" + option);
	System.out.println("Input:");
	System.out.println(stringArray);
	System.out.println("Cypher:");
	System.out.println(encode(stringArray, keyArray));
	System.out.println("Decrypted:");
	System.out.println(decode(encode(stringArray, keyArray), keyArray));

    }

    public static char[] stringToArray(String input) {
	char[] a = new char[input.length()];
	input = input.toUpperCase();
	for (int i = 0; i < input.length(); i++) {
	    a[i] = input.charAt(i);
	}
	return a;
    }

    public static char[] noRedundancy(char[] a) {
	Set<Character> charSet = new LinkedHashSet<>();
	for (char c : a) {
	    charSet.add(c);
	}

	StringBuilder sb = new StringBuilder();
	for (Character character : charSet) {
	    sb.append(character);
	}
	return stringToArray(sb.toString());

    }

    public static char[] keyGen(String input) {
	char[] keyArray = new char[input.length()];
	input = input + "abcdefghijklmnopqrstuvwxyz";
	keyArray = stringToArray(input);
	return noRedundancy(keyArray);
    }

    public static int[] charToInt(char[] a) {// sets all input chars to ints spaces are 32
	int[] b = new int[a.length];
	for (int i = 0; i < a.length; i++) {
	    if ((int) a[i] == 32) {
		b[i] = (int) a[i];
	    }else if((int)a[i]<65 && (int)a[i]>90){
		b[i]= (int) a[i];
	    }else {
		b[i] = (int) (((int) a[i]) - 65);

	    }
	    //System.out.println(b[i]);
	}

	return b;
    }

    public static char[] intToChar(int[] a) {
	char[] b = new char[a.length];
	for (int i = 0; i < a.length; i++) {
	    if ((char) a[i] == ' ') {
		b[i] = (char) a[i];
	    }else if(a[i]<65 && a[i]>90){
		b[i]= (char) a[i];
	    } else {
		b[i] = (char) ((char) (a[i] + 65));

	    }
	}

	return b;
    }

    public static char[] encode(char[] a, char[] key) {
	int[] b = new int[a.length];
	int[] keyInts = new int[key.length];
	b = charToInt(a);
	keyInts = charToInt(key);
	for (int i = 0, j = 0; i < a.length; i++, j++) {
	    if (b[i] == 32||b[i]<0||b[i]>25) {
		j--;
	    } else {
		b[i] = ((b[i] + keyInts[j]) % 26);
	    }
	}
	return intToChar(b);
    }

    public static char[] decode(char[] a, char[] key) {
	int[] b = new int[a.length];
	int[] keyInts = new int[key.length];
	b = charToInt(a);
	keyInts = charToInt(key);
	int temp;
	for (int i = 0, j = 0; i < a.length; i++, j++) {
	    if (b[i] == 32||b[i]<0||b[i]>25) {
		j--;
	    } else {
		if ((((b[i]) - (keyInts[j])) % 26) < 0) {
		    temp = 13;
		    temp = temp - ((Math.abs((b[i]) - (keyInts[j]))) % 26);
		    b[i] = temp + ((Math.abs((b[i]) - (keyInts[j]))) % 26);
		    b[i] = temp + b[i];
		} else {
		    b[i] = ((b[i]) - (keyInts[j])) % 26;
		}
	    }
	}
	return intToChar(b);

    }

}
