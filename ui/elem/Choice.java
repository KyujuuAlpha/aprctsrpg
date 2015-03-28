package ui.elem;

import java.awt.Graphics2D;

public class Choice implements Element {
	
	private String text; //internal data that holds the element's name
    private boolean enabled; //whether the current button is enabled or not
    
    private boolean clickedVar;
    
    private String tooltip;
    
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
    
    public void setToolTip(String stringVar) {
    	tooltip = stringVar;
    }
    
    public String getToolTip() {
    	return tooltip;
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
   
    public boolean isClicked() {
    	return clickedVar; //let other classes see if this button is clicked or not!
    }
    
    public void setClicked(boolean flag) {
    	clickedVar = flag;
    }
    
	@Override
	public void updateElement() {
	}

	@Override
	public void drawElement(Graphics2D render) {
	}
}
