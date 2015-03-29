package ui.elem;

import java.awt.Container;

public abstract class DockedElement {
	
	public static final byte NONE = 0;
	public static final byte BOTH = 1;
	public static final byte EAST = 2;
	public static final byte SOUTH = 3;
	public static final byte CENTER = 4;
	
	private int dock = NONE;
	private int changeX = 0;
	private int changeY = 0;
	
	protected int x;
	protected int y;
	
	protected int width;
	protected int height;
	
	public void setX(int intX) {
		x = intX;
	}
	
	public void setY(int intY) {
		y = intY;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setWidth(int intWidth) {
		width = intWidth;
	}
	
	public void setHeight(int intHeight) {
		height = intHeight;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setDock(byte a) {
    	dock = a;
    }
	
	protected void updateDock(Container containerVar) {
		if((dock == EAST || dock == BOTH) && this.changeX == 0) this.changeX = containerVar.getWidth() - this.x;
		if((dock == SOUTH || dock == BOTH) && this.changeY == 0) this.changeY = containerVar.getHeight() - this.y;
		if(dock == EAST || dock == BOTH) this.x = containerVar.getWidth() - changeX;
		if(dock == SOUTH || dock == BOTH) this.y = containerVar.getHeight() - changeY;
		if(dock == CENTER) this.x = containerVar.getWidth() / 2 - width / 2;
	}
}
