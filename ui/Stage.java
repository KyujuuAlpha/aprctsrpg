package ui;

import ui.elem.*;

import java.util.ArrayList;

public abstract class Stage {
    private ArrayList<Element> elementList = new ArrayList<Element>();
    
    private Display gameVar;
    
    private long tickDelay = 0;
    
    /**
     * Initial method that is called upon when stage starts
     */
    public void init() {
    }
    
    /**
     * Method that activates when one of the choices is clicked
     */
    public void choiceClicked(String buttonName) {
    }
    
    /**
     * Method that activates after a task is scheduled and is performed
     */
    public void taskPerformed() { 
    }
    
    /**
     * Simple task scheduling method, after specified number of ticks, run taskPerformed
     * 1 tick is equivalent to 1 twentieth of a second
     */
    public void scheduleTask(long ticks) { 
        tickDelay = ticks;
    }
    
    public void countDown() {
        boolean flag = false;
        if(tickDelay > 0) {
            if(tickDelay == 1) flag = true;
            tickDelay--;
        }
        if(flag) this.taskPerformed();
    }
    
    /**
     * Add a new element to this stage;
     */
    public void addElement(Element... elementVar) {
        for(Element element : elementVar) {
            if(elementList.indexOf(elementVar) < 0) {
                elementList.add(element);
                element.setGameInstance(gameVar);
                element.createElement(true);
            }
        }
        syncElements();
    }
    
    /**
     * Remove the given elements from this stage
     */
    public void removeElement(Element... elementVar) {
        for(Element element : elementVar) {
            elementList.remove(element);
            element.removeElement();
        }
        syncElements();
    }
    
    public void syncElements() {
        for(int i = 0; i < elementList.size(); i++) {
            Element element = elementList.get(i);
            element.sync();
        }
    }
    
    public void drawElements() {
        for(int i = 0; i < elementList.size(); i++) {
            Element element = elementList.get(i);
            element.draw(this);
        }
    }
    
    public void removeElements() {
        for(int i = 0; i < elementList.size(); i++) {
            Element element = elementList.get(i);
            element.removeElement();
        }
    }
    
    public void createElements() {
        for(int i = 0; i < elementList.size(); i++) {
            Element element = elementList.get(i);
            element.createElement(true);
        }
    }
    
    /**
     * Go to the next stage in the list
     */
    public void nextStage() {
        gameVar.nextStage();
    }
    
    /**
     * Go to the previous stage in the list
     */
    public void prevStage() {
        gameVar.prevStage();
    }
    
    public void setGameInstance(Display displayVar) {
        gameVar = displayVar;
    }
}
