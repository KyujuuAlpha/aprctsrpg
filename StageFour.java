import ui.elem.*;
import ui.*;

public class StageFour extends Stage {
	
	private DataHandler data;
	
	public StageFour(DataHandler dataVar) {
		data = dataVar;
	}
	
    private Text mainDialog;
    private Choice a;
    private int x = 0;
    private int y = 0;
    
    //this is a tutorial of what options are available to the user
    //after the tutorial, the stage goes to the StageHeadQuarters
    
    @Override
    public void choiceClicked(Element elementVar) {
        Choice choiceObject = (Choice)elementVar;
        if(choiceObject.getLabel().equals("Continue")){
            if(data.SHIELD){
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
        mainDialog = new Text("", 0, 0);
        this.add(mainDialog, a);
        if(data.SHIELD){
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
        this.remove(a);
        mainDialog.setText("You have two options here at headquarters.", "1) Go on a Zombie Patrol", "2) Go after the Mother Zombie", "Going after the Mother Zombie is highly unreccomended", "for beginners."); 
        this.scheduleTask(60);
    }
}
