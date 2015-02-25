import ui.Display;
import util.Utilities;

public class Engine {
    public static void main(String[] args) {
    	Utilities.init();
        Display displayVar = new Display("aprctsrpg");
        displayVar.addStage(new StageBattle()); // 0
        displayVar.addStage(new StagePrologue()); //1
        displayVar.addStage(new StageTeam()); //2
        displayVar.addStage(new StageBattleTutorial()); //3
        displayVar.addStage(new StageFour());//4
        displayVar.addStage(new HeadQuarters());//5
        displayVar.addStage(new ZombiePatrol()); //6
        displayVar.addStage(new WeaponUpgrade()); //7
        displayVar.addStage(new MotherZombie()); //8
        displayVar.addStage(new EndGame());
        displayVar.begin();
    }
}
