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

import static java.nio.charset.StandardCharsets.UTF_8;

import java.util.Random;

/**
 * @author dtmirizzi
 */
public class HW4_1 {

    public static void main(String[] args) {
	long key = keyGen(1);
	byte[][] a;
	String input = "Does this work always yo?";
	System.out.println("PlainText input: "+input);
	a = encode(input, key, 1);
	String output=decode(a, key, 1);
	System.out.println("Decrypted output: "+output);
    }

    // generates a 9 bit key
    public static long keyGen(int seed) {
	Random r = new Random(seed);
	long _long = r.nextLong();
	//System.out.println(bit2string(_long, 32));
	_long = (long) _long & 0b00000000000000000000111111111;
	//System.out.println(bit2string(_long, 32));
	byte temp = (byte) _long;
	//System.out.println(bit2string(temp, 16));
	return _long;
    }

    public static byte expander(byte _byte) {
	byte constantsl = _byte;
	byte constantsr = _byte;
	constantsl = (byte) ((constantsl << 2) & (0b11000000));
	//System.out.println("con L:" + bit2string(constantsl, 8));
	constantsr = (byte) ((constantsr) & (0b00000011));
	//System.out.println("con R:" + bit2string(constantsr, 8));
	byte left = _byte;
	byte right = _byte;
	left = (byte) (left << 3 & 0b00100000);
	//System.out.println("left:" + bit2string(left, 8));
	right = (byte) (right >>> 1 & 0b00000100);
	//System.out.println("right:" + bit2string(right, 8));
	_byte = (byte) (_byte << 1 & 0b00011000);
	_byte = (byte) (_byte ^ constantsl ^ constantsr ^ left ^ right);
	return _byte;
    }

    public static String decode(byte[][] b, long key, int iterations) {// need to flip left and right before using  
	b = decodeFlip(b);
	byte[][] temp = clone(b);
	for (int i = 0; i < iterations; i++) {
//            for (int k = 0; k < b.length; k++) {
//                for (int j = 0; j < 4; j++) {
//                    System.out.print(bit2string((b[k][j]), 8) + " ");
//                }
//                System.out.println();
//            }

	    temp = RtoL(temp);

	    b = rFunct(b, key);
//            for (int k = 0; k < b.length; k++) {
//                for (int j = 0; j < b[1].length; j++) {
//                    System.out.print(bit2string((b[k][j]), 8) + " ");
//                }
//                System.out.println();
//            }

	    b = LRadd(b);
//             for (int k = 0; k < b.length; k++) {
//                for (int j = 0; j < b[1].length; j++) {
//                    System.out.print(bit2string((b[k][j]), 8) + " ");
//                }
//                System.out.println();
//            }
	    b = RtoLCombind(b, temp);

	}
	b = decodeFlip(b);
	System.out.println();
	System.out.println("Decrypted Byte array:");
	for (int k = 0; k < b.length; k++) {
	    for (int j = 0; j < b[1].length; j++) {
		System.out.print(bit2string((b[k][j]), 8) + " ");
	    }
	    System.out.println();
	}
	

	return byteArrayToString(b);
    }

