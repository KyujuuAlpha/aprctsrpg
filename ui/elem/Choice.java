package ui.elem;

import ui.*;

import javax.swing.*;

import java.awt.event.*;

public class Choice implements Element, ActionListener {
    private JButton guiElement; //the gui counter part of this element
    
    private String text; //internal data that holds the element's name
    private boolean enabled; //whether the current button is enabled or not
    
    private Display gameVar; //the instance of the display
    
    public Choice() { //the default constructor if no parameters are passed
        this.text = "Choice"; //iniialize the internal data of this element
        this.enabled = true;
    }

    /**
     * Construct a new choice object;
     * The parameter sets its label
     */
    public Choice(String stringVar) {
        this.text = stringVar; //initialize by setting it to the parameter
        this.enabled = true;
    }
    
    /**
     * Retrieve the label of this button
     */
    public String getLabel() {
        return this.text; //access the label of this button element
    }
    
    /**
     * Set a new label for this button
     */
    public void setLabel(String stringVar) {
        this.text = stringVar; //set the label of this button element
    }
    
    /**
     * Set the label aswell as setting it's enabled state
     */
    public void setLabel(String stringVar, boolean flag) {
        this.text = stringVar; //set the label as well as it's enabled state
        this.setEnabled(flag);
    }
    
    /**
     * Set this button to be enabled or not
     */
    public void setEnabled(boolean flag) {
        this.enabled = flag; //set whether this button is enabled or not
    }
    
    /**
     * Check to see if this button is enabled
     */
    public boolean isEnabled() {
        return this.enabled; //return whether this button is enabled or note
    }
    
    @Override
    public void createElement() {
        this.guiElement = new JButton(getLabel()); //initialze the actual gui element
        this.guiElement.addActionListener(this); //add this object as its action listener
        if(this.gameVar != null) this.gameVar.actionsMenu.add(this.guiElement); //actually add it to the display if it exists
    }
    
    @Override
    public void removeElement() {
        this.gameVar.actionsMenu.remove(this.guiElement); //remove the element from the display
    }
    
    @Override
    public void sync() {
        if(this.guiElement == null) return; //skip if the gui element was never created
        this.guiElement.setText(this.text); //pass the internal data of this element to the gui counter part
        this.guiElement.setEnabled(this.enabled);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) { //basically call the choice clicked method when if this button is activated
        if(this.gameVar == null) return;
        else if(this.gameVar.getStage() == null) return;
        this.gameVar.getStage().choiceClicked(this);
    }
    
    @Override
    public void setGameInstance(Display displayVar) { 
        this.gameVar = displayVar; //set the display instance for this element
    }
}
