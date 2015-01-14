package util;

public class Character {
	static private double[] stat_Value = new double[6];
	static private String[] stats_Name = {"health", "armor", "speed", "speed_Multiplier", "attackDamage", "weapon_Dmg","Gold","Backpack"};
	public static void character_Stats()
		{
			stat_Value[0] = 100;
			stat_Value[1] = 0.10;
			stat_Value[2] = 10.0;
			stat_Value[3] = 0.05;
			stat_Value[4] = 5.0;
			stat_Value[5] = 0;
			
		}
	public static double character_Stats_Return (String stat_Name)
		{
			for (int i = 0; i <= stats_Name.length; i++)
				{
					if (stats_Name[i].equals(stat_Name))
						{
							return stat_Value[i];
						}
				}
			return 0;
		}
	public static void health_Mutator(double damage)
		{
			stat_Value[0] = stat_Value[0] - damage;
		}
	public static void health_Main_Mutator(double damage)
		{
			double temp_01;
			temp_01 = damage - (stat_Value[1] * damage);
			health_Mutator(temp_01);
			
		}
	public static void armor_Mutator(double armor){
		if (armor > 0.0 && armor <1.0)
			{
				stat_Value[1] = armor;
			}
				
		
		}
	public static void speed_Multiplier_Mutator(String item_Name){
		
	}
		
	
	

}
