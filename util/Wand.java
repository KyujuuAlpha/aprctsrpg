package util;

public class Wand extends Item {
	private double speedX,damage;
	/*
	 * defualt construction
	 */
	public Wand(){
	super();
	speedX = 1;
	}
	/*
	 * requires damage and speed (speed works as a times the amount the current speed of the character is) care in use of SpeedX, no more than 2.3
	 */
	public Wand(double damage, double speedX){
		this.damage = damage;
		this.speedX = speedX;
		
	}
	/*
	 * returns damage of object
	 */
	public double getDamage(){
		return damage;
	}
	/*
	 * returns speedX variable from constructed object
	 */
	public double getSpeedMultiplyer(){
		return speedX;
	}
	
}
