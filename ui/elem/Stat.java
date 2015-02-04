package ui.elem;

import ui.*;

import javax.swing.*;
import javax.imageio.*;

import java.awt.*;
import java.awt.image.*;

import java.io.*;

public class Stat extends Dialog {
    @Override
    public void removeElement() {
        ((JLabel)gameVar.getComponent("stats")).setText("");
        canSync = false;
    }
    
    @Override
    public void sync() {
        if(canSync) ((JLabel)gameVar.getComponent("stats")).setText(this.text);
    }
    
    @Override
    public void draw(Stage stageVar) {
        JLabel labelVar = (JLabel)gameVar.getComponent("stats");
        labelVar.revalidate();
        labelVar.repaint();
    }
}