import java.awt.Dimension;

import ui.Display;
import util.Utilities;

public class Engine {
    public static void main(String[] args) {
    	Utilities.init();
    	DataHandler data = new DataHandler();
        Display displayVar = new Display("AP-RC-TS RPG"); //names the frame
        displayVar.addStage(new StageBattle(data)); //the displaryVar.addStage adds the stage to an array list
        displayVar.addStage(new StagePrologue(data)); //1
        displayVar.addStage(new StageTeam(data)); //2
        displayVar.addStage(new StageBattleTutorial(data)); //3
        displayVar.addStage(new StageFour(data));//4
        displayVar.addStage(new StageHeadQuarters(data));//5
        displayVar.addStage(new StageZombiePatrol(data)); //6
        displayVar.addStage(new StageMotherZombie(data)); //7
        displayVar.addStage(new StageEndGame(data)); //8
        displayVar.addStage(new StageDeath(data)); //9
        displayVar.begin();
        displayVar.setMinimumSize(new Dimension(600, 600));
    }
}
