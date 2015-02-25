package util;

public class TankAbilties extends Abilities{
	public TankAbilties(EntityPlayer player){
		super(player);
		this.names = new String[]{"Opening Earth","Iron Body","Insanity","Blessing of the Gods" };
	}
	public double damageAbility(){
		return player.getDamage() * 2;
	}
	
	public String damageAbilityDesc(){
		return "You thrust your weapon into the ground causing the earth to split before you, cuasing you to deal x2 added damage to the enemy";
	}
	public double defenceAbility(){
		return player.getArmor() + (player.getArmor() / 2);
	}
	public String defenceAbilityDec(){
		return "you use feel energy surrounding your body as your skin hardens to iron cuasing your armor to increase by 1/2";
	} 
	public double utilAbility(){
		return player.getSpeed() + 0.2;
		
	}
	public String utilAbilityDesc(){
		return "you become insane and increase agility for a short time";
	}
	public double utliAbility(){
		return player.getDamage() * 2;
	}
	public String ultiAbilityDesc(){
		return "You are granted a blessing from the gods and are powerful for a moment";
				
	}
	public String getName(int x){
		return names[x];
	}
}
