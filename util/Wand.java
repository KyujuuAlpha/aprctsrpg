package util;

public class Wand extends Item {
	private double damage;
	/*
	 * defualt construction
	 */
	public Wand(){
	super();
	}
	/*
	 * requires damage and speed (speed works as a times the amount the current speed of the character is) care in use of SpeedX, no more than 2.3
	 */
	public Wand(double damage){
		this.damage = damage;
		
	}
	/*
	 * returns damage of object
	 */
	public double getDamage(){
		return damage;
	}
	public double adjustedStat(){
		return 3;
	}
}
