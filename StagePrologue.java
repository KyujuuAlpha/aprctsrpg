import ui.*;
import ui.elem.*;

public class StagePrologue extends Stage {
    private Dialog mainDialog;
    private Choice a;
    private Choice b;    
    @Override
    public void choiceClicked(Element elementVar) {
        Choice choiceObject = (Choice)elementVar;
        boolean cont = false;
        String charChoice;
        if(choiceObject.getLabel().equals("START")){
            stagePre();
            a.setLabel("Next", true);
            b.setLabel("Cancel", false);
            return;
        }
        if(choiceObject.getLabel().equals("Next")) stageChooseClass();
        if(choiceObject.getLabel().equals("Next")){
            Choice c = new Choice("Assassin");
            this.addElements(c);
            a.setLabel("Tank", true);
            b.setLabel("Normal", true);
            return;
        }
        if(choiceObject.getLabel().equals("Tank")){
            this.nextStage();
        }else if(choiceObject.getLabel().equals("Normal")){
            
        }else{
                
        }
        if(cont == true) nextStage();
    }
    
    @Override
    public void taskPerformed() {
    }

    @Override
    public void init() {
        a = new Choice("START");
        b = new Choice("QUIT");
        mainDialog = new Dialog("");
        this.addElements(mainDialog, a, b);
        mainDialog.setText("Hello! Welcome to the Game!", "Press START to Continue");
    }
    
    public void stagePre(){
        mainDialog.setText("It's the year 151515, after the Last World War, with", "President Obama L finally dead,", "anarchy reigns as Ebola Z runs throughout the world. As Brad", "Pitt and Angelina Jolie rebuild ", "their giant mansion on the newly formed Hawaiian island of N'vu L'nodo,", "Robert Downey Jr.finally accepts his responsibility as Iron Man", "and forms SHIELD along with Samuel Jackson. ", "You are stuck in Seattle, the pot capital of the world, as you try", " to save the human race from ", "the deadly disease. Brad Pitt and Angelina Jolie are rumored to have protection and their own ", "private army, but SHIELD offers the Avengers and the Guardians of the Galaxy. With SHIELD there", "is a hope of being transported to another dimension. How will you proceed?", "Press A to Continue");
    }
    
    public void stageChooseClass(){
        mainDialog.setText("What CLASS will you choose?", "Tank - High Health", "Normal - Average", "Assassin - High Speed/Attack");
        
    }
}
