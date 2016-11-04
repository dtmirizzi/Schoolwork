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

/** This code uses a Book Cypher to encrypt messages.
 * @author dtmirizzi
 */
public class HW3_2 {

    public static void main(String[] args) {
	String input = "AbC dEf GhI jKl MnO pQr StU vWx Yz";
	String key = "Anothersourceofsupposedlyrandomnumbersisanybookpieceofmusicorotherobject";
	int[][] vTable = new int[26][26];
	vTable = tableGen();
	char[] inputChar = new char[input.length()];
	inputChar = stringToArray(input);
	char[] keyChar = new char[key.length()];
	keyChar = stringToArray(key);
	System.out.println("Plain Text: ");
	System.out.println(inputChar);
	System.out.println("Encoded Text(0): ");
	System.out.println(encode(inputChar, keyChar, vTable));
	System.out.println("Decoded Text(1): ");
	System.out.println(decode(encode(inputChar, keyChar, vTable), keyChar, vTable));

    }

    public static int[][] tableGen() {
	int[][] v = new int[26][26];
	for (int i = 0; i < 26; i++) {
	    for (int j = 0; j < 26; j++) {
		v[i][j] = (j + i) % 26;
		//System.out.print(v[i][j]);

	    }
	    // System.out.println();
	}
	return v;
    }

    public static char[] stringToArray(String input) {
	char[] a = new char[input.length()];
	input = input.toUpperCase();
	for (int i = 0; i < input.length(); i++) {
	    a[i] = input.charAt(i);
	}
	return a;
    }
    //Sets captital alphbetical letters[A,Z] to ints[0,25]
    public static int[] charToInt(char[] a) {// sets all input chars to ints spaces are 32
	int[] b = new int[a.length];
	for (int i = 0; i < a.length; i++) {
	    if ((int) a[i] == 32) {
		b[i] = (int) a[i];
	    } else if ((int) a[i] < 65 && (int) a[i] > 90) {
		b[i] = (int) a[i];
	    } else {
		b[i] = (int) (((int) a[i]) - 65);

	    }
	    //System.out.println(b[i]);
	}

	return b;
    }
    // sets ints[0,25] to captital alphbetical letters[A,Z] 
    public static char[] intToChar(int[] a) {
	char[] b = new char[a.length];
	for (int i = 0; i < a.length; i++) {
	    if ((char) a[i] == ' ') {
		b[i] = (char) a[i];
	    } else if (a[i] < 65 && a[i] > 90) {
		b[i] = (char) a[i];
	    } else {
		b[i] = (char) ((char) (a[i] + 65));

	    }
	}

	return b;
    }

    public static char[] encode(char[] a, char[] key, int[][] vTable) {
	int[] inputInts = new int[a.length];
	int[] keyInts = new int[key.length];
	inputInts = charToInt(a);
	keyInts = charToInt(key);
	for (int i = 0; i < a.length; i++) {
	    if (inputInts[i] == 32 || inputInts[i] < 0 || inputInts[i] > 25) {

	    } else {
		inputInts[i] = vTable[inputInts[i]][keyInts[i]];
	    }
	}
	return intToChar(inputInts);
    }

    public static char[] decode(char[] a, char[] key, int[][] vTable) {
	int[] b = new int[a.length];
	int[] keyInts = new int[key.length];
	b = charToInt(a);
	keyInts = charToInt(key);
	for (int i = 0, j; i < a.length; i++) {
	    for (j = 0; j < 26; j++) {
		if (b[i] == 32 || b[i] < 0 || b[i] > 25); else if (vTable[j][keyInts[i]] == b[i]) {
		    b[i] = j;
		    break;
		}
	    }
	}
	return intToChar(b);
    }
    public static String doWork(){
	return "NO I WANT TO LAY DOWN!!";
    }
}
