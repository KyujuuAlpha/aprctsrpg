package ui.elem;

import ui.*;

import javax.swing.*;
import java.awt.*;

public class Input implements Element {
    private Component guiElement;
    private JTextField guiElementField = null;
    private JLabel guiElementText = null;
    
    private int size;
    private String name;
    private String text;
    
    private Display gameVar;
    
    public Input() {
        this.size = 6;
        this.name = "TextBox";
        this.text = "";
    }
    
    /**
     * Construct a new input;
     * Sets the name and the size of the input 
     */
    public Input(String stringVar, int intVar) {
        this.size = intVar;
        this.name = stringVar;
        this.text = "";
    }
    
    /**
     * Get the current size of this input
     */
    public int getSize() {
        return this.size;
    }
    
    /**
     * Set the current size of this input
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
     */
    public void setText(String stringVar) {
        this.text = stringVar;
        if(this.guiElementField == null) return;
        this.guiElementField.setText(stringVar);
    }
    
    @Override
    public void createElement(boolean flag) {
        this.guiElementField = new JTextField(getSize());
        this.guiElementField.setText(this.text);
        this.guiElementText = new JLabel(getName() + ": ");
        this.guiElement = new JPanel();
        JPanel temp = ((JPanel)this.guiElement);
        temp.setLayout(new FlowLayout(FlowLayout.LEFT));
        temp.add(this.guiElementText);
        temp.setMaximumSize(new Dimension(Integer.MAX_VALUE, (int)this.guiElementField.getPreferredSize().getHeight() + 10));
        temp.add(this.guiElementField);
        if(flag) gameVar.getComponentPanel("input").add(this.guiElement); sync();
    }
    
    @Override
    public void removeElement() {
        gameVar.getComponentPanel("input").remove(this.guiElement);
    }
    
    @Override
    public void sync() {
        if(this.guiElement == null) return;
        this.text = this.guiElementField.getText();
        this.guiElementField.setColumns(getSize());
        this.guiElementText.setText(getName() + ": ");
    }
    
    @Override
    public void draw(Stage stageVar) {
        JPanel panelVar = gameVar.getComponentPanel("input");
        panelVar.revalidate();
        panelVar.repaint();
    }
    
    @Override
    public void setGameInstance(Display displayVar) {
        gameVar = displayVar;
    }
}
