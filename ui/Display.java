package ui;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import ui.elem.*;

@SuppressWarnings("serial")
public class Display extends JFrame implements ActionListener, KeyListener { 
    private JPanel statsMenu; //declare new jpanels
    private JPanel statsMenu2;
    
    private int currentStage = 0; //declare an integer for keeping track of the current stage #
    
    private ArrayList<Stage> stageList = new ArrayList<Stage>(); //declare and intiialize a new arraylist with type being stage
    
    private JPanel actionsMenu; //declare the containers for each type of element
    private JPanel imageMenu; //sprites
    private JPanel inputMenu; //inputs
    private JLabel dialog; //dialog
    private JLabel stats; //player stats
    private JLabel stats2; //opponent stats
    
    private boolean toggleFullscreen;
    
    private final String simpleName;
    
    public Display(String str) {
        super(str);
        simpleName = str;
        this.setPreferredSize(new Dimension(800,600));
        setContentPane(new JPanel(){
        	@Override
        	public void paintComponent(Graphics g) {
        		super.paintComponent(g);
        		Graphics2D render = (Graphics2D) g;
        		setBackground(Color.BLACK);
        	}
        });
        this.addKeyListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        Timer timerVar = new Timer(50, this);
        timerVar.start();
        toggleFullscreen = false;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) { //called whenver the timer ticks
        if(getStage() == null) return; //if the stage does not exist, dont do anything
        if(!this.getTitle().equals(simpleName + " - " + getStage().getClass().getSimpleName())) this.setTitle(simpleName + " - " + getStage().getClass().getSimpleName());
        int incrementVar = getStage().incrementVar(); //to save cpu usage, save the incrementVar variable for the current stage
        if(incrementVar == 1) { this.nextStage(); } //if the incrementVar var is set to code 1, try to go to the next stage
        else if(incrementVar == 2) { this.prevStage(); } //if it is code 2, try to go to the previous stage
        else if(incrementVar > 2) { this.setStage(incrementVar - 3); } //if it's code is greater than 2, then try to set the current stage with id set to the increment variable - 3
        boolean flag = false;
        try { for(Element elementVar : getStage().getElements()) { //loop through each element in the stage's element list
        	if(elementVar.getComponent() == null) { //if the element has no container
        		if(elementVar instanceof ui.elem.Choice) elementVar.setComponent(actionsMenu); //if it is type choice, set the component to the choice container
        		else if(elementVar instanceof ui.elem.Input) elementVar.setComponent(inputMenu); //etcetera "
        		else if(elementVar instanceof ui.elem.Sprite) elementVar.setComponent(imageMenu);
        		else if(elementVar instanceof ui.elem.Stat) elementVar.setComponent(stats); 
        		else if(elementVar instanceof ui.elem.OpponentStat) elementVar.setComponent(stats2);
        		else if(elementVar instanceof ui.elem.Dialog) elementVar.setComponent(dialog);
        		elementVar.createElement(); //create the element while adding it to the element's new container!
        	} else if(!flag) {
        		if(elementVar instanceof ui.elem.Choice && ((ui.elem.Choice)elementVar).isClicked()) { //if it has a container and the button is clicked already, 
        			((ui.elem.Choice)elementVar).setClicked(false); //set the variable showing whether it is clicked or not to false
        			getStage().choiceClicked(elementVar); //and invoke the current stage's choice clicked method
        			flag = true; //dont call the choice clicked method more than once (only if two buttons are clicked at the same exact time some how HAAAX!) 
        		}
        	}
        } } catch(ConcurrentModificationException error) { /* dont do anything and save it for the next tick */ }
        getStage().decreaseTicks(); //decrease the stage's ticks, 
        getStage().syncElements(); //sync all it's elements
        this.revalidate(); //revalidate this jframe's elements
        this.repaint(); //repaint this jframe's elements
    }
    
    /**
     * Begin the game starting at stage 0
     */
    public void begin() {
        if(stageList.size() > 0) getStage().init(); //if the stagelist has more than 0 stages, invoke the init method from the first one
    }
    
    /**
     * Add a new stage to the list
     */
    public void addStage(Stage stageVar) {
        stageList.add(stageVar); //add the stage to the stagelist
        stageVar.setID(stageList.size() - 1);
    }
    
    /**
     * Move onto the next stage on the list
     */
    public void nextStage() {
        getStage().removeElements(); //remove all the elements from the current stage
        if(currentStage < stageList.size() - 1) currentStage++; //check if you should increase the current stage variable, this check is to avoid the index out of bounds exception
        getStage().resetIncrement(); //avoid infinite loop plz
        getStage().init(); //invoke the init method from the current stage
    }
    
    /**
     * Go back one stage on the list
     */
    public void prevStage() {
        getStage().removeElements();
        if(currentStage > 0) currentStage--; //go to the previous stage; same with this "
        getStage().resetIncrement();
        getStage().init();
    }
    
    /**
     * Set the current stage to the specified stage
     */
    public void setStage(int intVar) {
        getStage().removeElements();
        currentStage = intVar; //set the current stage integer to the explicit parameter intVar
        if(currentStage < 0) currentStage = 0; //check if it is less than 0;
        if(currentStage >= stageList.size()) currentStage = stageList.size() - 1; //check if it is greater than the size of the list
        getStage().resetIncrement();
        getStage().init();
    }
    
    /**
     * Get the current stage this game is on
     */
    public int getStageNumber() { 
        return currentStage; //return the current stage's index
    }
    
    /**
     * Get the actual current stage object
     */
    public Stage getStage() {
        if(currentStage < stageList.size()) return stageList.get(currentStage); //if the current stage not bigger than the stagelist's size to prevent index out of bounds
        return null;
    }

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_F11) {
			this.dispose();
			if(!toggleFullscreen) {
				toggleFullscreen = true;
				this.setUndecorated(true);
				this.setExtendedState(JFrame.MAXIMIZED_BOTH);
			} else {
				toggleFullscreen = false;
				this.setUndecorated(false);
				this.setExtendedState(JFrame.NORMAL);
				this.pack();
			}
			this.setVisible(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}