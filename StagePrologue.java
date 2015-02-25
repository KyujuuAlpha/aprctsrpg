import ui.*;
import ui.elem.*;
import util.*;
public class StagePrologue extends Stage {
    private Dialog mainDialog;
    private Choice a;
    private Choice b;    
    private Choice c;
    
    @Override
    public void choiceClicked(Element elementVar) {
        Choice choiceObject = (Choice)elementVar;
        if(choiceObject.getLabel().equals("START")){
            prestage();
            a.setLabel("Next", true);
            return;
        }
        
        if(choiceObject.getLabel().equals("Next")) {
        	if(DataHandler.player == null) {
	            chooseClass();
	            this.addElements(b);
        	} else {
        		this.nextStage();
        	}
            return;
        }
        
        if(choiceObject.getLabel().equals("Tank")){
        	DataHandler.player = new Tank();
            chooseItem();
            return;
        } else if(choiceObject.getLabel().equals("Normal")){
        	DataHandler.player = new EntityPlayer();
        	chooseItem();
        	return;
        } else if(choiceObject.getLabel().equals("Assassin")){
        	DataHandler.player = new Assassin();
        	chooseItem();
        	return;
        }
        
        if(choiceObject.getLabel().equals("Wand")){
            DataHandler.player.addItem(Item.basicSword);
            poststage();
            return;
        } else if(choiceObject.getLabel().equals("Holy SFHS iPad")){
            DataHandler.player.addItem(Item.basicWand);
            poststage();
            return;
        } else if(choiceObject.getLabel().equals("Pistol")){
            DataHandler.player.addItem(Item.pistol);
            poststage();
            return;
        }
    }
    
    @Override
    public void taskPerformed() {
    }

    @Override
    public void init() {
        a = new Choice("START");
        b = new Choice();
        c = new Choice();
        mainDialog = new Dialog();
        this.addElements(mainDialog, a);
        mainDialog.setText("Hello! Welcome to the Game!", "Press START to Continue");
    }
    
    public void prestage(){
        mainDialog.setText("It's the year 151515, after the Last World War, with", "President Obama L finally dead,", "anarchy reigns as Ebola Z runs throughout the world. As Brad", "Pitt and Angelina Jolie rebuild ", "their giant mansion on the newly formed Hawaiian island of N'vu L'nodo,", "Robert Downey Jr.finally accepts his responsibility as Iron Man", "and forms SHIELD along with Samuel Jackson. ", "You are stuck in Seattle, the pot capital of the world, as you try", " to save the human race from ", "the deadly disease. Brad Pitt and Angelina Jolie are rumored to have protection and their own ", "private army, but SHIELD offers the Avengers and the Guardians of the Galaxy. With SHIELD there", "is a hope of being transported to another dimension. How will you proceed?", "Click Next to Continue");
    }
    
    public void chooseClass(){
        a.setLabel("Tank", true);
        b.setLabel("Normal", true);
        c.setLabel("Assassin", true);
        this.addElements(c, new Sprite("tank.png", 0.5f), new Sprite("norm.png", 0.5f), new Sprite("assassin.png", 0.5f));
        mainDialog.setText("What CLASS will you choose?", "Tank - High Health", "Normal - Average", "Assassin - High Speed/Attack");
    }
    
    public void chooseItem() {
    	this.removeElements(a, b, c);
    	this.addElements(a, b, c); //make sure they are in order :)
    	a.setLabel("Wand", true);
    	b.setLabel("Holy SFHS iPad", true);
    	c.setLabel("Pistol", true);
    	mainDialog.setText("You wake up and get ready to leave your apartment.", "What weapon will you take?", "Option 1: Wand", "Option 2: Holy SFHS iPad", "Option 3: Pistol");
    }
    
    public void poststage() {
    	this.removeElements(b, c);
        a.setLabel("Next", true);
        mainDialog.setText("You leave your apartment, after locking all your doors and windows.", "The other tenants of your building have long since left.", "One 50 year old man claimed to be smuggling out a 14 year old girl whose blood has the cure to Ebola Z.", "You don't care about any of this.", "With food, fresh water, and ammo running low, you have to get out.", "Where will you go?" );
    }
}
