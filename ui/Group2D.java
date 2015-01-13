package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

import java.util.ArrayList;

//Written by Troi-Ryan Stoeffler, EXTREMELY MESSY ;P
public class Group2D {
    private ArrayList<Object2D> group;
   
    private double radians = 0;
    private double scale2 = 1.0D;
    
    private double x = 0.0D;
    private double y = 0.0D;
    
    private double width = 0.0D;
    private double height = 0.0D;
    
    public Group2D() {
         this.group = new ArrayList<Object2D>();
    }
    
    public Group2D(ArrayList<Object2D> a) {
         this.group = a;
    }
    
    public Group2D clone() {
        return new Group2D(this.group).setX(x).setY(y).rotate(radians).scale(scale2).setHW();
    }
    
    public Group2D add(Object2D a) {
         this.group.add(a);
         this.setHW();
         return this;
    }
    
    public Group2D scale(double a) {
        this.scale2 = a;
        return this;
    }
    
    public Group2D rotate(double a) {
        this.radians = a;
        return this;
    }
    
    public Group2D setX(double a) {
        this.x = a;
        return this;
    }
    
    public Group2D setY(double a) {
        this.y = a;
        return this;
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public double getWidth() {
        return this.width;
    }
    
    public double getHeight() {
        return this.height;
    }
    
    public Object2D get(int a) {
        return group.get(a);
    }
    
    public void draw(Graphics2D a) {
        double groupX = 0;
        double groupY = 0;
        for(int i = 0; i < this.group.size(); i++) {
            if(this.group.get(i).getX() < groupX)
                groupX = this.group.get(i).getX();
            if(this.group.get(i).getY() < groupY)
                groupY = this.group.get(i).getY();
        }
        for(int i = 0; i < this.group.size(); i++) {
            this.group.get(i).setOrigin(x + groupX, y + groupY);
            this.group.get(i).rotate(radians);
            this.group.get(i).scale(scale2);
            this.group.get(i).draw(a);
        }
    }
    
    public Group2D setHW() {
        double groupWidth = 0;
        double groupHeight = 0;
        for(int i = 0; i < this.group.size(); i++) {
            if(this.group.get(i).getX() + this.group.get(i).getWidth() > groupWidth)
                groupWidth = this.group.get(i).getX() + this.group.get(i).getWidth();
            if(this.group.get(i).getY() + this.group.get(i).getHeight() > groupHeight)
                groupHeight = this.group.get(i).getY() + this.group.get(i).getHeight();
        }
        width = groupWidth;
        height = groupHeight;
        return this;
    }
}
