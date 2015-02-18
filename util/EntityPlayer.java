package util;

public class EntityPlayer extends Entity {
<<<<<<< HEAD
	protected double addedArmor,addedDamage,armor,speed,speedX;
	
	public EntityPlayer () {
		super();
		this.armor = 0.1;
		this.speed = 0.1;
	}
	
	
	public EntityPlayer(double armor, double health, double speed, double damage){
		super(health, damage);
		this.armor = armor;
		this.speed = speed;
		this.maxHealth = health;
		
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
		health = health - ( creature.getDamage() - (creature.getDamage() * armor));
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
	
	/*
	 * adds item based on type
	 * 
	 * works off of instanceof , error will occur if one of the following items aren't used "Armor, Potion, Wand, Sword, Boot"
	 */
	public void addItem(Item item){
		if(item instanceof Armor)
			{
				this.addedArmor = ((Armor)item).getArmor() + this.armor;
			}
		if (item instanceof Potion)
			{
				this.health = (healPlayer(((Potion)item).getHeal())); 
			}
		if (item instanceof Wand)
			{
				this.addedDamage = ((Wand)item).getDamage() + this.damage;
			}
		if (item instanceof Sword)
			{
				this.addedDamage =((Sword)item).getDamage() + this.damage;
			}
		if (item instanceof Boots)
			{
				this.speedX = ((Boots)item).getSpeed();
			}
		
	}
=======
    protected double addedArmor,addedDamage,armor,speed,speedX;
    
    public EntityPlayer () {
        this.armor = 0.1;
        this.speed = 0.1;
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
        health = health - ( creature.getDamage() - (creature.getDamage() * armor));
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
    
    /*
     * adds item based on type
     * 
     * works off of instanceof , error will occur if one of the following items aren't used "Armor, Potion, Wand, Sword, Boot"
     */
    public void addItem(Item item){
        if(item instanceof Armor)
            {
                this.addedArmor = ((Armor)item).getArmor() + this.armor;
            }
        if (item instanceof Potion)
            {
                this.health = (healPlayer(((Potion)item).getHeal())); 
            }
        if (item instanceof Wand)
            {
                this.addedDamage = ((Wand)item).getDamage() + this.damage;
            }
        if (item instanceof Sword)
            {
                this.addedDamage =((Sword)item).getDamage() + this.damage;
            }
        if (item instanceof Boots)
            {
                this.speedX = ((Boots)item).getSpeed();
            }
        if (item instanceof iPad)
            {
                this.addedDamage = ((iPad)item).getDamage() + this.damage;
            }
    
        
    }
>>>>>>> origin/master
}
