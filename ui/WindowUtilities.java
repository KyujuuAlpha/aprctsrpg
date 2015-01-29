package ui;

import ui.elem.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public abstract class WindowUtilities {
    public static Window getWindowInstance() {
        return Window.getInstance();
    }

    public static Component getComponent(String type) {
        switch(type) {
            case "choice": return Window.actionsMenu;
            case "image": return Window.imageMenu;
            case "input": return Window.inMenu;
            case "text": return Window.dialog;
            case "stats": return Window.stats;
            case "stats2": return Window.stats2;
            default: return null;
        }
    }
    
    public static JPanel getComponentPanel(String type) {
       if(type == "text" || type == "stats" || type == "stats2") return null;
       return (JPanel)getComponent(type);
    }
    
    public static Component[] getComponentArray(String type) {
        if(type == "text" || type == "stats" || type == "stats2") return null;
        return getComponentPanel(type).getComponents();
    }
}
