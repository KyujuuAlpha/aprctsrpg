package util;

public class Armor extends Item{
	private double armor;
	public Armor(){
		super("defualtArmor");
	}
	public Armor(double armor, String name){
		super(name);
		this.armor = armor;
	}
	public double getArmor(){
		return armor;
	}
	
	
}
