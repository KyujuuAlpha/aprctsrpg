import ui.*;
import ui.elem.*;
import util.*;
public class StageThree extends Stage {
    private Dialog mainDialog;
    private Choice a;
    private Choice b;   
    private Choice c;
    private Choice d;
    private int x = 0;
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
        if(x == 5){ x++; tutorialFive(); return;}
        if(x == 6){ x++; fight(); return;}
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
        b.setLabel("Weapon Attack 1", false);
        c = new Choice(null);
        c.setLabel("Weapon Attack 2", false);
        d = new Choice(null);
        d.setLabel("Run!!!", false);
        this.addElements(b, c, d);
        mainDialog.setText("Welcome to the Fight Screen!!!");
        this.scheduleTask(60);
    }
    public void tutorialOne(){
        mainDialog.setText("On the right, you can see that you have four battle", "options.");
        this.scheduleTask(60);
    }
    public void tutorialTwo(){
        mainDialog.setText("The first attack is PUNCH, which does minimal damage", "but hits every time.");
        this.scheduleTask(60);
    }
    public void tutorialThree(){
        mainDialog.setText("The second and third options have to do with what", "type of weapon you have.", "If you have a melee weapon, the options will be slash", "and stab.");
        this.scheduleTask(120);
    }
    public void tutorialFour(){
        mainDialog.setText("If you have a ranged weapon, then the attacks will", "be shoot and club.", "The last button, RUN, enables you to flee your opponent.", "This only works 0.0005% of the time.");
        this.scheduleTask(120);
    }
    public void tutorialFive(){
        mainDialog.setText("This is turn-based combat, which should come easily.", "Good Luck!!!, First one to 0 health loses!", "Go get 'em!");
        this.scheduleTask(100);
    }
    public void fight(){
        a.setLabel("PUNCH", true);
        b.setLabel("Weapon Attack 1", true);
        c.setLabel("Weapon Attack 2", true);
        d.setLabel("Run!!!", true);
        mainDialog.setText("Player Health = ", "Enemy Health = ", "What will you do next?");
    }
}
