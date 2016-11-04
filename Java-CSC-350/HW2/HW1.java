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
 * @author dtmirizzi
 */
public class HW1 {

    public static String bit2string(long data, int bits) { //prints binary bits to a string 
	String result = "";
	for (int i = bits - 1; i >= 0; --i) {
	    result = result + (((data >>> i) & 0x01) == 1 ? '1' : '0');
	}
	return result;
    }

    public static byte leftShift(byte _byte) { // extract most sig nibble
	byte mask = (byte) 0b11110000;
	byte test = (byte) _byte;
	_byte = (byte) (_byte >>> 4);
	return (byte) ((byte) mask ^ (byte) _byte);
    }

    public static byte rightShift(byte _byte) { //Extract 4 least sig nibble 
	byte mask = (byte) 0b11110000;
	_byte = (byte) ((byte) _byte << 4);
	_byte = (byte) ((byte) _byte >>> 4);
	_byte = (byte) ((byte) mask ^ (byte) _byte);
	return _byte;
    }

    public static byte sixBits(byte _byte) { //extract most sig 6 bits
	byte mask = (byte) 0b11000000;
	_byte = (byte) (_byte >>> 2);
	return (byte) ((byte) mask ^ (byte) _byte);
    }

    public static short lrSwap(short _in) { //swaps most sig byte with the least sig byte
	short mask = (short) 0b1111111100000000;
	short right = (short) ((short) mask ^ (~(short) _in << 8));
	short left = (short) ((short) mask ^ ((short) _in >>> 8));
	return (short) (left ^ right);
    }

    public static byte expander(byte _byte) {
	byte constantsl = _byte;
	byte constantsr = _byte;
	constantsl = (byte) ((constantsl << 2) & (0b11000000));
	constantsr = (byte) ((constantsr) & (0b00000011));
	byte left = _byte;
	byte right = _byte;
	left = (byte) (left << 3 & 0b00100000);
	right = (byte) (right >>> 1 & 0b00000100);
	_byte = (byte) (_byte << 1 & 0b00011000);
	_byte = (byte) (_byte ^ constantsl ^ constantsr ^ left ^ right);
	return _byte;
    }

    public static void main(String[] args) {
	/*byte b; // -- 8 bits
	 short s; // -- 16 bits
	 int i; // -- 32 bits
	 long l; // -- 64 bits
	 b = (byte) 0xFF;
	 s = (short) 0xFFFF;
	 i = (int) 0xFFFFFFFF;
	 l = 0xFFFFFFFFFFFFFFFFL;*/

	byte b = (byte) 0xaf;
	byte c = (byte) 0b00011001;
	System.out.println("Input:" + bit2string(b, 8));
	System.out.println("Left Shift:" + bit2string(leftShift(b), 8));
	System.out.println("Right Shift:" + bit2string(rightShift(b), 8));
	System.out.println("SixBits:" + bit2string(sixBits(b), 8));
	System.out.println("LR Swap:" + bit2string(lrSwap((short) 0b1010101011111111), 16));
	System.out.println("New Input:" + bit2string(c, 8));
	System.out.println("Expand:" + bit2string(expander(c), 8));

	// Endianness Little and big
    }

}
