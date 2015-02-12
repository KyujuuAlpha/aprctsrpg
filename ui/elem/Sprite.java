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
    
    public Sprite() {
        setSource("");
    }
    
    /**
     * Create a new sprite element
     * Sets the target resource to specified image located in the resources/ directory: new Sprite("troi.png");
     */
    public Sprite(String stringVar) {
        setSource(stringVar);
    }
    
    /**
     * Sets the target resource to specified image located in the resources/ directory: spriteVar.setSource("troi.png");
     */
    public void setSource(String stringVar) {
        this.url = stringVar;
        try { this.bufferedImage = ImageIO.read(new File("resources/" + this.url));
        } catch(Exception e) { try { this.bufferedImage = ImageIO.read(new File("resources/unknown.png"));
        } catch(Exception e2) { this.bufferedImage = null; } }
    }
    
    /**
     * Get the target resource's name
     */
    public String getSource() {
        return this.url;
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
        panelVar.setLayout(new GridLayout(1, panelVar.getComponents().length));
        this.guiElement.setIcon(new ImageIcon(bufferedImage.getScaledInstance((int)(panelVar.getHeight() * (bufferedImage.getWidth() / bufferedImage.getHeight())), panelVar.getHeight(), Image.SCALE_FAST)));
    }
    
    @Override
    public void setGameInstance(Display displayVar) {
        this.gameVar = displayVar;
    }
}
