package util;

public class Boots extends Item{
	private double speedX;
	public Boots(){
		super();
		
	}
	public Boots(double speedMutliplier){
		super();
		this.speedX = speedMutliplier;
	}
	public double getSpeed(){
		return speedX;
	}
}
