import java.util.Random;
import ui.*;
import ui.elem.*;
import util.Assassin;
import util.BattleHandler;
import util.EntityCreature;
import util.Item;
import util.Tank;
import util.Zombie;
/*
 * This is the class where all the battles are handled
 */
public class StageBattle extends Stage {
    //initializing choices
    private Choice fightButton;
    private Choice ability0;
    private Choice ability1;
    private Choice ability2;
    private Choice ability3;
    private Choice runButton;
    //initializing the stats
    //the stats are located at the top and the bottom of the screen on the upper and lower right
    private Stat playerStat;
    private OpponentStat opponentStat;
    
    
    private Dialog mainDialog;
    
    private int scheduleCode = 0;
    
    private int selectedAbility = -1;
    
    private Item itemVar2;

    @Override
    public void init() {
        if(DataHandler.player == null) { this.setStage(1); return; } //if there is no player, then just start stage prologue for character creation
        itemVar2 = null; //sets the Item to null
        fightButton = new Choice("Attack"); //creates the important attack button
        ability0 = new Choice(DataHandler.player.getAbilitiesName(0)); //gets the abilities' name using a method that does just that and adds it as a new choice
        ability1 = new Choice(DataHandler.player.getAbilitiesName(1));
        ability2 = new Choice(DataHandler.player.getAbilitiesName(2));
        ability3 = new Choice(DataHandler.player.getAbilitiesName(3));
        runButton = new Choice("Run!"); //the all powerful run method that never works
        playerStat = new Stat(); //creates the stat. The player's are on the top right and the opponent's are on the bottom right
        opponentStat = new OpponentStat();
        mainDialog = new Dialog();
        this.addElements(fightButton, ability0, ability1, ability2, ability3, runButton, playerStat, opponentStat, mainDialog);
        
        //the following methods check what picture should be put on the rightmost pane
        if(DataHandler.player instanceof Tank) this.addElements(new Sprite("tank.png", 0.5f));
        else if(DataHandler.player instanceof Assassin) this.addElements(new Sprite("assassin.png", 0.5f));
        else this.addElements(new Sprite("norm.png", 0.5f));
                
        if(DataHandler.opponent instanceof Zombie) {
            if(new Random().nextInt(2) == 0) this.addElements(new Sprite("minion.png", 0.5f)); //a random conditional to determine which one will be added
            else this.addElement        s(new Sprite("minion2.png", 0.5f));
        } else if(DataHandler.source instanceof StageMotherZombie) {
            switch(new Random().nextInt(3)) { 
                //adding the appropriate sprite to the screen
                case 0: this.addElements(new Sprite("boss1.png", 0.5f)); break;
                case 1: this.addElements(new Sprite("boss2.png", 0.5f)); break;
                case 2: this.addElements(new Sprite("boss3.png", 0.5f)); break;
                default: this.addElements(new Sprite("guy.png", 0.5f)); break;
            }
        } else if(DataHandler.opponent instanceof EntityCreature) this.addElements(new Sprite("guy.png", 0.5f));
        fightButton.setEnabled(false);
        runButton.setEnabled(false);
        playerTurn();
    }

