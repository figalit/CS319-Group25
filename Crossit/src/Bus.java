
public class Bus extends Vehicle 
{
	protected Bus(int direction)
	{
		super(direction);
		if(direction == 0)
			super.setImage("truck1.png"); //addr of car png
		else
			super.setImage("truck0.png"); //addr of car png
	}
	
	protected void print()
	{
		System.out.print("-Bus: " + getDirection()+ '-');
	}
}