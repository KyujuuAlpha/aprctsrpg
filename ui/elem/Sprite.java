package ui.elem;

import ui.*;

import javax.swing.*;
import javax.imageio.*;

import java.awt.*;
import java.awt.image.*;

import java.io.*;

public class Sprite implements Element {
    private Component guiElement;
    
    private String url;
    private BufferedImage bufferedImage;
    
    public Sprite(String stringVar) {
        createElement(false);
        setName(stringVar);
    }
    
    public void setName(String stringVar) {
        this.url = stringVar;
        try { this.bufferedImage = ImageIO.read(new File("resources/" + this.url + ".png"));
        } catch(Exception e) { this.bufferedImage = null; }
        sync();
    }
    
    public String getName() {
        return this.url;
    }
    
    public BufferedImage getImage() {
        return bufferedImage;
    }
    
    @Override
    public void createElement(boolean flag) {
        guiElement = new JLabel();
        if(flag) Display.getComponentPanel("image").add(guiElement);
    }
    
    @Override
    public void removeElement() {
        Display.getComponentPanel("image").remove(this.guiElement);
    }
    
    @Override
    public void sync() {
        if(getImage() == null || this.guiElement == null) return;
        JPanel panelVar = Display.getComponentPanel("image");
        ((JLabel)this.guiElement).setIcon(new ImageIcon(getImage().getScaledInstance((int)(panelVar.getHeight() * (getImage().getWidth() / getImage().getHeight())), panelVar.getHeight(), Image.SCALE_FAST)));
    }
    
    @Override
    public void draw(Stage stageVar) {
        JPanel panelVar = Display.getComponentPanel("image");
        panelVar.setLayout(new GridLayout(1, Display.getComponentArray("image").length));
        panelVar.revalidate();
        panelVar.repaint();
    }
}
