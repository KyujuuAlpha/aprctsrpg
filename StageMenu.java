import ui.*;
import ui.elem.*;

public class StageMenu extends Stage {
    private Dialog mainDialog;

    @Override
    public void choiceDone(String a) {
        nextStage();
    }
    
    @Override
    public void taskPerformed() {
        addElement(new Choice("Option1"));
        mainDialog.setText("Choose an option");
    }

    @Override
    public void init() { //basically initializing most main variables and loading sprites
        mainDialog = new Dialog("");
        start();
    }
    
    public void start() {
        addElement(mainDialog);
        mainDialog.setText("Welcome to this place!");
        scheduleTask(100);
    }
}
