import ui.Display;
import util.Utilities;

public class Engine {
    public static void main(String[] args) {
    	Utilities.init();
        Display displayVar = new Display("AP-RC-TS RPG");
        displayVar.addStage(new StageBattle()); // 0
        displayVar.addStage(new StagePrologue()); //1
        displayVar.addStage(new StageTeam()); //2
        displayVar.addStage(new StageBattleTutorial()); //3
        displayVar.addStage(new StageFour());//4
        displayVar.addStage(new StageHeadQuarters());//5
        displayVar.addStage(new StageZombiePatrol()); //6
        displayVar.addStage(new StageMotherZombie()); //7
        displayVar.addStage(new StageEndGame()); //8
        displayVar.addStage(new StageDeath()); //9
        displayVar.begin();
    }
}
