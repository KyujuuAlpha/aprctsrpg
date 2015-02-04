package ui.elem;

import ui.*;

import javax.swing.*;
import java.awt.*;

import java.awt.event.*;

public class Choice implements Element, ActionListener {
    private Component guiElement;
    private String text;
    private boolean enabled;
    
    private Display gameVar;
    
    public Choice() {
        this.text = "Choice";
        this.enabled = true;
    }

    /**
     * Construct a new choice object;
     * The parameter sets its label
     */
    public Choice(String stringVar) {
        this.text = stringVar;
        this.enabled = true;
    }
    
    @Override
    public void setGameInstance(Display displayVar) {
        gameVar = displayVar;
    }
    
    /**
     * Retrieve the label of this button
     */
    public String getLabel() {
        return this.text;
    }
    
    /**
     * Set a new label for this button
     */
    public void setLabel(String stringVar) {
        this.text = stringVar;
    }
    
    /**
     * Set the label aswell as setting it's enabled state
     */
    public void setLabel(String stringVar, boolean flag) {
        this.text = stringVar;
        this.setEnabled(flag);
    }
    
    /**
     * Set this button to be enabled or not
     */
    public void setEnabled(boolean flag) {
        this.enabled = flag;
    }
    
    /**
     * Check to see if this button is enabled
     */
    public boolean isEnabled() {
        return this.enabled;
    }
    
    @Override
    public void createElement(boolean flag) {
        this.guiElement = new JButton(getLabel());
        JButton temp = (JButton)this.guiElement;
        temp.addActionListener(this);
        temp.setAlignmentX(Component.CENTER_ALIGNMENT);
        if(flag) gameVar.getComponentPanel("choice").add(this.guiElement); sync();
    }
    
    @Override
    public void removeElement() {
        gameVar.getComponentPanel("choice").remove(this.guiElement);
    }
    
    @Override
    public void sync() {
        if(this.guiElement == null) return;
        ((JButton)this.guiElement).setText(this.text);
        ((JButton)this.guiElement).setEnabled(this.enabled);
    }
    
    @Override
    public void draw(Stage stageVar) {
        JPanel panelVar = gameVar.getComponentPanel("choice");
        panelVar.revalidate();
        panelVar.repaint();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(gameVar == null) return;
        else if(gameVar.getStage() == null) return;
        gameVar.getStage().choiceClicked(this);
    }
}
