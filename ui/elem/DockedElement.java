package ui.elem;

import java.awt.Container;

public abstract class DockedElement {
	
	public static final byte NONE = 0;
	public static final byte BOTH = 1;
	public static final byte EAST = 2;
	public static final byte SOUTH = 3;
	public static final byte CENTER = 4;
	public static final byte CENTER_SOUTH = 5;
	public static final byte TRUE_CENTER = 6;
	
	private int dock = NONE;
	private int changeX = 0;
	private int changeY = 0;
	
	protected int x;
	protected int y;
	
	protected int width;
	protected int height;
	
	public void setX(int intX) {
		x = intX;
		this.changeX = 0;
	}
	
	public void setY(int intY) {
		y = intY;
		this.changeY = 0;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setWidth(int intWidth) {
		width = intWidth;
		this.changeX = 0;
	}
	
	public void setHeight(int intHeight) {
		height = intHeight;
		this.changeY = 0;
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
		if((dock == SOUTH || dock == BOTH || dock == CENTER_SOUTH) && this.changeY == 0) this.changeY = containerVar.getHeight() - this.y;
		if((dock == CENTER || dock == CENTER_SOUTH) && this.changeX == 0) this.changeX = containerVar.getWidth() / 2 - this.x;
		if((dock == CENTER) && this.changeY == 0) this.changeY = containerVar.getHeight() / 2 - this.y;
		if(dock == EAST || dock == BOTH) this.x = containerVar.getWidth() + changeX;
		if(dock == SOUTH || dock == BOTH || dock == CENTER_SOUTH) this.y = containerVar.getHeight() - changeY;
		if((dock == CENTER || dock == CENTER_SOUTH)) this.x = containerVar.getWidth() / 2 - changeX;
		if((dock == CENTER)) this.y = containerVar.getHeight() / 2 - changeY;
		if((dock == TRUE_CENTER)) this.x = containerVar.getWidth() / 2 - width / 2;
	}
}
