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
    
    public Input(String stringVar, int intVar) {
        this.size = intVar;
        this.name = stringVar;
        this.text = "";
    }
    
    @Override
    public void setGameInstance(Display displayVar) {
        gameVar = displayVar;
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
    }
    
    public void setText(String stringVar) {
        this.guiElementField.setText(stringVar);
    }
    
    public void setSize(int intVar) {
        this.size = intVar;
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
}
