import ui.Display;
import ui.Stage;
import util.Utilities;

public class Engine {
    public static void main(String[] args) {
    	Utilities.init();
        Display displayVar = new Display("aprctsrpg");
        displayVar.addStage(new StagePrologue());
        displayVar.addStage(new StageOne());
        displayVar.addStage(new StageTwo());
        displayVar.addStage(new StageThree());
        displayVar.begin();
    }
}
