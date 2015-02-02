package ui.elem;

import ui.*;

import javax.swing.*;

import java.awt.Component;

public interface Element {
    public void draw(Stage stageVar);
    public void sync();
    public void createElement(boolean flag);
    public void removeElement();
}
