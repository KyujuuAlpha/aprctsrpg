package util;

import java.util.ArrayList;
import java.util.Random;

public class EntityCreature extends Entity{
	Random gen = new Random();//constructed a new Random genereator
	public static ArrayList<EntityCreature> creatureList = new ArrayList<EntityCreature>();//constructed an arrayList of EntityCrerature
	
	public EntityCreature() {//defualt constructer
		super();//invokes superClass from Entity
		creatureList.add(this);//adds this class to the array LIst
		
	}
	
	public EntityCreature(double damage, double health){//
		super();
		this.damage = damage;
		this.health = health;
		
		
	}
	
	/*
	 * returns damage
	 */
	public double getDamage(){
		return damage;
	}
	
	/*
	 * effects health of creature thorugh object player
	 */
	public void damageCreature(EntityPlayer player){
		if (player != null) this.health = this.health - player.getDamage();//checks for a null value then of player, then runs if not true
	}
	
	/*
	 * Returns an object Item based off of what is generated in the Random num genreator
	 */
	public Item randomDrop(){//returns type of Item
		int temp = gen.nextInt(Item.itemList.size());//cretaed a temperary variabel that is assigned the random number that is from 0 to the size of the ArrayList
		return Item.itemList.get(temp);
	}
	
	/*
	 * returns 0-1 as a percent chance of comparison
	 */
	public double hitChance(){
		int temp = gen.nextInt(100);
		return temp/100.0D;//returns the value of a double
	}
	
	public double getXP(){
		return getDamage() + maxHealth;
	}
	public void levelUp(EntityPlayer player){
		this.health = this.health + ((player.getLevel() * health)/5);//scales the health
		this.damage = this.damage + ((player.getLevel() * damage)/3);//scales the damage
	}

}
