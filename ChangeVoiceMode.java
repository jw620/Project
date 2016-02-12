package Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeVoiceMode implements Mode {

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		GUI gui = GUI.getInstance();
		gui.clearMatrixButtons();
		gui.removeAllListeners();
		
		//LightUpListener lightUpListener = new LightUpListener();
		
		gui.addListenerToAllMatrixButtons(new LightUpListener());
		// TODO Auto-generated method stub

	}
	
	public static class LightUpListener implements ActionListener{
		
		public int column;
		public int row;
		GUI gui = GUI.getInstance();
		@Override
		public void actionPerformed(ActionEvent e) {
			MatrixButton pressedButton = (MatrixButton)e.getSource();
			
			column = pressedButton.getColumnID();
			row = pressedButton.getRowID();
			
			if(!pressedButton.isButtonActive()){
				gui.lightUpColumnAndRow(row, column);
			}else{
				gui.clearMatrixButtons();
			}
			
			
		}
		
	}

}
