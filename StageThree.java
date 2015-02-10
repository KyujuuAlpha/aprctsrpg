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
        if(choiceObject.getLabel().equals("Continue")){
            fight();
        }
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
    public void fight(){
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
}
