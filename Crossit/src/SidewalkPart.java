
public class SidewalkPart extends Part {
	
	public SidewalkPart()
	{
		setCollectable(null);
		setCharacter(null);
		this.vehicle = null;
		super.setImage("grass.png");
	}
	public SidewalkPart(Character character)
	{
		setCollectable(null);
		setCharacter(character);
		this.vehicle = null;
	}
	public SidewalkPart(Character character, Collectable collectable)
	{
		setCollectable(collectable);
		setCharacter(character);
		this.vehicle = null;
	}
	public SidewalkPart(Collectable collectable)
	{
		setCollectable(collectable);
		setCharacter(null);
		this.vehicle = null;
	}

	public Collectable getCollectable() {
		return collectable;
	}
	public void setCollectable(Collectable collectable) {
		this.collectable = collectable;
	}
	public Character getCharacter() {
		return character;
	}
	public void setCharacter(Character character) {
		this.character = character;
	}
	public Character moveCharacter()
	{
		Character temp = getCharacter();
		setCharacter(null);
		return temp;
	}	
	public void print()
	{
		super.print();
	}
	public Vehicle getVehicle() {
		return null;
	}
}
