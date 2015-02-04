package ui;

import ui.elem.*;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;

public class Display extends JFrame implements ActionListener { 
    private Display displayVar;
    
    private JPanel actionsMenu;
    private JPanel statsMenu;
    private JPanel statsMenu2;
    private JPanel imageMenu;
    private JPanel inMenu;
    
    private JLabel dialog;
    private JLabel stats;
    private JLabel stats2;
    
    private int currentStage = 0;
    
    private ArrayList<Stage> stageList = new ArrayList<Stage>();
    
    public Display(String str) {
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
        imageMenu.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        subContainerA.add(imageMenu);
        inMenu = new JPanel();
        inMenu.setLayout(new BoxLayout(inMenu, BoxLayout.Y_AXIS));
        temp = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dialog = new JLabel("");
        temp.add(dialog);
        temp2 = new JScrollPane(temp); //dialog
        temp2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        subContainerB.add(temp2);
        temp2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        temp2 = new JScrollPane(inMenu); //inputs
        subContainerB.add(temp2);
        actionsMenu.setLayout(new BoxLayout(actionsMenu, BoxLayout.Y_AXIS));
        statsMenu = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        statsMenu2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        stats = new JLabel("");
        stats2 = new JLabel("");
        statsMenu.add(stats); //statistics
        this.add(statsMenu, BorderLayout.NORTH);
        statsMenu2.add(stats2); //stats 2
        this.add(statsMenu2, BorderLayout.SOUTH);
        temp2 = new JScrollPane(actionsMenu); //actions
        temp2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        this.add(temp2, BorderLayout.WEST);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        Timer timerVar = new Timer(50, this); //ticking timer
        timerVar.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(getStage() == null) return;
        getStage().countDown();
        getStage().syncElements();
        this.revalidate();
        this.repaint();
    }

    public Component getComponent(String type) {
        switch(type) {
            case "choice": return actionsMenu;
            case "image": return imageMenu;
            case "input": return inMenu;
            case "text": return dialog;
            case "stats": return stats;
            case "stats2": return stats2;
            default: return null;
        }
    }
    
    public JPanel getComponentPanel(String type) {
       if(type == "text" || type == "stats" || type == "stats2") return null;
       return (JPanel)getComponent(type);
    }
    
    public Component[] getComponentArray(String type) {
        if(type == "text" || type == "stats" || type == "stats2") return null;
        return getComponentPanel(type).getComponents();
    }
    
    /**
     * Begin the game starting at stage 0
     */
    public void begin() {
        if(stageList.size() > 0) stageList.get(0).init();
    }
    
    /**
     * Add a new stage to the list
     */
    public void addStage(Stage stageVar) {
        stageVar.setGameInstance(this);
        stageList.add(stageVar);
    }
    
    /**
     * Move onto the next stage on the list
     */
    public void nextStage() {
        getStage().removeElements();
        currentStage++;
        getStage().init();
        getStage().createElements();
        getStage().syncElements();
        this.revalidate();
        this.repaint();
    }
    
    /**
     * Go back one stage on the list
     */
    public void prevStage() {
        getStage().removeElements();
        if(currentStage > 0) currentStage--;
        getStage().init();
        getStage().createElements();
        getStage().syncElements();
        this.revalidate();
        this.repaint();
    }
    
    /**
     * Get the current stage this game is on
     */
    public int getStageNumber() { 
        return currentStage; 
    }
    
    /**
     * Get the actual current stage object
     */
    public Stage getStage() {
        if(currentStage < stageList.size()) return stageList.get(currentStage);
        else if(stageList.size() > 0) return stageList.get(stageList.size()-1);
        return null;
    }
}
