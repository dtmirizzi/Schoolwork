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

package Notes;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author dtmirizzi
 */
public class oldMultiThread {

    
    public static void main(String[] args) {
        Increment p1= new Increment("a");
	Increment p2= new Increment("b");
	Thread t1= new Thread(p1);
	Thread t2= new Thread(p2);
	t1.start();
	t2.start();
	try {
	    t1.join();
	    t2.join();
	} catch (InterruptedException ex) {
	    Logger.getLogger(oldMultiThread.class.getName()).log(Level.SEVERE, null, ex);
	}
	System.out.println(Increment.i);
    }

}
