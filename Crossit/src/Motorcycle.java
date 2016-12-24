
public class Motorcycle extends Vehicle 
{
	protected Motorcycle(int direction)
	{
		super(direction);
		if(direction == 0)
			super.setImage("motorcycle1.png"); //addr of car png
		else
			super.setImage("motorcycle0.png"); //addr of car png
	}
	protected void print()
	{
		System.out.print("-Motor: " + getDirection()+ '-');
	}
}
