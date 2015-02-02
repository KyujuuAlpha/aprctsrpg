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
    
    public Input(String stringVar, int intVar) {
        this.size = intVar;
        this.name = stringVar;
        this.text = "";
        createElement(false);
        sync();
    }
    
    public int getSize() {
        return this.size;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getText() {
        this.text = this.guiElementField.getText();
        return this.guiElementField.getText();
    }
    
    public void setName(String stringVar) {
        this.name = stringVar;
        sync();
    }
    
    public void setText(String stringVar) {
        this.guiElementField.setText(stringVar);
        sync();
    }
    
    public void setSize(int intVar) {
        this.size = intVar;
        sync();
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
        if(flag) Display.getComponentPanel("input").add(this.guiElement);
    }
    
    @Override
    public void removeElement() {
        Display.getComponentPanel("input").remove(this.guiElement);
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
        JPanel panelVar = Display.getComponentPanel("input");
        panelVar.revalidate();
        panelVar.repaint();
    }
}
