package ui.elem;

import ui.*;

import javax.swing.*;

import java.awt.Component;

public interface Element {
    public void sync();
    public void createElement();
    public void removeElement();
    public void setGameInstance(Display displayVar);
}
