package ui;

import ui.elem.*;

import java.util.ArrayList;

public abstract class Stage {
    private static int currentStage = 0;
    
    private static ArrayList<Stage> stageList = new ArrayList<Stage>();
    
    private ArrayList<Element> elementList = new ArrayList<Element>();
    
    private static long tickDelay = 0;
    
    /**
     * Initial method that is called upon when stage starts
     */
    public void init() {
        nextStage();
    }
    
    /**
     * Method that activates when one of the choices is clicked
     */
    public void choiceDone(String buttonName) {
    }
    
    /**
     * Method that activates after a task is scheduled and is performed
     */
    public void taskPerformed() { 
    }
    
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
    
    //STATIC METHODS

    /**
     * Begin the game starting at stage 0
     */
    public static void begin() {
        if(stageList.size() > 0) stageList.get(0).init();
    }
    
    /**
     * Add a new stage to the list
     */
    public static void addStage(Stage stageVar) {
        stageList.add(stageVar);
    }
    
    /**
     * Move onto the next stage on the list
     */
    public static void nextStage() {
        currentStage++;
        getStage().removeElements();
        if(currentStage < stageList.size()) stageList.get(currentStage).init();
        getStage().createElements();
        getStage().syncElements();
        getStage().drawElements();
    }
    
    /**
     * Go back one stage on the list
     */
    public static void prevStage() {
        getStage().removeElements();
        if(currentStage > 0) currentStage--;
        if(currentStage < stageList.size()) stageList.get(currentStage).init();
        else if(stageList.size() > 0) stageList.get(stageList.size()-1).init();
        getStage().createElements();
        getStage().syncElements();
        getStage().drawElements();
    }
    
    /**
     * Get the current stage this game is on
     */
    public static int getStageNumber() { 
        return currentStage; 
    }
    
    /**
     * Get the actual current stage object
     */
    public static Stage getStage() {
        if(currentStage < stageList.size()) return stageList.get(currentStage);
        else if(stageList.size() > 0) return stageList.get(stageList.size()-1);
        return null;
    }
}
