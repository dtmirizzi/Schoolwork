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
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JComboBox;

public class ControlPanel {

    private static final Insets buttonInsets
	    = new Insets(10, 10, 0, 10);

    private GameOfLifeFrame frame;

    private GridBase model;

    private JPanel panel;

    private JTextField generationTextField;

    public ControlPanel(GameOfLifeFrame frame, GridBase model) {
	this.frame = frame;
	this.model = model;
	createPartControl();
    }

    private void createPartControl() {
	StartSimulationActionListener startListener
		= new StartSimulationActionListener(frame, model);
	StopSimulationActionListener stopListener
		= new StopSimulationActionListener();
	stopListener.setListener(startListener);

	panel = new JPanel();
	panel.setLayout(new GridBagLayout());

	int gridy = 0;

	JButton randomButton = new JButton("Random Initialization");
	randomButton.addActionListener(
		new RandomInitializationActionListener(frame, model));
	addComponent(panel, randomButton, 0, gridy++, 2, 1,
		buttonInsets, GridBagConstraints.LINE_START,
		GridBagConstraints.HORIZONTAL);

	JButton startButton = new JButton("Start Simulation");
	startButton.addActionListener(startListener);
	addComponent(panel, startButton, 0, gridy++, 2, 1,
		buttonInsets, GridBagConstraints.LINE_START,
		GridBagConstraints.HORIZONTAL);

	JButton stopButton = new JButton("Stop Simulation");
	stopButton.addActionListener(stopListener);
	addComponent(panel, stopButton, 0, gridy++, 2, 1,
		buttonInsets, GridBagConstraints.LINE_START,
		GridBagConstraints.HORIZONTAL);

	JButton clearButton = new JButton("Clear Simulation");
	clearButton.addActionListener(
		new ClearSimulationActionListener(frame, model));
	addComponent(panel, clearButton, 0, gridy++, 2, 1,
		buttonInsets, GridBagConstraints.LINE_START,
		GridBagConstraints.HORIZONTAL);

	String[] bookTitles = new String[]{"Default Rule", "Alt Rule",
	    "Default Rule with Wraping", "Alt Rule with Wraping"};

	JComboBox<String> bookList = new JComboBox<>(bookTitles);
	bookList.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent event) {
		JComboBox<String> combo = (JComboBox<String>) event.getSource();
		String selectedBook = (String) combo.getSelectedItem();

		if (selectedBook.equals("Default Rule")) {
		    model.setRule(1);
		} else if (selectedBook.equals("Alt Rule")) {
		    model.setRule(2);
		}
		else if (selectedBook.equals("Default Rule with Wraping")) {
		    model.setRule(3);
		}
		else if (selectedBook.equals("Default Rule with Wraping")) {
		    model.setRule(4);
		}
	    }
	});
	addComponent(panel, bookList, 0, gridy++, 2, 1,
		buttonInsets, GridBagConstraints.LINE_START,
		GridBagConstraints.HORIZONTAL);
	String[] objectTitles = new String[]{"Make Cell", "Make Snake", "Make Sin","Make Glider"};

	JComboBox<String> objectList = new JComboBox<>(objectTitles);
	objectList.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent event) {
		JComboBox<String> combo = (JComboBox<String>) event.getSource();
		String selectedBook = (String) combo.getSelectedItem();
		if (selectedBook.equals("Make Cell")) {

		} else if (selectedBook.equals("Make Snake")) {
		    int size = model.getGridWidth();
		    int count = size * size / 5;
		    for (int k = 0; k < count; k++) {
			int i = k %size;
			int j = k %size;
			model.setCell(i, j);
			if(j==i&& j>10 && j<90&i>10 &i<90){
			    model.setCell(i+3, j+1);
			}
		    }
		    frame.repaintGridPanel();

		} else if (selectedBook.equals("Make Sin")) {
		    int size = model.getGridWidth();
		    int count = size * size / 5;
		    for (int k = 0; k < count; k++) {
			int i = 100-k %size-1;
			int j = Math.abs((int) (50 *Math.sin(k) %size-1));
			model.setCell(i, j);
			
		    }
		    frame.repaintGridPanel();

		}
		else if (selectedBook.equals("Make Glider")){
		    model.setCell(50,50);
		    model.setCell(51,50);
		    model.setCell(52,50);
		    model.setCell(52,51);
		    model.setCell(51,52);
		    
		    model.setCell(60,60);
		    model.setCell(61,60);
		    model.setCell(62,60);
		    model.setCell(62,61);
		    model.setCell(61,62);
		    frame.repaintGridPanel();
		}
	    }
	});
	addComponent(panel, objectList, 0, gridy++, 2, 1,
		buttonInsets, GridBagConstraints.LINE_START,
		GridBagConstraints.HORIZONTAL);

	JLabel sliderLabel = new JLabel("Generation Delay in Seconds",
		JLabel.CENTER);
	sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	addComponent(panel, sliderLabel, 0, gridy++, 2, 1,
		buttonInsets, GridBagConstraints.LINE_START,
		GridBagConstraints.HORIZONTAL);

	int defaultDelay = (int) model.getGenerationDelay() / 1000;
	JSlider generationDelaySlider
		= new JSlider(JSlider.HORIZONTAL, 1, 10, defaultDelay);
	generationDelaySlider.addChangeListener(new GenerationDelayChangeListener(model));
	generationDelaySlider.setMajorTickSpacing(1);
	generationDelaySlider.setPaintLabels(true);
	generationDelaySlider.setPaintTicks(true);
	addComponent(panel, generationDelaySlider, 0, gridy++, 2, 1,
		buttonInsets, GridBagConstraints.LINE_START,
		GridBagConstraints.HORIZONTAL);

	JLabel generationLabel = new JLabel("Generation:");
	addComponent(panel, generationLabel, 0, gridy, 1, 1,
		buttonInsets, GridBagConstraints.LINE_START,
		GridBagConstraints.HORIZONTAL);

	generationTextField = new JTextField(10);
	generationTextField.setHorizontalAlignment(JTextField.CENTER);
	generationTextField.setEditable(false);
	addComponent(panel, generationTextField, 1, gridy++, 1, 1,
		buttonInsets, GridBagConstraints.LINE_START,
		GridBagConstraints.HORIZONTAL);

    }

    private void addComponent(Container container, Component component,
	    int gridx, int gridy, int gridwidth, int gridheight,
	    Insets insets, int anchor, int fill) {
	GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
		gridwidth, gridheight, 1.0D, 1.0D, anchor, fill,
		insets, 0, 0);
	container.add(component, gbc);
    }

    public void setGenerationTextField(long generationCount) {
	NumberFormat nf = NumberFormat.getInstance();
	generationTextField.setText(nf.format(generationCount));
    }

    public JPanel getPanel() {
	return panel;
    }

}
