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
 
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import gol.AddGridRecActionListener;

 
import javax.swing.JFrame;
import javax.swing.JPanel;
 
import gol.GridBase;

 
public class GameOfLifeFrame {
     
    private ControlPanel controlPanel;
     
    private GridBase model;
     
    private GridPanel gridPanel;
     
    private JFrame frame;
     
    public GameOfLifeFrame(GridBase model) {
        this.model = model;
        createPartControl();
    }
 
    private void createPartControl() {
        controlPanel = new ControlPanel(this, model);
        gridPanel = new GridPanel(model);
	
	gridPanel.addMouseListener(new AddGridRecActionListener(this, model));
         
        frame = new JFrame();
        frame.setTitle("Conway's GoL");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                exitProcedure();
            }
        });
        frame.setResizable(false);
         
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(gridPanel);
        mainPanel.add(controlPanel.getPanel());
        
        frame.setLayout(new FlowLayout());
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
 
    public void exitProcedure() {
        frame.dispose();
        System.exit(0);
    }
     
    public void setGenerationTextField() {
        controlPanel.setGenerationTextField(model.getGenerationCount());
    }
 
    public void repaintGridPanel() {
        gridPanel.repaint();
    }

}
