package Project;

public class SaveConfigurationMode implements Mode {

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		GUI gui = GUI.getInstance();
		gui.clearMatrixButtons();
		gui.removeAllListeners();
		
		
		gui.addOnOffListener(new ChangeModeListener(new OnOffMode()));
		gui.addOkListener(new ChangeModeListener(new PerformanceMode()));
		
		gui.setLCDText("Save Configuration Mode");

	}

}
