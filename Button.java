package Project;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
/**
 * Button class. 
 * Extension of the JButton class to allow for an associated 
 * list of listeners to be added to the button. 
 * This functionality is used when switching to another mode.
 * 
 * @author Jessica, Preslav 
 * @version 1.0 9/2/16
 */
public class Button extends JButton{
	

	private static final long serialVersionUID = 1L;
	private List<ActionListener> list = new ArrayList<>();

	
	/**
	* Public constructor which uses JButton constructor. 
	* Attaches passed string as a name of the button.
	*
	* @param name 	name of the button
	*/
	public Button(String name){
		super(name);
	}
	
	/**
	* Public no argument constructor which uses JButton constructor.
	*/
	public Button(){
		super();
	}
	
/**
 * overridden addactionListener method not only adds the specific action listener functionality
 * to the object, but also adds it to a list of action listeners associated with the button, so
 * they can be removed easily, at once if necessary.
 * 
 * @param ActionListener l
 * 
 */
	@Override
	public void addActionListener(ActionListener l) {
		list.add(l);
		super.addActionListener(l);
	}
	
	/**
	 * removeAllListeners method goes through list of action listeners and removes them
	 * 
	 */
	public void removeAllListeners(){
		for(ActionListener listener:list){
			super.removeActionListener(listener);
		}
	}
	
	

}
