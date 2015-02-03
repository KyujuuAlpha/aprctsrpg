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
        handleText(stringVar);
    }
    
    @Override
    public void setGameInstance(Display displayVar) {
        gameVar = displayVar;
    }
    
    public String getText() {
        return this.text;
    }
    
    public void setText(String... stringVar) {
        handleText(stringVar);
    }
    
    private void handleText(String[] stringVar) {
        if(stringVar.length > 1) {
            this.text = "<html>";
            for(int i = 0; i < stringVar.length; i++) this.text += stringVar[i] + "<br>";
            this.text += "</html>";
        } else this.text = stringVar[0];
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