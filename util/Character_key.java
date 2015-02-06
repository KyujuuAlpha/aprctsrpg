package util;

public class Character_key {
	private static double health;
	private static double speed;
	private static double armor,damage;
	static Interface org;
	
	public Character_key(Interface Class)
		{
			Class.initiate();
			health = Class.returnH();
			speed = Class.returnS();
			damage = Class.returnD();
			org = Class;
			
		}
	/**
	 * health mutator / insert creature object 
	 */
	public static void health_M(Creature_key creature)
		{
			health = health - (creature.returnD() - (creature.returnD() * armor));
		}
	/**
	 * health reset / only use in between stages
	 */
	public static void health_R(boolean TF)
		{
			if (TF = true )
				{
					health = org.returnH();
				}
			if (TF = false)
			{
				health = health;
			}
		}
	/**
	 * Used if a health pot is used or a Godly act was given to the player :P
	 */
	public static void health_A(Item_Interface item)
		{
			health = health + item.pot_H;
				if (health > org.returnH())
				{
					health = org.returnH();
				}
		}
	/**
	 * this returns the damage of this Player
	 */
	public static double returnD()
		{
			return damage;
		}
	
}
