import ui.*;
import ui.elem.*;
import util.*;
import java.util.Random;

public class StageZombiePatrol extends Stage {
    private Dialog mainDialog;
    private Choice a;
    private EntityCreature c1;
    private Random rand = new Random();
    @Override
    public void init() {
    	int j = rand.nextInt(50) + 1;
    	int k = rand.nextInt(50) + 1;
        c1 = new EntityCreature(j, k);
        a = new Choice("Continue");
        mainDialog = new Dialog("");
        this.addElements(mainDialog, a);
        if(DataHandler.battleCompleted) {
        	this.removeElements(a);
    		DataHandler.battleCompleted = false;
    		mainDialog.setText("Whew! 99 Problems but a Zombie ain't one...");
    		scheduleTask(40);
    		return;
    	}
        mainDialog.setText("A wild zombie attacked!");
    }
    
    @Override
    public void choiceClicked(Element elementVar) {
    	if(elementVar == a){DataHandler.prepareBattle(DataHandler.player, c1, this); this.setStage(0); return;}
    }
    
    @Override
    public void taskPerformed() {
    	setStage(5);
    }
}
