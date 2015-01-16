package ui;

import ui.elem.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements ActionListener { 
    private static Painter painterVar;
    private static Window windowVar;
    
    private static JPanel actionsMenu;
    private static JPanel statsMenu;
    private static JPanel ostatsMenu;
    private static JPanel displayMenu;
    private static SpritePanel imageMenu;
    
    private static JPanel ioMenu;
    private static JPanel inMenu;
    
    private static JLabel dialog;
    
    public static void init() {
        windowVar = new Window("RPG");
        Stage.begin();
    }
    
    public Window(String str) {
        super(str);
        this.setSize(800,600);
        displayMenu = new JPanel();
        statsMenu = new JPanel();
        ostatsMenu = new JPanel();
        actionsMenu = new JPanel();
        imageMenu = new SpritePanel();
        ioMenu = new JPanel();
        inMenu = new JPanel();
        this.setLayout(new BorderLayout());
        displayMenu.setLayout(new GridLayout(1,2));
        ioMenu.setLayout(new GridLayout(2,1));
        JPanel temp = new JPanel();
        dialog = new JLabel(" ");
        temp.add(dialog, BorderLayout.WEST);
        ioMenu.add(temp, BorderLayout.WEST);
        ioMenu.add(inMenu);
        displayMenu.add(ioMenu);
        displayMenu.add(imageMenu);
        this.add(displayMenu, BorderLayout.CENTER);
        this.add(statsMenu, BorderLayout.NORTH);
        this.add(ostatsMenu, BorderLayout.SOUTH);
        this.add(actionsMenu, BorderLayout.WEST);
        this.setVisible(true);
    }
    
    public static void renderDisplay() {
        displayMenu.revalidate();
        displayMenu.repaint();
    }
    
    public static Window getInstance() {
        return windowVar;
    }
    
    public static Component getComponent(String type) {
        switch(type) {
            case "choice": return actionsMenu;
            case "image": return imageMenu;
            case "input": return inMenu;
            case "text": return dialog;
            default: return null;
        }
    }
    
    public static JPanel getComponentPanel(String type) {
        switch(type) {
            case "choice": return actionsMenu;
            case "image": return imageMenu;
            case "input": return inMenu;
            default: return null;
        }
    }
    
    public static Component[] getComponentArray(String type) {
        return getComponentPanel(type).getComponents();
    }
    
    public static String getTextFromField(int id) {
        return ((JTextField)getComponentArray("input")[id]).getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < actionsMenu.getComponents().length; i++) {
            actionsMenu.getComponents()[i].setEnabled(false);
        }
        Stage.getStage().choiceDone(((JButton)e.getSource()).getText());
        renderDisplay();
    }
}
