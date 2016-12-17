
public abstract class Vehicle extends GameObject
{
	private int direction; //0 for left, 1 for right
	public Vehicle(int direction)
	{
		this.setDirection(direction);
	}
	public void setImage(String addr)
	{
		super.setImage(addr);
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
}
