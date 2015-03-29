package ui.elem;

import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Sprite implements Element {

    private String url;
    private BufferedImage bufferedImage;
    
    private int x = 0;
    private int y = 0;
    private int width = 0;
    private int height = 0;
    
    public Sprite() {
        setSource("");
    }
    
    public Sprite(String stringVar, int intX, int intY) {
        setSource(stringVar);
        x = intX;
        y = intY;
        if(bufferedImage != null) {
        	width = bufferedImage.getWidth();
        	height = bufferedImage.getHeight();
        }
    }
    
    public Sprite(String stringVar, int intX, int intY, int intWidth, int intHeight) {
        setSource(stringVar);
        x = intX;
        y = intY;
        width = intWidth;
        height = intHeight;
    }

    public void setSource(String stringVar) {
        this.url = stringVar;
        try { this.bufferedImage = ImageIO.read(new File("resources/" + this.url)); //try to find if the resource exists
        } catch(Exception e) { this.bufferedImage = null; }
    }
   
    public String getSource() {
        return this.url;
    }
    
    public void setSize(int intWidth, int intHeight) {
    	width = intWidth;
    	height = intHeight;
    }

    @Override
	public void updateElement(Container container) {
	}

	@Override
	public void drawElement(Graphics2D render, Container container) {
		if(bufferedImage == null) return;
		render.drawImage(bufferedImage.getScaledInstance(width, height, Image.SCALE_FAST), x, y, container);
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
}
