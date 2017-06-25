/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EchoWExt;


/**
 *
 * @author dtmirizzi
 */
import HW.Echo.*;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.util.HashMap;
import javafx.util.Pair;

public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    //	node id of the initiator of the wave
    private final InetSocketAddress id;
    //	node if of the sender of this message
    private final InetSocketAddress sender;

    public Message(InetSocketAddress id, InetSocketAddress sender) {
	this.id = id;
	this.sender = sender;

    }

    public InetSocketAddress getId() {
	return id;
    }

    public InetSocketAddress getSender() {
	return sender;
    }

    @Override
    public String toString() {
	return "Message{" + "id=" + id + ", sender=" + sender + '}';
    }

}
