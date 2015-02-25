package util;

public class Abilities {
	protected EntityPlayer player;
	public String[] names = {null,null,null,null};
	public Abilities(EntityPlayer player){
		this.player = player;
	}
	public double damageAbility(){
		return 0;
	}
	
	public String damageAbilityDesc(){
		return null;
	}
	public double defenceAbility(){
		return 0;
	}
	public String defenceAbilityDec(){
		return null;
	} 
	public double utilAbility(){
		return 0;
	}
	public String utilAbilityDesc(){
		return null;
	}
	public double ultiAbility(){
		return 0;
	}
	public String ultiAbilityDesc(){
		return null;
	}
	public String getName(int x){
		return names[x];
	}

}
