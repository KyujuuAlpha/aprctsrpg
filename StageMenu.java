import ui.*;
import ui.elem.*;

public class StageMenu extends Stage {
    private Dialog mainDialog;
    private Choice a;
    private Choice b;
    @Override
    public void choiceDone(String a) {
        if(a.equals("START")){
            
            stageOne();
        }else if(a.equals("QUIT")){
        }
    }
    
    @Override
    public void taskPerformed() {
        
    }

    @Override
    public void init() { //basically initializing most main variables and loading sprites
        a = new Choice("START");
        b = new Choice("QUIT");
        mainDialog = new Dialog("");
        mainDialog.setText("Hello! Welcome to the Game!", "Press START to Continue");
        this.addElement(mainDialog, a, b);
    }
    
    public void stageOne(){
        mainDialog.setText("It's the year 151515...", "Press A to Continue");
        this.addElement(mainDialog, new Choice("A"));
    }
}
