package ui.elem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Sprite extends DockedElement implements Element {

    private BufferedImage bufferedImage;
    
    private Stroke imageStroke = null;
    private Paint strokeColor = Color.BLACK;
    
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
    
    public Sprite(int intX, int intY, int intWidth, int intHeight) {
        x = intX;
        y = intY;
        width = intWidth;
        height = intHeight;
    }
    
    public Sprite(BufferedImage image, int intX, int intY) {
        x = intX;
        y = intY;
        bufferedImage = image;
        if(bufferedImage != null) {
        	width = bufferedImage.getWidth();
        	height = bufferedImage.getHeight();
        }
    }
    
    public Sprite(BufferedImage image, int intX, int intY, int intWidth, int intHeight) {
        bufferedImage = image;
        x = intX;
        y = intY;
        width = intWidth;
        height = intHeight;
    }
    
    public Sprite setAnchor(byte dock2) {
    	this.setDock(dock2);
    	return this;
    }
    
    public void setStroke(Stroke stroke, Paint paint) {
    	imageStroke = stroke;
    	strokeColor = paint;
    }
    
    public void setImage(BufferedImage image) {
    	bufferedImage = image;
    }
    
    public Sprite(String stringVar, int intX, int intY, int intWidth, int intHeight) {
        setSource(stringVar);
        x = intX;
        y = intY;
        width = intWidth;
        height = intHeight;
    }

    public void setSource(String stringVar) {
        try { this.bufferedImage = ImageIO.read(new File("resources/" + stringVar)); //try to find if the resource exists
        } catch(Exception e) { this.bufferedImage = null; }
    }

    @Override
	public void updateElement(Container container) {
	}

	@Override
	public void drawElement(Graphics2D render, Container container) {
		updateDock(container);
		if(bufferedImage == null) return;
		if(imageStroke != null) {
			Stroke oldStroke = render.getStroke();
			render.setPaint(strokeColor);
			render.setStroke(imageStroke);
			render.draw(new Rectangle(x, y, width, height));
			render.setStroke(oldStroke);
		}
		render.drawImage(bufferedImage.getScaledInstance(width, height, Image.SCALE_FAST), x, y, container);
	}
}
