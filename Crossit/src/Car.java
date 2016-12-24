
public class Car extends Vehicle 
{
	protected Car(int direction)
	{
		super(direction);
		if(direction == 0)
			super.setImage("car0.png"); //addr of car png
		else
			super.setImage("car1.png"); //addr of car png
	}
	protected void print()
	{
		System.out.print("-Car: " + getDirection()+ '-');
	}
	
}
