package ui;

import ui.elem.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements ActionListener { 
    private static Window windowVar;
    
    public static JPanel actionsMenu;
    public static JPanel statsMenu;
    public static JPanel statsMenu2;
    public static JPanel imageMenu;
    public static JPanel inMenu;
    
    public static JLabel dialog;
    public static JLabel stats;
    public static JLabel stats2;
    
    public static void init() {
        windowVar = new Window("RPG");
        Stage.begin();
    }
    
    public Window(String str) {
        super(str);
        this.setSize(800,600);
        JPanel subContainerA = new JPanel(new GridLayout(1,2));
        JPanel subContainerB = new JPanel(new GridLayout(2,1));
        subContainerA.add(subContainerB);
        this.add(subContainerA, BorderLayout.CENTER);
        JPanel temp;
        JScrollPane temp2;
        actionsMenu = new JPanel(new BoxLayout(actionsMenu, BoxLayout.Y_AXIS));
        imageMenu = new JPanel(); //imageMenu
        subContainerA.add(imageMenu);
        inMenu = new JPanel();
        inMenu.setLayout(new BoxLayout(inMenu, BoxLayout.Y_AXIS));
        temp = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dialog = new JLabel("");
        temp.add(dialog);
        temp2 = new JScrollPane(temp); //dialog
        subContainerB.add(temp2);
        temp2 = new JScrollPane(inMenu); //inputs
        subContainerB.add(temp2);
        actionsMenu.setLayout(new BoxLayout(actionsMenu, BoxLayout.Y_AXIS));
        statsMenu = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        statsMenu2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        stats = new JLabel("f");
        stats2 = new JLabel("g");
        statsMenu.add(stats); //statistics
        this.add(statsMenu, BorderLayout.NORTH);
        statsMenu2.add(stats2); //stats 2
        this.add(statsMenu2, BorderLayout.SOUTH);
        temp2 = new JScrollPane(actionsMenu); //actions
        this.add(temp2, BorderLayout.WEST);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        Timer timerVar = new Timer(50, this);
        timerVar.start();
    }
    
    @Override
    public void paint(Graphics g) {
        Stage.getStage().syncElements();
        super.paint(g);
    }
    
    public static Window getInstance() {
        return windowVar;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof Timer) {
            Stage.getStage().countDown();
            Stage.getStage().syncElements();
            this.revalidate();
            this.repaint();
            return;
        }
        for(int i = 0; i < actionsMenu.getComponents().length; i++) {
            actionsMenu.getComponents()[i].setEnabled(false);
        }
        Stage.getStage().choiceDone(((JButton)e.getSource()).getText());
    }
}
