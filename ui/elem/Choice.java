package ui.elem;

import ui.*;

import javax.swing.*;
import java.awt.*;

public class Choice implements Element {
    private JButton guiElement = null;
    private String text;

    public Choice(String stringVar) {
        this.text = stringVar;
        syncElement();
        WindowUtilities.getComponentPanel("choice").add(guiElement);
    }
    
    public String getLabel() {
        return this.text;
    }
    
    public void setLabel(String stringVar) {
        this.text = stringVar;
    }
    
    private void syncElement() {
        this.guiElement = new JButton(getLabel());
        this.guiElement.addActionListener(WindowUtilities.getWindowInstance());
        this.guiElement.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
    
    @Override
    public void draw(Stage stageVar) {
        JPanel panelVar = WindowUtilities.getComponentPanel("choice");
        panelVar.revalidate();
        panelVar.repaint();
    }
}
