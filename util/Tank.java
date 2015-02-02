package util;

public class Tank implements Interface{
	private double damage, health, speed, armor;
	
	public void initiate()
		{
			damage = 5;
			health = 40.0;
			speed = 0.1;
			armor = 0.2;
			
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
