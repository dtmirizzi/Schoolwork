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
 * GNU General Public License for more details.Iterat
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package HW;

import Notes.MyHashMap;
import Notes.MyHashMapwResize;
import java.util.Random;

/**
 * @author dtmirizzi
 */
public class HW3_1 {

    public static void main(String[] args) {
	MyHashMap<String,Integer> a=new MyHashMap<>(5);
	MyHashMapwResize<String,Integer> b=new MyHashMapwResize<>(5);
	int[] buc=new int[5];
	int N=1000000;
//	a.put("damian", 760);
//	System.out.println(a.containsKey("damian"));
//	a.delete("damian");
//	System.out.println(a.containsKey("damian"));
	for(int i=0;i<N;i++){
	    Random r= new Random();
	    String rand = generateString(r,"abcdefghijklmop",5);
	    
	    switch(a.getBucketNumber(rand)){
		case 0:
		    buc[0]++;
		    break;
		case 1:
		    buc[1]++;
		    break;
		case 2:
		    buc[2]++;
		    break;
		case 3:
		    buc[3]++;
		    break;
		case 4:
		    buc[4]++;
		    break;
	    }
	    
	}
	double avg = ((double)(buc[0]+buc[1]+buc[2]+buc[3]+buc[4]))/5;
	System.out.println("Average Bucket size: " + avg );
	int low=N,high=0;
	for(int i=0;i<5;i++){
	    if(buc[i]<low){
		low=buc[i];
	    }
	    if(buc[i]>high){
		high=buc[i];
	    }
	    
	}
	System.out.println("longest Bucket Length:"+high);
	System.out.println("Shortest Bucket Length:"+low);
	
	
	for(int i=0;i<N;i++){
	    Random r= new Random();
	    String rand = generateString(r,"abcdefghijklmop",5);
	    
	    b.put(rand, 20);
	    
	}
	int sum=0;
	low=0;
	high=0;
	for(int i=0;i<b.getBucketLength();i++){
	    if(b.getBucketLength(low)<b.getBucketLength(i)){
		low=i;
	    }
	    if(b.getBucketLength(high)>b.getBucketLength(i)){
		high=i;
	    }
	    sum=sum+b.getBucketLength(i);
	    
	}
	avg= sum/b.getBucketLength();
	System.out.println("Avg Buck Size:"+avg);
	System.out.println("Bucket with least:"+high+" with "+b.getBucketLength(high));
	System.out.println("Bucket with most:"+low+" with "+b.getBucketLength(low));

	
	

    }
    public static String generateString(Random rng, String characters, int length)
{
    char[] text = new char[length];
    for (int i = 0; i < length; i++)
    {
        text[i] = characters.charAt(rng.nextInt(characters.length()));
    }
    return new String(text);
}

}
