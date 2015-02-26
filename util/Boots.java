package util;

public class Boots extends Item{
	private double speedX;
	public Boots(){
		super("defualtBoots");
		
	}
	public Boots(double speedMutliplier, String name){//requires values of a double var and a string var / text
		super(name);
		this.speedX = speedMutliplier;
	}
	public double getSpeed(){
		return speedX;
	}
}
