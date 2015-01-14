package ui;

import java.util.ArrayList;

public class Stage
{
    private static int currentStage = 0;
    
    private static ArrayList<Stage> stageList = new ArrayList<Stage>();
    
    private String dialogText = "";
    
    private String[] choices;
    
    /**
     * Initial method that is called upon when stage starts
     */
    public void init() {
        nextStage();
    }
    
    /**
     * Method that activates when one of the choices is clicked
     * 1 Parameter: the button's name
     */
    public void choiceDone(String button) {
    }
    
    /**
     * Set the current dialog for this stage
     */
    public void setDialog(String str) {
        dialogText = str;
    }
    
    /**
     * Get the current dialog for this stage
     */
    public String getDialog() {
        return dialogText;
    }
    
    public String[] getChoices() {
        return choices;
    }
    
    /**
     * Set the current choices for this stage
     */
    public void setChoices(String... buttons) {
        choices = buttons;
        Window.syncChoices();
    }

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
        Window.syncChoices();
    }
    
    /**
     * Go back one stage on the list
     */
    public static void prevStage() {
        if(currentStage > 0) currentStage--;
        if(currentStage < stageList.size()) stageList.get(currentStage).init();
        else if(stageList.size() > 0) stageList.get(stageList.size()-1).init();
        Window.syncChoices();
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
