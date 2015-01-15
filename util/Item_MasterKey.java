package util;
public class Item_MasterKey {
	static double[] stats_Value = new double[2];
	static String[] stats_Name = {"damage", "drop_Num","poisonDotDamage"};
	public static void set_Stats(double damage, double drop_Num,double poisonDotDmg)
		{
			stats_Value[0] = damage;
			stats_Value[1] = drop_Num;
			stats_Value[2] = poisonDotDmg;
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

}
