package ui.elem;

import ui.*;

import javax.swing.*;
import javax.imageio.*;

import java.awt.*;
import java.awt.image.*;

import java.io.*;

public class OpponentStat extends Dialog {
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