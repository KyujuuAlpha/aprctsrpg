package util;

public class EntityCreature extends Entity{
	public EntityCreature() {
		super();
	}
	public void damageCreature(EntityPlayer player){
		this.health = this.health - player.getDamage();
	}

}
