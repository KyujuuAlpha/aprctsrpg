import ui.*;
import ui.elem.*;

public class StageMenu extends Stage {
    Input inputVar;
    
    @Override
    public void choiceDone(String a) {
        removeElement(inputVar);
        Input temp = new Input("HI2", 10);
        temp.setText(a);
        addElement(temp, new Dialog("test"));
        init();
    }
    
    @Override
    public void init() {
        inputVar = new Input("HI", 10);
        addElement(new Choice("Click To Expand"), new Choice("Click To JUMP"), new Choice("Click To JUMP"), new Choice("Click To JUMP"), inputVar, new Sprite("troi"));
    }
}
