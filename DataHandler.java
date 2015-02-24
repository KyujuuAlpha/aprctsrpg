import ui.Stage;
import util.*;

public class DataHandler {
	public static Stage source;
	public static EntityPlayer player;
	public static EntityCreature opponent;
	public static boolean battleCompleted = false;
	public static boolean SHIELD;
	public static Item weapon;
	
	public static void prepareBattle(EntityPlayer playerVar, EntityCreature entity, Stage stageVar) {
		player = playerVar;
		opponent = entity;
		source = stageVar;
		battleCompleted = false;
	}
}