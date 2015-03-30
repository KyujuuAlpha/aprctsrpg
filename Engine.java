import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ui.Display;
import util.Utilities;

public class Engine {
    public static void main(String[] args) {
    	Utilities.init();
    	DataHandler data = new DataHandler();
    	data.reset();
    	try {
    		data.entitiesSheet = ImageIO.read(new File("resources/entities.png"));
    		data.gameOver = ImageIO.read(new File("resources/rip.png"));
    	} catch(IOException e) {
    		System.out.println("Cannot find any resources,");
    		System.exit(0);
        }
        Display displayVar = new Display("AP-RC-TS RPG"); //names the frame
        displayVar.addStage(new StageBattle(data)); //the displaryVar.addStage adds the stage to an array list
        displayVar.addStage(new StagePrologue(data)); //1
        displayVar.addStage(new StageTeam(data)); //2
        displayVar.addStage(new StageBattleTutorial(data)); //3
        displayVar.addStage(new StageFour(data)); //4
        displayVar.addStage(new StageHeadQuarters(data));//5
        displayVar.addStage(new StageZombiePatrol(data)); //6
        displayVar.addStage(new StageMotherZombie(data)); //7
        displayVar.addStage(new StageEndGame(data)); //8
        displayVar.addStage(new StageDeath(data)); //9
        displayVar.begin();
        displayVar.setMinimumSize(new Dimension(600, 600));
    }
}
