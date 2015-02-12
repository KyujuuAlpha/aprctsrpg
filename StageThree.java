import ui.*;
import ui.elem.*;
import util.*;
public class StageThree extends StageMain {
    private Dialog mainDialog;
    private Choice a;
    private Choice b;
    private int x = 0;
    private boolean fight = true;
    @Override
    public void choiceClicked(Element elementVar) {
        Choice choiceObject = (Choice)elementVar;
        if(choiceObject.getLabel().equals("Continue")){ x++; tutorialStart(); return;} 
    }
    @Override
    public void taskPerformed() {
        if(x == 1){ x++; tutorialOne(); return;}
        if(x == 2){ x++; tutorialTwo(); return;}
        if(x == 3){ x++; tutorialThree(); return;}
        if(x == 4){ x++; tutorialFour(); return;}
        if(x == 5){ x++; fight(); return;}
    }
    @Override
    public void init() {
        a = new Choice("Continue");
        mainDialog = new Dialog("");
        this.addElements(mainDialog, a);
        mainDialog.setText("A wild SHIELD attacked!!!");
    }
    public void tutorialStart(){
        a.setLabel("Punch", false);
        b = new Choice(null);
        b.setLabel("Run!!!", false);
        this.addElements(b);
        mainDialog.setText("Welcome to the Fight Screen!!!");
        this.scheduleTask(60);
    }
    public void tutorialOne(){
        mainDialog.setText("On the right, you can see that you have two battle", "options.");
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
        mainDialog.setText("This is turn-based combat, which should come easily.", "Good Luck!!!, First one to 0 health loses!", "Go get 'em!");
        this.scheduleTask(100);
    }
    public void fight(){
        EntityCreature c1 = new EntityCreature(10.0, 50.0);
        a.setLabel("ATTACK", true);
        b.setLabel("RUN", true);
        fight = true;
        while(fight){
            mainDialog.setText("Player Health = " + player.getHealth(), "Enemy Health = " + c1.getHealth(), "What will you do next?");
            if(c1.getHealth() == 0){
                fight = false;
            }
        }
        mainDialog.setText("Congrats!!!", "You killed the SHIELD scoundrels!!!");
    }
}
