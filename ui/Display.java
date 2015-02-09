package ui;

import ui.elem.*;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;

public class Display extends JFrame implements ActionListener { 
    private JPanel statsMenu;
    private JPanel statsMenu2;
    
    private int currentStage = 0;
    
    private ArrayList<Stage> stageList = new ArrayList<Stage>();
    
    public final JPanel actionsMenu;
    public final JPanel imageMenu;
    public final JPanel inputMenu;
    public final JLabel dialog;
    public final JLabel stats;
    public final JLabel stats2;
    
    public Display(String str) {
        super(str);
        this.setSize(800,600);
        JPanel subContainerA = new JPanel(new GridLayout(1,2));
        JPanel subContainerB = new JPanel(new GridLayout(2,1));
        subContainerA.add(subContainerB);
        this.add(subContainerA, BorderLayout.CENTER);
        JPanel temp;
        JScrollPane temp2;
        actionsMenu = new JPanel();
        actionsMenu.setLayout(new BoxLayout(actionsMenu, BoxLayout.Y_AXIS));
        imageMenu = new JPanel(); //imageMenu
        imageMenu.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        subContainerA.add(imageMenu);
        inputMenu = new JPanel();
        inputMenu.setLayout(new BoxLayout(inputMenu, BoxLayout.Y_AXIS));
        temp = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dialog = new JLabel("");
        temp.add(dialog);
        temp2 = new JScrollPane(temp); //dialog
        temp2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        subContainerB.add(temp2);
        temp2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        temp2 = new JScrollPane(inputMenu); //inputs
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
    
    /**
     * Begin the game starting at stage 0
     */
    public void begin() {
        if(stageList.size() > 0) getStage().init();
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
        if(currentStage < stageList.size() - 1) currentStage++;
        getStage().init();
    }
    
    /**
     * Go back one stage on the list
     */
    public void prevStage() {
        getStage().removeElements();
        if(currentStage > 0) currentStage--;
        getStage().init();
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
