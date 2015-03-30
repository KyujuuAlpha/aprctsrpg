import java.awt.Font;
import java.util.Random;

import ui.Stage;
import ui.elem.Choice;
import ui.elem.Element;
import ui.elem.Sprite;
import ui.elem.Text;
import util.Assassin;
import util.BattleHandler;
import util.EntityCreature;
import util.Item;
import util.Mother;
import util.Tank;
import util.Zombie;

public class StageBattle extends Stage {
	
	private DataHandler data;
	
	public StageBattle(DataHandler dataVar) {
		data = dataVar;
	}
	
    private Choice fightButton;
    private Choice ability0;
    private Choice ability1;
    private Choice ability2;
    private Choice ability3;
    private Choice runButton;

    private Text playerStat;
    private Text opponentStat;
    
    
    private Text mainDialog;
    
    private int scheduleCode = 0;
    
    private int selectedAbility = -1;
    
    private Item itemVar2;

    @Override
    public void init() {
        if(data.player == null) { this.setStage(1); return; } //if there is no player, then just start stage prologue for character creation
        itemVar2 = null; //sets the Item to null
        int abilityWidth = 150;
        ability0 = new Choice(data.player.getAbilitiesName(0)); //gets the abilities' name using a method that does just that and adds it as a new choice
        ability0.setWidth(abilityWidth);
        ability0.setDock(Choice.CENTER_SOUTH);
        ability0.setX((int) (getWidth() / 2 - ability0.getWidth() - 5));
        ability0.setY(this.getHeight() - 100 - ability0.getHeight()*2 - 10*2);
        ability1 = new Choice(data.player.getAbilitiesName(1));
        ability1.setWidth(abilityWidth);
        ability1.setDock(Choice.CENTER_SOUTH);
        ability1.setX((int) (getWidth() / 2 + 5));
        ability1.setY(this.getHeight() - 100 - ability1.getHeight()*2 - 10*2);
        ability2 = new Choice(data.player.getAbilitiesName(2));
        ability2.setWidth(abilityWidth);
        ability2.setDock(Choice.CENTER_SOUTH);
        ability2.setX((int) (getWidth() / 2 + 5));
        ability2.setY(this.getHeight() - 100 - ability2.getHeight() - 10);
        ability3 = new Choice(data.player.getAbilitiesName(3));
        ability3.setWidth(abilityWidth);
        ability3.setDock(Choice.CENTER_SOUTH);
        ability3.setX((int) (getWidth() / 2 - ability3.getWidth() - 5));
        ability3.setY(this.getHeight() - 100 - ability3.getHeight() - 10);
        fightButton = new Choice("Attack"); //creates the important attack button
        fightButton.setDock(Choice.CENTER_SOUTH);
        fightButton.setWidth(ability0.getWidth() * 2 + 5*2);
        fightButton.setX((int) (getWidth() / 2 - fightButton.getWidth() / 2));
        fightButton.setY(this.getHeight() - 100 - ability0.getHeight()*3 - 10*3);
        runButton = new Choice("Run!"); //the all powerful run method that never works
        runButton.setDock(Choice.CENTER_SOUTH);
        runButton.setWidth(ability0.getWidth() * 2 + 5*2);
        runButton.setX((int) (getWidth() / 2 - runButton.getWidth() / 2));
        runButton.setY(this.getHeight() - 100);
        playerStat = new Text("", 0, 0); //creates the stat. The player's are on the top right and the opponent's are on the bottom right
        opponentStat = new Text("", 0, 0);
        mainDialog = new Text("", 0, 100);
    	mainDialog.setFont(new Font("Arial", Font.PLAIN, 12));
    	mainDialog.setDock(Text.TRUE_CENTER);
		this.add(fightButton, ability0, ability1, ability2, ability3, runButton, playerStat, opponentStat, mainDialog);
		
		//the following methods check what picture should be put on the rightmost pane
		if(data.player instanceof Tank) this.add(new Sprite("tank.png", 0, 0));
		else if(data.player instanceof Assassin) this.add(new Sprite("assassin.png", 0, 0));
		else this.add(new Sprite("norm.png", 0, 0));
				
		if(data.opponent instanceof Zombie) {
			if(new Random().nextInt(2) == 0) this.add(new Sprite(data.getEntityImage(4, 0), 0, 0, 200, 200)); //a random conditional to determine which one will be added
			else this.add(new Sprite(data.getEntityImage(0, 1), 0, 0, 200, 200));
		} else if(data.source instanceof StageMotherZombie) {
			if(data.opponent instanceof Mother) this.add(new Sprite(data.getEntityImage(4, 1), 0, 0));
			else {
				switch(new Random().nextInt(3)) { 
					case 0: this.add(new Sprite(data.getEntityImage(1, 1), 0, 0, 200, 200)); break;
					case 1: this.add(new Sprite(data.getEntityImage(2, 1), 0, 0, 200, 200)); break;
					case 2: this.add(new Sprite(data.getEntityImage(3, 1), 0, 0, 200, 200)); break;
					default: this.add(new Sprite(data.getEntityImage(3, 0), 0, 0, 200, 200)); break;
				}
			}
		} else if(data.opponent instanceof EntityCreature) this.add(new Sprite(data.getEntityImage(3, 0), 0, 0, 200, 200));
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
                boolean flag = BattleHandler.playerTurn(data.player, selectedAbility, data.opponent);
                updateStats();//a method to update the stats
                if(flag) mainDialog.appendText("\nYou dealt damage!");
                else mainDialog.appendText("\nYour attack missed!");
                scheduleCode = 2;
                this.scheduleTask(30);
            } else if(choiceObject == runButton){
                if(BattleHandler.run(data.player, data.opponent) && !(data.source instanceof StageMotherZombie)) {
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
                data.player.addItem(itemVar2);
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
        if(data.opponent.getHealth() <= 0 || data.player.getHealth() <= 0){
            exitBattle();
            return;
        }
        updateStats();
        fightButton.setEnabled(true);
        runButton.setEnabled(true);
        ability0.setEnabled(true);
        ability0.setToolTip(data.player.getAbilitiesDesc(0));
        ability1.setEnabled(true);
        ability1.setToolTip(data.player.getAbilitiesDesc(1));
        ability2.setEnabled(true);
        ability2.setToolTip(data.player.getAbilitiesDesc(2));
        ability3.setEnabled(true);
        ability3.setToolTip(data.player.getAbilitiesDesc(3));
        selectedAbility = -1;
        mainDialog.setText("What will you do next?");
    }
    
    private void opponentTurn() {
        if(data.opponent.getHealth() <= 0 || data.player.getHealth() <= 0){
            exitBattle();
            return;
        }
        updateStats();
        boolean flag = BattleHandler.creatureTurn(data.player, data.opponent);
        updateStats();
        if(flag) mainDialog.setText("Your opponent dealt damage!");
        else mainDialog.setText("Your opponent's attack missed!");
        scheduleCode = 3;
        this.scheduleTask(20);
    }
    
    private void updateStats(){
        playerStat.setText("PLAYER STATS - Level: " + ((int)(data.player.getLevel()*10))/10.0D + "\nHealth: " + ((int)(data.player.getHealth()*10))/10.0D);
        opponentStat.setText("OPPONENT STATS - Health: " + ((int)(data.opponent.getHealth()*10))/10.0D);
    }
    
    private void exitBattle() {
        data.battleCompleted = true;
        if(data.opponent.getHealth() <= 0){
            data.player.leveling(data.opponent);
            giveItem(data.opponent.randomDrop());
            return;
        }
        endBattle();
    }
    
    private void endBattle() {
        if(data.player.getHealth() <= 0) this.setStage(9);
        else this.setStage(data.source.getID());
    }
    
    private void giveItem(Item itemVar) {
        this.remove(ability0, ability1, ability2, ability3, playerStat, opponentStat);
        mainDialog.setText("YOU GOT A " + itemVar.getName().toUpperCase(), "Do you want it?");
        itemVar2 = itemVar;
        fightButton.setLabel("Accept Item", true);
        runButton.setLabel("Reject Item", true);
    }
}