package util;

public class NormalAbilities extends Abilities {
	public NormalAbilities(EntityPlayer player) {
		super(player);
		this.names = new String[]{"Iron Fist","Extra Armor", "Nikes", "Chuk-norris to the Face"};
	}
	public double damageAbility(){
		return player.getDamage() * 2.3;
	}
	
	public String damageAbilityDesc(){
		
		return  "Your fists become more powerful that your weapon, dealing extra damage";
	}
	public double defenceAbility(){
		return player.getArmor() + 0.3;
	}
	public String defenceAbilityDec(){
		
		return "It comes in handy when you have a armor vest on";
	} 
	public double utilAbility(){
		return player.getSpeed() * 1.2;
		
	}
	public String utilAbilityDesc(){
		
		return "DEM NIKES THOUGH";
	}
	public double ultiAbility(){
		player.health = player.health - 6;
		return player.getDamage() * 3;
	}
	public String ultiAbilityDesc(){
		
		return  "The enemy takes a chuck-norris puck to the face... but it is so powerful it hurt anyone who weilds its powers";
				
	}
	public String getName(int x){
		return names[x];
	}
}
