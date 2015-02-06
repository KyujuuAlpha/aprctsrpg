package util;

public class Boots implements Item_Interface {
	private double damage, armor, speed;
	private int drop_num;
	private String name;
	private int health;
	public Boots()
	{
		damage = 0;
		name = "null";
		drop_num = 0;
		health = 0;
		speed = 0;
		
	}
	public Boots(double Damage, String Name, int Drop_num, int Health, double Armor, double Speed)
	{
		health = Health;
		damage = Damage;
		name = Name;
		drop_num = Drop_num;
	}
	public double returnD()
	{
		return damage;
	}
	public double returnHG()
	{
		return health;
	}
	public double returnDN()
	{
		return drop_num;
	}
	public String name()
	{
		return name;
	}
	
	

}
