package util;

public class BattleHandler {

    /*
     * takes in the EntityPlayer object and the EntityCreature object, using the existing methods inside, applies the damage to creature
     * 
     * this takes care of changing the health
     */
    public static boolean playerTurn (EntityPlayer player, int abilities, EntityCreature creature){
        /*creature.damageCreature(player);
        if (creature.getHealth() <= 0){
            player.leveling(creature);
        }*/
    	if (creature.hitChance() > player.getSpeed()) {
            return false;
        }   			
    			
    	
    		else {
    		if(abilities != -1){
        		for(int i = 0; i<4;i++){
        			if( player.getAbilities(i) == player.getAbilities(0)){
        				creature.damageCreature(null,player.getAbilities(0));
    				}
        			if( player.getAbilities(i) == player.getAbilities(1)){
        		}
    		}
            creature.damageCreature(player);
            return true;
        }
    }
  }
    /*
     * This uses the EntityPLayer object and the EntityCreature object, using the existing methods inside, applies the damage to player
     * 
     * This takes care of changing the player health, and takes into effect of the speed, there is a chance nothing will happen at all.
     * 
     * if missed, the message will be stored to static variable "exception"
     */
    
    public static boolean creatureTurn (EntityPlayer player, EntityCreature creature){
        if (creature.hitChance() <= player.getSpeed()) {
            return false;
        } else {
            player.damagePlayer(creature);
            return true;
        }
    }
    
    public static boolean run(EntityPlayer player, EntityCreature creature){
    	if (creature.hitChance() > player.getSpeed()) {
            return false;
        } 
        else {
            return true;
        }
    }

}
