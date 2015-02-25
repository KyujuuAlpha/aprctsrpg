package util;

public class NormalAbilities extends Abilities {
	public String[] names = {"Iron Fist","Extra Armor", "Nikes", "Chuk-norris to the Face"};
	public NormalAbilities(EntityPlayer player) {
		super(player);
	}
	public double damageAbility(){
		return player.getDamage() * 2.3;
	}
	
	public String damageAbilityDesc(){
		String x = "Your fists become more powerful that your weapon, dealing extra damage";
		return x;
	}
	public double defenceAbility(){
		return player.getArmor() + 0.3;
	}
	public String defenceAbilityDec(){
		String x = "It comes in handy when you have a armor vest on";
		return x;
	} 
	public double utilAbility(){
		return player.getSpeed() * 1.2;
		
	}
	public String utilAbilityDesc(){
		String x = "DEM NIKES THOUGH";
		return x;
	}
	public double ultiAbility(){
		player.health = player.health - 6;
		return player.getDamage() * 3;
	}
	public String ultiAbilityDesc(){
		String x = "The enemy takes a chuck-norris puck to the face... but it is so powerful it hurt anyone who weilds its powers";
		return x;
				
	}
	public String getName(int x){
		return names[x];
	}
}
