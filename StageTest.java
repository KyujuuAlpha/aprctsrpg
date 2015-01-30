import ui.*;
import ui.elem.*;

public class StageTest extends Stage {
    private Dialog mainDialog;
    
    @Override
    public void choiceDone(String a) {
    }
    
    @Override
    public void taskPerformed() {
        mainDialog.setText("Sorry");
    }

    @Override
    public void init() { //basically initializing most main variables and loading sprites
        mainDialog = new Dialog("");
        start();
    }
    
    public void start() {
        addElement(mainDialog);
        mainDialog.setText("Welcome to this place!");
        scheduleTask(200);
    }
}
