package util;

public class Assassin extends EntityPlayer{
	public Assassin(){
		super(0.1,50,0.65,45);//calls apon the super constructer form EntityPlayer Class
		this.maxHealth = this.health;
		this.abilities = new AssasinAbilities(this);
		
	}
}
