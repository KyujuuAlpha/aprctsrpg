package util;

public class Potion extends Item {
	protected double heal;
	/*
	 * defualt
	 */
	public Potion (){
		super("Potion");
		heal = 5;
	}
	/*
	 * required health input
	 */
	public Potion(double health,String name){
		super(name);
		this.heal = health;
	}
	/*
	 * returns value of healing ability
	 */
	public double getHeal() {
		return heal;
	}
}
