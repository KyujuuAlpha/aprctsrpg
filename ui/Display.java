package ui;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import ui.elem.*;

public class Display extends JFrame implements ActionListener { 
    private JPanel statsMenu; //declare new jpanels
    private JPanel statsMenu2;
    
    private int currentStage = 0; //declare an integer for keeping track of the current stage #
    
    private ArrayList<Stage> stageList = new ArrayList<Stage>(); //declare and intiialize a new arraylist with type being stage
    
    public final JPanel actionsMenu; //declare the containers for each type of element
    public final JPanel imageMenu; //sprites
    public final JPanel inputMenu; //inputs
    public final JLabel dialog; //dialog
    public final JLabel stats; //player stats
    public final JLabel stats2; //opponent stats
    
    public Display(String str) {
        super(str); //call the parent classes' constructor
        this.setSize(800,600); //set the jpanel's size
        JPanel subContainerA = new JPanel(new GridLayout(1,2)); //initialize jpanels with specified layout manager
        JPanel subContainerB = new JPanel(new GridLayout(2,1));
        subContainerA.add(subContainerB); //add container b to container a
        this.add(subContainerA, BorderLayout.CENTER); //add container a to this jframe
        JPanel temp; //create a temp container
        JScrollPane temp2; //create a temp scrolling pane
        actionsMenu = new JPanel(); //initialize the actions jpanel
        actionsMenu.setLayout(new BoxLayout(actionsMenu, BoxLayout.Y_AXIS)); //set it's layout to the specified layout manager
        imageMenu = new JPanel(); //imageMenu
        imageMenu.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)); //set the container's border style
        subContainerA.add(imageMenu); //add the panel to this jframe
        inputMenu = new JPanel();
        inputMenu.setLayout(new BoxLayout(inputMenu, BoxLayout.Y_AXIS));
        temp = new JPanel(new FlowLayout(FlowLayout.LEFT)); //initialize the temp container
        dialog = new JLabel(""); //initialize the dialog to an empty jlabel
        temp.add(dialog);
        temp2 = new JScrollPane(temp); //dialog and initialize the temporary scrolling pane
        temp2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        subContainerB.add(temp2);
        temp2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        temp2 = new JScrollPane(inputMenu); //inputs
        subContainerB.add(temp2);
        actionsMenu.setLayout(new BoxLayout(actionsMenu, BoxLayout.Y_AXIS));
        statsMenu = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        statsMenu2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        stats = new JLabel("");
        stats2 = new JLabel("");
        statsMenu.add(stats); //statistics
        this.add(statsMenu, BorderLayout.NORTH);
        statsMenu2.add(stats2); //stats 2
        this.add(statsMenu2, BorderLayout.SOUTH);
        temp2 = new JScrollPane(actionsMenu); //actions
        temp2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        this.add(temp2, BorderLayout.WEST);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //kill the java.exe process plz
        this.setVisible(true); //set the visibility of this jframe to true
        Timer timerVar = new Timer(50, this); //ticking timer
        timerVar.start(); //invoke the start method from the timervar
    }
    
    @Override
    public void actionPerformed(ActionEvent e) { //called whenver the timer ticks
        if(getStage() == null) return; //if the stage does not exist, dont do anything
        int incrementVar = getStage().incrementVar(); //to save cpu usage, save the incrementVar variable for the current stage
        if(incrementVar == 1)this.nextStage(); //if the incrementVar var is set to code 1, try to go to the next stage
        else if(incrementVar == 2) this.prevStage(); //if it is code 2, try to go to the previous stage
        else if(incrementVar > 2) this.setStage(incrementVar - 3); //if it's code is greater than 2, then try to set the current stage with id set to the increment variable - 3
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
    }
    
    /**
     * Move onto the next stage on the list
     */
    public void nextStage() {
        getStage().removeElements(); //remove all the elements from the current stage
        if(currentStage < stageList.size() - 1) currentStage++; //check if you should increase the current stage variable, this check is to avoid the index out of bounds exception
        getStage().init(); //invoke the init method from the current stage
    }
    
    /**
     * Go back one stage on the list
     */
    public void prevStage() {
        getStage().removeElements();
        if(currentStage > 0) currentStage--; //go to the previous stage; same with this "
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
        else if(stageList.size() > 0) return stageList.get(stageList.size()-1); //prevent index out of bounds
        return null;
    }
}
