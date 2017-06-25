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
 
 
public class ClearSimulationActionListener implements ActionListener {
 
    private GameOfLifeFrame frame;
     
    private GridBase model;
 
    public ClearSimulationActionListener(GameOfLifeFrame frame,
            GridBase model) {
        this.frame = frame;
        this.model = model;
    }
 
    @Override
    public void actionPerformed(ActionEvent event) {
        model.clearGrid();
        frame.setGenerationTextField();
        frame.repaintGridPanel();
    }
     
}
