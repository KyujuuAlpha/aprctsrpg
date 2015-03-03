package util;

public class Potion extends Item {//inherits the Class Items methods and variabels
	protected double heal;
	/*
	 * defualt
	 */
	public Potion (){
		super("Potion");//calls apon the super instructer with the explicit paremeters of STring Potion
		heal = 5;
	}
	/*
	 * required health input
	 */
	public Potion(double health,String name){//another constructer with the explicit parameters of a adouble and Strin name;
		super(name);//invokes super Constructer with the explicit parameters of string name;
		this.heal = health;//assignes the value of 
	}
	/*
	 * returns value of healing ability
	 */
	public double getHeal() {
		return heal;
	}
}
