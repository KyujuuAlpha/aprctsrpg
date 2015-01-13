package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements ActionListener { 
    private static Painter painterVar;
    private static Window windowVar;
    
    private static JPanel actionsMenu;
    private static JPanel statsMenu;
    private static JPanel ostatsMenu;
    
    public static void init() {
        windowVar = new Window("RPG");
        Stage.begin();
    }
    
    public Window(String str) {
        super(str);
        this.setSize(800,600);
        painterVar = new Painter();
        statsMenu = new JPanel();
        ostatsMenu = new JPanel();
        actionsMenu = new JPanel();
        this.add(statsMenu, BorderLayout.NORTH);
        this.add(ostatsMenu, BorderLayout.SOUTH);
        this.add(actionsMenu, BorderLayout.WEST);
        this.add(painterVar);
        this.setVisible(true);
    }
    
    public static void syncChoices() {
        actionsMenu.removeAll();
        if(Stage.getStage().getChoices() == null) return;
        actionsMenu.setLayout(new GridLayout(Stage.getStage().getChoices().length, 1));
        for(int i = 0; i < Stage.getStage().getChoices().length; i++) {
            JButton jb = new JButton(Stage.getStage().getChoices()[i]);
            jb.addActionListener(windowVar);
            actionsMenu.add(jb);
        }
    }
    
    public static void disableChoices() {
        for(int i = 0; i < actionsMenu.getComponents().length; i++) {
            actionsMenu.getComponents()[i].setEnabled(false);
        }
    }
    
    public static void redraw() {
        painterVar.repaint();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(Stage.getStage().getChoice() == null) {
            Stage.getStage().setChoice(((JButton)e.getSource()).getText());
            disableChoices();
            Stage.getStage().choiceDone();
        }
    }
    
    static class Painter extends JComponent {
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D render = (Graphics2D)g;
            render.drawString(Stage.getStage().getDialog(), 0, 0);
        }
    };
}
