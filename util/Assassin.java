package util;

public class Assassin extends EntityPlayer{
	public Assassin(){
		super(0.1,50,0.55,45);
		this.maxHealth = this.health;
		this.abilities = new AssasinAbilities(this);
		
	}
}
