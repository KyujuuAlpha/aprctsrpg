package ui;

import ui.elem.*;

import javax.swing.*;

public class SpritePanel extends JPanel {
    @Override
    public void repaint() {
        if(Window.getComponentPanel("image") != null) Sprite.sync(Stage.getStage());
        super.revalidate();
        super.repaint();
    }
}