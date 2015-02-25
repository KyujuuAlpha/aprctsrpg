import ui.elem.*;
import ui.*;

public class StageFour extends Stage{
    private Dialog mainDialog;
    private Choice a;
    private Choice b;
    private Choice c;
    private int x = 0;
    private int y = 0;
    
    @Override
    public void choiceClicked(Element elementVar) {
        Choice choiceObject = (Choice)elementVar;
        if(choiceObject.getLabel().equals("Continue")){
            if(DataHandler.SHIELD){
                x++; 
                stageOne();
                return;
            }else{
                y++;
                islandOne();
                return;
            }
        }
        if(choiceObject.getLabel().equals("Next")){
        	stageOne(); 
        }
        if(choiceObject.getLabel().equals("Zombie Patrol")){
            setStage(6);
        }
        if(choiceObject.getLabel().equals("Mother Zombie")){
            setStage(7);
        }
    }
    @Override
    public void taskPerformed() {
        if(y == 1){y++; stageOne(); return;}
        if(y == 2){nextStage(); return;}
        if(x == 1){nextStage(); return;}
    }
    @Override
    public void init() {
        a = new Choice("Continue");
        mainDialog = new Dialog("");
        this.addElements(mainDialog, a);
        if(DataHandler.SHIELD){
            mainDialog.setText("Hi, my name is Jar-- ULTRON --vis.", "I will be helping you --TO YOUR DOOM-- during your time", "here at SHIELD.");
        }else{
            mainDialog.setText("You black out after your battle with SHIELD", "and wake up among Kanye West, Ryan Gosling and", "Megan Fox.");
        }
    }
    public void islandOne(){
        a.setLabel("Next");
        mainDialog.setText("Kanye introduces himself as the captain of your", "squad, and explains you duties on the island.");
    }
    public void stageOne(){
        this.removeElements(a);
        mainDialog.setText("You have four options here at headquarters.", "1) Go on a Zombie Patrol", "2) Go after the Mother Zombie", "Going after the Mother Zombie is highly unreccomended", "for beginners."); 
        this.scheduleTask(60);
    }
    public void stageTwo(){
        a.setLabel("Zombie Patrol");
        c = new Choice("Mother Zombie");
        this.addElements(c);
        if(DataHandler.SHIELD){
            mainDialog.setText("What would you like to do today?");
        } else{mainDialog.setText("What's up?");}
    }
}
