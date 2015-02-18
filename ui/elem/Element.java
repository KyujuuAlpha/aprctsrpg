package ui.elem;

import ui.*;

public interface Element {
    public void sync(); //this method is called whenever a tick is ticked, syncs the actual element's data with the gui versions
    public void createElement(); //invoked when the element is added to a stage
    public void removeElement(); //invoked when the element gui counter part is requested to be removed
    public void setGameInstance(Display displayVar); //set display instance field
}
