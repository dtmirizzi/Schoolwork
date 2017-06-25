/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HW.Echo;

/**
 *
 * @author dtmirizzi
 */

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;


public class EchoNode implements Runnable {

    private final int port;
    private final InetSocketAddress[] neighbors;
    private final boolean initiator;
    private InetSocketAddress parent;
    private final boolean[] receivedFrom;
    private Message ParMessage;
    

    public EchoNode(int port, InetSocketAddress[] neighbors, boolean initiator) {
	this.port = port;
	this.neighbors = neighbors;
	this.initiator = initiator;
	this.parent = null;
	receivedFrom = new boolean[neighbors.length];
    }

    private void sendTo(int i, Message m) throws Exception {
	System.out.println((m.getSender().getPort() - 30000) + " sent to " + (neighbors[i].getPort() - 30000));
	try (Socket clientSocket = new Socket(neighbors[i].getAddress(), neighbors[i].getPort())) {
	    ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
	    out.writeObject(m);
	}
    }

    private Message receive(ServerSocket welcomeSocket) throws Exception {
	Message message;
	try (Socket connectionSocket = welcomeSocket.accept()) {
	    ObjectInputStream in = new ObjectInputStream(connectionSocket.getInputStream());
	    message = (Message) in.readObject();
	    SocketAddress sender = message.getSender();
	    
	    for (int i = 0; i < neighbors.length; i++) {
		if (neighbors[i].equals(sender)) {
		    receivedFrom[i] = true;
		}

	    }
	}
	return message;
    }

    public int computeParent(Message message) {
	for (int i = 0; i < neighbors.length; i++) {
	    if (neighbors[i].equals(message.getSender())) {
		this.parent = neighbors[i];
		return i;
	    }
	}

	return -1;
    }

    private boolean recAll() {
	for (int i = 0; i < receivedFrom.length; i++) {
	    if (receivedFrom[i] == false) {
		return false;
	    }
	}
	return true;
    }

    @Override
    public void run() {
	boolean Blasted = false;
	int parIndex = -1;

	try {
	    if (initiator) {
		for (int i = 0; i < neighbors.length; i++) {
		    sendTo(i, new Message(EchoMain.makeID(port), EchoMain.makeID(port)));
		    this.ParMessage= new Message(EchoMain.makeID(port),EchoMain.makeID(port));
		}
	    }

	    ServerSocket welcomeSocket = new ServerSocket(port);

	    while (true) {
		Message message = receive(welcomeSocket);
		if(initiator){
		    ParMessage.addParentingInfo(message);
		}
		if (!initiator && !Blasted) {
		    //Blast to all minus Parent
		    if (parIndex == -1) {
			parIndex = computeParent(message);
			ParMessage= new Message(message.getSender(),EchoMain.makeID(port));
			ParMessage.addParent(parent, port);
		    }
		    //blast new messages
		    for (int i = 0; i < neighbors.length; i++) {
			if (parIndex != i) {
			    sendTo(i, new Message(message.getId(), EchoMain.makeID(port)));
			}
		    }
		    Blasted = true;
		}
		if(!initiator&& Blasted){
		    ParMessage.addParentingInfo(message);
		}
		if (recAll()) {
		    if (initiator) {
			ParMessage.printParents();
		    } else {
			
			sendTo(parIndex, ParMessage);
			
		    }
		    welcomeSocket.close();
		    break;
		}
	    }
	} catch (Exception _ex) {
	}

	System.out.println((port) + ": DONE");
    }
}

