package ui.elem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

public class Choice implements Element, TypeMouse {
	
	public static final byte NONE = 0;
	public static final byte BOTH = 1;
	public static final byte EAST = 2;
	public static final byte SOUTH = 3;
	
	private int dock = NONE;
	private int changeX = 0;
	private int changeY = 0;
	
	private String label;
    private boolean enabled;
    
    private boolean mouseDown = false;
    
    private String tooltip;
    
    private int x;
    private int y;
    private int width;
    private int height;
    
    public Choice() {
        this.label = "Choice";
        this.enabled = true;
    }

    public Choice(String stringVar) {
        this.label = stringVar;
        this.enabled = true;
        this.x = 0;
        this.y = 0;
        this.width = 100;
        this.height = 25;
    }
    
    public Choice(String stringVar, int intX, int intY) {
        this.label = stringVar;
        this.enabled = true;
        this.x = intX;
        this.y = intY;
        this.width = 100;
        this.height = 25;
    }
    
    public Choice(String stringVar, int intX, int intY, int intWidth, int intHeight) {
        this.label = stringVar;
        this.enabled = true;
        this.x = intX;
        this.y = intY;
        this.width = intWidth;
        this.height = intHeight;
    }
    
    public void setX(int intX) {
    	this.x = intX;
    }
    
    public void setY(int intY) {
    	this.y = intY;
    }
    
    public String getLabel() {
        return this.label; 
    }
    
    public void setLabel(String stringVar) {
        this.label = stringVar;
    }

    public void setLabel(String stringVar, boolean flag) {
        this.label = stringVar;
        this.setEnabled(flag);
    }
    
    public void setToolTip(String stringVar) {
    	tooltip = stringVar;
    }
    
    public String getToolTip() {
    	return tooltip;
    }

    public void setEnabled(boolean flag) {
        this.enabled = flag;
    }

    public boolean isEnabled() {
        return this.enabled;
    }
    
    public void setDock(byte a) {
    	dock = a;
    }
    
	@Override
	public void updateElement(Container container) {
	}

	@Override
	public void drawElement(Graphics2D render, Container containerVar) {
		Shape oldClip = render.getClip();
		if((dock == EAST || dock == BOTH) && this.changeX == 0) this.changeX = containerVar.getWidth() - this.x;
		if((dock == SOUTH || dock == BOTH) && this.changeY == 0) this.changeY = containerVar.getHeight() - this.y;
		if(dock == EAST || dock == BOTH) this.x = containerVar.getWidth() - changeX;
		if(dock == SOUTH || dock == BOTH) this.y = containerVar.getHeight() - changeY;
		int fontSize = 12;
		int roundFactor = 2;
		render.setFont(new Font("Arial", Font.PLAIN, fontSize));
		FontMetrics fontMetrics = render.getFontMetrics(render.getFont());
		render.setPaint(Color.LIGHT_GRAY);
		if(mouseDown || !isEnabled()) render.setPaint(Color.DARK_GRAY);
		RoundRectangle2D.Double container = new RoundRectangle2D.Double(x, y, width, height, roundFactor, roundFactor);
		render.clip(container);
		render.fill(container);
		render.setPaint(Color.BLACK);
		render.drawString(getLabel(), (int)container.getX() + (int)container.getWidth() / 2 - fontMetrics.stringWidth(getLabel()) / 2, (int)container.getY() + (int)container.getHeight() / 2 + render.getFont().getSize() / 2);
		render.setClip(oldClip);
	}

	@Override
	public void mouseClicked() {
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

	@Override
	public void mouseDown() {
		mouseDown = true;
	}

	@Override
	public void mouseUp() {
		mouseDown = false;
	}

	@Override
	public void mouseOver() {
	}
}
