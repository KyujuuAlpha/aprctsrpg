package ui;

import java.util.ArrayList;

public class Stage
{
    private static int currentStage = 0;
    
    private static ArrayList<Stage> stageList = new ArrayList<Stage>();
    
    private String dialogText = "";
    private String[] imageDisplay = {""};
    
    private String[] choices;
    
    private int[] inputs;
    
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
    
    /**
     * get the text from an input
     */
    public String getInputText(int id) {
        if(inputs.length < 1) return null;
        return Window.getTextFromField(id);
    }
    
    /**
     * Set the current inputs for this stage
     */
    public void setInputs(int... inputsVar) {
        inputs = inputsVar;
        Window.syncInputs();
    }
    
    /**
     * Get the current inputs for this stage
     */
    public int[] getInputLengths() {
        return inputs;
    }
    
    /**
     * Set the current images for this stage
     */
    public void setImages(String... images) {
        imageDisplay = images;
    }
    
    /**
     * Get the current images for this stage
     */
    public String[] getImages() {
        return imageDisplay;
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
