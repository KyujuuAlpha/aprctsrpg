package util;

public class Abilities {
	protected EntityPlayer player;//initialized a viarble that is type player, and is reused through all classes that inherit parent
	public String[] names = {null,null,null,null};//constructed String array names, all with a null
	public Abilities(EntityPlayer player){//created a construter
		this.player = player;
	}
	public double damageAbility(){//returns double value
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
	public String utilAbilityDesc(){//returns String
		return null;//does not point to any value/information
	}
	public double ultiAbility(){
		return 0;
	}
	public String ultiAbilityDesc(){
		return null;
	}
	public String getName(int x){
		return names[x];//returns value of name at index 'x'
	}

}
