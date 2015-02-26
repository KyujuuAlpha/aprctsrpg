import ui.*;
import ui.elem.*;
import util.*;
import java.util.Random;

public class StageMotherZombie extends Stage {
    private Dialog mainDialog;
    private Choice a;
    private Choice b;
    private EntityCreature Boss1;
    private EntityCreature Boss2;
    private EntityCreature Boss3;
    private EntityCreature MotherZombie;
    private int x = 0;
    
    @Override
    public void init() {
        a = new Choice("Continue");
        b = new Choice();
        mainDialog = new Dialog();
        this.addElements(mainDialog, a);
        Boss1 = new EntityCreature(100.0, 500.0);
        Boss2 = new EntityCreature(75.0, 750.0);
        Boss3 = new EntityCreature(150.0, 500.0);
        MotherZombie = new Mother(200.0, 1000.0);
        if(DataHandler.battleCompleted) {
            DataHandler.battleCompleted = false;
            if(x == 1) {
            	mainDialog.setText("You approach the second boss..");
            } else if(x == 2) {
            	mainDialog.setText("You approach the third boss..");
            } else if(x == 3) {
            	mainDialog.setText("The mother zombie approaches!");
            } else if(x == 4) {
            	mainDialog.setText("What's happening here?");
            }
            return;
        }
        mainDialog.setText("You approach the first boss...");
    }
    
    @Override
    public void choiceClicked(Element elementVar) {
        if(x == 0){
            DataHandler.prepareBattle(DataHandler.player, Boss1, this);
            this.setStage(0);
            x++;
            return;
        }
        if(x == 1){
            DataHandler.prepareBattle(DataHandler.player, Boss2, this);
            this.setStage(0);
            x++;
            return;
        }
        if(x == 2){
            DataHandler.prepareBattle(DataHandler.player, Boss3, this);
            this.setStage(0);
            x++;
            return;
        }
        if(x == 3){
            DataHandler.prepareBattle(DataHandler.player, MotherZombie, this);
            this.setStage(0);
            x++;
            return;
        }
        if(x == 4){
            nextStage();
        }
    }

	@Override
	public void taskPerformed() {
	}
}
