import ui.elem.*;
import ui.*;

public class StageHeadQuarters extends Stage{
    /*
     * here is where the headquarters is.
     * As Kanye or JARVIS described, there are two options
     * if you die during either of the battles, you will lose the game
     * if you win in Zombie Patrol, you return to HeadQuarters
     * if you win in Mother Zombie, you advance to StageEndGame
     */
    private Text mainDialog;
    private Choice a;
    private Choice c;
    private Text stat;
    
    
    @Override
    public void choiceClicked(Element elementVar) {
        Choice choiceObject = (Choice)elementVar;
        if(choiceObject.getLabel().equals("Zombie Patrol")){
            setStage(6);
        }else if(choiceObject.getLabel().equals("Mother Zombie")){
            setStage(7);
        }else{
            setStage(5);
        }
    }
    @Override
    public void taskPerformed() {
    }
    @Override
    public void init() {
        a = new Choice("Zombie Patrol");
        c = new Choice("Mother Zombie");
        stat = new Text("PLAYER STATS - Level: " + ((int)(DataHandler.player.getLevel()*10))/10.0D + "\nHealth: " + ((int)(DataHandler.player.getHealth()*10))/10.0D, 0, 0);
        mainDialog = new Text("", 0, 0);
        this.add(mainDialog, a, c, stat);
        if(DataHandler.SHIELD){
            mainDialog.setText("What would you like to do today?");
        } else{
            mainDialog.setText("What's up?");
        }
    }
}
