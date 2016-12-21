
public class Motorcycle extends Vehicle 
{
	public Motorcycle(int direction)
	{
		super(direction);
		super.setImage("car.png"); //addr of motor png
	}
	public void print()
	{
		System.out.print("-Motor: " + getDirection()+ '-');
	}
}
