import ui.*;
import ui.elem.Dialog;
import ui.elem.Element;


public class StageDeath extends Stage {

	private Dialog mainDialog;
	
	@Override
	public void init() {
		mainDialog = new Dialog();
		this.addElements(mainDialog);
		mainDialog.setText("HAH YOU DIED");
	}

	@Override
	public void choiceClicked(Element elementVar) {
		
		
	}

	@Override
	public void taskPerformed() {
		
	}

}
