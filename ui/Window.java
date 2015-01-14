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
    private static JPanel displayMenu;
    
    public static void init() {
        windowVar = new Window("RPG");
        Stage.begin();
    }
    
    public Window(String str) {
        super(str);
        this.setSize(800,600);
        painterVar = new Painter();
        displayMenu = new JPanel();
        statsMenu = new JPanel();
        ostatsMenu = new JPanel();
        actionsMenu = new JPanel();
        this.setLayout(new BorderLayout());
        displayMenu.setLayout(new BorderLayout());
        displayMenu.add(painterVar, BorderLayout.CENTER);
        this.add(displayMenu, BorderLayout.CENTER);
        this.add(statsMenu, BorderLayout.NORTH);
        this.add(ostatsMenu, BorderLayout.SOUTH);
        this.add(actionsMenu, BorderLayout.WEST);
        this.setVisible(true);
    }
    
    public static void renderDisplay() {
        displayMenu.revalidate();
        displayMenu.repaint();
        painterVar.repaint();
    }
    
    public static void syncChoices() {
        if(Stage.getStage().getChoices() == null) return;
        else actionsMenu.removeAll();
        actionsMenu.setLayout(new GridLayout(Stage.getStage().getChoices().length, 1));
        for(int i = 0; i < Stage.getStage().getChoices().length; i++) {
            JButton jb = new JButton(Stage.getStage().getChoices()[i]);
            jb.addActionListener(windowVar);
            actionsMenu.add(jb);
        }
        actionsMenu.revalidate();
        actionsMenu.repaint();
        renderDisplay();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < actionsMenu.getComponents().length; i++) {
            actionsMenu.getComponents()[i].setEnabled(false);
        }
        Stage.getStage().choiceDone(((JButton)e.getSource()).getText());
        renderDisplay();
    }
    
    static class Painter extends JComponent {
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D render = (Graphics2D)g;
            render.setPaint(Color.BLACK);
            render.drawString(Stage.getStage().getDialog(), 0, 20);
        }
    };
}
