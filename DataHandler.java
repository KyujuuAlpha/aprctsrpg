import ui.Stage;
import util.*;

public class DataHandler {
	public Stage source;
	public EntityPlayer player;
	public EntityCreature opponent;
	public boolean battleCompleted = false;
	public boolean SHIELD;
	public Item weapon;
	
	public void prepareBattle(EntityPlayer playerVar, EntityCreature entity, Stage stageVar) {
		player = playerVar;
		opponent = entity;
		source = stageVar;
		battleCompleted = false;
	}
}