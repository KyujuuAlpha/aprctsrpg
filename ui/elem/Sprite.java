package ui.elem;

import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Sprite implements Element {

    private String url;
    private BufferedImage bufferedImage;
    
    private double resizable = 0.0f;
    
    private int customWidth = 0;
    private int customHeight = 0;
    
    public Sprite() {
        setSource("");
        this.resizable = 1.0f;
    }
    
    /**
     * Create a new sprite element
     * Sets the target resource to specified image
     * @param stringVar The resource file in the resources/ directory
     */
    public Sprite(String stringVar) {
        setSource(stringVar);
        this.resizable = 1.0f;
    }
    
    public Sprite(String stringVar, float f) {
        setSource(stringVar);
        this.resizable = f;
    }
    
    /**
     * Set if the image should expand to the height of it's container
     * @param flag Whether this sprite resizes with the window's height
     */
    public void setResizable(boolean flag) {
        if(flag) this.resizable = 1.0f;
        else this.resizable = 0.0f;
    }
    
    /**
     * Set if the image should expand to the height of it's container
     * @param flag Whether this sprite resizes with the containers height: 1.0f, width: 0.5f; or none: 0.0f;
     */
    public void setResizable(float f) {
        this.resizable = Math.round(f / 0.5f) * 0.5f;
    }
    
    /**
     * Check if the image is resizable
     */
    public boolean isResizable() {
        return this.resizable > 0.0f;
    }
    
    /**
     * Sets the target resource to specified image
	 * @param stringVar The resource file in the resources/ directory
     */
    public void setSource(String stringVar) {
        this.url = stringVar;
        try { this.bufferedImage = ImageIO.read(new File("resources/" + this.url)); //try to find if the resource exists
        } catch(Exception e) { this.bufferedImage = null; }
    }
    
    /**
     * Get the target resource's name
     */
    public String getSource() {
        return this.url; //dont actually return the buffered image
    }
    
    /**
     * Set a custom size for this sprite
     */
    public void setSize(int intVar0, int intVar1) {
    	customWidth = intVar0;
    	customHeight = intVar1;
    }
    @Override
	public void updateElement(Container container) {

	}

	@Override
	public void drawElement(Graphics2D render, Container container) {

	}
}
