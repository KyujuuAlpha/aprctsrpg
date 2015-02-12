package ui.elem;

import ui.*;

import javax.swing.*;
import javax.imageio.*;

import java.awt.*;
import java.awt.image.*;

import java.io.*;

public class OpponentStat extends Dialog { //inherit all methods from the dialog class
    /**
     * Create a new opponent stat element
     * Set the stat's contents to specified text
     * (ALERT) for multiliners, add another parameter: new OpponentStat("Line1, "Line2");
     */
    public OpponentStat(String... stringVar) {
        super(stringVar); //call the constructor of the parent class
    }
    
    @Override
    public void removeElement() {
        gameVar.stats2.setText("");
        canSync = false;
    }
    
    @Override
    public void sync() {
        if(canSync) gameVar.stats2.setText(this.text);
    }
}