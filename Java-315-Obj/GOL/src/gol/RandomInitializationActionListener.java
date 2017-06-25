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
import java.util.Random;
 
import gol.GridBase;
import gol.GameOfLifeFrame;
 
public class RandomInitializationActionListener 
        implements ActionListener {
 
    private GameOfLifeFrame frame;
     
    private GridBase model;
     
    private Random random;
 
    public RandomInitializationActionListener(GameOfLifeFrame frame,
            GridBase model) {
        this.frame = frame;
        this.model = model;
        this.random = new Random();
    }
 
    @Override
    public void actionPerformed(ActionEvent event) {
        int size = model.getGridWidth();
        int count = size * size / 5;
        for (int k = 0; k < count; k++) {
            int i = random.nextInt(size);
            int j = random.nextInt(size);
            model.setCell(i, j);
        }
        frame.repaintGridPanel();
    }
     
     
}