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
	
	public Item getSlot(int slot) {
		return this.itemList[slot];
	}
}