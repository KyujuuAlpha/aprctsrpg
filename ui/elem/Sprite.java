package ui.elem;

import javax.swing.*;
import javax.imageio.*;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

public class Sprite implements Element {
	private JPanel container;
    private JLabel guiElement;
    
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
    public void createElement() {
        this.guiElement = new JLabel();
        if(this.container != null) this.container.add(this.guiElement);
    }
    
    @Override
    public void removeElement() {
    	if(this.container != null) this.container.remove(this.guiElement);
    }
    
    @Override
    public Component getComponent() {
    	return this.container;
    }
    
    @Override
    public void setComponent(Component componentVar) {
    	this.container = (JPanel)componentVar;
    }
    
    @Override
    public void sync() {
        if(bufferedImage == null || this.guiElement == null || this.container == null) return;
        this.container.setLayout(new GridLayout(1, this.container.getComponents().length)); //grid layout rock
        if(this.resizable == 1.0f) this.guiElement.setIcon(new ImageIcon(bufferedImage.getScaledInstance(this.container.getHeight() * this.bufferedImage.getWidth() / this.bufferedImage.getHeight(), this.container.getHeight() * this.bufferedImage.getHeight() / this.bufferedImage.getHeight(), Image.SCALE_SMOOTH))); //easy way of displaying an image trough a jlabel instead of messing with graphics
        else if(this.resizable == 0.5f) this.guiElement.setIcon(new ImageIcon(bufferedImage.getScaledInstance(this.container.getWidth() / this.container.getComponents().length * this.bufferedImage.getWidth() / this.bufferedImage.getWidth(), this.container.getWidth() / this.container.getComponents().length * this.bufferedImage.getHeight() / this.bufferedImage.getWidth(), Image.SCALE_SMOOTH)));
        else if(customWidth > 0 && customHeight > 0) this.guiElement.setIcon(new ImageIcon(bufferedImage.getScaledInstance(customWidth, customHeight, Image.SCALE_FAST)));
        else this.guiElement.setIcon(new ImageIcon(bufferedImage));
    }
}
