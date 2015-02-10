import ui.Display;
import ui.Stage;
import util.Utilities;

public class Engine {
    public static void main(String[] args) {
<<<<<<< HEAD
    	Utilities.init();
        Display displayVar = new Display("Window");
=======
        Display displayVar = new Display("aprctsrpg");
>>>>>>> origin/master
        displayVar.addStage(new StagePrologue());
        displayVar.addStage(new StageOne());
        displayVar.addStage(new StageTwo());
        displayVar.addStage(new StageThree());
        displayVar.begin();
    }
}
