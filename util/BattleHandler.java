package util;

import java.util.Random;

public class BattleHandler {

    /*
     * takes in the EntityPlayer object and the EntityCreature object, using the existing methods inside, applies the damage to creature
     * 
     * this takes care of changing the health
     */
    public static boolean playerTurn (EntityPlayer player, EntityCreature creature){
        /*creature.damageCreature(player);
        if (creature.getHealth() <= 0){
            player.leveling(creature);
        }*/
    	if (creature.hitChance() > player.getSpeed()) {
            return false;
        } else {
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
    
    public static boolean creatureTurn (EntityPlayer player, EntityCreature creature){
        if (creature.hitChance() <= player.getSpeed()) {
            return false;
        } else {
            player.damagePlayer(creature);
            return true;
        }
    }
    
    public static boolean run(EntityPlayer player, EntityCreature creature){
        if (player.getSpeed() > creature.hitChance()){
            return false;
        } else {
            return true;
        }
    }

}
