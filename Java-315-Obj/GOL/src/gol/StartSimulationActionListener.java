/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gol;

/**
 *
 * @author dtmirizzi
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.SwingUtilities;
 
import gol.GridBase;
import gol.GameOfLifeFrame;
 
public class StartSimulationActionListener implements ActionListener {
 
    private GameOfLifeFrame frame;
     
    private GridBase model;
     
    private RunSimulation runSimulation;
     
    public StartSimulationActionListener(GameOfLifeFrame frame,
            GridBase model) {
        this.frame = frame;
        this.model = model;
    }
 
    @Override
    public void actionPerformed(ActionEvent event) {
        runSimulation = new RunSimulation();
        new Thread(runSimulation).start();
    }
     
    public void stopSimulation() {
        runSimulation.stopRunning();
        runSimulation = null;
    }
     
    class RunSimulation implements Runnable {
         
        private volatile boolean running;
 
        @Override
        public void run() {
            this.running = true;
            while (running) {
                sleep();
                model.cycleGrid();
                repaint();
            }
        }
         
        private void repaint() {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    frame.setGenerationTextField();
                    frame.repaintGridPanel();
                }
            });
        }
         
        private void sleep() {
            try {
                Thread.sleep(model.getGenerationDelay());
            } catch (InterruptedException e) {
            }
        }
         
        public synchronized void stopRunning() {
            this.running = false;
        }
         
    }
 
}