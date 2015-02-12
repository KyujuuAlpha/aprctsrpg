package ui.elem;

import ui.*;

import javax.swing.*;
import javax.imageio.*;

import java.awt.*;
import java.awt.image.*;

import java.io.*;

public class Sprite implements Element {
    private JLabel guiElement;
    
    private String url;
    private BufferedImage bufferedImage;
    
    private Display gameVar;
    
    private boolean resizable;
    
    public Sprite() {
        setSource("");
        this.resizable = true;
    }
    
    /**
     * Create a new sprite element
     * Sets the target resource to specified image located in the resources/ directory: new Sprite("troi.png");
     */
    public Sprite(String stringVar) {
        setSource(stringVar);
        this.resizable = true;
    }
    
    /**
     * Set if the image should expand to the height of it's container
     */
    public void setResizable(boolean flag) {
        this.resizable = flag;
    }
    
    /**
     * Check if the image is resizable
     */
    public boolean isResizable() {
        return this.resizable;
    }
    
    /**
     * Sets the target resource to specified image located in the resources/ directory: spriteVar.setSource("troi.png");
     */
    public void setSource(String stringVar) {
        this.url = stringVar;
        try { this.bufferedImage = ImageIO.read(new File("resources/" + this.url)); //try to find if the resource exists
        } catch(Exception e) { this.bufferedImage = gameVar.getErrorImage(); }
    }
    
    /**
     * Get the target resource's name
     */
    public String getSource() {
        return this.url; //dont actually return the buffered image
    }
    
    @Override
    public void createElement() {
        this.guiElement = new JLabel();
        if(this.gameVar != null) this.gameVar.imageMenu.add(this.guiElement);
    }
    
    @Override
    public void removeElement() {
        gameVar.imageMenu.remove(this.guiElement);
    }
    
    @Override
    public void sync() {
        if(bufferedImage == null || this.guiElement == null) return;
        JPanel panelVar = gameVar.imageMenu;
        panelVar.setLayout(new GridLayout(1, panelVar.getComponents().length)); //grid layout rock
        if(this.resizable) this.guiElement.setIcon(new ImageIcon(bufferedImage.getScaledInstance((int)(panelVar.getHeight() * (bufferedImage.getWidth() / bufferedImage.getHeight())), panelVar.getHeight(), Image.SCALE_FAST))); //easy way of displaying an image trough a jlabel instead of messing with graphics
        else this.guiElement.setIcon(new ImageIcon(bufferedImage));
    }
    
    @Override
    public void setGameInstance(Display displayVar) {
        this.gameVar = displayVar;
    }
}
