package ui.elem;

import ui.*;

import javax.swing.*;
import javax.imageio.*;

import java.awt.*;
import java.awt.image.*;

import java.io.*;

public class Dialog extends Element {
    private String text;
    
    public Dialog(String stringVar) {
        this.text = stringVar;
    }
    
    public String getText() {
        return this.text;
    }
    
    public static void sync(Stage stageVar) {
        JLabel jL = (JLabel)getComponent("text");
        jL.setText(stageVar.getDialog().getText());
    }
}
