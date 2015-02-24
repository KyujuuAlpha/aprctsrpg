package ui.elem;

import javax.swing.*;

import java.awt.Component;
import java.awt.event.*;

public class Choice implements Element, ActionListener {
	private JPanel container;
    private JButton guiElement; //the gui counter part of this element
    
    private String text; //internal data that holds the element's name
    private boolean enabled; //whether the current button is enabled or not
    
    private boolean clickedVar;
    
    public Choice() { //the default constructor if no parameters are passed
        this.text = "Choice"; //iniialize the internal data of this element
        this.enabled = true;
    }

    /**
     * Construct a new choice object
     * @param stringVar The text displayed inside of the button
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
     * @param stringVar The text inside of the button
     */
    public void setLabel(String stringVar) {
        this.text = stringVar; //set the label of this button element
    }
    
    /**
     * Set the label aswell as setting it's enabled state
     * @param stringVar The text inside of the button
     * @param flag Whether this button is enabled or not
     */
    public void setLabel(String stringVar, boolean flag) {
        this.text = stringVar; //set the label as well as it's enabled state
        this.setEnabled(flag);
    }
    
    /**
     * Set this button to be enabled or not
     * @param flag Whether this button is enabled or not
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
        if(this.container != null) this.container.add(this.guiElement);
   }
    
    @Override
    public void removeElement() {
    	if(this.container != null) this.container.remove(this.guiElement);
    }
    
    @Override
    public void sync() {
        if(this.guiElement == null) return; //skip if the gui element was never created
        this.guiElement.setText(this.text); //pass the internal data of this element to the gui counter part
        this.guiElement.setEnabled(this.enabled);
    }
    
    @Override
    public Component getComponent() {
    	return this.container;
    }
    
    @Override
    public void setComponent(Component componentVar) {
    	this.container = (JPanel)componentVar;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) { //basically call the choice clicked method when if this button is activated
        if(this.guiElement != null && this.container != null) {
        	this.clickedVar = true; //this button is actually clicked now :)
        }
    }
    
    public boolean isClicked() {
    	return clickedVar; //let other classes see if this button is clicked or not!
    }
    
    public void setClicked(boolean flag) {
    	clickedVar = flag;
    }
}
