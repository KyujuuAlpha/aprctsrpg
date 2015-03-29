import ui.*;
import ui.elem.*;

public class StageTeam extends Stage {
    /*
     * This is the StageTeam class, where the player will get a chance to either join the SHIELD army or join the Island of Celebrities.
     * In this stage, after the player chooses whether or not to join the SHIELD army, they will fight a zombie or a SHIELD soldier, depending on their choice
     */
    private Text mainDialog; //declaring variables
    private Choice a; //a choice object is a button that shows up on the left side of the menu
    private Choice b;   
    
    @Override
    public void choiceClicked(Element elementVar) {
        Choice choiceObject = (Choice)elementVar;
        /*
         * When a button is clicked, it is assigned to the variable choiceObject. The getLabel() method checks the label assigned to the button and acts
         * according to the conditional.
         */
        if(choiceObject.getLabel().equals("The Marina")){
            eventMarina(); //a stage is a method, so to call a stage, all you need to do is invoke the method
            return;
        } else if(choiceObject.getLabel().equals("The Space Needle")){
            eventTower();
            return;
        }
        if(choiceObject.getLabel().equals("FIGHT")){
            nextStage();
        } else if(choiceObject.getLabel().equals("JOIN 'EM")){
            DataHandler.SHIELD = true; 
            nextStage();
        }
        /*
         * if one joins the SHIELD faction, then the boolean value true is assigned to a variable in the DataHandler, where all the data is stored.
         * This creates somewhat of an alternate storyline, but it only goes to a different headquarters
         */
    }
    
    @Override
    public void taskPerformed() {
    }
    
    @Override
    public void init() {
        a = new Choice("The Marina");
        b = new Choice("The Space Needle");
        mainDialog = new Text("", 0, 0);
        this.add(mainDialog, a, b);
        mainDialog.setText("Option 1: The Marina - to steal a boat and travel to the Pitt-Jolie Island", "Option 2: The Space Needle - to get a good look of the area");
    }
    
    public void eventMarina(){
        a.setLabel("FIGHT");
        b.setLabel("JOIN 'EM");
        mainDialog.setText("You're on your way to the marina when a SHIELD transport", "stops you.", "What do you do?");
    }
    
    public void eventTower(){
        a.setLabel("FIGHT");
        b.setLabel("JOIN 'EM");
        mainDialog.setText("You're on top of the Space Needle when a SHIELD ", "helicopter appears in front of you, ordering you to", "stand down", "What do you do?");
    }
}
