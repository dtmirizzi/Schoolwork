/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RumorAlg;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dtmirizzi
 */
public class GridNode implements Runnable {

    public volatile boolean infected = false;
    private final long timeout;
    public final int port;
    public volatile double temp;
    public double var = 0;
    private final InetSocketAddress[] neighbors;
    private int InfectionType = 1; // 1-push  2=pull  3=pushpull
    DatagramSocket serverSocket;

    public GridNode(int port, boolean infected, long timeout, InetSocketAddress[] neighbors, int inf) throws SocketException {
	this.infected = infected;
	this.timeout = timeout;
	this.neighbors = neighbors;
	this.InfectionType = inf;
	this.port = port;
	this.serverSocket = new DatagramSocket(port);
	Random rn = new Random();
	this.temp = rn.nextDouble() * 50 + 50;
    }

    private void sendTo(Message m) throws Exception {

	try {
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ObjectOutputStream oos = new ObjectOutputStream(baos);
	    oos.writeObject(m);
	    oos.flush();
	    // get the byte array of the object
	    byte[] Buf = baos.toByteArray();
	    DatagramPacket packet = new DatagramPacket(Buf, Buf.length, m.getId().getAddress(), m.getId().getPort());
	    this.serverSocket.send(packet);
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }

    public static InetSocketAddress makeID(int port) throws Exception {
	return new InetSocketAddress(InetAddress.getByName("localhost"), port);
    }

    @Override
    public void run() {

	Runnable rListener = () -> {
	    Message ReceiveData;
	    try {
		//port number
		while (true) {
		    byte[] incomingData = new byte[1024];
		    DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);

		    serverSocket.receive(incomingPacket);
		    byte[] data = incomingPacket.getData();
		    ByteArrayInputStream in = new ByteArrayInputStream(data);
		    ObjectInputStream is = new ObjectInputStream(in);
		    ReceiveData = (Message) is.readObject();

		    if (this.InfectionType == 1) { //if push 
			//System.out.println(this.port + " " + ReceiveData.isInfected());
			if (ReceiveData.isInfected()) {
			    this.infected = ReceiveData.isInfected();
			}

		    } else if (this.InfectionType == 2) { //if pull
			if (ReceiveData.timeSent() == 1) {
			    Message temp = new Message(ReceiveData.getSender(), makeID(port), this.infected, 2);
			    sendTo(temp);
			}
			if (ReceiveData.timeSent() == 2) {
			    if (ReceiveData.isInfected()) {
				this.infected = ReceiveData.isInfected();
			    }
			}

		    } else {// push pull /// use time stamps!
			double temp0 = this.temp;
			if (System.nanoTime() - ReceiveData.getTime() < TimeUnit.MILLISECONDS.toNanos(500)) {
			    this.temp = (temp + ReceiveData.getTemp()) / 2.0;
			    this.var = Math.sqrt(Math.abs(temp - temp0));
			}
			if (ReceiveData.isInfected() == true) {
			    this.infected = true;
			}
			if (ReceiveData.timeSent() == 1) {
			    Message temp = new Message(ReceiveData.getSender(), makeID(port), this.infected, 2, temp0, System.nanoTime());
			    sendTo(temp);
			}
		    }

		}
	    } catch (Exception ex) {
		ex.printStackTrace();
	    }
	};
	Thread t1 = new Thread(rListener);
	t1.start();

	try {// sleep before sending
	    Thread.sleep(1000);
	} catch (InterruptedException ex) {
	    Logger.getLogger(GridNode.class.getName()).log(Level.SEVERE, null, ex);
	}

	for (long stop = System.nanoTime() + TimeUnit.SECONDS.toNanos(timeout); stop > System.nanoTime();) {
	    Random rn = new Random();
	    try {
		if (this.InfectionType == 1 || this.InfectionType == 2) {
		    Message temp = new Message(this.neighbors[rn.nextInt(neighbors.length)], makeID(port), this.infected, 1);
		    sendTo(temp);
		    Thread.sleep(100);
		} else { // for push pull question 3
		    Message temp = new Message(this.neighbors[rn.nextInt(neighbors.length)], makeID(port), this.infected, 1, this.temp, System.nanoTime());
		    sendTo(temp);
		    Thread.sleep(100);
		}
	    } catch (Exception ex) {
		ex.printStackTrace();
	    }

	}
//	while(true){
//	if (System.nanoTime() - time >= TimeUnit.SECONDS.toNanos(timeout)) { //timeout to check rumor propagation
//			System.out.println("print " + port + " : " + this.infected);
//			time = System.nanoTime();
//		    }
//	}

    }
}
