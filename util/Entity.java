package util;

public class Entity {
	protected double health,damage,maxHealth;
	
	public Entity(){//defalt constructer
		health = 100;
		damage = 30;
		maxHealth = this.health;
	}
	public Entity(double health, double damage){//invoked constructer
		this.health = health;//asisnges this health, that is within this class, to the damaged value from the explicit parameters
		this.damage = damage;
	}
	
	public double getHealth(){
		return health;
	}
		

}
