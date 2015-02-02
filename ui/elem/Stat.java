package ui.elem;

import ui.*;

import javax.swing.*;
import javax.imageio.*;

import java.awt.*;
import java.awt.image.*;

import java.io.*;

public class Stat implements Element {
    private String text;
    private boolean canSync = false;
    
    public Stat(String... stringVar) {
        handleText(stringVar);
        sync();
    }
    
    public String getText() {
        return this.text;
    }
    
    public void setText(String... stringVar) {
        handleText(stringVar);
        sync();
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
        ((JLabel)Display.getComponent("stats")).setText("");
    }
    
    @Override
    public void sync() {
        if(canSync) ((JLabel)Display.getComponent("stats")).setText(this.text);
    }
    
    public void draw(Stage stageVar) {
        JLabel labelVar = (JLabel)Display.getComponent("stats");
        labelVar.revalidate();
        labelVar.repaint();
    }
}