package util;

public class tankAbilitites {
	public tankAbilitites(EntityPlayer player){
		super();
	}
	public double damageAbility(){
		return player.getDamage() * 2
	}
	
	public String damageAbilityDesc(){
		String x = "You thrust your sword into the ground causing the earth to split before you, cuasing you to deal x2 added damage to the enemy";
		return x;
	}
}
