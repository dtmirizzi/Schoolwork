/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gol;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author dtmirizzi
 */
public class AddGridRecActionListener implements MouseListener {

    private GameOfLifeFrame frame;
    private GridBase model;

    public AddGridRecActionListener(GameOfLifeFrame frame,
	    GridBase model) {
	this.frame = frame;
	this.model = model;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

	model.drawCell(e.getX(), e.getY());
	frame.repaintGridPanel();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
