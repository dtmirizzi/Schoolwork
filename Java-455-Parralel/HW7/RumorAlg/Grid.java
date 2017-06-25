/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RumorAlg;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author dtmirizzi
 */
public class Grid {

    public static void main(String[] args) {
	int N = 5;
	GridNode[][] nodez = new GridNode[N][N];

	System.out.println("Press Number to Print nodes, To do it again ");
	try {

	    InetSocketAddress[][][] nodes = new InetSocketAddress[N][N][];
	    Thread[][] threads = new Thread[N][N];

	    for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
		    int count = 0;
		    int nLeft = (j + (i * N) - 1);
		    if (nLeft >= 0 && (nLeft % N) != 3) {
			count++;
		    }
		    int nTop = j + (i * N) - N;
		    if (nTop >= 0) {
			count++;
		    }
		    int nRight = j + (i * N) + 1;
		    if ((nRight % N) != 0) {
			count++;
		    }
		    int nBottom = j + (i * N) + N;
		    if (nBottom < (N * N)) {
			count++;
		    }
		    nodes[i][j] = new InetSocketAddress[count];
		    int dec = count;

		    if (nLeft >= 0 && (nLeft % N) != 3) {
			nodes[i][j][count - dec] = makeID(nLeft + 30000);
			dec--;
		    }

		    if (nTop >= 0) {
			nodes[i][j][count - dec] = makeID(nTop + 30000);
			dec--;
		    }

		    if ((nRight % N) != 0) {
			nodes[i][j][count - dec] = makeID(nRight + 30000);
			dec--;
		    }

		    if (nBottom < (N * N)) {
			nodes[i][j][count - dec] = makeID(nBottom + 30000);
			dec--;
		    }

		    boolean infected = (i == 0 && j == 0);
		    GridNode node = new GridNode((j + (i * N) + 30000), infected, 5, nodes[i][j], 3);
		    Thread t = new Thread(node);
		    nodez[i][j] = node;
		    threads[i][j] = t;
		    t.start();
		}
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	}

	Runnable rKeyEventListener = () -> {
	    while (true) {

		Scanner scan = new Scanner(System.in);
		if (scan.hasNextInt()) {
		    for (int i = 0; i < nodez.length; i++) {
			for (int j = 0; j < nodez[i].length; j++) {
			    System.out.println(nodez[i][j].port + " : "
				    + nodez[i][j].infected + "->" + nodez[i][j].temp
				    + " : " + nodez[i][j].var);
			}
		    }
		}
	    }
	};

	Thread t1 = new Thread(rKeyEventListener);
	t1.start();

    }

    public static InetSocketAddress makeID(int port) throws Exception {
	return new InetSocketAddress(InetAddress.getByName("localhost"), port);
    }

}
