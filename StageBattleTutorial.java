import ui.*;
import ui.elem.*;
import util.*;

public class StageBattleTutorial extends Stage {
    private Dialog mainDialog;
    private Choice a;
    private Choice b;
    private int x = 0;
    private EntityCreature c1;
    
    @Override
    public void init() {
        c1 = new EntityCreature(10.0, 200.0);
        a = new Choice("Continue");
        b = new Choice();
        mainDialog = new Dialog("");
        this.addElements(mainDialog, a);
        if(DataHandler.battleCompleted) {
            a.setLabel("Ok");
            DataHandler.battleCompleted = false;
            endBattle();
            return;
        }
        if(DataHandler.SHIELD != true){ 
            mainDialog.setText("A wild SHIELD attacked!!!");
        } else { 
            tutorialSHIELDStart();
        }
    }
    
    @Override
    public void choiceClicked(Element elementVar) {
        Choice choiceObject = (Choice)elementVar;
        if(choiceObject.getLabel().equals("Continue")){ x++; tutorialStart(); return; }
        if(choiceObject.getLabel().equals("Ok")) nextStage();
    }
    
    @Override
    public void taskPerformed() {
        if(x == 1){ x++; tutorialOne(); return;}
        if(x == 2){ x++; tutorialTwo(); return;}
        if(x == 3){ x++; tutorialThree(); return;}
        if(x == 4){ x++; tutorialFour(); return;}
        if(x == 5){ x++; DataHandler.prepareBattle(DataHandler.player, c1, this); this.setStage(0); return; }
    }
    
    public void tutorialSHIELDStart(){
        mainDialog.setText("As you approach the SHIELD soldiers with your hands in the air,", "a zombie pops up behind you!", "Time to show them what you're made of!");
    }
    
    public void tutorialStart(){
        a.setLabel("Attack", false);
        b.setLabel("Run!", false);
        this.addElements(b);
        mainDialog.setText("Welcome to the Fight Screen!!!");
        this.scheduleTask(60);
    }
    
    public void tutorialOne(){
        mainDialog.setText("On the left, you can see that you have two battle", "options.");
        this.scheduleTask(60);
    }
    
    public void tutorialTwo(){
        mainDialog.setText("The first is to attack.");
        this.scheduleTask(60);
    }
    
    public void tutorialThree(){
        mainDialog.setText("The last button, RUN, enables you to flee your opponent.", "This only works 0.0005% of the time.");
        this.scheduleTask(120);
    }
    
    public void tutorialFour(){
        mainDialog.setText("This is turn-based combat, which should come easily.", "Your stats are on top, and your opponent's is on bottom. ", "Good Luck!!! First one to 0 health loses!", "Go get 'em!");
        this.scheduleTask(100);
    }
    
    public void endBattle(){
        if(DataHandler.SHIELD){mainDialog.setText("Whew! 99 Problems but a Zombie ain't one...");}
        else{
            mainDialog.setText("You killed the SHIELD scoundrels!");
       }
    }
}
