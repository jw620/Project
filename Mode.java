package Project;
import java.awt.event.ActionListener;

/**
 * Mode interface. 
 * Will be implemented by all modes to ensure general common behaviour.
 *
 * @author Jessica
 * @version 1.0 9/2/16
 */

public interface Mode {
	
	/**
	 * Method will describe behaviour of specific mode.
	 */
	public void doSomething();
	
	
	/**
	 * Method prepares the grid with relevant listeners and functionality to perform as 
	 * the mode specifies.
	 */
	public void init();

	
}
