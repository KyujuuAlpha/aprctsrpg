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
	
	public double getSpeed(){
		return speed;
	}
	public void addItem(Item item)
	switch (item.adjustedStat())
		{
			case 1: this.armor = this.armor + item.getArmor();
			case 2: this.speed = this.speed * item.getSpeedMultiplyer();
		}
}
