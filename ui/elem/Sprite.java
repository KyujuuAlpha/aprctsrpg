package ui.elem;

import ui.*;

import javax.swing.*;
import javax.imageio.*;

import java.awt.*;
import java.awt.image.*;

import java.io.*;

public class Sprite implements Element {
    private String url;
    private BufferedImage bufferedImage;
    
    public Sprite(String stringVar) {
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
    
    public void draw(Stage stageVar) {
        /*JPanel panelVar = getComponentPanel("image");
        if(stageVar.getSprites() == null) return;
        else panelVar.removeAll();
        panelVar.setLayout(new GridLayout(1, stageVar.getSprites().length));
        for(int i = 0; i < stageVar.getSprites().length; i++) {
            if(stageVar.getSprites()[i].getURL().length() < 1) continue;
            JLabel jl = new JLabel();
            BufferedImage bufferedImage2 = stageVar.getSprites()[i].getImage();
            if(bufferedImage2 == null) continue;
            jl.setIcon(new ImageIcon(bufferedImage2.getScaledInstance(bufferedImage2.getWidth() / bufferedImage2.getHeight() * panelVar.getHeight(), panelVar.getHeight(), Image.SCALE_FAST)));
            panelVar.add(jl);
        }*/
    }
}
