package ui.elem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Paint;

public class Text implements Element {
	
	public static final byte NONE = 0;
	public static final byte BOTH = 1;
	public static final byte EAST = 2;
	public static final byte SOUTH = 3;
	
	private int dock = NONE;
	private int changeX = 0;
	private int changeY = 0;
	
	private String label;
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	private Font font;
	
	private Paint fontColor = Color.BLACK;
	
	public Text(String text, int intX, int intY) {
		label = text;
		x = intX;
		y = intY;
		font = new Font("Arial", Font.PLAIN, 12);
	}
	
	public Text(String text, int intX, int intY, Font fontVar) {
		label = text;
		x = intX;
		y = intY;
		font = fontVar;
	}
	
	public void setFont(Font fontVar) {
		font = fontVar;
	}
	
	public void setDock(byte a) {
    	dock = a;
    }
	
	public String getText() {
		return label;
	}
	
	public void setText(String... text) {
		label = "";
		for(int i = 0; i < text.length; i++) {
			label += text[i];
			if(text.length > 1 && i < text.length - 1) label += "\n";
		}
	}
	
	public void appendText(String... text) {
		for(int i = 0; i < text.length; i++) {
			label += text[i];
			if(text.length > 1 && i < text.length - 1) label += "\n";
		}
	}
	
	public void setFontPaint(Paint paint) {
    	fontColor = paint;
    }
	
	public void setX(int intX) {
    	this.x = intX;
    }
    
    public void setY(int intY) {
    	this.y = intY;
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
		render.setPaint(fontColor);
		render.setFont(font);
		FontMetrics fontMetrics = render.getFontMetrics(render.getFont());
		this.width = fontMetrics.stringWidth(label);
		String[] strings = label.split("\n");
		if(strings != null && strings.length > 0) this.height = fontMetrics.getHeight()*strings.length;
		else this.height = fontMetrics.getHeight();
		drawString(render, label);
	}
	
	private void drawString(Graphics2D render, String str) {
		String[] strings = str.split("\n");
	    for(int i = 0; i < strings.length; i++) {
	    	if(strings[i] != "" || strings[i] != " ") render.drawString(strings[i], x, y + render.getFontMetrics().getHeight()*(i+1));
	    }
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
