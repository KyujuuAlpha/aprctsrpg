package util;

import java.util.*;

public class Item {
	public static ArrayList<Item> itemList = new ArrayList<Item>();
	
	public Item() {
		itemList.add(this);
	}
	
	public static Item getRandomItem() {
		return itemList.get(new Random().nextInt(itemList.size()));
	}



	public static final Potion basicPotion = new Potion(10);
	public static final Sword basicSword = new Sword(30);
	public static final Wand basicWand = new Wand(15);
	public static final Item normSword = new Sword(40);
	public static final Item normPotion = new Potion(30);
	public static final Item normWand = new Wand(20);
	public static final Item advSword = new Sword(50);
	public static final Item advPotion = new Potion(50);
	public static final Item advWand = new Wand(30);
	
	
}
