import ui.*;
import ui.elem.*;

public class StageMenu extends Stage {
    @Override
    public void choiceDone(String a) {
        //addElement(new Choice("Click To Expand"), new Choice("Click To JUMP"), new Choice("Click To JUMP"), new Choice("Click To JUMP"));
        addElement(new Input("HI2", 10), new Dialog("test"), new Sprite("troi"));
    }
    
    @Override
    public void init() {
        addElement(new Choice("Click To Expand"), new Choice("Click To JUMP"), new Choice("Click To JUMP"), new Choice("Click To JUMP"), new Input("HI", 10), new Sprite("troi"));
    }
}
