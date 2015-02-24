package util;

public class Boots extends Item{
	private double speedX;
	public Boots(){
		super("defualtBoots");
		
	}
	public Boots(double speedMutliplier, String name){
		super(name);
		this.speedX = speedMutliplier;
	}
	public double getSpeed(){
		return speedX;
	}
}
