package ui;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import ui.elem.*;

public class Display extends JFrame implements ActionListener { 
    private JPanel statsMenu; //declare new jpanels
    private JPanel statsMenu2;
    
    private int currentStage = 0; //declare an integer for keeping track of the current stage #
    
    private ArrayList<Stage> stageList = new ArrayList<Stage>(); //declare and intiialize a new arraylist with type being stage
    
    public final JPanel actionsMenu;
    public final JPanel imageMenu;
    public final JPanel inputMenu;
    public final JLabel dialog;
    public final JLabel stats;
    public final JLabel stats2;
    
    //public BufferedImage errorImage;
    
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
        /*try { this.errorImage = ImageIO.read(new File("resources/unknown.png"));
        } catch(IOException e) { this.errorImage = null; }*/
        this.setVisible(true); //set the visibility of this jframe to true
        Timer timerVar = new Timer(50, this); //ticking timer
        timerVar.start(); //invoke the start method from the timervar
    }
    
    /*public BufferedImage getErrorImage() {
        return this.errorImage;
    }*/
    
    @Override
    public void actionPerformed(ActionEvent e) { //called whenver the timer ticks
        if(getStage() == null) return; //if the stage does not exist, dont do anything
        switch(getStage().incrementVar()) { case 1: this.nextStage(); return; case 2: this.prevStage(); return; default: break; }
        for(Element elementVar : getStage().getElements()) {
        	if(elementVar.getComponent() == null) {
        		if(elementVar instanceof ui.elem.Choice) elementVar.setComponent(actionsMenu);
        		else if(elementVar instanceof ui.elem.Dialog) elementVar.setComponent(dialog);
        		else if(elementVar instanceof ui.elem.Input) elementVar.setComponent(inputMenu);
        		else if(elementVar instanceof ui.elem.Sprite) elementVar.setComponent(imageMenu);
        		else if(elementVar instanceof ui.elem.Stat) elementVar.setComponent(stats);
        		else if(elementVar instanceof ui.elem.OpponentStat) elementVar.setComponent(stats2);
    			elementVar.createElement();
        	} else {
        		if(elementVar instanceof ui.elem.Choice && ((ui.elem.Choice)elementVar).isClicked()) {
        			((ui.elem.Choice)elementVar).setClicked(false);
        			getStage().choiceClicked(elementVar);
        			break;
        		}
        	}
        }
        getStage().decreaseTicks(); //decrease the stage's ticks, 
        getStage().syncElements(); //sync all it's elements
        this.revalidate(); //revalidate this jframe's elements
        this.repaint();
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
        if(currentStage < stageList.size() - 1) currentStage++; //go to the next stage
        getStage().init(); //invoke the init method from the current stage
    }
    
    /**
     * Go back one stage on the list/
     */
    public void prevStage() {
        getStage().removeElements();
        if(currentStage > 0) currentStage--; //go to the previous stage
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
