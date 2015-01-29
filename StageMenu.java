import ui.*;
import ui.elem.*;

public class StageMenu extends Stage {
    Input inputVar;
    Sprite test;
    
    @Override
    public void choiceDone(String a) {
        removeElement(inputVar);
        this.delay(2000);
        Input temp = new Input("HI2", 10);
        temp.setText(a);
        addElement(temp, new Dialog("test"));
    }
    
    @Override
    public void init() {
        test = new Sprite("troi");
        inputVar = new Input("HI", 10);
        addElement(new Choice("TestButton"), inputVar, test);
    }
}
