package util;

import java.util.*;
import java.math.*;

public class EntityPlayer extends Entity {
	protected double armor,speed,speedX,level;
	protected int heldItemIndex;
	protected Inventory inventory;
	protected Abilities abilities;
	
	public int armorAbilityAddition = 0;
	public int damageAbilityAddition = 0;
	public int speedAbilityAddition = 0;
	
	public EntityPlayer() {
		super();
		this.armor = 0.1;
		this.speed = 0.45;
		this.speedX = 1;
		this.inventory = new Inventory(3);
		this.abilities = new NormalAbilities(this);
		
	}
	
	
	public EntityPlayer(double armor, double health, double speed, double damage){
		super(health, damage);
		this.armor = armor;
		this.speed = speed;
		this.maxHealth = health;
		this.inventory = new Inventory(3);
		this.level = 1;
		this.speedX = 1;
	}
	/*
	 * returns damage + the addedDamage combined
	 */
	public double getDamage(){
		  int temp = damageAbilityAddition;
		  damageAbilityAddition = 0;
		  if(temp > 0) return temp;
		  if(inventory.getItem(1) != null) return damage + ((Sword)inventory.getItem(1)).getDamage();
		  else return damage + (level * 5);
	}
	
	public double getArmor() {
		int temp = armorAbilityAddition;
		armorAbilityAddition = 0;
		if(temp > 0) return temp;
		if(inventory.getItem(0) != null) return armor + ((Armor)inventory.getItem(0)).getArmor() + temp;
		else return armor + (level/100);
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
		int temp = speedAbilityAddition;
		speedAbilityAddition = 0;
		if(temp > 0) return temp;
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
	public double getAbilities(int abilityNum){
		switch(abilityNum){
		case 0: return abilities.damageAbility();
		case 1: return abilities.defenceAbility();
		case 2: return abilities.utilAbility();
		case 3: return abilities.ultiAbility();
		}
		return -1;
		
	}
	
	public String getAbilitiesDesc(int abilityNum){
		switch(abilityNum){
		case 0: return abilities.damageAbilityDesc();
		case 1: return abilities.defenceAbilityDec();
		case 2: return abilities.utilAbilityDesc();
		case 3: return abilities.ultiAbilityDesc();
		}
		return null;
		
	}
	public String getAbilitiesName(int abilityNum){
		switch(abilityNum){
		case 0: return abilities.names[0];
		case 1: return abilities.names[1];
		case 2: return abilities.names[2];
		case 3: return abilities.names[3];
		}
		return null;
		
	}
		
	/*
	 * this is used to elimate item values
	 * MUST BE USED AFTER THE METHOD "setHeldItem(Item)"
	 */
	
	public void removeItem(int itemIndex) {
			inventory.setSlot(itemIndex,null);
		
	}
	

	public void leveling(EntityCreature creature){
		level = level + ((level * Math.sqrt(creature.getXP()))/70);
		this.health = this.health + ((getLevel() * health)/7);
		this.damage = this.damage + ((getLevel() * damage)/4);
		
	}
	public double getLevel(){
		return level;
	}
	
	

}
