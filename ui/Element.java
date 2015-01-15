package ui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public abstract class Element {
    public static void sync(Stage stageVar) { }
    
    public static Window getWindowInstance() {
        return Window.getInstance();
    }
    
    public static JPanel getComponentPanel(String type) {
        return Window.getComponentPanel(type);
    }
    
    public static Component[] getComponentArray(String type) {
        return Window.getComponentArray(type);
    }
    
    public static String getTextFromField(int id) {
        return Window.getTextFromField(id);
    }
}
