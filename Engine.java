import ui.Display;
import ui.Stage;
import util.Utilities;

public class Engine {
    public static void main(String[] args) {
    	Utilities.init();
        Display displayVar = new Display("Window");
        displayVar.addStage(new StagePrologue());
        displayVar.addStage(new StageOne());
        displayVar.begin();
    }
}
