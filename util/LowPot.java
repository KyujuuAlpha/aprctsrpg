package util;

public class LowPot extends Potions{
	private double damage, armor, speed;
	private int drop_num;
	private String name;
	private int health;
	public LowPot(double damage, String Name, int Drop_num, int Health, double Armor, double Speed)
	{
		super(damage, Name, Drop_num, Health, Armor, Speed);
	}

}
