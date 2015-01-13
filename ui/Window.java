package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements ActionListener { 
    private static Painter painterVar;
    
    public static void init() {
        JFrame windowVar = new Window("RPG");
        Stage.begin();
    }
    
    public Window(String str) {
        super(str);
        this.setSize(800,600);
        painterVar = new Painter();
        this.add(painterVar);
        this.setVisible(true);
    }
    
    public static void redraw() {
        painterVar.repaint();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    static class Painter extends JComponent {
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D render = (Graphics2D)g;
            render.drawString(Stage.getStage().getDialog(), 0, 0);
        }
    };
}
