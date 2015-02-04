package util;
import java.util.Random;
public class Creature_key {
	private static Random gen = new Random();
	private static double damage, health, speed;
	public Creature_key(double Damage, double Health, double Speed)
		{
			damage = Damage;
			health = Health;
			speed = Speed;
		}

	/**
	 * health mutator / insert creature object 
	 */
	public static void health_M(Character_key chara)
		{
			health = health - chara.returnD();
		}
	public static double returnD()
	{
		return damage;
	}
	public static Item_Interface item_Drop()
	{
		int temp = gen.nextInt(20);
		for (int x = 0; <= 20; x++)
		{
			if (temp == )
		}
	}
	
}
