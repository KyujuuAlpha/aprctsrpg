package util;

import java.util.*;

public class Item {
	protected String name;
	public static ArrayList<Item> itemList = new ArrayList<Item>();//constructeed new Arraylist with Item set
	
	public Item(String name) {//constructor with explicit parameters of a String 
		itemList.add(this);//stores this onbject into the arraylist
		this.name = name;//sets the name of this class as the name that lies inside of the method
	}
	
	public static Item getRandomItem() {//return type of Class Item
		return itemList.get(new Random().nextInt(itemList.size()));//returns item based off of a psudo random generator. Is also constructing a new Random Object
	}
	public String getName(){
		return name;
	}



	public static final Potion basicPotion = new Potion(10,"Basic Potion");//constructed a type potion sword with the giver explicit paramenters
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
