import ui.*;
import ui.elem.*;
import util.BattleHandler;

public class StageBattle extends Stage {
	private Choice fightButton;
	private Choice runButton;
	private Stat playerStat;
	private OpponentStat opponentStat;
	private Dialog mainDialog;
	
	private int scheduleCode = 0;

	@Override
	public void init() {
		if(DataHandler.player == null) { this.setStage(1); return; } //if there is no player, then just start stage prologue for character creation
		fightButton = new Choice("Attack");
		runButton = new Choice("Run!");
		playerStat = new Stat();
        opponentStat = new OpponentStat();
        mainDialog = new Dialog();
		this.addElements(fightButton, runButton, playerStat, opponentStat, mainDialog, new Sprite("char.png"));
		fightButton.setEnabled(false);
		runButton.setEnabled(false);
		playerTurn();
	}

	@Override
	public void choiceClicked(Element elementVar) {
		fightButton.setEnabled(false);
		runButton.setEnabled(false);
		Choice choiceObject = (Choice)elementVar;
		if(choiceObject == fightButton) {
			boolean flag = BattleHandler.playerTurn(DataHandler.player, DataHandler.opponent);
			updateStats();
            if(flag) mainDialog.appendText("\nYou dealt damage!");
            else mainDialog.appendText("\nYour attack missed!");
            scheduleCode = 2;
            this.scheduleTask(30);
        } else if(choiceObject == runButton){
        	if(BattleHandler.run(DataHandler.player, DataHandler.opponent)) {
	        	scheduleCode = 1;
	            mainDialog.appendText("\nYou got away safely..");
	            this.scheduleTask(20);
        	} else {
        		opponentTurn();
        	}
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