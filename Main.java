package Project;
/**
 * Main class from which the application is run.
 * Creates a GUI object and changes its state according to User actions.
 * On running the application, currentMode is set to be onOffMode,
 * This means that the use of buttons is disabled until the Simori-ON 
 * is switched on, and the application moves into PerformanceMode.
 *
 *@author Jessica, Natalia, Ecaterina, Nick, Preslav
 *
 *@version 1.3 9/2/16
 *
 */
public class Main {
	
	private static GUI gui;
	private static Mode currentMode = new OnOffMode(); 
	public static Layer currentLayer;
	public static final long SLEEP_TIME=10;
	
	//public static boolean buttonsDisabled = true;
		
	/**
	 * Method is called from other nodes when they 
	 * encounter an event that requires a change of mode.
	 * 
	 * @param mode  -- the mode in which the application 
	 * 				   will move into
	 * 
	 * @author Jessica
	 */
	public static void changeMode(Mode mode){
		gui.removeAllListeners();
		currentMode = mode;
		currentMode.init();
	}
	
	/**
	 * Main method initialises GUI according to its current mode. 
	 * As long as there is no event that requires a change of mode,
	 * the main method uses a thread to continuously call upon 
	 * the doSomething() method associated with its current mode.
	 * 
	 * @author Natalia, Ecaterina, Jessica, Preslav
	 */
	public static void main(String args[]){
		
		gui = GUI.getInstance();
		currentMode.init();
		
		while(true){
			currentMode.doSomething();
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}
	
}
