
public class Collectable extends GameObject 
{
	private int value;
	protected Collectable(int value)
	{
		setValue(value);
	}
	protected int getValue() {
		return value;
	}
	protected void setValue(int value) {
		this.value = value;
	}
	
	protected void setImage(String addr)
	{
		super.setImage(addr);
	}
}
