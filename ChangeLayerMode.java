package Project;

public class ChangeLayerMode implements Mode {

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		GUI gui = GUI.getInstance();
		gui.clearMatrixButtons();
		gui.removeAllListeners();
		
		gui.setLCDText("Change Layer Mode");

	}

}
