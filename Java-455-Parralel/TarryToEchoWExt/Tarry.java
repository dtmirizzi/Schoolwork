/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TarryToEchoWExt;

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
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tarry implements Runnable {

    private final int port;
    private final InetSocketAddress[] neighbors;
    private InetSocketAddress curWave;
    private InetSocketAddress ParentId;
    private boolean leader;
    private boolean init;
    private final boolean[] receivedFrom;

    public Tarry(int port, InetSocketAddress[] neighbors, boolean Init) throws Exception {
	this.port = port;
	this.neighbors = neighbors;
	this.init = Init;
	if (init == true) {
	    curWave = TarryMain.makeID(port);
	} else {
	    curWave = TarryMain.makeID(29999);
	}
	receivedFrom = new boolean[neighbors.length];
	leader = true;
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

	}
	return message;
    }

    private boolean recAll() {
	for (int i = 0; i < receivedFrom.length; i++) {
	    if (receivedFrom[i] == false) {
		return false;
	    }
	}
	return true;
    }

    public int computeParent(Message message) {
	for (int i = 0; i < neighbors.length; i++) {
	    if (neighbors[i].equals(message.getSender())) {
		System.out.println("Parent of " + port + " = " + neighbors[i]);
		return i;
	    }
	}

	return -1;
    }

    @Override
    public void run() {
	if (this.init == true) {
	    Runnable r1;
	    r1 = () -> {
		try {
		    Thread.sleep(2000);
		} catch (InterruptedException ex) {
		    Logger.getLogger(Tarry.class.getName()).log(Level.SEVERE, null, ex);
		}
		for (int i = 0; i < neighbors.length; i++) {
		    try {
			sendTo(i, new Message(this.curWave, TarryMain.makeID(port)));
		    } catch (Exception ex) {
			Logger.getLogger(Tarry.class.getName()).log(Level.SEVERE, null, ex);
		    }
		}
	    };

	    Thread tSender = new Thread(r1);
	    tSender.start();
	}

	try {

	    ServerSocket welcomeSocket = new ServerSocket(port);

	    while (true) {
		Message message = receive(welcomeSocket);
		if (this.curWave.getPort() < message.getId().getPort()) {
		    // makes sender his parent sets curWave to senderwave 
		    //resets received from data sets leader to false 
		    this.ParentId = message.getSender();
		    this.curWave = message.getId();
		    this.leader = false;
		    System.out.println("I am not the leader " + port);
		    for (int i = 0; i < this.receivedFrom.length; i++) {
			this.receivedFrom[i] = false;
		    }
		    int parIndex = computeParent(message);
		    for (int i = 0; i < neighbors.length; i++) {
			if (parIndex != i) {
			    sendTo(i, new Message(this.curWave, TarryMain.makeID(port)));
			}
		    }

		} else if (this.curWave.getPort() > message.getId().getPort()) {
		    // throw away
		}
		if (this.curWave.equals(message.getId())) {
		 // echo because q=r

		    /// Recived from will have to be checked inside this else
		    SocketAddress sender = message.getSender();

		    for (int i = 0; i < neighbors.length; i++) {
			if (neighbors[i].equals(sender)) {
			    receivedFrom[i] = true;
			}

		    }

		    ///normal Echo alg modifiy to get it to work with slight changes
		    if (recAll()) {
			if (leader) {
			    System.out.println("I am the Leader:" + this.port);
			} else {
			    int parIndex = 0;
			    for (int i = 0; i < this.neighbors.length; i++) {
				if (this.ParentId.equals(this.neighbors[i])) {
				    parIndex = i;
				}
			    }
			    sendTo(parIndex, new Message(this.curWave, TarryMain.makeID(port)));

			}

		    }
		}

	    }
	} catch (Exception _ex) {
	    _ex.printStackTrace();
	}

	System.out.println((port) + ": DONE");
    }
}
