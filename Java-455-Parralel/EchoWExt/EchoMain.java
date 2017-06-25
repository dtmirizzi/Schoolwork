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
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Random;

public class EchoMain {
    //	get an id for this node as a InetSocketAddress
    //	must match what we did in TarryMain to create neighbors

    public static InetSocketAddress makeID(int port) throws Exception {
	return new InetSocketAddress(InetAddress.getByName("localhost"), port);
    }

    public static void main(String[] args) throws Exception {
	Random rn = new Random(42);
	InetSocketAddress[] neighbors0
		= {
		    makeID(30001),
		    makeID(30003),makeID(30009),
		    makeID(30010),makeID(30012),
		    makeID(30016),};
	InetSocketAddress[][] Neighbors = new InetSocketAddress[24][];

	InetSocketAddress[] neighbors1
		= {
		    makeID(30000),
		    makeID(30004),
		    makeID(30002),};
	Neighbors[0] = neighbors1;
	
	InetSocketAddress[] neighbors2 = {
	    makeID(30001),
	    makeID(30003),
	};
	Neighbors[1] = neighbors2;
	InetSocketAddress[] neighbors3
		= {
		    makeID(30000),
		    makeID(30002),};
	Neighbors[2] = neighbors3;
	InetSocketAddress[] neighbors4
		= {
		    makeID(30001),makeID(30005),};
	Neighbors[3] = neighbors4;
	InetSocketAddress[] neighbors5
		= {
		    makeID(30004),
		    makeID(30017),};
	Neighbors[4] = neighbors5;
	InetSocketAddress[] neighbors6
		= {
		    makeID(30009),makeID(30007)};
	Neighbors[5] = neighbors6;
	InetSocketAddress[] neighbors7
		= {
		    makeID(30006),makeID(30008)};
	Neighbors[6] = neighbors7;
	InetSocketAddress[] neighbors8
		= {
		    makeID(30007),makeID(30023),};
	Neighbors[7] = neighbors8;
	InetSocketAddress[] neighbors9
		= {
		    makeID(30006),makeID(30013),makeID(30000)};
	Neighbors[8] = neighbors9;
	InetSocketAddress[] neighbors10
		= {
		    makeID(30000),
		    makeID(30014),makeID(30015),makeID(30011)};
	Neighbors[9] = neighbors10;
	InetSocketAddress[] neighbors11
		= {
		    makeID(30010),
		    makeID(30012),};
	Neighbors[10] = neighbors11;
	InetSocketAddress[] neighbors12
		= {
		    makeID(30011),
		    makeID(30000),};
	Neighbors[11] = neighbors12;
	InetSocketAddress[] neighbors13
		= {
		    makeID(30009),};
	Neighbors[12] = neighbors13;
	InetSocketAddress[] neighbors14
		= {
		    makeID(30010),
		    makeID(30015),};
	Neighbors[13] = neighbors14;
	InetSocketAddress[] neighbors15
		= {
		    makeID(30010),
		    makeID(30014),};
	Neighbors[14] = neighbors15;
	InetSocketAddress[] neighbors16
		= {
		    makeID(30000),
		    makeID(30024),};
	Neighbors[15] = neighbors16;
	InetSocketAddress[] neighbors17
		= {
		    makeID(30005)};
	Neighbors[16] = neighbors17;
	InetSocketAddress[] neighbors18
		= {
		    makeID(30021),
		    makeID(30019),};
	Neighbors[17] = neighbors18;
	InetSocketAddress[] neighbors19
		= {
		    makeID(30018),
		    makeID(30020),};
	Neighbors[18] = neighbors19;
	InetSocketAddress[] neighbors20
		= {
		    makeID(30019),
		    makeID(30022),};
	Neighbors[19] = neighbors20;
	InetSocketAddress[] neighbors21
		= {
		    makeID(30018),
		    makeID(30024),};
	Neighbors[20] = neighbors21;
	InetSocketAddress[] neighbors22
		= {
		    makeID(30020),
		    makeID(30023),};
	Neighbors[21] = neighbors22;
	InetSocketAddress[] neighbors23
		= {
		    makeID(30022),
		    makeID(30008),};
	Neighbors[22] = neighbors23;
	InetSocketAddress[] neighbors24
		= {
		    makeID(30021),
		    makeID(30016),};
	Neighbors[23] = neighbors24;


	EchoNode[] Nodes = new EchoNode[24];
	EchoNode node0 = new EchoNode(30000, neighbors0, true);
	int port = 30001;
	for (int i = 0; i < Nodes.length-1; i++) {
	    Nodes[i] = new EchoNode(port, Neighbors[i], true);
	    port++;
	}
	Nodes[Nodes.length-1] = new EchoNode(port, Neighbors[Nodes.length-1], false);

	Thread[] Threads = new Thread[24];
	Thread t0 = new Thread(node0);
	int i = 0;
	for (EchoNode x : Nodes) {
	    Threads[i] = new Thread(x);
	    i++;
	}

	t0.start();
	for (Thread t : Threads) {
	    t.start();
	}

	t0.join();
	for (Thread t : Threads) {
	    t.join();
	}
    }
}
