/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarry;

/**
 *
 * @author dtmirizzi
 */
//	one node running Tarry's algorithm
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Random;

public class Tarry implements Runnable
{

	private final int port;
	private final InetSocketAddress[] neighbors;
	private final boolean initiator;

	public Tarry(int port, InetSocketAddress[] neighbors, boolean initiator)
	{
		this.port = port;
		this.neighbors = neighbors;
		this.initiator = initiator;
	}

	//	send a message to neighbor i
	private void sendTo(int i, Message m) throws Exception
	{
		System.out.println(m.getSender() + " : send : " + neighbors[i]);
		try (Socket clientSocket = new Socket(neighbors[i].getAddress(), neighbors[i].getPort()))
		{
			ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
			out.writeObject(m);
		}
	}

	private Message receive(ServerSocket welcomeSocket) throws Exception
	{
		Message message;
		try (Socket connectionSocket = welcomeSocket.accept())
		{
			ObjectInputStream in = new ObjectInputStream(connectionSocket.getInputStream());
			message = (Message) in.readObject();
			InetAddress result = connectionSocket.getInetAddress();
			SocketAddress sender = message.getSender();
			System.out.println(port + " : recieved : " + result + ":" + sender);
		}
		return message;
	}

	//	given a message from a sender, compute the index of the sender
	//	in the neighbors array
	public int computeParent(Message message, boolean[] sentTo)
	{
		for (int i = 0; i < neighbors.length; i++)
		{
			if (neighbors[i].equals(message.getSender()))
			{
				System.out.println("Parent of " + port + " = " + neighbors[i]);
				return i;
			}
		}

		return -1;
	}

	//	find a neighbor, other than the parent, that we haven't sent to yet
	private int findNext(int parent, boolean[] sentTo)
	{
		for (int i = 0; i < sentTo.length; i++)
		{
			if (parent != i && !sentTo[i])
			{
				return i;
			}
		}

		return -1;
	}

	@Override
	public void run()
	{
		boolean[] sentTo = new boolean[ neighbors.length ];	//	all initially false
		int parent = -1;

		try
		{
			//	if we are an initiator start a wave tagged with our id by sending a message
			//	to a random neighbor
			int rand = new Random().nextInt(neighbors.length);
			if (initiator)
			{
				sendTo(rand, new Message(TarryMain.makeID(port), TarryMain.makeID(port)));
				sentTo[rand] = true;
			}

			ServerSocket welcomeSocket = new ServerSocket(port);

			while (true)
			{
				//	wait for an incoming message
				Message message = receive(welcomeSocket);
				//	if we are the initiator and we receive a message from the node we
				//	intially started the wave at, then we are done
				if (initiator && message.getSender().equals(neighbors[rand]))
				{
					break;
				}
				//	remember the parent the first time -- the initiator doesn't have a parent
				if (!initiator && parent == -1)
				{
					parent = computeParent(message, sentTo);
				}
				//	find a neighbor to forward the message to
				int neighbor = findNext(parent, sentTo);
				if (neighbor != -1)
				{
					sentTo[neighbor] = true;
					sendTo(neighbor, new Message(message.getId(), TarryMain.makeID(port)));
				}
				else
				{
					//	if we have sent the message to all neighbors, send it back to the parent
					sendTo(parent, new Message(message.getId(), TarryMain.makeID(port)));
					welcomeSocket.close();
					break;
				}
			}
		}
		catch (Exception _)
		{
		}

		System.out.println("DONE");
	}
}
