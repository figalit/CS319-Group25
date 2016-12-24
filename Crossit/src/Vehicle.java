
public abstract class Vehicle extends GameObject
{
	private int direction; //0 for left, 1 for right
	protected Vehicle(int direction)
	{
		this.setDirection(direction);
	}
	protected void setImage(String addr)
	{
		super.setImage(addr);
	}
	protected int getDirection() {
		return direction;
	}
	protected void setDirection(int direction) {
		this.direction = direction;
	}
	protected void print()
	{
		
	}
	
}
