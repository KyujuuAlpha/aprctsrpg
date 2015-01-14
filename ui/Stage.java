package ui;

import java.util.ArrayList;

public class Stage
{
    private static int currentStage = 0;
    
    private static ArrayList<Stage> stageList = new ArrayList<Stage>();
    
    private String dialogText = "";
    
    private String[] choices;
    
    public void init() {
        nextStage();
    }
    
    public void choiceDone(String button) {
    }
    
    public void setDialog(String str) {
        dialogText = str;
    }
    
    public String getDialog() {
        return dialogText;
    }
    
    public String[] getChoices() {
        return choices;
    }
    
    public void setChoices(String... buttons) {
        choices = buttons;
        Window.syncChoices();
    }
    
    /**
     * Redraw the window;
     */
    public void update() {
        Window.redraw();
    }
    
    public static void begin() {
        if(stageList.size() > 0) stageList.get(0).init();
    }
    
    public static void addStage(Stage stageVar) {
        stageList.add(stageVar);
    }
    
    public static void nextStage() {
        currentStage++;
        if(currentStage < stageList.size()) stageList.get(currentStage).init();
        Window.syncChoices();
        Window.redraw();
    }
    
    public static void prevStage() {
        if(currentStage > 0) currentStage--;
        if(currentStage < stageList.size()) stageList.get(currentStage).init();
        else if(stageList.size() > 0) stageList.get(stageList.size()-1).init();
        Window.syncChoices();
        Window.redraw();
    }
    
    public static int getStageNumber() { 
        return currentStage; 
    }
    
    public static Stage getStage() {
        if(currentStage < stageList.size()) return stageList.get(currentStage);
        else if(stageList.size() > 0) return stageList.get(stageList.size()-1);
        return null;
    }
}
