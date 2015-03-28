import ui.*;
import ui.elem.*;

public class StageEndGame extends Stage {
    private Dialog mainDialog;
    private Choice a;
    private int x = 0;
    @Override
    public void init() {
        mainDialog = new Dialog("");
        a = new Choice("So what now?");
        this.add(mainDialog, a);
        mainDialog.setText("You've disrupted the time-space continuum.", "Humans weren't supposed to survive the apocalypse.");
    }
    
    @Override
    public void choiceClicked(Element elementVar) {
        Choice choiceObject = (Choice)elementVar;
        if(choiceObject.getLabel().equals("So what now?")){
            stageOver();
        }
    }
    
    @Override
    public void taskPerformed() {
        if(x == 1){x++; stageTwo(); return;}
        if(x == 2){x++; stageOver(); return;}
    }
    
    public void stageOne() {
        mainDialog.setText("It's over");
        x++;
        this.scheduleTask(60);
    }
    
    public void stageTwo(){
        mainDialog.setText("This dimension has ended.");
        this.scheduleTask(30);
    }
    
    public void stageOver(){
        mainDialog.setText("Goodbye.");
    }
}
