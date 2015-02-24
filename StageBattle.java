import ui.*;
import ui.elem.*;
import util.BattleHandler;

public class StageBattle extends Stage {
	private Choice fightButton;
	private Choice runButton;
	private Stat playerStat;
	private OpponentStat opponentStat;
	private Dialog mainDialog;

	@Override
	public void init() {
		if(DataHandler.player == null) { this.setStage(1); return; } //if there is no player, then just start stage prologue for character creation
		fightButton = new Choice("Attack");
		runButton = new Choice("Run!");
		playerStat = new Stat();
        opponentStat = new OpponentStat();
        mainDialog = new Dialog();
		this.addElements(fightButton, runButton, playerStat, opponentStat, mainDialog);
		fight();
	}

	@Override
	public void choiceClicked(Element elementVar) {
		Choice choiceObject = (Choice)elementVar;
		if(choiceObject == fightButton){
            BattleHandler.playerTurn(DataHandler.player, DataHandler.opponent);
            BattleHandler.creatureTurn(DataHandler.player, DataHandler.opponent);
            fight();
        } else if(choiceObject == runButton){
            
        }
	}

	@Override
	public void taskPerformed() {
	}
	
	public void fight(){
        mainDialog.setText("What will you do next?");
        playerStat.setText("Player Health: " + DataHandler.player.getHealth());
        opponentStat.setText("Enemy Health: " + DataHandler.opponent.getHealth());
        if(DataHandler.opponent.getHealth() <= 0 || DataHandler.player.getHealth() <= 0){
            DataHandler.battleCompleted = true;
            this.setStage(DataHandler.source.getID());
        }
    }
}