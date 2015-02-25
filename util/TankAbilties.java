package util;

public class TankAbilties extends Abilities{
	private String[] names = {"Opening Earth","Iron Body","Insanity","Blessing of the Gods" };
	public TankAbilties(EntityPlayer player){
		super(player);
	}
	public double damageAbility(){
		return player.getDamage() * 2;
	}
	
	public String damageAbilityDesc(){
		String x = "You thrust your weapon into the ground causing the earth to split before you, cuasing you to deal x2 added damage to the enemy";
		return x;
	}
	public double defenceAbility(){
		return player.getArmor() + (player.getArmor() / 2);
	}
	public String defenceAbilityDec(){
		String x = "you use feel energy surrounding your body as your skin hardens to iron cuasing your armor to increase by 1/2";
		return x;
	} 
	public double utilAbility(){
		return player.getSpeed() + 0.2;
		
	}
	public String utilAbilityDesc(){
		String x = "you become insane and increase agility for a short time";
		return x;
	}
	public double utliAbility(){
		return 1.00;
	}
	public String ultiAbilityDesc(){
		String x = "You are granted a blessing from the gods and are invincible for a moment";
		return x;
				
	}
	public String getName(int x){
		return names[x];
	}
}
