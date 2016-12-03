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

import java.util.LinkedList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author dtmirizzi
 */
public class ThreadPool {

    public static double[] nums = new double[10000];
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service= Executors.newFixedThreadPool(4);
	Future<Double> f1 = service.submit(new MaxCallable(nums,0,5000)); // futures are objects that run and once done can be printed
	Future<Double> f2 = service.submit(new MaxCallable(nums,5000,nums.length));
	LinkedList<Future<Double>> l = new LinkedList<Future<Double>>();
	l.add(f1);
	l.add(f2);
	waitTillDone(l);
	System.out.println(Math.max(l.get(0).get(), l.get(1).get()));
	service.shutdown();
    }
    public static void waitTillDone(LinkedList<Future<Double>> a){
	for(Future<Double> f : a){
	    while(!f.isDone());
	}
    }

}
