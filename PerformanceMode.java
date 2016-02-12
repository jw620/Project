package Project;

import java.awt.event.ActionEvent;

import Project.MatrixButton.MatrixButtonListener;

/**
 * Performance mode.  So far just contains the clockhand which moves across the grid
 * at a set time (to be changed in next sprint)
 * 
 * When the init() method is called from main method, the LayerListener is applied to 
 * all buttons, which, when a matrix button is pressed, will set a boolean in the same 
 * position in the corresponding layer grid to true.
 * 
 * the change mode is added to the onOffListener which causes the application to cease 
 * from running should the on off button be pressed by the user in this class.
 * 
 * @author Jessica, Ecateria, Nick, Natalia, Preslav 
 *
 */

public class PerformanceMode implements Mode{
	

	
	// current column in which the current hand is in
	private int currentHandPosition = 0;
	
	// currently set time for the hand to travel across the grid
	private float duration = 8000;
	
	//current time
	private float time = 0;
	
	/*
	 * @author Jessica
	 */
	@Override
	public void doSomething() {
		
		//time must add on the time which the thread is not executing
		time += Main.SLEEP_TIME;
		
		// when time becomes longer than duration, the remainder is taken - this is added on to the next
		// loop along the grid, by using the modulus
		if(time>=duration){
			time %= duration;
		}
		
		// calculating new column position
		// as time/duration will be>1, when multiplied by grid size and cast to an int this will
		// give the column in which the lights are present.
		int newPosition = (int) ((time/duration)*GUI.GRID_SIZE);
		
		// when casting to an int gives a new column position, the current hand position is altered to this.
		if(newPosition != currentHandPosition){
			GUI gui = GUI.getInstance();
			currentHandPosition = newPosition;
			
		// as a result of the new position, the colours must be cleared from previous column
			// clear colour of buttons if not active in grid
			gui.clearColour();
			
		// Button to be lit up is located using buttonID and lit up using set colour method
			for(int i=0; i<GUI.GRID_SIZE; i+=5){
				int buttonID = (i*GUI.GRID_SIZE)+currentHandPosition;
				gui.getMatrixButton(buttonID).setButtonColour(true);
			}
		}	
	}

	/**
	 * Initialisation of performance mode. 
	 * Layer listener added to all matrix buttons
	 */
	@Override
	public void init() {
		GUI gui = GUI.getInstance();
		gui.clearMatrixButtons();
		gui.removeAllListeners();
		gui.setLCDText("Performance Mode");
		gui.addListenerToAllMatrixButtons(new LayerListener());
	
		
		// creation of layers.. need to be made multiple - perhaps stored in an array?
		// change layer mode - chooses which layer
		// create layers elsewhere - Layer Manager class - Array of 16 layers and current layer
		//static or a singleton
		Layer layer1 = new Layer();
		Main.currentLayer = layer1;

		
		gui.addOnOffListener(new ChangeModeListener(new OnOffMode()));
		gui.addListenerR1(new ChangeModeListener(new ChangeLayerMode()));
		gui.addListenerR2(new ChangeModeListener(new SaveConfigurationMode()));
		gui.addListenerR3(new ChangeModeListener(new LoadConfigurationMode()));
		gui.addListenerR4(new ChangeModeListener(new MasterSlaveMode()));
		gui.addListenerL1(new ChangeModeListener(new ChangeVoiceMode()));
		gui.addListenerL2(new ChangeModeListener(new ChangeVelocityMode()));
		gui.addListenerL3(new ChangeModeListener(new ChangeLoopSpeedMode()));
		gui.addListenerL4(new ChangeModeListener(new ChangeLoopPointMode()));
		
	}
	/**
	 * LayerListener class
	 * extends MatrixButtonListener class but also uses the co-ordinates of the 
	 * pressed matrix button to change a boolean from false to true on a corresponding
	 * grid of booleans representing a layer.  This value is then responsible for allowing
	 * a sound to be played when the clockhand reaches an active button.
	 * 
	 * @author Jessica 
	 *
	 */
	public static class LayerListener extends MatrixButtonListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			super.actionPerformed(e);
			
			int x = super.getPressedButton().getColumnID();
			int y = super.getPressedButton().getRowID();
			
			
			Main.currentLayer.toggle(x, y);
			System.out.println(Main.currentLayer.getGrid(x, y));
			


	}

}


}