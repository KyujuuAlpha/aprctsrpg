package util;

import java.util.*;

public class Item {
	protected String name;
	public static ArrayList<Item> itemList = new ArrayList<Item>();
	
	public Item(String name) {
		itemList.add(this);
		this.name = name;
	}
	
	public static Item getRandomItem() {
		return itemList.get(new Random().nextInt(itemList.size()));
	}



	public static final Potion basicPotion = new Potion(10,"Basic Potion");
	public static final Sword basicSword = new Sword(30,"Basic Sword");
	public static final Sword basicWand = new Sword(25,"Basic Wand");
	public static final Boots basicBoot = new Boots(1.2,"Basic Boots");
	public static final Armor basicArmor = new Armor(0.1,"Baisc Armor");
	public static final Boots normBoots = new Boots(1.3,"Normal Boots");
	public static final Armor normArmor = new Armor(0.3,"Normal Armor");
	public static final Sword normSword = new Sword(40, "Normal Sword");
	public static final Potion normPotion = new Potion(30, "Normal Potion");
	public static final Boots advBoots = new Boots(1.5,"Advanced Boots");
	public static final Armor advArmor = new Armor(0.5, "Advanced Armor");
	public static final Sword advSword = new Sword(50, "Advanced Sword");
	public static final Potion advPotion = new Potion(50,"Advanced Potion");
	public static final Sword pistol = new Sword(40,"Pistol");
	
	
	
}