    public static byte[][] decodeFlip(byte[][] a) {
	byte[][] temp = new byte[a.length][a[1].length];
	for (int i = 0; i < a.length; i++) {
	    for (int j = 0; j < 4; j++) {
		if (j == 0 || j == 2) {
		    temp[i][j] = a[i][j + 1];

		} else {
		    temp[i][j] = a[i][j - 1];
		}
	    }
	}
	return temp;
    }
    public static String byteArrayToString(byte[][] input){
	byte[][] temp=new byte[input.length][3];
	byte temp1,temp2;
	for(int i=0; i<input.length;i++){
	    for(int k=0;k<4;k++){
		if(k==0){
		    temp1=input[i][k];
		    temp1=(byte)(((byte)temp1<<2)&0b11111100);
		    temp[i][0]=temp1;
		}
		else if(k==1){
		    temp1=input[i][k];
		    temp1=(byte)(((byte)temp1>>>4)&0b000011);
		    temp[i][0]=(byte) (temp[i][0]^temp1);
		    temp2=input[i][k];
		    temp2=(byte)(((byte)temp2<<4)&0b11110000);
		    temp[i][1]=temp2;
		}
		else if(k==2){
		    temp1=input[i][k];
		    temp1=(byte)(((byte)temp1>>>2)&0b001111);
		    temp[i][1]=(byte) (temp[i][1]^temp1);
		    temp2=input[i][k];
		    temp2=(byte)(((byte)temp2<<6)&0b11000000);
		    temp[i][2]=temp2;
		}
		else if(k==3){
		    temp1=input[i][k];
		    temp1=(byte)(((byte)temp1)&0b00111111);
		    temp2=temp[i][2];
		    temp[i][2]=(byte)(temp2^temp1);
		}
		
	    }
	}
//	for(int i=0;i<temp.length;i++){
//	    for(int k=0;k<temp[i].length;k++){
//		System.out.print(temp[i][k]+" ");
//	    }
//	    System.out.println();
//	}
	StringBuilder obil= new StringBuilder();
	for(int i=0;i<temp.length;i++){
	    for(int k=0;k<temp[i].length;k++){
		obil.append((char)temp[i][k]);
	    }   
	}
	
	String output=obil.toString();
//	System.out.println(output);
	return output;
    } 

    public static byte[][] encode(String input, long key, int iterations) {
	String[] a = new String[(input.length() / 3) + (input.length() % 3)];
	a = stringToStringArray(input);
	byte[][] b = new byte[a.length][4];
	b = stringToByteArray(a);
	byte[][] temp = new byte[b.length][4];
	temp = clone(b);
	for (int i = 0; i < iterations; i++) {
	    System.out.println("Plain text Byte array:");
	    for (int k = 0; k < b.length; k++) {
		for (int j = 0; j < 4; j++) {
		    System.out.print(bit2string((b[k][j]), 8) + " ");
		}
		System.out.println();
	    }

	    temp = RtoL(temp);
	    System.out.println();
	    b = rFunct(b, key);
//            for (int k = 0; k < b.length; k++) {
//                for (int j = 0; j < b[1].length; j++) {
//                    System.out.print(bit2string((b[k][j]), 8) + " ");
//                }
//                System.out.println();
//            }

	    b = LRadd(b);
//             for (int k = 0; k < b.length; k++) {
//                for (int j = 0; j < b[1].length; j++) {
//                    System.out.print(bit2string((b[k][j]), 8) + " ");
//                }
//                System.out.println();
//            }
	    b = RtoLCombind(b, temp);
	    System.out.println();
	    System.out.println("Encrypted Byte array:");
	    for (int k = 0; k < b.length; k++) {
		for (int j = 0; j < b[1].length; j++) {
		    System.out.print(bit2string((b[k][j]), 8) + " ");
		}
		System.out.println();
	    }
	    System.out.println();
	}
	return b;

    }

    public static byte[][] clone(byte[][] b) {
	byte[][] temp = new byte[b.length][b[0].length];
	for (int i = 0; i < b.length; i++) {
	    for (int k = 0; k < b[i].length; k++) {
		temp[i][k] = b[i][k];
	    }
	}
	return temp;
    }

