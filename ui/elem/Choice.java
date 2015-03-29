package ui.elem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.RoundRectangle2D;

public class Choice extends DockedElement implements Element, TypeMouse {
	
	private String label;
    private boolean enabled;
    
    private boolean mouseDown = false;
    
    private String tooltip;
    
    private Paint fontColor = Color.BLACK;
    private Paint backColor = Color.LIGHT_GRAY;
    
    private Stroke buttonStroke = null;
    private Paint strokeColor = Color.BLACK;
    
    private Font font = new Font("Arial", Font.PLAIN, 12);
    
    public Choice() {
        this.label = "Choice";
        this.enabled = true;
        this.x = 0;
        this.y = 0;
        this.width = 100;
        this.height = 25;
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
    
    public void setFont(Font fontVar) {
		font = fontVar;
	}
    
    public void setFontPaint(Paint paint) {
    	fontColor = paint;
    }
    
    public void setBackgroundPaint(Paint paint) {
    	backColor = paint;
    }
    
    public void setStroke(Stroke stroke, Paint paint) {
    	buttonStroke = stroke;
    	strokeColor = paint;
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
    
	@Override
	public void updateElement(Container container) {
	}

	@Override
	public void drawElement(Graphics2D render, Container containerVar) {
		updateDock(containerVar);
		Shape oldClip = render.getClip();
		int roundFactor = 2;
		render.setFont(font);
		FontMetrics fontMetrics = render.getFontMetrics(render.getFont());
		RoundRectangle2D.Double container = new RoundRectangle2D.Double(x, y, width, height, roundFactor, roundFactor);
		if(buttonStroke != null) {
			Stroke oldStroke = render.getStroke();
			render.setPaint(strokeColor);
			render.setStroke(buttonStroke);
			render.draw(container);
			render.setStroke(oldStroke);
		}
		render.clip(container);
		render.setPaint(backColor);
		if(mouseDown || !isEnabled()) render.setPaint(Color.DARK_GRAY);
		render.fill(container);
		render.setPaint(fontColor);
		render.drawString(getLabel(), (int)container.getX() + (int)container.getWidth() / 2 - fontMetrics.stringWidth(getLabel()) / 2, (int)container.getY() + (int)container.getHeight() / 2 + render.getFont().getSize() / 2);
		render.setClip(oldClip);
	}

	@Override
	public void mouseClicked() {
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
