package ui.elem;

import ui.*;

import javax.swing.*;
import java.awt.*;

public class Input implements Element {
    private JPanel guiElement;
    private JTextField guiElementField = null;
    private JLabel guiElementText = null;
    
    private int size;
    private String name;
    private String text;
    
    private boolean overrideRequest;
    
    private Display gameVar;
    
    public Input() {
        this.size = 6;
        this.name = "TextBox";
        this.text = "";
        this.overrideRequest = false;
    }
    
    /**
     * Construct a new input;
     * Sets the name and the size of the input 
     * @param stringVar The name of the input box
     * @param intVar The number of columns this input box spans
     */
    public Input(String stringVar, int intVar) {
        this.size = intVar;
        this.name = stringVar;
        this.text = "";
        this.overrideRequest = false;
    }
    
    /**
     * Get the current size of this input
     */
    public int getSize() {
        return this.size;
    }
    
    /**
     * Set the current size of this input
     * @param intVar The number of columns this input box spans
     */
    public void setSize(int intVar) {
        this.size = intVar;
    }
    
    /**
     * Get the name of this input
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Set the name of this input
     * @param stringVar The name of the input box
     */
    public void setName(String stringVar) {
        this.name = stringVar;
    }
    
    /**
     * Get the current text of this input
     */
    public String getText() {
        if(this.guiElementField == null) return this.text;
        this.text = this.guiElementField.getText();
        return this.guiElementField.getText();
    }
    
    /**
     * Set the current text of this input
     * @param stringVar The text inside of the input box
     */
    public void setText(String stringVar) {
        this.text = stringVar;
        this.overrideRequest = true; //request to override the text in the text field instead of retrieving from it next sync
    }
    
    @Override
    public void createElement() {
        this.guiElementField = new JTextField(getSize());
        this.guiElementField.setText(this.text);
        this.guiElementText = new JLabel(getName() + ": ");
        this.guiElement = new JPanel();
        this.guiElement.setLayout(new FlowLayout(FlowLayout.LEFT)); //set the layout of the container holding the text field and label
        this.guiElement.setMaximumSize(new Dimension(Integer.MAX_VALUE, (int)this.guiElementField.getPreferredSize().getHeight() + 10)); //stretch the actual text field
        this.guiElement.add(this.guiElementText);
        this.guiElement.add(this.guiElementField);
        this.overrideRequest = false;
        if(this.gameVar != null) this.gameVar.inputMenu.add(this.guiElement);
    }
    
    @Override
    public void removeElement() {
        this.gameVar.inputMenu.remove(this.guiElement);
    }
    
    @Override
    public void sync() {
        if(this.guiElement == null) return;
        if(this.overrideRequest) this.guiElementField.setText(this.text); //set the text if the override is requested
        else this.text = this.guiElementField.getText(); //retrieve instead if it is not
        this.guiElementField.setColumns(getSize());
        this.guiElementText.setText(this.name + ": ");
        this.overrideRequest = false;
    }
    
    @Override
    public void setGameInstance(Display displayVar) {
        this.gameVar = displayVar;
    }
}
