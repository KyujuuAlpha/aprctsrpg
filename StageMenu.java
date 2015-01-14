import ui.Stage;

public class StageMenu extends Stage {
    @Override
    public void choiceDone(String a) {
        if(a.equals("hi")) setChoices("hi", "test", "Done", "adf", "dsfsdfs");
    }
    
    @Override
    public void init() {
        setChoices("hi");
    }
}
