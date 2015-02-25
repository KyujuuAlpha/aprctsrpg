package util;

import java.util.ArrayList;
import java.util.Random;

public class EntityCreature extends Entity{
	Random gen = new Random();
	public static ArrayList<EntityCreature> creatureList = new ArrayList<EntityCreature>();
	
	public EntityCreature() {
		super();
		creatureList.add(this);
		
	}
	public EntityCreature(double damage, double health){
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
		this.health = this.health - player.getDamage() ;
	}
	
	/*
	 * Returns an object Item based off of what is generated in the Random num genreator
	 */
	public Item randomDrop(){
		int temp = gen.nextInt(Item.itemList.size());
		return Item.itemList.get(temp);
	}
	
	/*
	 * returns 0-1 as a percent chance of comparison
	 */
	public double hitChance(){
		int temp = gen.nextInt(100);
		return temp/100;
	}
	public double getXP(){
		return getDamage() + maxHealth;
	}
	public void levelUp(EntityPlayer player){
		this.health = this.health + ((player.getLevel() * health)/5);
		this.damage = this.damage + ((player.getLevel() * damage)/3);
	}

}
