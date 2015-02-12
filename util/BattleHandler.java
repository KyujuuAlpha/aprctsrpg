package util;

public class BattleHandler {
	private static double playerDamage,playerHealth,creatureDamage,creatureHealth;
	public static void playerTurn (EntityPlayer player, EntityCreature creature){
		creature.damageCreature(player);
		creatureHealth = creature.getHealth();
		playerDamage = player.getDamage();
		
	}
	
	public static void creatureTurn (EntityPlayer player, EntityCreature creature){
		
		player.damagePlayer(creature);
		playerHealth = player.getHealth();
		creatureDamage = creature.getDamage();
	}

}
