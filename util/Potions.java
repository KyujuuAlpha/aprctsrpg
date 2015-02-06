package util;

public class Potions implements Item_Interface {
	private double damage;
	private int drop_num;
	private String name;
	private int health;
	public Potions()
	{
		damage = 0;
		name = "null";
		drop_num = 0;
		health = 0;
	}
	public Potions(double Damage, String Name, int Drop_num, int Health)
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
