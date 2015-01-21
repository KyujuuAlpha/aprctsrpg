package ui;

import ui.elem.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements ActionListener { 
    private static Window windowVar;
    
    public static JPanel actionsMenu;
    public static JPanel statsMenu;
    public static JPanel ostatsMenu;
    public static JPanel displayMenu;
    public static JPanel imageMenu;
    
    public static JPanel ioMenu;
    public static JPanel inMenu;
    
    public static JLabel dialog;
    
    public static void init() {
        windowVar = new Window("RPG");
        Stage.begin();
    }
    
    public Window(String str) {
        super(str);
        this.setSize(800,600);
        displayMenu = new JPanel();
        statsMenu = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ostatsMenu = new JPanel(new FlowLayout(FlowLayout.LEFT));
        actionsMenu = new JPanel();
        imageMenu = new JPanel();
        ioMenu = new JPanel();
        inMenu = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.setLayout(new BorderLayout());
        displayMenu.setLayout(new GridLayout(1,2));
        ioMenu.setLayout(new GridLayout(2,1));
        JPanel temp = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dialog = new JLabel(" ");
        temp.add(dialog, BorderLayout.WEST);
        ioMenu.add(temp, BorderLayout.WEST);
        ioMenu.add(inMenu);
        displayMenu.add(ioMenu);
        displayMenu.add(imageMenu);
        actionsMenu.setLayout(new BoxLayout(actionsMenu, BoxLayout.Y_AXIS));
        this.add(displayMenu, BorderLayout.CENTER);
        this.add(statsMenu, BorderLayout.NORTH);
        this.add(ostatsMenu, BorderLayout.SOUTH);
        this.add(actionsMenu, BorderLayout.WEST);
        this.setVisible(true);
    }
    
    public static Window getInstance() {
        return windowVar;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < actionsMenu.getComponents().length; i++) {
            actionsMenu.getComponents()[i].setEnabled(false);
        }
        Stage.getStage().choiceDone(((JButton)e.getSource()).getText());
    }
}
