package util;

public class MiscPot {
	private double damage, armor, speed;
	private int drop_num;
	private String name;
	private int health;
	public MiscPot(double Damage, String Name, int Drop_num, int Health, double Armor, double Speed)
	{
		health = Health;
		damage = Damage;
		name = Name;
		drop_num = Drop_num;
		armor = Armor;
		speed = Speed;
	}

}
