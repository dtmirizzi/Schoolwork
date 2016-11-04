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

/**
 * Program that Encodes and decodes a string by shifting bits.
 *
 * @author dtmirizzi
 *
 */
public class HW2_1 {

    public static void main(String[] args) {
	//input desired shift amaount:
	int shift = -3;
	System.out.println("Shift this much: " + shift);
	//Encode(0) or Decode(1)
	int option = 1;
	String input = "ABC DEF GHI JKL MNO PQR STU VWX YZ";
	char[] set = new char[input.length()];
	set = stringToArray(input);
	System.out.println("before encryption:");
	System.out.println(set);
	if (option == 0) {
	    System.out.println("Cypher:");
	    set = encode(set, shift);
	    System.out.println(set);
	} else if (option == 1) {
	    System.out.println("after decryption:");
	    set = decode(encode(set,shift), shift);
	    System.out.println(set);
	} else {
	    System.out.println("Please input Encode or Decode:");
	}

    }

    public static char[] stringToArray(String input) {
	char[] a = new char[input.length()];
	input = input.toUpperCase();
	for (int i = 0; i < input.length(); i++) {
	    a[i] = input.charAt(i);
	}
	return a;
    }

    public static char[] encode(char[] a, int shift) {
	int j;
	for (int i = 0; i < a.length; i++) {
	    for (j = 0; j < Math.abs(shift); j++) {
		if ((int)a[i]==32||(int)a[i]<65||(int)a[i]>90);
		if (a[i] == 'A') {
		    a[i] = 'Z';

		} else {
		    a[i] = (char) (a[i] - 1);
		}
	    }

	}
	return a;
    }

    public static char[] decode(char[] a, int shift) {
	int j;
	for (int i = 0; i < a.length; i++) {
	    for (j = 0; j < Math.abs(shift); j++) {
		if ((int)a[i]==32||(int)a[i]<65||(int)a[i]>90);
		if (a[i] == 'Z') {
		    a[i] = 'A';

		} else {
		    a[i] = (char) (a[i] + 1);
		}
	    }

	}
	return a;

    }

}
