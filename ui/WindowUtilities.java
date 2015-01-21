package ui;

import ui.elem.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public abstract class WindowUtilities {
    public static Window getWindowInstance() {
        return Window.getInstance();
    }
    
    public static void clearAllComponents() {
        Window.actionsMenu.removeAll();
        Window.imageMenu.removeAll();
        Window.inMenu.removeAll();
    }
    
    public static Component getComponent(String type) {
        switch(type) {
            case "choice": return Window.actionsMenu;
            case "image": return Window.imageMenu;
            case "input": return Window.inMenu;
            case "text": return Window.dialog;
            default: return null;
        }
    }
    
    public static JPanel getComponentPanel(String type) {
       if(type == "text") return null;
       return (JPanel)getComponent(type);
    }
    
    public static Component[] getComponentArray(String type) {
        if(type == "text") return null;
        return getComponentPanel(type).getComponents();
    }
}
