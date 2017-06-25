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

import java.awt.Graphics;
 
import javax.swing.JPanel;
 
import gol.GridBase;
import gol.GameOfLifeFrame;
 
public class GridPanel extends JPanel {
 
    private static final long serialVersionUID = -8035892195317835189L;
     
    private GridBase model;
    private GameOfLifeFrame frame;
    
 
    public GridPanel(GridBase model) {
        this.model = model;
        this.setPreferredSize(model.getPreferredSize());
    }
    
     
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        model.draw(g);
    }
}