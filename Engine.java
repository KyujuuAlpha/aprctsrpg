import ui.Display;
import ui.Stage;

public class Engine {
    public static void main(String[] args) {
        Stage.addStage(new StageMenu());
        Stage.addStage(new StageTest());
        Display.init();
    }
}
