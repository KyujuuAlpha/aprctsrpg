package ui.elem;

import ui.*;

import javax.swing.*;

import java.awt.Component;

public interface Element {
    public final int priority = 0;
    
    public void draw(Stage stageVar);
    public void sync();
}
