package ui.elem;

import ui.*;

import javax.swing.*;
import javax.imageio.*;

import java.awt.*;
import java.awt.image.*;

import java.io.*;

public class Dialog implements Element {
    private String text;
    
    public Dialog(String... stringVar) {
        handleText(stringVar);
        syncElement();
    }
    
    public String getText() {
        return this.text;
    }
    
    public void setText(String... stringVar) {
        handleText(stringVar);
        syncElement();
    }
    
    private void handleText(String[] stringVar) {
        if(stringVar.length > 1) {
            this.text = "<html>";
            for(int i = 0; i < stringVar.length; i++) this.text += stringVar[i] + "<br>";
            this.text += "</html>";
        } else this.text = stringVar[0];
    }
    
    private void syncElement() {
        JLabel labelVar = (JLabel)WindowUtilities.getComponent("text");
        labelVar.setText(this.text);
    }
    
    public void draw(Stage stageVar) {
        JLabel labelVar = (JLabel)WindowUtilities.getComponent("text");
        labelVar.revalidate();
        labelVar.repaint();
    }
}