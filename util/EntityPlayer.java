package util;

import java.util.*;
import java.math.*;

public class EntityPlayer extends Entity {
	protected double armor,speed,speedX,level;
	protected int heldItemIndex;
	protected Inventory inventory;
	protected Abilities abilities;
	
	public double armorAbilityAddition = 0;
	public double damageAbilityAddition = 0;
	public double speedAbilityAddition = 0;
	
	public EntityPlayer() {//defualt constructer
		super();//invokes super class constructer
		this.armor = 0.1;
		this.speed = 0.45;
		this.speedX = 1;
		this.inventory = new Inventory(3);//assignes the array of Inventory to a size of 4 holding spaces
		this.abilities = new NormalAbilities(this);//constructs a new class of Normal abilities that take in this class as it's explicit parameters
		
	}
	
	
	public EntityPlayer(double armor, double health, double speed, double damage){
		super(health, damage);//invokes the super constructer while feeding values to the explicit paremters
		this.armor = armor;//assignes this armor of this class to the explicit paramenters of the explicit parameters
		this.speed = speed;
		this.maxHealth = health;
		this.inventory = new Inventory(3);
		this.level = 1;
		this.speedX = 1;
	}
	/*
	 * returns damage + the addedDamage combined
	 */
	public double getDamage(){//reutrn type double
		  double temp = damageAbilityAddition;//creation of a temparary variable
		  damageAbilityAddition = 0;
		  if(temp > 0) return temp;//exits out of method
		  if(inventory.getItem(1) != null) return damage + ((Sword)inventory.getItem(1)).getDamage();//casts get item one which holds damage from a sword  as a sword, that holds the value of damage
		  else return damage + (level * 5);//exit
	}
	
	public double getArmor() {
		double temp = armorAbilityAddition;
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
	public double healPlayer(double item){//takes in the input of the explicit parameters of a double value
		if (item + health >= health)
			{
			this.maxHealth = this.maxHealth + ((getLevel() * maxHealth)/7);
			this.health = maxHealth;
				return health;
			}
		else return health + item;
		
	}
	
	/*
	 * returns speed times the multiplier
	 */
	public double getSpeed(){
		double temp = speedAbilityAddition;
		speedAbilityAddition = 0;
		if(temp > 0) return temp;
		return speed * speedX;
	}
	
	public Item getCurrentHeldItem() {
		return this.inventory.getItem(this.heldItemIndex);//returns the inventory class that was created above, invoke a method apon it, with the explicit parementers of the heldItemIndex
	}
	
	public void setHeldItem(Item item) {
		if(this.inventory.getSlot(item) > -1) this.heldItemIndex = this.inventory.getSlot(item);//sets the value of setItemIdex from the constructed clas inventory and invokes the method getSolt
	}
	
	/*
	 * adds item based on type
	 * 
	 * works off of instanceof , error will occur if one of the following items aren't used "Armor, Potion, Sword, Boot"
	 */
	public void addItem(Item item){
		for (int i = 0; i < inventory.size(); i++){//for loop that loop as much as invetory size method return value
			if(inventory.getItem(i) == item) {
				setHeldItem(item);
				removeItem(heldItemIndex);	
				break;
			}	
		}
		if(item instanceof Armor)//checks to see if the item value points to the same memeorylocation as Armor
			{
				inventory.setSlot(0,item);//invokes setSlot apon inventory with the explicit parameters
			}
		else if (item instanceof Potion)
			{
				this.health = (healPlayer(((Potion)item).getHeal())); //assignes this health to return value of health value with the explicit parameters of item poton.getHeal return value
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
		case 0: return abilities.damageAbility();//check to see equivuialce, then returns the abilitie class method
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
		level = level + ((level * Math.sqrt(creature.getXP()))/50);
		this.maxHealth = this.maxHealth + ((getLevel() * maxHealth)/7);
		this.damage = this.damage + ((getLevel() * damage)/4);
		
	}
	public double getLevel(){
		return level;
	}
	
	

}
