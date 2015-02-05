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
        gameVar.stats.setText("");
        canSync = false;
    }
    
    @Override
    public void sync() {
        if(canSync) gameVar.stats.setText(this.text);
    }
}