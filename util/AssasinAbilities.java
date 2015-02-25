package util;

public class AssasinAbilities extends Abilities {
	public String[] names;
	public AssasinAbilities(EntityPlayer player){
		super(player);
		this.names  = new String[]{"Third Eye","Shadows Torment","Darkness","Soul Blade" };
	}
	public double damageAbility(){
		return player.getDamage() *2.5;
	}
	
	public String damageAbilityDesc(){
		String x = "Your senses highten and you feel the critical shot next attack";
		return x;
	}
	public double defenceAbility(){
		return 0.2;
	}
	public String defenceAbilityDec(){
		String x = "The shadow you have casted reduces all incoming damage for a short doration";
		return x;
	} 
	public double utilAbility(){
		return player.getSpeed() * 2;
		
	}
	public String utilAbilityDesc(){
		String x = "You instantly become unseeable in the shadows, making you unable to be touched";
		return x;
	}
	public double utliAbility(){
		player.health = player.health - 10;
		return player.getDamage() * 5;
	}
	public String ultiAbilityDesc(){
		String x = "Your blade merges with your soul, increases your damage by a massive about but deals damage to yourself in the process";
		return x;
				
	}

}
