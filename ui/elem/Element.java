package ui.elem;

import java.awt.Container;
import java.awt.Graphics2D;

public interface Element {
    public void updateElement(Container container);
    public void drawElement(Graphics2D render, Container container);
}
