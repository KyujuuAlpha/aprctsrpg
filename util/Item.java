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
	public static final Sword normSword = new Sword(40);
	public static final Potion normPotion = new Potion(30);
	public static final Wand normWand = new Wand(20);
	public static final Sword advSword = new Sword(50);
	public static final Potion advPotion = new Potion(50);
	public static final Wand advWand = new Wand(30);
	
	
}
