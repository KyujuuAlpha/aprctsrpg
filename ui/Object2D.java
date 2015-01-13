package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

import java.util.Random;

//Object 2D class created by Troi-Ryan Stoeffler
//Used for expanding the capabilities of Java2D; simpilifies it :P
//v0.0.1
public class Object2D {
    private Graphics2D context;
    private Object obj;
    
    private Object fill;
    private Color stroke;
    
    private float alpha = 1.0f;
    private BasicStroke strokeStyle;
    
    private double radians = 0;
    private double scale2 = 1.0D;
    
    private boolean originActive = false;
    private double originX = 0.0D;
    private double originY = 0.0D;
    
    public Object2D(Object a, Graphics2D b) {
        this.context = b;
        this.obj = a;
        this.fill = Color.WHITE;
    }
    
    public Object2D(Object a) {
        this.context = null;
        this.obj = a;
        this.fill = Color.WHITE;
    }
    
    public Object2D setOrigin(double a, double b) {
        originX = a;
        originY = b;
        originActive = true;
        return this;
    }
    
    public Object2D removeOrigin() {
        originX = 0.0D;
        originY = 0.0D;
        originActive = false;
        return this;
    }
    
    public Object2D setStroke(Color a, BasicStroke b) {
        stroke = a;
        strokeStyle = b;
        return this;
    }
    
    public Object2D setStrokeColor(Color a) {
        stroke = a;
        if(strokeStyle == null) {
            strokeStyle = new BasicStroke(0);
        }
        return this;
    }
    
    public Object2D setStrokeStyle(BasicStroke a) {
        strokeStyle = a;
        if(stroke == null) {
            stroke = Color.WHITE;
        }
        return this;
    }
    
    public Object2D scale(double a) {
        scale2 = a;
        return this;
    }
    
    public Object2D rotate(double a) {
        radians = a;
        return this;
    }
    
    public Object2D setAlpha(float a) {
        alpha = a;
        return this;
    }
    
    public Object2D setFill(Object a) {
        if(a instanceof Paint) {
            fill = a;
        }
        return this;
    }
    
    public Object2D setContext(Graphics2D a) {
        context = a;
        return this;
    }
    
    public float getOpacity() {
        return alpha;
    }
    
    public double getScale() {
        return scale2;
    }
    
    public double getDeg() {
        return radians;
    }
    
    public Color getStroke() {
        return stroke;
    }
    
    public Object getFill() {
        return fill;
    }
    
    public Graphics2D getContext() {
        return context;
    }
    
    public void draw(Graphics2D a) {
        Graphics2D b = this.getContext();
        this.setContext(a);
        this.draw();
        this.setContext(b);
    }
    
    public void draw() {
        AffineTransform contextSaved = context.getTransform(); //save state
        double x = getX(); 
        double y = getY();
        if(!originActive) {
            context.translate(getWidth()/2 + getX(), getHeight()/2 + getY()); //translate origin to it's half point
            setX(-getWidth() / 2); //set it's x to -half of width
            setY(-getHeight() / 2);
        } else {
            context.translate(originX, originY);
        }
        context.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha)); //set alpha
        context.scale(scale2, scale2); //scale
        context.rotate(Math.toRadians(radians)); //rotate
        context.setPaint((Paint)fill); //set it's color
        context.fill((Shape)obj); //fill it
        if(stroke != null) { //if it's stroke is true, draw it!
            context.setPaint(stroke);
            context.setStroke(strokeStyle);
            context.draw((Shape)obj);
        }
        context.setTransform(contextSaved); //restore state
        setX(x); //reset x to former x coord
        setY(y);
    }
    
    public Object2D setCoord(String a, double b) {
        try {
            try { obj.getClass().getField(a).set(obj, (int)b);
            } catch(IllegalAccessException e) {}
        } catch(NoSuchFieldException e) {}
        return this;
    }
    
    public Object2D setX(double a) {
        try {
            try { obj.getClass().getField("x").set(obj, (int)a);
            } catch(IllegalAccessException e) {}
        } catch(NoSuchFieldException e) {}
        return this;
    }
    
    public Object2D setY(double a) {
       try {
            try { obj.getClass().getField("y").set(obj, (int)a);
            } catch(IllegalAccessException e) {}
        } catch(NoSuchFieldException e) {}
       return this;
    }
    
    public double getCoord(String a) {
        try {
            try { return (double)obj.getClass().getField(a).getDouble(obj);
            } catch(IllegalAccessException e) {}
        } catch(NoSuchFieldException e) {}
        return 0.0D;
    }
    
    public double getX() {
        try {
            try { return (double)obj.getClass().getField("x").getDouble(obj);
            } catch(IllegalAccessException e) {}
        } catch(NoSuchFieldException e) {}
        return 0.0D;
    }
    
    public double getY() {
        try {
            try { return (double)obj.getClass().getField("y").getDouble(obj);
            } catch(IllegalAccessException e) {}
        } catch(NoSuchFieldException e) {}
        return 0.0D;
    }
    
    public Object2D setWidth(double a) {
        try {
            try { obj.getClass().getField("width").set(obj, (int)a);
            } catch(IllegalAccessException e) {}
        } catch(NoSuchFieldException e) {}
        return this;
    }
    
    public Object2D setHeight(double a) {
       try {
            try { obj.getClass().getField("height").set(obj, (int)a);
            } catch(IllegalAccessException e) {}
        } catch(NoSuchFieldException e) {}
       return this;
    }
    
    public double getWidth() {
        try {
            try { return (double)obj.getClass().getField("width").getDouble(obj);
            } catch(IllegalAccessException e) {}
        } catch(NoSuchFieldException e) {}
        return 0.0D;
    }
    
    public double getHeight() {
        try {
            try { return (double)obj.getClass().getField("height").getDouble(obj);
            } catch(IllegalAccessException e) {}
        } catch(NoSuchFieldException e) {}
        return 0.0D;
    }
    
    public Object getObject() {
        return obj;
    }
}