/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gol;

/**
 * @author dtmirizzi
 */
import javax.swing.SwingUtilities;
 
import gol.GridBase;
import gol.GameOfLifeFrame;
 
public class GameOfLife implements Runnable {
     
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new GameOfLife());
    }
 
    @Override
    public void run() {
        new GameOfLifeFrame(new GridBase());
    }
 
}