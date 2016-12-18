
public class Collectable extends GameObject 
{
	private int value;
	public Collectable(int value)
	{
		setValue(value);
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
