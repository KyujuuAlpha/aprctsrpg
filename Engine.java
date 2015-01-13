import ui.Window;
import ui.Stage;

public class Engine {
    public static void main(String[] args) {
        Stage.addStage(new StageMenu());
        Window.init();
    }
}
