package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Display extends JFrame implements ActionListener, KeyListener { 
    
    private int currentStage = 0;
    
    private ArrayList<Stage> stageList = new ArrayList<Stage>();

    
    private boolean toggleFullscreen;
    
    private final String simpleName;
    
    public Display(String str) {
        super(str);
        simpleName = str;
        this.setPreferredSize(new Dimension(800,600));
        setContentPane(new JPanel(){
        	@Override
        	public void paintComponent(Graphics g) {
        		super.paintComponent(g);
        		Graphics2D render = (Graphics2D) g;
        		setBackground(Color.BLACK);
        	}
        });
        this.addKeyListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        Timer timerVar = new Timer(50, this);
        timerVar.start();
        toggleFullscreen = false;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(getStage() == null) return;
        if(!this.getTitle().equals(simpleName + " - " + getStage().getClass().getSimpleName())) this.setTitle(simpleName + " - " + getStage().getClass().getSimpleName());
        int incrementVar = getStage().incrementVar();
        if(incrementVar == 1) { this.nextStage(); }
        else if(incrementVar == 2) { this.prevStage(); }
        else if(incrementVar > 2) { this.setStage(incrementVar - 3); }
        /*boolean flag = false;
        try { for(Element elementVar : getStage().getElements()) {
        	if(elementVar.getComponent() == null) {
        		if(elementVar instanceof ui.elem.Choice)
        		else if(elementVar instanceof ui.elem.Input)
        		else if(elementVar instanceof ui.elem.Sprite)
        		else if(elementVar instanceof ui.elem.Stat) 
        		else if(elementVar instanceof ui.elem.OpponentStat) 
        		else if(elementVar instanceof ui.elem.Dialog)
        		elementVar.createElement();
        	} else if(!flag) {
        		if(elementVar instanceof ui.elem.Choice && ((ui.elem.Choice)elementVar).isClicked()) {
        			((ui.elem.Choice)elementVar).setClicked(false);
        			getStage().choiceClicked(elementVar);
        			flag = true;
        		}
        	}
        } } catch(ConcurrentModificationException error) { }*/
        getStage().decreaseTicks();
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
        stageList.add(stageVar);
        stageVar.setID(stageList.size() - 1);
    }
    
    /**
     * Move onto the next stage on the list
     */
    public void nextStage() {
        getStage().removeElements();
        if(currentStage < stageList.size() - 1) currentStage++;
        getStage().resetIncrement();
        getStage().init();
    }
    
    /**
     * Go back one stage on the list
     */
    public void prevStage() {
        getStage().removeElements();
        if(currentStage > 0) currentStage--;
        getStage().resetIncrement();
        getStage().init();
    }
    
    /**
     * Set the current stage to the specified stage
     */
    public void setStage(int intVar) {
        getStage().removeElements();
        currentStage = intVar;
        if(currentStage < 0) currentStage = 0;
        if(currentStage >= stageList.size()) currentStage = stageList.size() - 1;
        getStage().resetIncrement();
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
        return null;
    }

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_F11) {
			this.dispose();
			if(!toggleFullscreen) {
				toggleFullscreen = true;
				this.setUndecorated(true);
				this.setExtendedState(JFrame.MAXIMIZED_BOTH);
			} else {
				toggleFullscreen = false;
				this.setUndecorated(false);
				this.setExtendedState(JFrame.NORMAL);
				this.pack();
			}
			this.setVisible(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}