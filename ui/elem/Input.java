package ui.elem;

import ui.*;

import javax.swing.*;
import java.awt.*;

public class Input implements Element {
    private JTextField guiElement = null;
    private JLabel guiElementText = null;
    
    private int size;
    private String name;
    
    public Input(String stringVar, int intVar) {
        this.size = intVar;
        this.name = stringVar;
        createElement();
        sync();
    }
    
    public int getSize() {
        return this.size;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getText() {
        return this.guiElement.getText();
    }
    
    private void createElement() {
        this.guiElement = new JTextField(getSize());
        this.guiElementText = new JLabel(getName() + ": ");
        JPanel temp = new JPanel();
        temp.setLayout(new FlowLayout(FlowLayout.LEFT));
        temp.add(this.guiElementText);
        temp.setMaximumSize(new Dimension(Integer.MAX_VALUE, (int)this.guiElement.getPreferredSize().getHeight() + 10));
        temp.add(this.guiElement);
        WindowUtilities.getComponentPanel("input").add(temp);
    }
    
    @Override
    public void sync() {
        this.guiElement.setColumns(getSize());
        this.guiElementText.setText(getName() + ": ");
    }
    
    @Override
    public void draw(Stage stageVar) {
        JPanel panelVar = WindowUtilities.getComponentPanel("input");
        panelVar.revalidate();
        panelVar.repaint();
    }
}
