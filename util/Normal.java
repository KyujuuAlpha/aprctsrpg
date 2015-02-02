package util;

public class Normal implements Interface{
	private double damage, health, speed, armor;
	
	public void initiate()
		{
			damage = 10;
			health = 30.0;
			speed = 0.2;
			armor = 0.15;
			
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
