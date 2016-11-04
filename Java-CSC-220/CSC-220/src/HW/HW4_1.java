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

package HW;
import Notes.Tree23Ver3;
import java.util.Random;
/**
 * @author dtmirizzi
 */
public class HW4_1 {

    
    public static void main(String[] args) {
        Tree23Ver3 a= new Tree23Ver3();
	Random r= new Random(); 
	int N=10000000;
	for(int i=0; i<N; i++){
	    a.put(r.nextInt(1000), 58);
	}
	System.out.println(a.depth());
	//a.print();
    }

}
