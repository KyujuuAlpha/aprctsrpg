package ui;

import javax.swing.*;
import javax.imageio.*;

import java.awt.*;
import java.awt.image.*;

import java.io.*;

public class Sprite {
    private String url;
    
    public Sprite(String stringVar) {
        this.url = stringVar;
    }
    
    public String getURL() {
        return this.url;
    }
    
    public static void sync(Stage stageVar) {
        JPanel panelVar = Window.getComponentPanel("image");
        if(stageVar.getSprites() == null) return;
        else panelVar.removeAll();
        panelVar.setLayout(new GridLayout(1, stageVar.getSprites().length));
        for(int i = 0; i < stageVar.getSprites().length; i++) {
            if(stageVar.getSprites()[i].getURL().length() < 1) continue;
            JLabel jl = new JLabel();
            BufferedImage bufferedImage;
            try { bufferedImage = ImageIO.read(new File("resources/" + stageVar.getSprites()[i].getURL() + ".png"));
            } catch(Exception e) { bufferedImage = null; }
            Image image = bufferedImage.getScaledInstance(bufferedImage.getWidth() / bufferedImage.getHeight() * panelVar.getHeight(), panelVar.getHeight(), Image.SCALE_FAST);
            jl.setIcon(new ImageIcon(image));
            panelVar.add(jl);
        }
    }
}
