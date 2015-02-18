package util;

public class Entity {
	protected double health,damage,maxHealth;
	
	public Entity(){
		health = 100;
		damage = 30;
		maxHealth = this.health;
	}
	public Entity(double health, double damage){
		this.health = health;
		this.damage = damage;
	}
	
	public double getHealth(){
		return health;
	}


}
