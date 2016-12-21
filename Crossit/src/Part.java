
public abstract class Part extends GameObject 
{
	protected Collectable collectable;
	protected Vehicle vehicle;
	protected Character character;
	public abstract Collectable getCollectable();
	public abstract Character getCharacter();
	public abstract Vehicle getVehicle();
	public abstract void setCharacter(Character character);
	public abstract void setCollectable(Collectable collectable);
	public void setImage(String addr)
	{
		super.setImage(addr);
	}
	public abstract Character moveCharacter();
	public void print()
	{
		if(getVehicle() != null && getCharacter() == null)
			((Motorcycle)getVehicle()).print();
		else
			if(getVehicle() == null && getCharacter() != null)
				System.out.print("-char");
			else
				if(getVehicle() != null && getCharacter() != null)
					System.out.print("-collision-");
				else
					System.out.print("-empty-");
	}
}
