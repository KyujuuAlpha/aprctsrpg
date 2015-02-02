package util;

public class Assassin implements Interface{
	private double damage, health, speed, armor;
	
	public void initiate()
		{
			damage = 20.0;
			health = 15.0;
			speed = 0.3;
			armor = 0.06;
			
		}
	public double returnH()
	{
		return health;
	}
	public double returnA()
	{
		return armor;
	}
	public double returnS()
	{
		return speed;
	}
	public double returnD()
	{
		return damage;
	}
}
