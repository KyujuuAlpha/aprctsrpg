import ui.elem.*;
import ui.*;

public class StageHeadQuarters extends Stage{
    private Dialog mainDialog;
    private Choice a;
    private Choice c;
    private int x = 0;
    private int y = 0;
    
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
        mainDialog = new Dialog("");
        this.addElements(mainDialog, a, c);
        if(DataHandler.SHIELD){
            mainDialog.setText("What would you like to do today?");
        } else{
            mainDialog.setText("What's up?");
        }
    }
}
