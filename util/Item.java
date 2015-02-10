package util;

import java.util.*;

public class Item {
	private static ArrayList<Class> itemList = new ArrayList<Class>();
	
	public Item() {
	}
	
	public static void addItem(Class... var){
		for(Class itemVar : var) {
			itemList.add(itemVar);
		}
	}
	
	public static Class randomItemClass() {
		return itemList.get(new Random().nextInt(itemList.size()));
	}
}
