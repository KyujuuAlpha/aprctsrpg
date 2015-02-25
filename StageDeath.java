import ui.Stage;
import ui.elem.*;

public class StageDeath extends Stage {
	private Dialog mainDialog;
	
	@Override
	public void init() {
		mainDialog = new Dialog();
		this.addElements(mainDialog);
		mainDialog.setText("HAHAHAHAHA YOU LOSE YOU DIED SUCCKAH!");
	}

	@Override
	public void choiceClicked(Element elementVar) {
		
	}

	@Override
	public void taskPerformed() {
		
	}	
}
