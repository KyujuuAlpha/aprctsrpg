import java.awt.Font;

import ui.*;
import ui.elem.*;
import util.*;

public class StageBattleTutorial extends Stage {
	
	private DataHandler data;
	
	public StageBattleTutorial(DataHandler dataVar) {
		data = dataVar;
	}
	
    //declaring variables
    private Text mainDialog;
    private Choice a;
    private Choice b;
    private Choice c;
    private int x = 0;
    private EntityCreature c1;
    
    @Override
    public void init() {
        //a creature needs to be created, as it will be the opponent in this case
        c1 = new EntityCreature(10.0, 200.0);
        a = new Choice("Continue");
        a.setFont(new Font("Arial", Font.BOLD, 12));
        a.setX((int) (getWidth() / 2 - a.getWidth() / 2));
        a.setY(this.getHeight() - 100);
        a.setDock(Text.CENTER_SOUTH);
        b = new Choice();
        b.setFont(new Font("Arial", Font.BOLD, 12));
        b.setX((int) (getWidth() / 2 - a.getWidth() / 2 - a.getWidth() / 2 - 10));
        b.setY(this.getHeight() - 100);
        b.setDock(Text.CENTER_SOUTH);
        mainDialog = new Text("", 0, 100);
    	mainDialog.setFont(new Font("Arial", Font.PLAIN, 12));
    	mainDialog.setDock(Text.TRUE_CENTER);
        this.add(mainDialog, a);
        //this conditional checks if the battle is completed
        //if it is, then the stage moves on
        if(data.battleCompleted) {
            a.setLabel("Ok");
            data.battleCompleted = false;
            endBattle();
            return;
        }
        //just gives a different dialog if the player did not join SHIELD
        if(data.SHIELD != true){ 
            mainDialog.setText("A wild SHIELD attacked!!!");
        } else { 
            tutorialSHIELDStart();
        }
    }
    
    @Override
    public void choiceClicked(Element elementVar) {
        Choice choiceObject = (Choice)elementVar;
        if(choiceObject.getLabel().equals("Continue")){ x++; tutorialStart(); return; }
        else if(choiceObject.getLabel().equals("Ok")) { nextStage(); return; }
        else if(choiceObject == c) {
        	x = 5;
        	scheduleTask(0);
        	return;
        }
    }
    
    @Override
    public void taskPerformed() {
        if(x == 1){ x++; tutorialOne(); return;}
        if(x == 2){ x++; tutorialTwo(); return;}
        if(x == 3){ x++; tutorialThree(); return;}
        if(x == 4){ x++; tutorialFour(); return;}
        if(x == 5){ x++; data.prepareBattle(data.player, c1, this); this.setStage(0); return; }
    }
    
    public void tutorialSHIELDStart(){
        mainDialog.setText("As you approach the SHIELD soldiers with your hands in the air,", "a zombie pops up behind you!", "Time to show them what you're made of!");
    }
    
    //all the methods below are part of a tutorial that teaches the user how to use the interface
    public void tutorialStart(){
        a.setLabel("Attack", false);
        a.setX((int) (getWidth() / 2 - a.getWidth() / 2));
        a.setY(this.getHeight() - 100 - a.getHeight() - 10);
        b.setLabel("Run!", false);
        b.setX((int) (getWidth() / 2 - b.getWidth() / 2));
        b.setY(this.getHeight() - 100);
        c = new Choice("Skip");
        c.setDock(Choice.CENTER_SOUTH);
        c.setX((int) (getWidth() / 2 - c.getWidth() / 2));
        c.setY(this.getHeight() - 100 - c.getHeight()*2 - 10*2);
        this.add(b, c);
        mainDialog.setText("Welcome to the Fight Screen!!!");
        //this is the timer for when to check the method taskPerformed
        this.scheduleTask(30);
    }
    
    public void tutorialOne(){
        mainDialog.setText("On the left, you can see that you have two battle", "options.");
        this.scheduleTask(65);
    }
    
    public void tutorialTwo(){
        mainDialog.setText("The first is to attack.", "The buttons below it are your abilities, ", "Hover over them to see what they do,", "You can only use one per round,");
        this.scheduleTask(135);
    }
    
    public void tutorialThree(){
        mainDialog.setText("The last button, RUN, enables you to flee your opponent.", "This works depending on your speed");
        this.scheduleTask(120);
    }
    
    public void tutorialFour(){
        mainDialog.setText("This is turn-based combat, which should come easily.", "Your stats are on top, and your opponent's is on bottom. ", "Good Luck!!! First one to 0 health loses!", "Go get 'em!");
        this.scheduleTask(100);
    }
    
    public void endBattle(){
        if(data.SHIELD){
            mainDialog.setText("Whew! 99 Problems but a Zombie ain't one...");
        }else{
            mainDialog.setText("You killed the SHIELD scoundrels!");
        }
    }
}