package ui.elem;

import ui.*;

import javax.swing.*;
import javax.imageio.*;

import java.awt.*;
import java.awt.image.*;

import java.io.*;

public class Stat extends Dialog {
    /**
     * Create a new stat element
     * Set the stat's contents to specified text
     * (ALERT) for multiliners, add another parameter: new Stat("Line1, "Line2");
     */
    public Stat(String... stringVar) {
        super(stringVar);
    }
    
    @Override
    public void removeElement() {
        gameVar.stats.setText("");
        canSync = false;
    }
    
    @Override
    public void sync() {
        if(canSync) gameVar.stats.setText(this.text);
    }
}