    public static byte[][] rFunct(byte[][] a, long key) {
	byte[][] s1 //s1 [8][2] REWRITE AS A [2][8] REMOVE IF STATEMENTS USING TEMP>>>3 TO INDEX ARRAY AND 0B00000111 TO ISOLATE THE REST
		= {{0b00000101, 0b0000001}, {0b00000010, 0b0000100},
		{0b00000001, 0b0000110}, {0b00000110, 0b0000010},
		{0b00000011, 0b0000000}, {0b00000100, 0b0000111},
		{0b00000111, 0b0000101}, {0b00000000, 0b0000011}};
	byte[][] s2 //s2 [8][2]
		= {{0b00000100, 0b0000101}, {0b00000000, 0b0000011},
		{0b00000110, 0b0000000}, {0b00000101, 0b0000111},
		{0b00000111, 0b0000110}, {0b00000001, 0b0000010},
		{0b00000011, 0b0000001}, {0b00000010, 0b0000100}};
	byte tempR, tempL;
	for (int i = 0; i < a.length; i++) {
	    for (int j = 0; j < 4; j++) {
		if (j == 1 || j == 3) {
		    tempR = a[i][j];
		    a[i][j] = expander(tempR);
//		    System.out.println("a" + bit2string(a[i][j], 8));
//		    System.out.println("k" + bit2string(key, 8));
		    tempR = a[i][j];
		    a[i][j] = (byte) (tempR ^ (byte) key);
//		    System.out.println("b" + bit2string(a[i][j], 8));
		    tempR = a[i][j];
		    tempR = (byte) (tempR & 0b00001111);
		    tempL = a[i][j];
		    tempL = (byte) ((tempL >>> 4) & 0b00001111);
//		    System.out.println("tr" + bit2string(tempR, 8));
//		    System.out.println("tl" + bit2string(tempL, 8));

//		    for (int y = 0; y < a.length; y++) {
//			for (int z = 0; z < a[1].length; z++) {
//			    System.out.print(bit2string((a[y][z]), 8) + " ");
//			}
//			System.out.println();
//		    } System.out.println();
		    //Sbox start
		    byte testTempL = tempL;
		    byte testTempR = tempR;
		    if ((((byte) (testTempL >>> 3)) & (byte) 0b00000001) == 0) {
//			System.out.println("a" + bit2string(tempL, 8));
			for (int k = 0; k < 8; k++) {
			    testTempL = tempL;
//			    System.out.println("a" + bit2string((byte)(tempL&0b00000111), 8));
//			    System.out.println("b" + bit2string(s1[k][0], 8));
			    if ((byte) (testTempL & 0b00000111) == s1[k][0]) {
				tempL = s1[k][1];
			    } else {

			    }
			}
		    } else {

			for (int k = 0; k < 8; k++) {
			    testTempL = tempL;
			    if ((byte) (testTempL & 0b00000111) == s1[k][1]) {
				tempL = s1[k][0];
			    } else {

			    }
			}

		    }
//		    System.out.println("b" + bit2string(tempL, 8));
//		    System.out.println("x" + bit2string(tempR, 8));
		    testTempR = tempR;
		    if ((((byte) (testTempR >>> 3)) & (byte) 0b00000001) == 0) {
			for (int k = 0; k < 8; k++) {
			    testTempR = tempR;
			    if ((byte) (testTempR & 0b00000111) == s2[k][0]) {
				tempR = s2[k][1];
			    } else {

			    }
			}
		    } else {
			for (int k = 0; k < 8; k++) {
			    testTempR = tempR;
			    if ((byte) (testTempR & 0b00000111) == s2[k][1]) {
				tempR = s2[k][0];
			    } else {

			    }

			}
//			System.out.println("x" + bit2string(tempR, 8));

		    }
		    a[i][j] = (byte) ((tempL << 3) ^ (tempR));
//                    System.out.println(i + bit2string((a[i][j]), 8));

		}

	    }
	}
//	for (int i = 0; i < a.length; i++) {
//	    for (int j = 0; j < a[1].length; j++) {
//		System.out.print(bit2string((a[i][j]), 8) + " ");
//	    }
//	    System.out.println();
//	}
	return a;
    }

    public static byte[][] LRadd(byte[][] a) {//add functionality exclusive or left and right.
	for (int i = 0; i < a.length; i++) {
	    for (int j = 0; j < 4; j++) {
		if (j % 2 == 0) {
//		    System.out.println(bit2string(a[i][j], 8));
//		    System.out.println(bit2string(a[i][j+1], 8));
		    a[i][j + 1] = (byte) (a[i][j] ^ a[i][j + 1]);
//		    System.out.println(bit2string(a[i][j+1], 8));
		}

	    }
	}
	return a;
    }

