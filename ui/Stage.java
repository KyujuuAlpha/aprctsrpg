package ui;

import ui.elem.*;

import java.util.ArrayList;

public abstract class Stage {
    private static int currentStage = 0;
    
    private static ArrayList<Stage> stageList = new ArrayList<Stage>();
    
    private ArrayList<Element> elementList = new ArrayList<Element>();
    
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
     * Add a new element to this stage;
     */
    public void addElement(Element... elementVar) {
        for(Element element : elementVar) elementList.add(element);
        syncElements();
    }
    
    public void syncElements() {
        for(int i = 0; i < elementList.size(); i++) {
            Element elementVar = elementList.get(i);
            elementVar.draw(this);
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
        WindowUtilities.clearAllComponents();
        if(currentStage < stageList.size()) stageList.get(currentStage).init();
        WindowUtilities.clearAllComponents();
        getStage().syncElements();
    }
    
    /**
     * Go back one stage on the list
     */
    public static void prevStage() {
        WindowUtilities.clearAllComponents();
        if(currentStage > 0) currentStage--;
        if(currentStage < stageList.size()) stageList.get(currentStage).init();
        else if(stageList.size() > 0) stageList.get(stageList.size()-1).init();
        getStage().syncElements();
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
