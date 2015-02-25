package util;

public class BattleHandler {
    private static String Exception;
    /*
     * takes in the EntityPlayer object and the EntityCreature object, using the existing methods inside, applies the damage to creature
     * 
     * this takes care of changing the health
     */
    public static void playerTurn (EntityPlayer player, EntityCreature creature){
        creature.damageCreature(player);
        if (creature.getHealth() <= 0){
            player.leveling(creature);
        }
        
    }
    /*
     * This uses the EntityPLayer object and the EntityCreature object, using the existing methods inside, applies the damage to player
     * 
     * This takes care of changing the player health, and takes into effect of the speed, there is a chance nothing will happen at all.
     * 
     * if missed, the message will be stored to static variable "exception"
     */
    
    public static String creatureTurn (EntityPlayer player, EntityCreature creature){
        if (player.speedX > creature.hitChance()) {
                player.health = player.getHealth();
                Exception = " But it Missed!!!!!";
                return Exception;
            }
        else {
                player.damagePlayer(creature);
                Exception = "And you took damage!!!";
                return Exception;
            }
        /*
         * if this method is invoked, it calculates the propbabiliy of runing away
         * 
         * takes into acco  unt the chance if its a hit or miss
         */
    }
    public static String Run(EntityPlayer player, EntityCreature creature){
        if (player.getSpeed() * 2 < creature.hitChance()){
            return creatureTurn(player, creature);
        }else {
            Exception = "Your ran away!!!!!";
            return Exception;
        }
    }

}
