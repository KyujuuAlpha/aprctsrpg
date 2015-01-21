package ui.elem;

import ui.*;

import javax.swing.*;
import javax.imageio.*;

import java.awt.*;
import java.awt.image.*;

import java.io.*;

public class Sprite implements Element {
    private JLabel guiElement = null;
    
    private String url;
    private BufferedImage bufferedImage;
    
    public Sprite(String stringVar) {
        setURL(stringVar);
        createElement();
        sync();
    }
    
    public void setURL(String stringVar) {
        this.url = stringVar;
        try { this.bufferedImage = ImageIO.read(new File("resources/" + this.url + ".png"));
        } catch(Exception e) { this.bufferedImage = null; }
    }
    
    public String getURL() {
        return this.url;
    }
    
    public BufferedImage getImage() {
        return bufferedImage;
    }
    
    private void createElement() {
        guiElement = new JLabel();
        WindowUtilities.getComponentPanel("image").add(guiElement);
    }
    
    @Override
    public void sync() {
        if(getImage() == null) return;
        JPanel panelVar = WindowUtilities.getComponentPanel("image");
        guiElement.setIcon(new ImageIcon(getImage().getScaledInstance(getImage().getWidth() / getImage().getHeight() * panelVar.getHeight(), panelVar.getHeight(), Image.SCALE_FAST)));
    }
    
    @Override
    public void draw(Stage stageVar) {
        JPanel panelVar = WindowUtilities.getComponentPanel("image");
        panelVar.setLayout(new GridLayout(1, WindowUtilities.getComponentArray("image").length));
        panelVar.revalidate();
        panelVar.repaint();
    }
}
