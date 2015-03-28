import ui.*;
import ui.elem.*;

public class StageDeath extends Stage {

	private Dialog mainDialog;
	
	@Override
	public void init() {
		mainDialog = new Dialog();
		Sprite rip = new Sprite("rip.png");
		rip.setResizable(0.5f);
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
