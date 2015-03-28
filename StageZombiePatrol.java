import ui.*;
import ui.elem.*;
import util.*;
import java.util.Random;

public class StageZombiePatrol extends Stage {
    /*
     * this is basically a radiant quest, where it's the same quest objective over and over again,
     * but with varying difficulty. This is where the Random class comes into play. 
     */
    //declaring variables
    private Dialog mainDialog;
    private Choice a;
    private Zombie c1;
    private Random rand = new Random(); //creating Random instance field
    @Override
    public void init() {
    	int j = rand.nextInt(50) + 1; //sets j to a random integer between 1 and 50 inclusive, and does the same to k
    	int k = rand.nextInt(50) + 1;
        c1 = new Zombie(j, k); //creates a new Zombie with the damage and health of j and k
        a = new Choice("Continue");
        mainDialog = new Dialog("");
        this.add(mainDialog, a);
        if(DataHandler.battleCompleted) {//checks whether or not the battle is completed
        	this.remove(a); //removes the button
    		DataHandler.battleCompleted = false; //resets the boolean
    		mainDialog.setText("Whew! 99 Problems but a Zombie ain't one..."); //gives encouragement
    		scheduleTask(40); //starts a timer to move on
    		return;
    	}
        mainDialog.setText("A wild zombie attacked!");
    }
    
    @Override
    public void choiceClicked(Element elementVar) {
    	if(elementVar == a){DataHandler.prepareBattle(DataHandler.player, c1, this); this.setStage(0); return;}
    }
    
    @Override
    public void taskPerformed() {
    	setStage(5); //the setStage method can set the next stage to the specified stage ID, which is the stage's location within the arrayList
    }
}
