package ui.elem;

import ui.*;

import javax.swing.*;
import javax.imageio.*;

import java.awt.*;
import java.awt.image.*;

import java.io.*;

public class Dialog implements Element {
    private String text;
    private boolean canSync = false;
    
    private Display gameVar;
    
    public Dialog(String... stringVar) {
        this.text = handleText(stringVar);
    }
    
    @Override
    public void setGameInstance(Display displayVar) {
        gameVar = displayVar;
    }
    
    public String getText() {
        return this.text;
    }
    
    public void setText(String... stringVar) {
        this.text = handleText(stringVar);
    }
    
    public void appendText(String... stringVar) {
        String temp = handleText(stringVar);
        this.text = this.text.replace("</html>", "").replace("<html>", ""); 
        temp = temp.replace("</html>", "").replace("<html>", ""); 
        this.text = "<html>" + this.text + temp + "</html>";
    }
    
    public void replaceText(String stringVar0, String stringVar1) {
        this.text = this.text.replaceAll(stringVar0, stringVar1);
    }
    
    private String handleText(String[] stringVar) {
        String temp = "<html>";
        if(stringVar.length > 1) {
            for(int i = 0; i < stringVar.length - 1; i++) temp += stringVar[i] + "<br>";
            temp += stringVar[stringVar.length - 1];
        } else temp = stringVar[0];
        temp += "</html>";
        return temp;
    }
    
    @Override
    public void createElement(boolean flag) {
        if(flag) canSync = true;
        sync();
    }
    
    @Override
    public void removeElement() {
        ((JLabel)gameVar.getComponent("text")).setText("");
        canSync = false;
    }
    
    @Override
    public void sync() {
        if(canSync) ((JLabel)gameVar.getComponent("text")).setText(this.text);
    }
    
    public void draw(Stage stageVar) {
        JLabel labelVar = (JLabel)gameVar.getComponent("text");
        labelVar.revalidate();
        labelVar.repaint();
    }
}