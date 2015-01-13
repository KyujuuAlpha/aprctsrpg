package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements ActionListener { 
    private static Painter painterVar;
    private static Window windowVar;
    
    private static JPanel actionsMenu;
    
    public static void init() {
        windowVar = new Window("RPG");
        Stage.begin();
    }
    
    public Window(String str) {
        super(str);
        this.setSize(800,600);
        painterVar = new Painter();
        actionsMenu = new JPanel();
        this.add(actionsMenu, BorderLayout.WEST);
        this.add(painterVar);
        this.setVisible(true);
    }
    
    public static void syncChoices(String[] choices) {
        actionsMenu.removeAll();
        actionsMenu.setLayout(new GridLayout(choices.length, 1));
        for(int i = 0; i < choices.length; i++) {
            actionsMenu.add(new JButton(choices[i]));
        }
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
