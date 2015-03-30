import java.awt.Font;

import ui.Stage;
import ui.elem.Choice;
import ui.elem.Element;
import ui.elem.Sprite;
import ui.elem.Text;
import util.Assassin;
import util.EntityPlayer;
import util.Item;
import util.Tank;
public class StagePrologue extends Stage {
	
	private DataHandler data;
	
	public StagePrologue(DataHandler dataVar) {
		data = dataVar;
	}
	
    /* 
     * In every stage class, there will for sure be three class:
     *           choiceClicked(): assigns the button clicked to the variable choiceObject and looks through the conditionals, acting accordingly
     *           taskPerformed(): used in conjunction with the scheduleTask() method. After the specified amount of time, the method will looks through the conditionals within
     *           init(): the method that is first looked at in every class
     *Usually, withiin every init() class:
     *           1. the choices are initialized: the choices are the buttons on the left side of the gui. At this point, they are given labels
     *           2. the mainDialog, which is the center text, is initialized and text is assigned to it.
     *           3. the this.add() method is so the external parameters (the choice and mainDialog) are added to the gui and are visible
     *           
     * This is the prologue stage, where the player chooses what weapon they will use and what character class they will use
     * Character classes:
     *           Tank: higher hp, but lower damage
     *           Normal: normal hp, with normal damage
     *           Assassin: faster, with lower hp but higher attack
     * The weapons:
     *           Wand: cause Harry Potter
     *           Holy SFHS iPad: cause why not
     *           Pistol: cause stereotypical zombie game
     * 
     * After every stage, the method nextStage() will be used to tell the engine to move to the next stage listed in the array.
     * The next stage in the order will be stageTeam();
     */
    private Text mainDialog;
    private Choice a;
    private Choice b;    
    private Choice c;
    private Sprite d;
    private Sprite e;
    private Sprite f;
    
    @Override
    public void choiceClicked(Element elementVar) {
        Choice choiceObject = (Choice)elementVar;
        if(choiceObject.getLabel().equals("START")){ //checks to see if the label of choiceObject is the same as start using the String.equals() method
            prestage(); //calls to a substage of the stage
            a.setLabel("Next", true); //sets the Label as the string "Next" and clickeable
            return;
        }
        
        if(choiceObject.getLabel().equals("Next")) {
            //since there are two instances when the text "Next" is being used, there must be ways to differentiate between the two times.
            if(data.player == null) { //detects whether or not there is a player object created. If not, the game sends the user to character class choice
                chooseClass();
                this.add(b);
            } else {
                this.nextStage(); //the nextStage() method moves the game to the next method that is in the stage arrayList
            }
            return;
        }
        
        if(choiceObject.getLabel().equals("Tank")){
            data.player = new Tank(); //creates an instance field of the class Tank, which is a subclass of the superclass EntityPlayer
            chooseItem();//sends the player to the chooseItem() substage, where the user can choose their weapon.
            return;
        } else if(choiceObject.getLabel().equals("Normal")){
            data.player = new EntityPlayer();
            chooseItem();
            return;
        } else if(choiceObject.getLabel().equals("Assassin")){
            data.player = new Assassin();
            chooseItem();
            return;
        }
        
        if(choiceObject.getLabel().equals("Wand")){ //adds an item to the weapon inventory based on the users selection
            data.player.addItem(Item.basicSword);
            poststage();
            return;
        } else if(choiceObject.getLabel().equals("Holy SFHS iPad")){
            data.player.addItem(Item.basicWand);
            poststage();
            return;
        } else if(choiceObject.getLabel().equals("Pistol")){
            data.player.addItem(Item.pistol);
            poststage();
            return;
        }
    }
    
    @Override
    //not used in this method, but is important in the class StageBattleTutorial
    public void taskPerformed() {
    }

