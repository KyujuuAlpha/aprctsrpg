package ui.elem;

import ui.*;

import javax.swing.*;
import java.awt.*;

public class Choice implements Element {
    private JButton guiElement = null;
    
    private String text;

    public Choice(String stringVar) {
        this.text = stringVar;
        createElement();
        sync();
    }
    
    public String getLabel() {
        return this.text;
    }
    
    public void setLabel(String stringVar) {
        this.text = stringVar;
    }
    
    private void createElement() {
        this.guiElement = new JButton(getLabel());
        this.guiElement.addActionListener(WindowUtilities.getWindowInstance());
        this.guiElement.setAlignmentX(Component.CENTER_ALIGNMENT);
        WindowUtilities.getComponentPanel("choice").add(guiElement);
    }
    
    @Override
    public void sync() {
        this.guiElement.setText(getLabel());
    }
    
    @Override
    public void draw(Stage stageVar) {
        JPanel panelVar = WindowUtilities.getComponentPanel("choice");
        panelVar.revalidate();
        panelVar.repaint();
    }
}
