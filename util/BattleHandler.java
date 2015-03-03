package util;

public class BattleHandler {

    /*
     * takes in the EntityPlayer object and the EntityCreature object, using the existing methods inside, applies the damage to creature
     * 
     * this takes care of changing the health
     */
    public static boolean playerTurn (EntityPlayer player, int abilities, EntityCreature creature){//return true or false
    	if (creature.hitChance() > player.getSpeed()) {// checks for return value of the condition to be true
            return false;//if true then returns false, stepping out of the class
        } else {
    		if(abilities > -1){
    			if(abilities == 0){
    				player.damageAbilityAddition =  player.getAbilities(0);//assignes player variable to the retuned value in player.getabilities(1)
				}
    			if(abilities == 1){
    				player.armorAbilityAddition =  player.getAbilities(1);//assignes player variable to the retuned value in player.getabilities(1)
        		}
    			if(abilities == 2){
    				player.speedAbilityAddition =  player.getAbilities(2);
        		}
    			if(abilities == 3){
    				player.damageAbilityAddition = player.getAbilities(3);
        		}
    			
	        }
    		creature.damageCreature(player);
    		return true;
        }
    }
    /*
     * This uses the EntityPLayer object and the EntityCreature object, using the existing methods inside, applies the damage to player
     * 
     * This takes care of changing the player health, and takes into effect of the speed, there is a chance nothing will happen at all.
     * 
     * if missed, the message will be stored to static variable "exception"
     */
    
    public static boolean creatureTurn (EntityPlayer player, EntityCreature creature){//Requires the value to different type objects
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
