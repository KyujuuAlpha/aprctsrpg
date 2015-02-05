package ui.elem;

import ui.*;

import javax.swing.*;
import java.awt.*;

import java.awt.event.*;

public class Choice implements Element, ActionListener {
    private JButton guiElement;
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
    public void createElement() {
        this.guiElement = new JButton(getLabel());
        this.guiElement.addActionListener(this);
        if(this.gameVar != null) this.gameVar.actionsMenu.add(this.guiElement); sync();
    }
    
    @Override
    public void removeElement() {
        this.gameVar.actionsMenu.remove(this.guiElement);
    }
    
    @Override
    public void sync() {
        if(this.guiElement == null) return;
        this.guiElement.setText(this.text);
        this.guiElement.setEnabled(this.enabled);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.gameVar == null) return;
        else if(this.gameVar.getStage() == null) return;
        this.gameVar.getStage().choiceClicked(this);
    }
    
    @Override
    public void setGameInstance(Display displayVar) {
        this.gameVar = displayVar;
    }
}
