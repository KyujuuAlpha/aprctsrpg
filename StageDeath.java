import ui.*;
import ui.elem.*;

public class StageDeath extends Stage {
	
	private DataHandler data;
	
	public StageDeath(DataHandler dataVar) {
		data = dataVar;
	}

	private Text mainDialog;
	
	@Override
	public void init() {
		mainDialog = new Text("", 0, 0);
		Sprite rip = new Sprite("rip.png", 0, 0);
		this.add(mainDialog, rip);
		mainDialog.setText("HAH YOU DIED");
	}

	@Override
	public void choiceClicked(Element elementVar) {
		
		
	}

	@Override
	public void taskPerformed() {
		
	}

}
