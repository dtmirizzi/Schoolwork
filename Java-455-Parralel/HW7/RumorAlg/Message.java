/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RumorAlg;

import java.io.Serializable;
import java.net.InetSocketAddress;

/**
 *
 * @author dtmirizzi
 */
public class Message implements Serializable {

    private static final long serialVersionUID = 42L;
    private boolean infected;
    private int timeSent;
    //	node id of the initiator of the wave
    private final InetSocketAddress id;
    //	node if of the sender of this message
    private final InetSocketAddress sender;
    private final double temp;
    private final long time;

    public Message(InetSocketAddress id, InetSocketAddress sender, boolean inf, int timeSent) {
	this.infected = inf;
	this.id = id;
	this.sender = sender;
	this.timeSent = timeSent;
	this.temp = 0;
	time=0;
    }

    public Message(InetSocketAddress id, InetSocketAddress sender, boolean inf, int timeSent, double temp, long time) {
	this.infected = inf;
	this.id = id;
	this.sender = sender;
	this.timeSent = timeSent;
	this.temp = temp;
	this.time= time;
    }

    public double getTemp() {
	return temp;
    }

    public InetSocketAddress getId() {
	return id;
    }

    public int timeSent() {
	return timeSent;
    }
    
    public long getTime(){
	return time;
    }

    public InetSocketAddress getSender() {
	return sender;
    }

    public boolean isInfected() {
	return this.infected;
    }

}
