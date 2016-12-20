
public abstract class Part extends GameObject 
{
	protected Collectable collectable;
	protected Vehicle vehicle;
	protected Character character;
	public abstract Collectable getCollectable();
	public abstract Character getCharacter();
	public abstract Vehicle getVehicle();
	public void setImage(String addr)
	{
		super.setImage(addr);
	}
}
