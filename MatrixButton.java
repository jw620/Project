package Project;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.swing.JButton;
/**
 * MatrixButton class.
 * The class describes a button on the grid (matrix). 
 * Provides methods to access buttons from another 
 * classes and alternate button when it is in action.
 * Has attributes to identify if button is active and if it should be colored.
 * Default 'active color' is set to orange.
 * 
 * @author Natalia, Preslav, Ecaterina, Jessica
 * @version 1.3 10.02.2016
 */


public class MatrixButton extends Button {

	private boolean isActive = false;
	private boolean isColoured = false;
	private int columnID;
	private int rowID;
	private int buttonID;
	private final static Color ACTIVE_COLOUR = Color.ORANGE;

	
	
	/**
	 * Constructor which takes in the ID of a button, from
	 * which the position in the row and column can be calculated
	 *
	 * @param ID 	ID of the button on the matrix
	 */
	public MatrixButton(int ID) {
		this.buttonID = ID;
		this.rowID = buttonID/GUI.GRID_SIZE;
		this.columnID = buttonID % GUI.GRID_SIZE;
	}

	
	/**
	* Method returns the state of button.
	*
	* @return isActive 		Boolean flag identifying if button is in use
	*/	
	public boolean isButtonActive() {
		return isActive;
	}
	
	
	/**
	* Method returns ID of the column that button is in.
	*
	* @return columnID 
	*/
	public int getColumnID(){
		return this.columnID;
	}
	
	
	/**
	* Method returns ID of the row that button is in.
	*
	* @return rowID
	*/
	public int getRowID(){
		return this.rowID;
	}
	
	/**
	* Method returns a unique ID of the button.
	*
	* @return buttonID
	*/
	public int getButtonID() {
		return buttonID;
	}
	
	/**
	 * Method changes the state of the button 
	 * depending in the Boolean value passed as an argument.
	 * Illuminates button if it is set active and removes colouring if not.
	 * Button having this flag as 'true' will later be played as a sound.
	 * 
	 * @param b 	Boolean value
	 */
	public void setButtonActive(boolean b) {
		if (b) {
			this.setBackground(ACTIVE_COLOUR);
		} else {
			this.setBackground(null);
		}
		this.isActive = b;
	}
	
	/**
	 * Method changes the state of the button 
	 * depending in the Boolean value passed as an argument.
	 * Illuminates button if it is set active and removes colouring if not.
	 * Button having this flag 'true' will be 
	 * eliminated but will not do any other action.
	 * 
	 * @param b		Boolean value
	 */
	public void setButtonColour(boolean b){
		if(b){
			this.setBackground(ACTIVE_COLOUR);
		}else{
			this.setBackground(null);
		}
		this.isColoured = b;
	}
	
	
	/**
	* Method returns Boolean value if the button is coloured or not.
	*
	* @return isColoured	Boolean flag
	*/
	public boolean isColoured(){
		return isColoured;
	}

	
	/**
	 * MatrixButtonListener class.
	 * Listener listens for a matrix button to be pressed,
	 * which when pressed sets the button to active and changes its colour.
	 * When pressed again, it removes illumination and sets it as inactive.
	 * 
	 * @author Jessica 
	 */
	
	public static class MatrixButtonListener implements ActionListener {
		
		MatrixButton pressedButton;
		@Override
		public void actionPerformed(ActionEvent e) {

			pressedButton = (MatrixButton) e.getSource();

			if (!pressedButton.isButtonActive()) {
				pressedButton.setButtonActive(true);

			} else {
				pressedButton.setButtonActive(false);
			}

		}
		
		/**
		* Method returns pressed button object.
		*
		* @pressedButton 
		*/
		public MatrixButton getPressedButton(){
			return pressedButton;
		}
	}
}
