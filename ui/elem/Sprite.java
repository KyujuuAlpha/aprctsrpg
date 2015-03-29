package ui.elem;

import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Sprite implements Element {
	
	public static final byte NONE = 0;
	public static final byte BOTH = 1;
	public static final byte EAST = 2;
	public static final byte SOUTH = 3;
	
	private int dock = NONE;
	private int changeX = 0;
	private int changeY = 0;

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
    
    public void setDock(byte a) {
    	dock = a;
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
		if((dock == EAST || dock == BOTH) && this.changeX == 0) this.changeX = container.getWidth() - this.x;
		if((dock == SOUTH || dock == BOTH) && this.changeY == 0) this.changeY = container.getHeight() - this.y;
		if(dock == EAST || dock == BOTH) this.x = container.getWidth() - changeX;
		if(dock == SOUTH || dock == BOTH) this.y = container.getHeight() - changeY;
		if(bufferedImage == null) return;
		render.drawImage(bufferedImage.getScaledInstance(width, height, Image.SCALE_FAST), x, y, container);
	}
	
	public void setX(int intX) {
    	this.x = intX;
    }
    
    public void setY(int intY) {
    	this.y = intY;
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
