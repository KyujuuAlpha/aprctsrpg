import ui.Window;
import ui.Stage;

public class Engine {
    public static void main(String[] args) {
        Stage.addStage(new StageMenu());
        Stage.addStage(new StageTest());
        Window.init();
    }
}