    //for saving the right to the left 
    public static byte[][] RtoL(byte[][] a) {
	for (int i = 0; i < a.length; i++) {
	    for (int j = 3; j > -1; j--) {
		if (j % 2 == 1) {
		    // System.out.println(bit2string(a[i][j], 8));
		    a[i][j - 1] = a[i][j];
		    //System.out.println(bit2string(a[i][j-1], 8));
		}
	    }
	}
	return a;
    }

    //for combinding your saved left bits to the new right bits
    public static byte[][] RtoLCombind(byte[][] a, byte[][] saved) {
	for (int i = 0; i < a.length; i++) {
	    for (int j = 0; j < 4; j++) {
		if (j % 2 == 0) {
		    a[i][j] = saved[i][j];
		}

	    }
	}
	return a;
    }

    // This function returns a byte[a.lenght][4, seperates 3 UTF_8 chars into 4, 6 bit bytes(left zero)].
    public static byte[][] stringToByteArray(String[] a) {
	byte[][] b = new byte[a.length][3];
	byte[][] c = new byte[a.length][4];
	for (int i = 0; i < a.length; i++) {
	    b[i] = a[i].getBytes(UTF_8);
//	     System.out.println(Arrays.toString(b[i]));
	}

//	
//	System.out.println(b.length);
//	System.out.println(c.length);
	byte temp, temp2, temp3 = 0, temp4;
	for (int i = 0; i < b.length; i++) {
	    for (int j = 3; j >= 0; j--) {
		if (j == 3) {

//		    System.out.println("d"+bit2string(b[i][2], 8));
		    temp=b[i][2];
		    c[i][3] = (byte) (temp & 0b00111111);
//		    System.out.println("d"+bit2string(c[i][j], 8));

		} else if (j == 2) {
//		    System.out.println(bit2string(b[i][j], 8));
//		    System.out.println(bit2string(b[i][j-1], 8));
		    temp = b[i][2];
		    temp = (byte) ((temp >>> 6) & 0b00000011);
		    temp2 = b[i][1];
		    temp2 = (byte) ((temp2 << 2) & 0b00111100);
		    c[i][2] = (byte) (temp ^ temp2);
//		    System.out.println("c"+bit2string(c[i][j], 8));
		} else if (j == 1) {
//		    System.out.println(bit2string(b[i][j], 8));
//		    System.out.println(bit2string(b[i][j-1], 8));
		    temp = b[i][j - 1];
		    temp = (byte) ((temp << 4) & 0b00110000);
		    temp2 = b[i][j];
		    temp2 = (byte) ((temp2 >> 4) & 0b00001111);
		    c[i][1] = (byte) (temp ^ temp2);
//		    System.out.println("b"+bit2string(c[i][j], 8));
		} else if (j == 0) {
//		    System.out.println(bit2string(b[i][j], 8));
		    temp=b[i][j];
		    c[i][0] = (byte) ((temp >>> 2) & 0b00111111);
//		    System.out.println("a"+bit2string(c[i][j], 8));
		}
	    }
	}
	return c;
    }

    //this function pads using UTF-8[004](data end transmission) and breaks a string into 3s. 
    public static String[] stringToStringArray(String input) {
	String[] a = new String[(input.length() / 3) + (input.length() % 3)];
	while (input.length() % 3 != 0) {
	    char padding = (char) 004;
	    input = input + padding;
	    //System.out.println((input.length()));
	}
	a = input.split("(?<=\\G...)");
//	System.out.println(java.util.Arrays.toString(a));
	return a;
    }

    public static String bit2string(long data, int bits) { //prints binary bits to a string 
	String result = "";
	for (int i = bits - 1; i >= 0; --i) {
	    result = result + (((data >>> i) & 0x01) == 1 ? '1' : '0');
	}
	return result;
    }

}
