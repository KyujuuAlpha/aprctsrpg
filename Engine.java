import ui.Display;
import ui.Stage;

public class Engine {
    public static void main(String[] args) {
        Display displayVar = new Display("Window");
        displayVar.addStage(new StagePrologue());
        displayVar.addStage(new StageOne());
        displayVar.begin();
    }
}
