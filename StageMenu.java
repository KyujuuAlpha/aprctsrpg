import ui.Stage;
import ui.Choice;

public class StageMenu extends Stage {
    @Override
    public void choiceDone(String a) {
        setDialog("Minimized");
        setImages("troi", "troi");
        if(a.equals("Click To Expand")) setChoices(new Choice("Click To Minimize"), new Choice("Disable Me"), new Choice("Disable Me"), new Choice("Disable Me"), new Choice("Disable Me"), new Choice(getInputText(0)));
        else if(a.equals("Click To Minimize")) init();
    }
    
    @Override
    public void init() {
        setDialog("Maximized");
        setImages("troi");
        setInputs(5,10);
        setChoices(new Choice("Click To Expand"), new Choice("Disable Me"));
    }
}
