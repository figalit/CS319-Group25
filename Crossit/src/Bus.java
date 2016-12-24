
public class Bus extends Vehicle 
{
	protected Bus(int direction)
	{
		super(direction);
		super.setImage(""); //addr of bus png
	}
	
	protected void print()
	{
		System.out.print("-Bus: " + getDirection()+ '-');
	}
}