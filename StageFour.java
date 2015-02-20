    import ui.*;
import ui.elem.*;
import util.*;
public class StageFour extends StageMain {
    private Dialog mainDialog;
    private Choice a;
    private Choice b;
    private int x = 0;
    private int y = 0;
    private boolean fight = false;
    @Override
    public void choiceClicked(Element elementVar) {
        Choice choiceObject = (Choice)elementVar;
        if(choiceObject.getLabel().equals("Continue")){
            if(DataHandler.SHIELD){
                x++;
            }else{
                y++;
            }
        }
    }
    @Override
    public void taskPerformed() {
        if(x == 0){ y++; shieldOne();}
    }
    @Override
    public void init() {
        a = new Choice("Continue");
        mainDialog = new Dialog("");
        this.addElements(mainDialog, a);
        if(DataHandler.SHIELD){
            mainDialog.setText("Hi, my name is Jar-- ULTRON --vis.", "I will be helping you --TO YOUR DOOM-- during your time", "here at SHIELD.");
        }else{
            mainDialog.setText("You black out after your battle with SHIELD", "and wake up among Kanye West, Ryan Gosling and Megan Fox.");
        }
    }
    public void shieldOne(){
        mainDialog.setText("You have four options here at SHIELD.", "1) Go on a Zombie Patrol", "2) Upgrade your weapon"); 
    }
}
