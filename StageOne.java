import ui.*;
import ui.elem.*;

public class StageOne extends Stage {
    private Dialog mainDialog;
    private Choice a;
    private Choice b;   
    @Override
    public void choiceClicked(Element elementVar) {
        Choice choiceObject = (Choice)elementVar;
        boolean cont = false;
        if(choiceObject.getLabel().equals("START")){
        }else if(choiceObject.getLabel().equals("QUIT")){
        }
    }
    
    @Override
    public void taskPerformed() {
    }

    @Override
    public void init() {
        a = new Choice("START");
        b = new Choice("QUIT");
        mainDialog = new Dialog("");
        this.addElement(mainDialog, a, b, new Sprite("troi.png"));
        mainDialog.setText("You wake up and get ready to leave your apartment.", "What weapon will you take?", "Option 1: Bow and Arrow", "Option 2: iPad Special Weapon", "Pistol");
    }
    
    public void stagePre(){
        mainDialog.setText("You leave your apartment, after locking all your doors and windows.", "The other tenants of your building have long since left.", "One 50 year old man claimed to be smuggling out a 14 year old girl whose blood has the cure to Ebola Z.", "You don't care about any of this.", "With food, fresh water, and ammo running low, you have to get out.", "Where will you go?" );
    }
    
    public void stageOne(){
        mainDialog.setText("What CLASS will you choose?", "Tank - High Health", "Normal - Average", "Assassin - High Speed/Attack");
        
    }
}
