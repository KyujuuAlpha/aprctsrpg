package ui;

import ui.elem.*;

import java.util.ArrayList;

public class Stage
{
    private static int currentStage = 0;
    
    private static ArrayList<Stage> stageList = new ArrayList<Stage>();
    
    private Dialog dialogVar;
    
    private Sprite[] imageDisplay = {};
    
    private Choice[] choicesVar;
    
    private Input[] inputsVar;
    
    /**
     * Initial method that is called upon when stage starts
     */
    public void init() {
        nextStage();
    }
    
    /**
     * Method that activates when one of the choices is clicked
     */
    public void choiceDone(String button) {
    }
    
    /**
     * Set the current dialog for this stage
     */
    public void setDialog(Dialog dialogVar_2) {
        dialogVar = dialogVar_2;
        Dialog.sync(this);
    }
    
    /**
     * Get the current dialog for this stage
     */
    public Dialog getDialog() {
        return dialogVar;
    }
    
    /**
     * Set the current text boxes for this stage
     */
    public void setInputs(Input... input) {
        inputsVar = input;
        Input.sync(this);
    }
    
    /**
     * Get the current text boxe array for this stage
     */
    public Input[] getInputs() {
        return inputsVar;
    }
    
    /**
     * Set the current image array for this stage
     */
    public void setSprites(Sprite... images) {
        imageDisplay = images;
        Sprite.sync(this);
    }
    
    /**
     * Get the current sprite array for this stage
     */
    public Sprite[] getSprites() {
        return imageDisplay;
    }
    
    /**
     * Get the current choice array for this stage
     */
    public Choice[] getChoices() {
        return choicesVar;
    }
    
    /**
     * Set the current choices for this stage
     */
    public void setChoices(Choice... buttons) {
        choicesVar = buttons;
        Choice.sync(this);
    }

    /**
     * Begin the game starting at stage 0d
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
        if(currentStage < stageList.size()) stageList.get(currentStage).init();
        Choice.sync(stageList.get(currentStage));
    }
    
    /**
     * Go back one stage on the list
     */
    public static void prevStage() {
        if(currentStage > 0) currentStage--;
        if(currentStage < stageList.size()) stageList.get(currentStage).init();
        else if(stageList.size() > 0) stageList.get(stageList.size()-1).init();
        Choice.sync(stageList.get(currentStage));
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
