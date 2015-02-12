import ui.*;
import ui.elem.*;
import util.*;
public class StagePrologue extends Stage {
    private Dialog mainDialog;
    private Choice a;
    private Choice b;    
    private Choice c;
    private Sprite ae;
    @Override
    public void choiceClicked(Element elementVar) {
        ae.setResizable(false);
        Choice choiceObject = (Choice)elementVar;
        String charChoice;
        if(choiceObject.getLabel().equals("START")){
            stagePre();
            a.setLabel("Next", true);
            b.setLabel("Cancel", false);
            return;
        }
        if(choiceObject.getLabel().equals("Next")){ 
            stageChooseClass();
            return;
        }
        if(choiceObject.getLabel().equals("Continue")){
            nextStage();
        }
        if(choiceObject.getLabel().equals("Tank")){
        	nextStage();
        }else if(choiceObject.getLabel().equals("Normal")){
            nextStage();
        }else{
            nextStage();
        }
    }
    
    @Override
    public void taskPerformed() {
    }

    @Override
    public void init() {
        a = new Choice("START");
        b = new Choice("QUIT");
        c = new Choice(null);
        mainDialog = new Dialog("");
        ae = new Sprite("unknow.png");
        this.addElements(mainDialog, a, b, ae);
        mainDialog.setText("Hello! Welcome to the Game!", "Press START to Continue");
    }
    
    public void stagePre(){
        mainDialog.setText("It's the year 151515, after the Last World War, with", "President Obama L finally dead,", "anarchy reigns as Ebola Z runs throughout the world. As Brad", "Pitt and Angelina Jolie rebuild ", "their giant mansion on the newly formed Hawaiian island of N'vu L'nodo,", "Robert Downey Jr.finally accepts his responsibility as Iron Man", "and forms SHIELD along with Samuel Jackson. ", "You are stuck in Seattle, the pot capital of the world, as you try", " to save the human race from ", "the deadly disease. Brad Pitt and Angelina Jolie are rumored to have protection and their own ", "private army, but SHIELD offers the Avengers and the Guardians of the Galaxy. With SHIELD there", "is a hope of being transported to another dimension. How will you proceed?", "Press A to Continue");
    }
    
    public void stageChooseClass(){
        a.setLabel("Tank", true);
        b.setLabel("Normal", true);
        c.setLabel("Assassin", true);
        this.addElements(c);
        mainDialog.setText("What CLASS will you choose?", "Tank - High Health", "Normal - Average", "Assassin - High Speed/Attack");
    }
}
