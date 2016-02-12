package Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * ChangeModeListener class. 
 * Listener is added to buttons. When such a button is pressed, it changes the current mode
 * to the one passed as an argument.
 * 
 * @author Jessica, Nick
 * @version 1.0 9/2/16
 *
 */
public class ChangeModeListener implements ActionListener{
	private Mode mode;
	
	/**
	 * Public constructor for ChangeModeListener. 
	 * 
	 * @param mode 		future mode
	 */
	public ChangeModeListener(Mode mode){
		this.mode = mode;
	}
	
	
	/**
	 * Method switches from current mode to future mode. 
	 * 
	 * @param e		ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Main.changeMode(mode);
		
	}
	
}
