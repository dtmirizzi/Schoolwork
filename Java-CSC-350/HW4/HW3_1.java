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
import java.util.Random;
import java.util.Set;
/** This Code uses a randomly generated key to encrypt and decrypt messages. 
 * @author dtmirizzi
 */
public class HW3_1 {

    
    public static void main(String[] args) {
	String input= "AbC dEf GhI jKl MnO pQr StU vWx Yz";
	char[] keyChar= new char[26];
	char[] inputChar= new char[input.length()];
	inputChar=stringToArray(input);
	//Seed is the length of the input text this may be chaged. 
	keyChar=keyGen(input.length());
	System.out.println("Input: ");
	System.out.println(inputChar);
	System.out.println("Encoded(0): ");
	System.out.println(encode(inputChar,keyChar));
	System.out.println("Decoded(1): ");
	System.out.println(decode(encode(inputChar,keyChar),keyChar));
	
        
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
    // Generates psydo random keys
    public static char[] keyGen(int seed) {
	char[] keyArray = new char[26];
	int[] intArray = new int[500];
	Random rand= new Random(seed);
	for(int i=0; i<500;i++){
	    intArray[i]=rand.nextInt(26);
	}
	keyArray=noRedundancy(intToChar(intArray));
	//System.out.println(keyArray);
	return keyArray;
	
    }
    //Sets captital alphbetical letters[A,Z] to ints[0,25]
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
    // sets ints[0,25] to captital alphbetical letters[A,Z] 
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
