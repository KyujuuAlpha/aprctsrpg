import java.awt.image.BufferedImage;

import ui.Stage;
import util.EntityCreature;
import util.EntityPlayer;
import util.Item;

public class DataHandler {
	public Stage source;
	public EntityPlayer player;
	public EntityCreature opponent;
	public boolean battleCompleted = false;
	public boolean SHIELD;
	public Item weapon;
	
	public BufferedImage entitiesSheet;
	public BufferedImage gameOver;
	
	public void prepareBattle(EntityPlayer playerVar, EntityCreature entity, Stage stageVar) {
		player = playerVar;
		opponent = entity;
		source = stageVar;
		battleCompleted = false;
	}
	
	public BufferedImage getEntityImage(int indexX, int indexY) {
		return entitiesSheet.getSubimage(indexX*100, indexY*100, 100, 100);
	}
}