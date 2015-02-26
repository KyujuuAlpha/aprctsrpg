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
        mainDialog = new Dialog("");
        this.addElements(mainDialog, a);
        if(DataHandler.battleCompleted) {
            DataHandler.battleCompleted = false;
            return;
        }
        mainDialog.setText("You approach the Mother Zombie...");
    }
    
    @Override
    public void choiceClicked(Element elementVar) {
        Choice choiceObject = (Choice)elementVar;
        if(choiceObject.getLabel().equals("Continue") && x == 0){
            battleOne();
            x++;
            return;
        }
        if(choiceObject.getLabel().equals("First Obstacle...Let's Go!") && x == 1){
            DataHandler.prepareBattle(DataHandler.player, Boss1, this);
            this.setStage(0);
            x++;
            return;
        }
        if(choiceObject.getLabel().equals("Round Two...Fight!!!") && x == 2){
            DataHandler.prepareBattle(DataHandler.player, Boss2, this);
            this.setStage(0);
            x++;
            return;
        }
        if(choiceObject.getLabel().equals("Round Three...Bring it on!!!") && x == 3){
            DataHandler.prepareBattle(DataHandler.player, Boss3, this);
            this.setStage(0);
            x++;
            return;
        }
        if(choiceObject.getLabel().equals("What?") && x == 4){
            nextStage();
        }
    }
    
    @Override
    public void taskPerformed() {
        if(x == 1){ x++; battleOne(); return;}
        if(x == 2){ x++; battleTwo(); return;}
    }
    
    public void battleOne(){
        Boss1 = new EntityCreature(100.0, 500.0);
        a.setLabel("First Obstacle...Let's Go!");
        mainDialog.setText("A zombie approaches...");
    }
    
    public void battleTwo(){
        Boss2 = new EntityCreature(75.0, 750.0);
        a.setLabel("Round Two...Fight!!!");
    }
    
    public void battleThree(){
        Boss3 = new EntityCreature(150.0, 500.0);
        a.setLabel("Round Three...Bring it on!!!");
    }
    
    public void battle(){
        MotherZombie = new EntityCreature(200.0, 1000.0);
        a.setLabel("The mother zombie approaches...");
    }
    
    public void endBattle(){
        mainDialog.setText("You weren't supposed to beat her...");
        a.setLabel("What?");
    }
}
