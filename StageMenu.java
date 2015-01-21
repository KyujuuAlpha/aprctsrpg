import ui.*;
import ui.elem.*;

public class StageMenu extends Stage {
    @Override
    public void choiceDone(String a) {
        //addElement(new Choice("Click To Expand"), new Choice("Click To JUMP"), new Choice("Click To JUMP"), new Choice("Click To JUMP"));
    }
    
    @Override
    public void init() {
        addElement(new Choice("Click To Expand"), new Choice("Click To JUMP"), new Choice("Click To JUMP"), new Choice("Click To JUMP"));
    }
}
