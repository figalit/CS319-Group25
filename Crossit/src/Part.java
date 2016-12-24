
public abstract class Part extends GameObject 
{
	protected Collectable collectable;
	protected Vehicle vehicle;
	protected Character character;
	protected abstract void setCharacter(Character character);
	protected abstract void setCollectable(Collectable collectable);
	protected void setImage(String addr)
	{
		super.setImage(addr);
	}
	protected abstract Character moveCharacter();
	protected void print()
	{
		if(getVehicle() != null && getCharacter() == null)
			getVehicle().print();
		else
			if(getVehicle() == null && getCharacter() != null)
				System.out.print("-char");
			else
				if(getVehicle() != null && getCharacter() != null)
					System.out.print("-collision-");
				else
					System.out.print("-empty-");
	}
	protected Character getCharacter() {
		return character;
	}
	
	protected boolean detectCollision()
	{
		if(getVehicle() != null && getCharacter() != null)
			return true;
		return false;
	}
	protected Collectable getCollectable() {
		return collectable;
	}
	protected Vehicle getVehicle() {
		return vehicle;
	}
}
