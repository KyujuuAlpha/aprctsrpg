package util;

public class Sword implements Item_Interface {
	private double damage;
	private int drop_num;
	private String name;
	private int health;
	public Sword()
	{
		damage = 0;
		name = "null";
		drop_num = 0;
	}
	public Sword(double Damage, String Name, int Drop_num)
	{
		
	}
	public double returnD()
	{
		return damage;
	}
	public double returnHG()
	{
		return health;
	}
	
	

}
