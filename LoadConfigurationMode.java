package Project;

public class LoadConfigurationMode implements Mode {

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		GUI gui = GUI.getInstance();
		gui.clearMatrixButtons();
		gui.removeAllListeners();

	}

}
