/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TarryToEchoWExt;

/**
 * @author dtmirizzi
 */
import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 *
 * @author graham
 */
public class TarryMain {

		//	get an id for this node as a InetSocketAddress
    //	must match what we did in TarryMain to create neighbors

    public static InetSocketAddress makeID(int port) throws Exception {
	return new InetSocketAddress(InetAddress.getByName("localhost"), port);
    }

    public static void main(String[] args) throws Exception {

	InetSocketAddress[] neighbors0
		= {
		    makeID(30001),
		    makeID(30003),};
	InetSocketAddress[] neighbors1
		= {
		    makeID(30000),
		    makeID(30004),
		    makeID(30002),};
	InetSocketAddress[] neighbors2
		= {
		    makeID(30001),
		    makeID(30003),};
	InetSocketAddress[] neighbors3
		= {
		    makeID(30000),
		    makeID(30002),};
	InetSocketAddress[] neighbors4
		= {
		    makeID(30001),};

	Tarry node0 = new Tarry(30000, neighbors0,true);
	Tarry node1 = new Tarry(30001, neighbors1,true);
	Tarry node2 = new Tarry(30002, neighbors2,true);
	Tarry node3 = new Tarry(30003, neighbors3,true);
	Tarry node4 = new Tarry(30004, neighbors4,false);

	Thread t0 = new Thread(node0);
	Thread t1 = new Thread(node1);
	Thread t2 = new Thread(node2);
	Thread t3 = new Thread(node3);
	Thread t4 = new Thread(node4);

	t0.start();
	t1.start();
	t2.start();
	t3.start();
	t4.start();

	t0.join();
	t1.join();
	t2.join();
	t3.join();
	t4.join();
    }
}
