import ui.Stage;

public class StageMenu extends Stage {
    @Override
    public void choiceDone(String a) {
        setDialog("Minimized");
        setImages("troi", "troi");
        if(a.equals("Click To Expand")) setChoices("Click To Minimize", "Disable Me", "Disable Me", "Disable Me", "Disable Me", "Disable Me");
        else if(a.equals("Click To Minimize")) init();
    }
    
    @Override
    public void init() {
        setDialog("Maximized");
        setImages("troi");
        setChoices("Click To Expand", "Disable Me");
    }
}
