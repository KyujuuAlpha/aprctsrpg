import ui.*;
import ui.elem.*;

public class StageMenu extends Stage {
    @Override
    public void choiceDone(String a) {
        setDialog(new Dialog("Minimized"));
        setSprites(new Sprite("troi"), new Sprite("troi"));
        if(a.equals("Click To Expand")) setChoices(new Choice("Click To Minimize"), new Choice("Disable Me"), new Choice("Disable Me"), new Choice("Disable Me"), new Choice("Disable Me"), new Choice(getInputs()[0].getText()));
        else if(a.equals("Click To Minimize")) init();
    }
    
    @Override
    public void init() {
        setDialog(new Dialog("Maximized"));
        setSprites(new Sprite("troi"));
        setInputs(new Input("Name", 5), new Input("Troi", 10));
        setChoices(new Choice("Click To Expand"), new Choice("Disable Me"));
    }
}
