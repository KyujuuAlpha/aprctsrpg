package ui;

import ui.elem.*;

import java.util.ArrayList;

public abstract class Stage {
    //declare and initialize a new arraylist with the type of element
    private ArrayList<Element> elementList = new ArrayList<Element>();
    
    //declare a Display instance variable
    private Display gameVar;
    
    //declare a long variable for task scheduling
    private long ticks = 0;
    
    /**
     * Called when this stage becomes the current stage
     */
    public abstract void init();
    
    /**
     * Called whenever a choice is clicked by the mouse
     */
    public abstract void choiceClicked(Element elementVar);
    
    /**
     * Called after a task is scheduled after certain amount of ticks
     */
    public abstract void taskPerformed();
    
    /**
     * Simple task scheduling method, after specified number of ticks, run taskPerformed
     * 1 tick is equivalent to 1 twentieth of a second
     */
    public void scheduleTask(long intVar) { 
        ticks += intVar; //add the specified number of ticks to the countdown 
        if(ticks == 0 && intVar == 0) this.taskPerformed(); //if for some reason they are both 0, just call the action method
    }
    
    public void decreaseTicks() { //called whenever the timer ticks
        if(ticks > 0) { //if the countdown is greater than 0, then
            ticks--; //decrease it
            if(ticks == 0) this.taskPerformed(); //if it just turned 0, run the action method
        }
    }
    
    /**
     * Add a new element to this stage;
     */
    public void addElements(Element... elementVar) {
        for(Element element : elementVar) { //foreach element in the array
            if(elementList.indexOf(elementVar) < 0) { //if that element does not already exist
                elementList.add(element); //then add it to the element list
                element.setGameInstance(gameVar); //sest it's display instance variable
                element.createElement(); //create it to avoid null pointer exceptions
            }
        }
    }
    
    /**
     * Remove the given elements from this stage
     */
    public void removeElements(Element... elementVar) {
        for(Element element : elementVar) { 
            elementList.remove(element); //remove that element if it exists in the list
            element.removeElement(); //invoke the element's removeElement method
        }
    }
    
    public void syncElements() {
        for(int i = 0; i < elementList.size(); i++) {
            Element element = elementList.get(i); //get the current element in the element list
            element.sync(); //invoke it's sync method
        }
    }

    public void removeElements() {
        for(int i = 0; i < elementList.size(); i++) {
            Element element = elementList.get(i);
            element.removeElement(); //invoke it's remove method!
        }
        elementList.clear(); //remove all the elements from the elementList
    }
    
    /**
     * Go to the next stage in the list
     */
    public void nextStage() {
        gameVar.nextStage(); //move onto the next stage by invoking the nextstage method from the displayinstance
    }
    
    /**
     * Go to the previous stage in the list
     */
    public void prevStage() {
        gameVar.prevStage(); //invoke the prevstage method from the display instance
    }
    
    public void setGameInstance(Display displayVar) {
        gameVar = displayVar; //set the display instance to the specified parameter
    }
}
