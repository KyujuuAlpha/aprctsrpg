import ui.*;
import ui.elem.*;

public class StageMenu extends Stage {
    private Dialog mainDialog;
    private Sprite troi;

    @Override
    public void choiceDone(String a) {
        addElement(troi);
    }
    
    @Override
    public void taskPerformed() {
        addElement(new Choice("Option1"));
        mainDialog.setText("Choose an option");
    }

    @Override
    public void init() { //basically initializing most main variables and loading sprites
        mainDialog = new Dialog("");
        troi = new Sprite("troi");
        start();
    }
    
    public void start() {
        addElement(mainDialog);
        mainDialog.setText("Welcome to this place!");
        scheduleTask(100);
    }
}