    @Override
    //this is the first method that will be called upon
    public void init() {
        a = new Choice("START", 0, this.getHeight() - 200, 100, 25); //creates a new Choice instance field with the text of "START"
        a.setDock(Choice.CENTER_SOUTH);
        a.setFont(new Font("Arial", Font.BOLD, 12));
        a.setX(getWidth() / 2 - a.getWidth() / 2);
        b = new Choice();//the choices are all located on the leftmost pane of the gui
        b.setDock(Choice.CENTER_SOUTH);
        b.setFont(new Font("Arial", Font.BOLD, 12));
        c = new Choice();
        c.setDock(Choice.CENTER_SOUTH);
        c.setFont(new Font("Arial", Font.BOLD, 12));
        mainDialog = new Text("", 0, 0); //creates a new mainDialog instance field that is currently empty, the mainDialog is located in the middle pane of the gui
        this.add(mainDialog, a); //this.add adds the mainDialog and Choice a to the screen where they belong
        mainDialog.setText("AP-RC-TS RPG: The Game"); //this sets the text to whatever is in the explicit parameters
        mainDialog.setDock(Text.TRUE_CENTER);
        mainDialog.setFont(new Font("Arial", Font.BOLD + Font.ROMAN_BASELINE, 40));
        mainDialog.setY(100);
    }
    /*
     * all the rest of these are substages, which usually change whenever the choices or dialog needs to change.
     */
    public void prestage(){
    	mainDialog.setY(100);
    	mainDialog.setFont(new Font("Arial", Font.PLAIN, 12));
        mainDialog.setText("It's the year 151515, after the Last World War, with", "President Obama the Fiftieth finally dead,", "anarchy reigns as Ebola Z runs throughout the world. As Brad", "Pitt and Angelina Jolie rebuild ", "their giant mansion on the newly formed Hawaiian island of N'vu L'nodo,", "Robert Downey Jr.finally accepts his responsibility as Iron Man", "and forms SHIELD along with Samuel Jackson. ", "You are stuck in Seattle, the pot capital of the world, as you try", " to save the human race from ", "the deadly disease. Brad Pitt and Angelina Jolie are rumored to have protection and their own ", "private army, but SHIELD offers the Avengers and the Guardians of the Galaxy. With SHIELD there", "is a hope of being transported to another dimension. How will you proceed?", "Click Next to Continue");
    }
    
    public void chooseClass() {
    	mainDialog.setY(50);
        a.setLabel("Tank", true); //the setLabel methods doesn't need the addElement method to update the label
        a.setX((int) (getWidth() / 2 - a.getWidth() / 2 - a.getWidth() - 10));
        a.setY(this.getHeight() - 100);
        b.setLabel("Normal", true); //the setLabel method had to parameters. The first is the new text, and the second is a boolean value that 
        b.setX((int) (getWidth() / 2 - b.getWidth() / 2));
        b.setY(this.getHeight() - 100);
        c.setLabel("Assassin", true);// decides whether or not the button is clickable
        c.setX((int) (getWidth() / 2 - c.getWidth() / 2 + c.getWidth() + 10));
        c.setY(this.getHeight() - 100);
        d = new Sprite(data.getEntityImage(0, 0), getWidth() / 2 - 100 - 200, getHeight() / 2 - 150, 200, 200); //tank
        d.setDock(Sprite.CENTER);
        e = new Sprite(data.getEntityImage(2, 0), getWidth() / 2 - 100, getHeight() / 2 - 150, 200, 200); //norm
        e.setDock(Sprite.CENTER);
        f = new Sprite(data.getEntityImage(1, 0), getWidth() / 2 - 100 + 200, getHeight() / 2 - 150, 200, 200); //assassin
        f.setDock(Sprite.CENTER);
        this.add(c, d, e, f);
        mainDialog.setText("What CLASS will you choose?", "Tank - High Health", "Normal - Average", "Assassin - High Speed/Attack");
    }
    
    public void chooseItem() {
    	mainDialog.setY(100);
        this.remove(a, b, c, d, e, f); //the removeElements() method removes elements if they are unneeded in the current substage
        this.add(a, b, c); //make sure they are in order :)
        a.setLabel("Wand", true); //setting the label to new options
        b.setLabel("Holy SFHS iPad", true);
        c.setLabel("Pistol", true);
        mainDialog.setText("You wake up and get ready to leave your apartment.", "What weapon will you take?", "Option 1: Wand", "Option 2: Holy SFHS iPad", "Option 3: Pistol");
    }
    
    public void poststage() {
        this.remove(b, c);
        a.setX(getWidth() / 2 - a.getWidth() / 2);
        a.setY(this.getHeight() - 200);
        a.setLabel("Next", true);
        mainDialog.setText("You leave your apartment, after locking all your doors and windows.", "The other tenants of your building have long since left.", "One 50 year old man claimed to be smuggling out a 14 year old girl whose blood has the cure to Ebola Z.", "You don't care about any of this.", "With food, fresh water, and ammo running low, you have to get out.", "Where will you go?" );
    }
}
