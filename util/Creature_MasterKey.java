package util;
import java.util.Random;

public class Creature_MasterKey {
	static Random gen = new Random();
	private static double[] stats_Value = new double[3];
	private static String[] stats_Name = {"health", "armor", "speed", "attackDamage"};
	public static void set_Stats(double health , double armor, double speed, double attackDamage)
		{
			stats_Value[0] = health;
			stats_Value[1] = armor;
			stats_Value[2] = speed;
			stats_Value[3] = attackDamage;
		}
	public static double stat_Return(String stat)
		{
		for (int i = 0; i <= stats_Name.length; i++)
			{
				if (stats_Name[i].equals(stat))
					{
						return stats_Value[i];
					}
			}
		return 0;
		}
	public static void health_Mutator(double damage)
		{
			stats_Value[0] = stats_Value[0] - damage;
		}
	public static void health_Main_Mutator(double damage)
		{
			double temp_01;
			temp_01 = damage - (stats_Value[1] * damage);
			health_Mutator(temp_01);
			
		}
	public static int randomDrop_Gen()
		{
			int temp;
			temp = gen.nextInt(20);
			return temp;
		}
	
	
}
