import ui.Display;
import ui.Stage;

public class Engine {
    public static void main(String[] args) {
        Display displayVar = new Display("Window");
        displayVar.addStage(new StageMenu());
        displayVar.addStage(new StageTest());
        displayVar.begin();
    }
}
