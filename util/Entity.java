package util;

public class Entity {
	protected double health,damage,maxHealth;
	
	public Entity(){
		health = 100;
		damage = 30;
		maxHealth = this.health;
	}
	
	public double getHealth(){
		return health;
	}
	
	public double getDamage(){
		return damage;
	}

}
