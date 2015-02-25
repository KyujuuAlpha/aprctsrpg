import ui.*;
import ui.elem.*;
import util.BattleHandler;
import util.Zombie;

public class StageBattle extends Stage {
	private Choice fightButton;
	private Choice ability0;
	private Choice ability1;
	private Choice ability2;
	private Choice ability3;
	private Choice runButton;
	private Stat playerStat;
	private OpponentStat opponentStat;
	private Dialog mainDialog;
	
	private int scheduleCode = 0;
	
	private int selectedAbility = -1;

	@Override
	public void init() {
		if(DataHandler.player == null) { this.setStage(1); return; } //if there is no player, then just start stage prologue for character creation
		fightButton = new Choice("Attack");
		ability0 = new Choice(DataHandler.player.getAbilitiesName(0));
		ability1 = new Choice(DataHandler.player.getAbilitiesName(1));
		ability2 = new Choice(DataHandler.player.getAbilitiesName(2));
		ability3 = new Choice(DataHandler.player.getAbilitiesName(3));
		runButton = new Choice("Run!");
		playerStat = new Stat();
        opponentStat = new OpponentStat();
        mainDialog = new Dialog();
		this.addElements(fightButton, ability0, ability1, ability2, ability3, runButton, playerStat, opponentStat, mainDialog, new Sprite("char.png"));
		if(DataHandler.opponent instanceof Zombie) this.addElements(new Sprite("zombie.png"));
		fightButton.setEnabled(false);
		runButton.setEnabled(false);
		playerTurn();
	}

	@Override
	public void choiceClicked(Element elementVar) {
		fightButton.setEnabled(false);
		runButton.setEnabled(false);
		ability0.setEnabled(false);
		ability1.setEnabled(false);
		ability2.setEnabled(false);
		ability3.setEnabled(false);
		Choice choiceObject = (Choice)elementVar;
		if(choiceObject == fightButton) {
			boolean flag = BattleHandler.playerTurn(DataHandler.player, selectedAbility, DataHandler.opponent);
			updateStats();
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
        playerStat.setText("PLAYER STATS - Level: " + (int)DataHandler.player.getLevel() + "\nHealth: " + DataHandler.player.getHealth());
        opponentStat.setText("OPPONENT STATS - Health: " + DataHandler.opponent.getHealth());
    }
	
	private void exitBattle() {
		DataHandler.battleCompleted = true;
		if(DataHandler.player.getHealth() <= 0) this.setStage(10);
		else this.setStage(DataHandler.source.getID());
	}
}