package util;

import java.util.*;

public class EntityPlayer extends Entity {
	protected double armor,speed,speedX;
	protected int heldItemIndex;
	protected Inventory inventory;
	
	public EntityPlayer() {
		super();
		this.armor = 0.1;
		this.speed = 0.1;
		this.inventory = new Inventory(3);
	}
	
	
	public EntityPlayer(double armor, double health, double speed, double damage){
		super(health, damage);
		this.armor = armor;
		this.speed = speed;
		this.maxHealth = health;
		this.inventory = new Inventory(3);
	}
	/*
	 * returns damage + the addedDamage combined
	 */
	public double getDamage(){
		if(inventory.getItem(0) != null) return armor + ((Armor)inventory.getItem(0)).getArmor();
		else return armor;
	}
	
	public double getArmor() {
		if(inventory.getItem(0) != null) return armor + ((Armor)inventory.getItem(0)).getArmor();
		else return armor;
	}
	
	/*
	 * applies input damage from object creature to player
	 * 
	 * takes into account armor
	 */
	public void damagePlayer(EntityCreature creature){
		health = health - ( creature.getDamage() - (creature.getDamage() * (getArmor())));
	}
	
	/*
	 * adds health to player, then returns
	 * 
	 * takes into account error in going over full health, no worries
	 */
	public double healPlayer(double item){
		if (item + health >= health)
			{
				health = maxHealth;
				return health;
			}
		else return health + item;
		
	}
	
	/*
	 * returns speed times the multiplier
	 */
	public double getSpeed(){
		return speed * speedX;
	}
	
	public Item getCurrentHeldItem() {
		return this.inventory.getItem(this.heldItemIndex);
	}
	
	public void setHeldItem(Item item) {
		if(this.inventory.getSlot(item) > -1) this.heldItemIndex = this.inventory.getSlot(item);
	}
	
	/*
	 * adds item based on type
	 * 
	 * works off of instanceof , error will occur if one of the following items aren't used "Armor, Potion, Sword, Boot"
	 */
	public void addItem(Item item){
		for (int i = 0; i < inventory.size(); i++){
			if(inventory.getItem(i) == item) {
				setHeldItem(item);
				removeItem(heldItemIndex);	
				break;
			}	
		}
		if(item instanceof Armor)
			{
				inventory.setSlot(0,item);
			}
		else if (item instanceof Potion)
			{
				this.health = (healPlayer(((Potion)item).getHeal())); 
			}
		else if (item instanceof Sword)
			{
				inventory.setSlot(1,item);
			}
		else if (item instanceof Boots)
			{
				this.speedX = ((Boots)item).getSpeed();
				inventory.setSlot(2,item);
			}
	}
		
	/*
	 * this is used to elimate item values
	 * MUST BE USED AFTER THE METHOD "SETHELDITEM"
	 */
	
	public void removeItem(int itemIndex) {
			inventory.setSlot(itemIndex,null);
		
	}
	

}
