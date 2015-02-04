import ui.*;
import ui.elem.*;

public class StageMenu extends Stage {
    private Dialog mainDialog;
    private Choice a;
    private Choice b;
    
    private Input c = new Input("test", 10);
    
    @Override
    public void choiceClicked(Element elementVar) {
        Choice choiceName = (Choice)elementVar;
        c.setName("TESTETS");
        c.setText("TESTTSET");
        if(choiceName.getLabel().equals("START")){
            a.setLabel("A", true);
            b.setLabel("B", false);
            stageOnePointOne();
        }else if(choiceName.getLabel().equals("QUIT")){
            this.nextStage();
        }
    }
    
    @Override
    public void taskPerformed() {
    }

    @Override
    public void init() {
        a = new Choice("START");
        b = new Choice("QUIT");
        mainDialog = new Dialog("");
        this.addElement(mainDialog, a, b, new Sprite("troi.png"), c);
        mainDialog.setText("Hello! Welcome to the Game!", "Press START to Continue");
    }
    
    public void stageOnePointOne(){
        mainDialog.setText("It's the year 151515, after the Last World War, with", "President Obama L finally dead,", "anarchy reigns as Ebola Z runs throughout the world. As Brad", "Pitt and Angelina Jolie rebuild ", "their giant mansion on the newly formed Hawaiian island of N'vu L'nodo,", "Robert Downey Jr.finally accepts his responsibility as Iron Man", "and forms SHIELD along with Samuel Jackson. ", "You are stuck in Seattle, the pot capital of the world, as you try", " to save the human race from ", "the deadly disease. Brad Pitt and Angelina Jolie are rumored to have protection and their own ", "private army, but SHIELD offers the Avengers and the Guardians of the Galaxy. With SHIELD there", "is a hope of being transported to another dimension. How will you proceed?", "Press A to Continue");
    }
}
