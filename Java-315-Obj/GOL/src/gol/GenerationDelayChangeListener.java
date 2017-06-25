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
 
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
 
import gol.GridBase;
 
public class GenerationDelayChangeListener implements ChangeListener {
 
    private GridBase model;
     
    public GenerationDelayChangeListener(GridBase model) {
        this.model = model;
    }
 
    @Override
    public void stateChanged(ChangeEvent event) {
        JSlider source = (JSlider) event.getSource();
        if (!source.getValueIsAdjusting()) {
            model.setGenerationDelay(1000L * source.getValue());
        }
    }
 
}
