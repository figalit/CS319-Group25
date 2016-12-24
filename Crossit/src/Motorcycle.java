
public class Motorcycle extends Vehicle 
{
	protected Motorcycle(int direction)
	{
		super(direction);
		super.setImage("car.png"); //addr of motor png
	}
	protected void print()
	{
		System.out.print("-Motor: " + getDirection()+ '-');
	}
}
