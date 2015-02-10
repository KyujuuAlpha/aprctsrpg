import ui.*;
import ui.elem.*;
import util.*;
public class StageThree extends Stage {
    private Dialog mainDialog;
    private Choice a;
    private Choice b;   
    private Choice c;
    private Choice d;
    private Choice e;
    @Override
    public void choiceClicked(Element elementVar) {
        Choice choiceObject = (Choice)elementVar;
        if(choiceObject.getLabel().equals("Continue")){ tutorialStart(); return;} 
        if(choiceObject.getLabel().equals("A")){ tutorialOne(); return;}
        if(choiceObject.getLabel().equals("B")){ tutorialTwo(); return;}
        if(choiceObject.getLabel().equals("C")){ tutorialThree(); return;}
        if(choiceObject.getLabel().equals("D")){ tutorialFour(); return;}
        if(choiceObject.getLabel().equals("E")){ tutorialFive(); return;}
        if(choiceObject.getLabel().equals("FIGHT!!!")){ fight(); return;}
    }
    @Override
    public void taskPerformed() {
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
        e = new Choice("A");
        this.addElements(b, c, d, e);
        mainDialog.setText("Welcome to the Fight Screen!!!", "Press A to continue!!!");
    }
    public void tutorialOne(){
        e.setLabel("B");
        mainDialog.setText("On the right, you can see that you have four battle", "options.", "Press B to continue.");
    }
    public void tutorialTwo(){
        e.setLabel("C");
        mainDialog.setText("The first attack is PUNCH, which does minimal damage", "but hits every time.", "Press C to continue");
    }
    public void tutorialThree(){
        e.setLabel("D");
        mainDialog.setText("The second and third options have to do with what", "type of weapon you have.", "If you have a melee weapon, the options will be slash", "and stab.", "Press D to continue");
    }
    public void tutorialFour(){
        e.setLabel("E");
        mainDialog.setText("If you have a ranged weapon, then the attacks will", "be shoot and club.", "The last button, RUN, enables you to flee your opponent.", "This only works 0.0005% of the time.", "Press E to continue.");
    }
    public void tutorialFive(){
        e.setLabel("FIGHT!!!");
        mainDialog.setText("This is turn-based combat, which should come easily.", "Good Luck!!!, First one to 0 health loses!", "Go get 'em!" ,"Press the FIGHT!!! button to face the SHIELD people.");
    }
    public void fight(){
        a.setLabel("PUNCH", true);
        b.setLabel("Weapon Attack 1", true);
        c.setLabel("Weapon Attack 2", true);
        d.setLabel("Run!!!", true);
        this.removeElements(e);
        mainDialog.setText("Player Health = ", "Enemy Health = ", "What will you do next?");
    }
}
