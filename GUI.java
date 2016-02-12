package Project;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

/**
 * GUI class.
 * Class Representing the graphical user interface.
 * Constructor sets up an instance of GUI. 
 * Singleton design pattern makes sure that only one instance 
 * of GUI exists at one time.
 * Provides methods to add and remove listeners. 
 * Button-specific listeners will be specified in separate classes. 
 * 
 * @author Ecaterina, Jessica, Preslav, Natalia, Nick
 * 
 * @version 1.3 10/2/2016 
 *
 */
public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private Button onOffButton, L1, L2, L3, L4, R1, R2, R3, R4, OK;
	private JLabel LCD;
	//private boolean isOff;
	private MatrixButton[] buttons = new MatrixButton[256];
	//private boolean offFlag;

	public static final int GRID_SIZE = 16;
	private static GUI gui;
	

	/**
	 * Private GUI constructor, does not take any arguments.
	 * Sets up whole graphical user interface for Simori-ON. 
	 * 
	 * @author Ecaterina, Jessica, Preslav, Natalia, Nick
	 */
	private GUI() {

		// Define the size of the frame
		this.setSize(700, 500);

		// Opens the frame in the middle of the screen
		this.setLocationRelativeTo(null);

		// Define how the frame exits (Click the Close Button)
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Define the title for the frame
		this.setTitle("Tenori-on");

		//creation of central panel with grid for buttons	
		JPanel thePanel = new JPanel();
		thePanel.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE, 5, 10));
		thePanel.setMaximumSize(new Dimension(700, 500));
		this.add(thePanel, BorderLayout.CENTER);

		JPanel top = new JPanel();
		top.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		this.add(top, BorderLayout.PAGE_START);

		onOffButton = new Button("ON");
		top.add(onOffButton);

		//adding matrix buttons to the main panel
		for(int i=0; i<buttons.length; i++){
			MatrixButton b = new MatrixButton(i);
			buttons[i]=b;
			thePanel.add(b);
		}
		
		
		JPanel east = new JPanel();
		east.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		this.add(east, BorderLayout.EAST);
		east.setLayout(new GridLayout(4, 1, 5, 10));

		R1 = new Button("R1");
		east.add(R1);

		R2 = new Button("R2");
		east.add(R2);

		R3 = new Button("R3");
		east.add(R3);

		R4 = new Button("R4");
		east.add(R4);

		JPanel west = new JPanel();
		west.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		this.add(west, BorderLayout.WEST);
		west.setLayout(new GridLayout(4, 1, 5, 10));

		L1 = new Button("L1");
		west.add(L1);

		L2 = new Button("L2");
		west.add(L2);

		L3 = new Button("L3");
		west.add(L3);

		L4 = new Button("L4");
		west.add(L4);

		JPanel south = new JPanel();
		south.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		this.add(south, BorderLayout.SOUTH);
		south.setLayout(new GridLayout(1, 2, 5, 10));

		LCD = new JLabel("LCD"); 							
		south.add(LCD);

		OK = new Button("OK");
		south.add(OK);

		this.add(thePanel);
		this.pack();
		this.setVisible(true);

	}
	
	/** 
	 * Provides access to a specific button on the matrix.
	 * 
	 * @author Jessica
	 * @param ID 	button ID
	 * @return button  
	 */
	public MatrixButton getMatrixButton(int ID){
		return buttons[ID];
	}
	
	/**
	 * the following methods allow the user to access and add listeners to specific
	 * buttons from each mode class.  This enables the GUI functionality to be manipulated
	 * from each mode without it affecting other mode functions.
	 * 
	 * @param listener
	 * @author Jessica
	 */
	
	public void addOnOffListener(ActionListener listener){
		onOffButton.addActionListener(listener);
	}
	
	public void addOkListener(ActionListener listener){
		OK.addActionListener(listener);
	}
	
	public void addListenerR1(ActionListener listener){
		R1.addActionListener(listener);
	}
	
	public void addListenerR2(ActionListener listener){
		R2.addActionListener(listener);
	}
	
	public void addListenerR3(ActionListener listener){
		R3.addActionListener(listener);
	}
	
	public void addListenerR4(ActionListener listener){
		R4.addActionListener(listener);
	}
	
	public void addListenerL1(ActionListener listener){
		L1.addActionListener(listener);
	}
	
	public void addListenerL2(ActionListener listener){
		L2.addActionListener(listener);
	}
	
	public void addListenerL3(ActionListener listener){
		L3.addActionListener(listener);
	}
	
	public void addListenerL4(ActionListener listener){
		L4.addActionListener(listener);
	}
	

	/**
	 * Method sets what is currently displayed on LCD.
	 * 
	 * @param text -- the text that will appear on the LCD
	 * 
	 * @author Nick
	 */
	public void setLCDText(String text){
		LCD.setText(text);
	}
		
	/**
	 * Method does not take any arguments and does not return anything.
	 * it clears all of the buttons on the matrix - sets their active 
	 * state to false /not being in use/.
	 * 
	 * @author Preslav
	 */
	public void clearMatrixButtons(){
		for(int i=0; i<buttons.length; i++){
			buttons[i].setButtonActive(false);
		}
	}
	
	/**
	 * Remove all the listeners from each button on the Simori-ON.
	 * Not currently used.
	 * 
	 * @author Jessica
	 */
	public void removeAllListeners(){
		R1.removeAllListeners();
		R2.removeAllListeners();
		R3.removeAllListeners();
		R4.removeAllListeners();
		L1.removeAllListeners();
		L2.removeAllListeners();
		L3.removeAllListeners();
		L4.removeAllListeners();
		OK.removeAllListeners();
		onOffButton.removeAllListeners();
		
		for(int i=0; i<buttons.length; i++){
			buttons[i].removeAllListeners();
		}
	}
	
	/**
	 * Method adds a particular listener to all buttons in the matrix.
	 * @param listener
	 * 
	 * @author Jessica
	 */
	public void addListenerToAllMatrixButtons(ActionListener listener){
		for(int i=0; i<buttons.length; i++){
			buttons[i].addActionListener(listener);
		}
	}
	
	
	/**
	 * Method takes no parameters and
	 * does not return anything, but it disables all
	 * of the buttons in the GUI
	 * 
	 * @author Preslav
	 */
	public void disableAllButtons(){
		R1.setEnabled(false);
		R2.setEnabled(false);
		R3.setEnabled(false);
		R4.setEnabled(false);
		L1.setEnabled(false);
		L2.setEnabled(false);
		L3.setEnabled(false);
		L4.setEnabled(false);
		OK.setEnabled(false);
		
		for(int i=0; i<buttons.length; i++){
			buttons[i].setEnabled(false);
		}
	}
	
	
	/**
	 * Method takes no parameters and 
	 * does not return anything, but it disables all
	 * of the buttons in the GUI 
	 * 
	 * @author Preslav 
	 */
	public void enableAllButtons(){
		R1.setEnabled(true);
		R2.setEnabled(true);
		R3.setEnabled(true);
		R4.setEnabled(true);
		L1.setEnabled(true);
		L2.setEnabled(true);
		L3.setEnabled(true);
		L4.setEnabled(true);
		OK.setEnabled(true);

		
		for(int i=0; i<buttons.length; i++){
			buttons[i].setEnabled(true);
		}
	}
	
	/**
	 * Method sets LCD to be blank. 
	 * 
	 * @author Nick
	 */
	public void clearLCD(){
		LCD.setText(null);
	}
	
	/**
	 * Method clears buttons that have been lit up by the clockhand. 
	 * @author Jessica
	 */
	public void clearColour(){
		for(int i=0; i<buttons.length; i++){
			if (buttons[i].isColoured() && ! buttons[i].isButtonActive()){
				buttons[i].setBackground(null);
			}
		}
	}
	
	/**
	 * 
	 * Method lights up entire row and columns with row and column IDs.
	 * @param rowID
	 * @param columnID
	 */
	public void lightUpColumnAndRow(int rowID, int columnID){
		for(int i=0; i<256; i++){
			if(buttons[i].getColumnID() == columnID || buttons[i].getRowID()==rowID){
				buttons[i].setButtonActive(true);
				
			}
		}
		
	}

	/**
	 * 
	 * getIntance method is designed following the 
	 * Thread Safe Singleton design pattern. It ensures 
	 * that a class has only one instance, and provides a 
	 * global point of access of it. It does not accept 
	 * any arguments it returns GUI instance. 
	 * 
	 * @return gui -- GUI object representing the Senori-On
	 * 				  graphical user interface
	 * 
	 * @author Preslav 
	 */
	public static GUI getInstance() {
		// check if instance exists
		if (gui == null) {
			synchronized (GUI.class) {
				if (gui == null) {
					gui = new GUI();
				}
			}
		}
		return gui;
	}


}


