package util;

public class Sword extends Item {
	private double damage;
	/*
	 * defualt
	 */
	public Sword(){
		super("defualtSword");
		this.damage = 20;
	}
	/*
	 * requires input of damage to construct object
	 */
	public Sword (double damage, String name){
		super(name);
		this.damage = damage;
	}
	public double getDamage(){
		return damage;
	}

}
