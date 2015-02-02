package ui.elem;

import ui.*;

import javax.swing.*;
import java.awt.*;

public class Choice implements Element {
    private Component guiElement;
    private String text;

    public Choice(String stringVar) {
        this.text = stringVar;
        createElement(false);
        sync();
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
    
    @Override
    public void createElement(boolean flag) {
        this.guiElement = new JButton(getLabel());
        JButton temp = (JButton)this.guiElement;
        temp.addActionListener(Display.getInstance());
        temp.setAlignmentX(Component.CENTER_ALIGNMENT);
        if(flag) Display.getComponentPanel("choice").add(this.guiElement);
    }
    
    @Override
    public void removeElement() {
        Display.getComponentPanel("choice").remove(this.guiElement);
    }
    
    @Override
    public void sync() {
        if(this.guiElement == null) return;
        ((JButton)this.guiElement).setText(getLabel());
    }
    
    @Override
    public void draw(Stage stageVar) {
        JPanel panelVar = Display.getComponentPanel("choice");
        panelVar.revalidate();
        panelVar.repaint();
    }
}
