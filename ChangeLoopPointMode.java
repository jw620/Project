package Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Project.MatrixButton.MatrixButtonListener;

public class ChangeLoopPointMode implements Mode {

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		GUI gui = GUI.getInstance();
		gui.clearMatrixButtons();
		gui.removeAllListeners();
		
		ActionListener light = new LightUpListener();
		gui.addListenerToAllMatrixButtons(light);

	}

	public static class LightUpListener implements ActionListener{
		
		GUI gui = GUI.getInstance();
		
		
		@Override
		public void actionPerformed(ActionEvent e) {

			MatrixButton pressedButton = (MatrixButton) e.getSource();
			int column = pressedButton.getColumnID();
			System.out.println(column);
			int row = pressedButton.getRowID();
			System.out.println(row);

			if (!pressedButton.isButtonActive()) {
				gui.lightUpColumnAndRow(row, column);
				System.out.println("done");


			} else {
				gui.clearMatrixButtons();
				
			}

		}

		
	
	}
}
