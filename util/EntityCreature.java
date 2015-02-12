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
	public void damageCreature(EntityPlayer player){
		this.health = this.health - player.getDamage();
	}
	public Item randomDrop(){
		int temp = gen.nextInt(Item.itemList.size());
		return Item.itemList.get(temp);
	}

}
