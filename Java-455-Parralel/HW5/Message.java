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

//    private final static LinkedList<int[]> parents = new LinkedList<>();
    private HashMap<Pair<Integer,Integer>,Integer> Parents = new HashMap<>();

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

    public void addParent(InetSocketAddress parent, int childPort) {
        Parents.put(new Pair<>(parent.getPort(), childPort),1);
    }

    public HashMap<Pair<Integer,Integer>,Integer> getParents() {
	return Parents;
    }
    
    public void addParentingInfo(Message M){
        Parents.putAll(M.getParents());
    }

    @Override
    public String toString() {
	return "Message{" + "id=" + id + ", sender=" + sender + '}';
    }

    public void printParents() {
	System.out.println("Parents:");
        Parents.forEach((k,v)->System.out.println(k.getKey()+" -> "+k.getValue()));
    }

}