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
 
public class StopSimulationActionListener implements ActionListener {
     
    private StartSimulationActionListener listener;
 
    public void setListener(StartSimulationActionListener listener) {
        this.listener = listener;
    }
 
    @Override
    public void actionPerformed(ActionEvent event) {
	try{
        listener.stopSimulation();
	}catch(Exception ex){
	    
	}
    }
 
}