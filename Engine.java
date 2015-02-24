import ui.Display;
import util.Utilities;

public class Engine {
    public static void main(String[] args) {
    	Utilities.init();
        Display displayVar = new Display("aprctsrpg");
        displayVar.addStage(new StageBattle());
        displayVar.addStage(new StagePrologue());
        displayVar.addStage(new StageTeam());
        displayVar.addStage(new StageBattleTutorial());
        displayVar.addStage(new StageFour());
        displayVar.addStage(new ZombiePatrol());
        displayVar.begin();
    }
}
