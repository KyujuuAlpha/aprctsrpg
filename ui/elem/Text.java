package ui.elem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Paint;

public class Text extends DockedElement implements Element {
	
	private String label;
	
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

	@Override
	public void updateElement(Container container) {
	}

	@Override
	public void drawElement(Graphics2D render, Container container) {
		updateDock(container);
		render.setPaint(fontColor);
		render.setFont(font);
		FontMetrics fontMetrics = render.getFontMetrics(render.getFont());
		String[] strings = label.split("\n");
		if(strings != null && strings.length > 0) this.height = fontMetrics.getHeight()*strings.length;
		else this.height = fontMetrics.getHeight();
		drawString(render, label);
	}
	
	private void drawString(Graphics2D render, String str) {
		FontMetrics fontMetrics = render.getFontMetrics(render.getFont());
		String[] strings = str.split("\n");
		int newWidth = 0;
	    for(int i = 0; i < strings.length; i++) {
	    	if(newWidth < fontMetrics.stringWidth(strings[i])) newWidth = fontMetrics.stringWidth(strings[i]);
	    	if(strings[i] != "" || strings[i] != " ") render.drawString(strings[i], x, y + fontMetrics.getHeight()*(i+1));
	    }
	    if(this.width != newWidth) this.width = newWidth;
	}
	
	@Override
	public void setX(int intX) {
		return;
	}
	
	@Override
	public void setY(int intY) {
		return;
	}
}
