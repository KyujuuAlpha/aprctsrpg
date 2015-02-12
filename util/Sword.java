package util;

public class Sword extends Item {
	private double damage;
	/*
	 * defualt
	 */
	public Sword(){
		super();
		this.damage = 20;
	}
	/*
	 * requires input of damage to construct object
	 */
	public Sword (double damage){
		super();
		this.damage = damage;
	}
	public double getDamage(){
		return damage;
	}
	public double adjustedStat(){
		return 3;
	}
}
