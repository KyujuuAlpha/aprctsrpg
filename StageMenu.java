import ui.Stage;

public class StageMenu extends Stage {
    @Override
    public void init() {
        System.out.println(checkChoices());
        nextStage();
    }
}
