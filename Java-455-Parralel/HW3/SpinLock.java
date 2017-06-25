/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HW;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author dtmirizzi
 */
public class SpinLock {
    private static AtomicBoolean locker; //false== unlocked True== locked 
    
    public void SpinLock(){
	locker.set(false);
    }
    
    public void lock(){
	while(true){
	    if(locker.get()==true);
	    else{
		locker.set(true);
		break;
	    }
	}
    }
    
    public void unlock(){
	locker.set(false);
    }
    
}
