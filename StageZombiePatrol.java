import ui.*;
import ui.elem.*;
import util.*;
import java.util.Random;

public class StageZombiePatrol extends Stage {
    private Dialog mainDialog;
    private Choice a;
    private Choice b;
    private int x = 0;
    private EntityCreature c1;
    private Random rand = new Random();
    @Override
    public void init() {
    	int j = rand.nextInt(50) + 1;
    	int k = rand.nextInt(50) + 1;
        c1 = new EntityCreature(j, k);
        a = new Choice("Continue");
        b = new Choice();
        mainDialog = new Dialog("");
        this.addElements(mainDialog, a);
        if(DataHandler.battleCompleted) {
    		DataHandler.battleCompleted = false;
    		setStage(5);
    		return;
    	}
        mainDialog.setText("A wild zombie attacked!");
        this.scheduleTask(60);
    }
    
    @Override
    public void choiceClicked(Element elementVar) {
    }
    
    @Override
    public void taskPerformed() {
        if(x == 0){DataHandler.prepareBattle(DataHandler.player, c1, this); this.setStage(0); return;}
    }
    
    public void endBattle(){
        mainDialog.setText("Whew! 99 Problems but a Zombie ain't one...");
    }
}
