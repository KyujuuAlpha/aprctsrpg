import ui.*;
import ui.elem.*;
import util.*;
public class StageOne extends Stage {
    private Dialog mainDialog;
    private Choice a;
    private Choice b;   
    private Choice c;
    @Override
    public void choiceClicked(Element elementVar) {
        Choice choiceObject = (Choice)elementVar;
        if(choiceObject.getLabel().equals("Wand")){
            DataHandler.player.addItem(Item.basicSword);
            stageOne();
            return;
        }else if(choiceObject.getLabel().equals("Holy SFHS iPad")){
            DataHandler.player.addItem(Item.basicWand);
            stageOne();
            return;
        }else if(choiceObject.getLabel().equals("Pistol")){
            DataHandler.player.addItem(Item.Pistol);
            stageOne();
            return;
        }
        if(choiceObject.getLabel().equals("Next")){
            nextStage();
        }
    }
    @Override
    public void taskPerformed() {
    }
    @Override
    public void init() {
        a = new Choice("Wand");
        b = new Choice("Holy SFHS iPad");
        c = new Choice("Pistol");
        mainDialog = new Dialog("");
        this.addElements(mainDialog, a, b, c);
        mainDialog.setText("You wake up and get ready to leave your apartment.", "What weapon will you take?", "Option 1: Wand", "Option 2: Holy SFHS iPad", "Option 3: Pistol");
    }
    public void stageOne(){
        this.removeElements(b, c);
        a.setLabel("Next");
        mainDialog.setText("You leave your apartment, after locking all your doors and windows.", "The other tenants of your building have long since left.", "One 50 year old man claimed to be smuggling out a 14 year old girl whose blood has the cure to Ebola Z.", "You don't care about any of this.", "With food, fresh water, and ammo running low, you have to get out.", "Where will you go?" );
    }
}
