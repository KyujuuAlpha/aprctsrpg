package util;

public class Potion extends Item {
	protected double heal;
	public Potion (){
		heal = 5;
	}
	public Potion(double health){
		this.heal = health;
	}
	
	public double healValue() {
		return heal;
	}
}
