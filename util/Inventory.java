package util;

public class Inventory {
	private Item[] itemList;
	
	public Inventory(int invSize) {
		this.itemList = new Item[invSize];
	}
	
	public int size() {
		return this.itemList.length;
	}
	
	public void setSlot(int slot, Item item) {
		this.itemList[slot] = item;
	}
	
	public Item getItem(int slot) {
		return this.itemList[slot];
		
	}
	
	public int getSlot(Item item) {
		for(int i = 0; i < this.itemList.length; i++) {
			if(item == this.itemList[i]) return i;
		}
		return -1;
	}
}