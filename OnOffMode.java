package Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * OnOffMode class.
 * Application always starts by creating an instance of this method.  
 * When init() method is called, all matrix buttons are cleared 
 * and application moves into Performance Mode.
 * 
 * @author Jessica, Natalia
 * @version 1.1 9/2/16
 * 
 * 
 */

public class OnOffMode implements Mode {


	@Override
	public void doSomething() {
		
	}

	/**
	 * Method clears all matrix buttons and 
	 * application moves into Performance Mode.
	 */
	@Override
	public void init() {

		GUI gui = GUI.getInstance();
		gui.clearMatrixButtons();
		gui.clearLCD();		
		
		// create instance of change mode listener which sets the mode to the one given as an argument
		ActionListener changeModeListener = new ChangeModeListener(new PerformanceMode());
		gui.addOnOffListener(changeModeListener);
		

		}
		

	

}
