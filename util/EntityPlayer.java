package util;

import java.util.*;

public class EntityPlayer extends Entity {
	protected double addedArmor,addedDamage,armor,speed,speedX;
	protected int heldItemIndex;
	protected ArrayList<Item> inventory;
	
	public EntityPlayer() {
		super();
		this.armor = 0.1;
		this.speed = 0.1;
		this.inventory = new ArrayList<Item>();
	}
	
	
	public EntityPlayer(double armor, double health, double speed, double damage){
		super(health, damage);
		this.armor = armor;
		this.speed = speed;
		this.maxHealth = health;
		this.inventory = new ArrayList<Item>();
	}
	/*
	 * returns damage + the addedDamage combined
	 */
	public double getDamage(){
		return damage + addedDamage;
	}
	
	/*
	 * applies input damage from object creature to player
	 * 
	 * takes into account armor
	 */
	public void damagePlayer(EntityCreature creature){
		health = health - ( creature.getDamage() - (creature.getDamage() * (addedArmor + armor)));
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
		return this.inventory.get(this.heldItemIndex);
	}
	
	public void setHeldItem(Item item) {
		if(this.inventory.indexOf(item) > -1) this.heldItemIndex = this.inventory.indexOf(item);
	}
	
	/*
	 * adds item based on type
	 * 
	 * works off of instanceof , error will occur if one of the following items aren't used "Armor, Potion, Wand, Sword, Boot"
	 */
	public void addItem(Item item){
		if (inventory.size() < 6) {
			if(inventory.contains(item)) {
				setHeldItem(item);
				removeItem(heldItemIndex);	
			}
			if(item instanceof Armor)
				{
					this.addedArmor = ((Armor)item).getArmor();
					inventory.add(item);
				}
			else if (item instanceof Potion)
				{
					this.health = (healPlayer(((Potion)item).getHeal())); 
					inventory.add(item);
				}
			else if (item instanceof Wand)
				{
					this.addedDamage = ((Wand)item).getDamage();
					inventory.add(item);
				}
			else if (item instanceof Sword)
				{
					this.addedDamage =((Sword)item).getDamage();
					inventory.add(item);
				}
			else if (item instanceof Boots)
				{
					this.speedX = ((Boots)item).getSpeed();
					inventory.add(item);
				}
		}
		}
		
	/*
	 * this is used to elimate item values
	 * MUST BE USED AFTER THE METHOD "SETHELDITEM"
	 */
	
	public void removeItem(int itemIndex) {
		if(inventory.get(itemIndex) instanceof Armor)
			{
				addedArmor = 0;
				inventory.remove(itemIndex);
			}
		else if (inventory.get(itemIndex) instanceof Wand)
			{
				addedDamage = 0;
				inventory.remove(itemIndex);
			}
		else if (inventory.get(itemIndex) instanceof Sword)
			{
				addedDamage = 0;
				inventory.remove(itemIndex);
			}
		else if (inventory.get(itemIndex) instanceof Boots)
			{
				this.speedX = 1;
				inventory.remove(itemIndex);
			}
		this.inventory.remove(itemIndex);
		
	}
	

}
