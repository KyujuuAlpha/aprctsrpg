package ui.elem;

import ui.*;

import javax.swing.*;
import javax.imageio.*;

import java.awt.*;
import java.awt.image.*;

import java.io.*;

public class OpponentStat extends Dialog {
    private String text;
    private boolean canSync = false;
    
    private Display gameVar;
    
    @Override
    public void removeElement() {
        ((JLabel)gameVar.getComponent("stats2")).setText("");
        canSync = false;
    }
    
    @Override
    public void sync() {
        if(canSync) ((JLabel)gameVar.getComponent("stats2")).setText(this.text);
    }
    
    public void draw(Stage stageVar) {
        JLabel labelVar = (JLabel)gameVar.getComponent("stats2");
        labelVar.revalidate();
        labelVar.repaint();
    }
}