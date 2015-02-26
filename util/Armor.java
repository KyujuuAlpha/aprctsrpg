package util;

public class Armor extends Item{//inherits from Item
	private double armor;
	public Armor(){
		super("defualtArmor");
	}
	public Armor(double armor, String name){
		super(name);
		this.armor = armor;//assigns the value from this method to the variable form this class
	}
	public double getArmor(){
		return armor;
	}
	
	
}
