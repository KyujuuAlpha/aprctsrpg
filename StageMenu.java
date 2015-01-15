import ui.Stage;
import ui.Choice;
import ui.Sprite;

public class StageMenu extends Stage {
    @Override
    public void choiceDone(String a) {
        setDialog("Minimized");
        setSprites(new Sprite("troi"), new Sprite("troi"));
        if(a.equals("Click To Expand")) setChoices(new Choice("Click To Minimize"), new Choice("Disable Me"), new Choice("Disable Me"), new Choice("Disable Me"), new Choice("Disable Me"), new Choice(getInputText(0)));
        else if(a.equals("Click To Minimize")) init();
    }
    
    @Override
    public void init() {
        setDialog("Maximized");
        setSprites(new Sprite("troi"));
        setInputs(5,10);
        setChoices(new Choice("Click To Expand"), new Choice("Disable Me"));
    }
}
