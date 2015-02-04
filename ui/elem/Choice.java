package ui.elem;

import ui.*;

import javax.swing.*;
import java.awt.*;

public class Choice implements Element {
    private Component guiElement;
    private String text;
    
    private Display gameVar;

    public Choice(String stringVar) {
        this.text = stringVar;
    }
    
    @Override
    public void setGameInstance(Display displayVar) {
        gameVar = displayVar;
    }
    
    public String getLabel() {
        return this.text;
    }
    
    public void setLabel(String stringVar) {
        this.text = stringVar;
    }
    
    public void setLabel(String stringVar, boolean flag) {
        this.text = stringVar;
        this.setEnabled(flag);
    }
    
    public void setEnabled(boolean flag) {
        ((JButton)guiElement).setEnabled(flag);
    }
    
    public boolean isEnabled() {
        return ((JButton)guiElement).isEnabled();
    }
    
    @Override
    public void createElement(boolean flag) {
        this.guiElement = new JButton(getLabel());
        JButton temp = (JButton)this.guiElement;
        temp.addActionListener(gameVar);
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
        ((JButton)this.guiElement).setText(getLabel());
    }
    
    @Override
    public void draw(Stage stageVar) {
        JPanel panelVar = gameVar.getComponentPanel("choice");
        panelVar.revalidate();
        panelVar.repaint();
    }
}
