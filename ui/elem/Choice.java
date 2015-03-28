package ui.elem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

public class Choice implements Element {
	
	public final byte NONE = 0;
	public final byte BOTH = 1;
	public final byte EAST = 2;
	public final byte SOUTH = 3;
	
	private int dock = BOTH;
	private int changeX = 0;
	private int changeY = 0;
	
	private String label;
    private boolean enabled;
    
    private boolean clickedVar;
    
    private String tooltip;
    
    private int x;
    private int y;
    
    public Choice() {
        this.label = "Choice";
        this.enabled = true;
    }

    public Choice(String stringVar) {
        this.label = stringVar;
        this.enabled = true;
        this.x = 0;
        this.y = 0;
    }
    
    public Choice(String stringVar, int intX, int intY) {
        this.label = stringVar;
        this.enabled = true;
        this.x = intX;
        this.y = intY;
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
   
    public boolean isClicked() {
    	return clickedVar;
    }
    
    public void setClicked(boolean flag) {
    	clickedVar = flag;
    }
    
	@Override
	public void updateElement(Container container) {
	}

	@Override
	public void drawElement(Graphics2D render, Container containerVar) {
		if((dock == EAST || dock == BOTH) && this.changeX == 0) this.changeX = containerVar.getWidth() - this.x;
		if((dock == SOUTH || dock == BOTH) && this.changeY == 0) this.changeY = containerVar.getHeight() - this.y;
		if(dock == EAST || dock == BOTH) this.x = containerVar.getWidth() - changeX;
		if(dock == SOUTH || dock == BOTH) this.y = containerVar.getHeight() - changeY;
		int spaceX = 10;
		int spaceY = 5;
		int fontSize = 12;
		int roundFactor = 2;
		render.setFont(new Font("Arial", Font.BOLD, fontSize));
		FontMetrics fontMetrics = render.getFontMetrics(render.getFont());
		render.setPaint(Color.LIGHT_GRAY);
		RoundRectangle2D.Double container = new RoundRectangle2D.Double(x, y, fontMetrics.stringWidth(getLabel()) + spaceX*2, fontMetrics.getHeight() + spaceY*2, roundFactor, roundFactor);
		render.fill(container);
		render.setPaint(Color.BLACK);
		render.drawString(getLabel(), (int)container.getX() + spaceX, (int)container.getY() + render.getFont().getSize() + spaceY);
	}
}
