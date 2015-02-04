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
    
    private Display gameVar;
    
    public Sprite(String stringVar) {
        setSource(stringVar);
    }
    
    @Override
    public void setGameInstance(Display displayVar) {
        gameVar = displayVar;
    }
    
    public void setSource(String stringVar) {
        this.url = stringVar;
        try { this.bufferedImage = ImageIO.read(new File("resources/" + this.url));
        } catch(Exception e) { try { this.bufferedImage = ImageIO.read(new File("resources/unknown.png"));
        } catch(Exception e2) { this.bufferedImage = null; } }
    }
    
    public String getSource() {
        return this.url;
    }
    
    public BufferedImage getImage() {
        return bufferedImage;
    }
    
    @Override
    public void createElement(boolean flag) {
        guiElement = new JLabel();
        if(flag) gameVar.getComponentPanel("image").add(guiElement); sync();
    }
    
    @Override
    public void removeElement() {
        gameVar.getComponentPanel("image").remove(this.guiElement);
    }
    
    @Override
    public void sync() {
        if(getImage() == null || this.guiElement == null) return;
        JPanel panelVar = gameVar.getComponentPanel("image");
        ((JLabel)this.guiElement).setIcon(new ImageIcon(getImage().getScaledInstance((int)(panelVar.getHeight() * (getImage().getWidth() / getImage().getHeight())), panelVar.getHeight(), Image.SCALE_FAST)));
    }
    
    @Override
    public void draw(Stage stageVar) {
        JPanel panelVar = gameVar.getComponentPanel("image");
        panelVar.setLayout(new GridLayout(1, gameVar.getComponentArray("image").length));
        panelVar.revalidate();
        panelVar.repaint();
    }
}
