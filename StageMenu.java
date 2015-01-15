import ui.*;
import ui.elem.*;

public class StageMenu extends Stage {
    @Override
    public void choiceDone(String a) {
        setDialog("Minimized");
        setSprites(new Sprite("troi"), new Sprite("troi"));
        if(a.equals("Click To Expand")) setChoices(new Choice("Click To Minimize"), new Choice("Disable Me"), new Choice("Disable Me"), new Choice("Disable Me"), new Choice("Disable Me"), new Choice(getInputs()[0].getText()));
        else if(a.equals("Click To Minimize")) init();
    }
    
    @Override
    public void init() {
        setDialog("Maximized");
        setSprites(new Sprite("troi"));
        setInputs(new Input(5), new Input(10));
        setChoices(new Choice("Click To Expand"), new Choice("Disable Me"));
    }
}
