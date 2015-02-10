package util;
import java.util.Random;
public class Creature_key {
	private static Random gen = new Random();
	private static double damage, health, speed;
	private static Item_Interface[] Item = new Item_Interface[]{new Gun(),new Sword(),};
	public Creature_key(double Damage, double Health, double Speed)
		{
			damage = Damage;
			health = Health;
			speed = Speed;
		}

	/**
	 * health mutator / insert creature object 
	 */
	public void health_M(Character_key chara)
		{
			health = health - chara.returnD();
		}
	public double returnD()
	{
		return damage;
	}
/*	public Item_Interface item_Drop()
	{
		
		int temp = gen.nextInt(20);
		for (int x = 0; x <= 20; x++)
		{
			if (temp == )
		}
	}*/
	
}