    @Override
    public void choiceClicked(Element elementVar) {
        if(itemVar2 == null) {
            fightButton.setEnabled(false);
            runButton.setEnabled(false);
            ability0.setEnabled(false);
            ability1.setEnabled(false);
            ability2.setEnabled(false);
            ability3.setEnabled(false);
            Choice choiceObject = (Choice)elementVar;
            if(choiceObject == fightButton) {
                boolean flag = BattleHandler.playerTurn(DataHandler.player, selectedAbility, DataHandler.opponent);
                updateStats();//a method to update the stats
                if(flag) mainDialog.appendText("\nYou dealt damage!");
                else mainDialog.appendText("\nYour attack missed!");
                scheduleCode = 2;
                this.scheduleTask(30);
            } else if(choiceObject == runButton){
                if(BattleHandler.run(DataHandler.player, DataHandler.opponent) && !(DataHandler.source instanceof StageMotherZombie)) {
                    scheduleCode = 1;
                    mainDialog.appendText("\nYou got away safely..");
                    this.scheduleTask(30);
                } else {
                    scheduleCode = 2;
                    mainDialog.appendText("\nCan't escape!");
                    this.scheduleTask(30);
                }
            } else if(choiceObject == ability0) {
                fightButton.setEnabled(true);
                runButton.setEnabled(true);
                selectedAbility = 0;
            } else if(choiceObject == ability1) {
                fightButton.setEnabled(true);
                runButton.setEnabled(true);
                selectedAbility = 1;
            } else if(choiceObject == ability2) {
                fightButton.setEnabled(true);
                runButton.setEnabled(true);
                selectedAbility = 2;
            } else if(choiceObject == ability3) {
                fightButton.setEnabled(true);
                runButton.setEnabled(true);
                selectedAbility = 3;
            }
        } else {
            if(elementVar == fightButton) {
                DataHandler.player.addItem(itemVar2);
                endBattle();
            }
            endBattle();
        }
    }

    @Override
    public void taskPerformed() {
        if(scheduleCode == 1) {
            exitBattle();
        } else if(scheduleCode == 2) {
            opponentTurn();
        } else if(scheduleCode == 3) {
            playerTurn();
        }
    }
    
    private void playerTurn() {
        if(DataHandler.opponent.getHealth() <= 0 || DataHandler.player.getHealth() <= 0){
            exitBattle();
            return;
        }
        updateStats();
        fightButton.setEnabled(true);
        runButton.setEnabled(true);
        ability0.setEnabled(true);
        ability0.setToolTip(DataHandler.player.getAbilitiesDesc(0));
        ability1.setEnabled(true);
        ability1.setToolTip(DataHandler.player.getAbilitiesDesc(1));
        ability2.setEnabled(true);
        ability2.setToolTip(DataHandler.player.getAbilitiesDesc(2));
        ability3.setEnabled(true);
        ability3.setToolTip(DataHandler.player.getAbilitiesDesc(3));
        selectedAbility = -1;
        mainDialog.setText("What will you do next?");
    }
    
    private void opponentTurn() {
        if(DataHandler.opponent.getHealth() <= 0 || DataHandler.player.getHealth() <= 0){
            exitBattle();
            return;
        }
        updateStats();
        boolean flag = BattleHandler.creatureTurn(DataHandler.player, DataHandler.opponent);
        updateStats();
        if(flag) mainDialog.setText("Your opponent dealt damage!");
        else mainDialog.setText("Your opponent's attack missed!");
        scheduleCode = 3;
        this.scheduleTask(20);
    }
    
    private void updateStats(){
        playerStat.setText("PLAYER STATS - Level: " + ((int)(DataHandler.player.getLevel()*10))/10.0D + "\nHealth: " + ((int)(DataHandler.player.getHealth()*10))/10.0D);
        opponentStat.setText("OPPONENT STATS - Health: " + ((int)(DataHandler.opponent.getHealth()*10))/10.0D);
    }
    
    private void exitBattle() {
        DataHandler.battleCompleted = true;
        if(DataHandler.opponent.getHealth() <= 0){
            DataHandler.player.leveling(DataHandler.opponent);
            giveItem(DataHandler.opponent.randomDrop());
            return;
        }
        endBattle();
    }
    
    private void endBattle() {
        if(DataHandler.player.getHealth() <= 0) this.setStage(9);
        else this.setStage(DataHandler.source.getID());
    }
    
    private void giveItem(Item itemVar) {
        this.removeElements(ability0, ability1, ability2, ability3, playerStat, opponentStat);
        mainDialog.setText("YOU GOT A " + itemVar.getName().toUpperCase(), "Do you want it?");
        itemVar2 = itemVar;
        fightButton.setLabel("Accept Item", true);
        runButton.setLabel("Reject Item", true);
    }
}