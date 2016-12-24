
public class Car extends Vehicle 
{
	protected Car(int direction)
	{
		super(direction);
		super.setImage("car.png"); //addr of car png
	}
	protected void print()
	{
		System.out.print("-Car: " + getDirection()+ '-');
	}
	
}
