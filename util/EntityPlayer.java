package util;

public class EntityPlayer extends Entity {
	protected double armor,speed;
	
	public EntityPlayer () {
		this.armor = 0.1;
		this.speed = 0.1;
	}

	public void damagePlayer(EntityCreature creature){
		health = health - ( creature.getDamage() - (creature.getDamage() * armor));
	}
	
	public void healPlayer(Potion item){
		if (item.healValue() + health >= health)
			{
				health = maxHealth;
			}
	}

}
