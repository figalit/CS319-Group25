
public class SidewalkPart extends GameObject {
	private Collectable collectable;
	private Character character;
	
	public SidewalkPart()
	{
		setCollectable(null);
		setCharacter(null);
	}
	public SidewalkPart(Character character)
	{
		setCollectable(null);
		setCharacter(character);
	}
	public SidewalkPart(Character character, Collectable collectable)
	{
		setCollectable(collectable);
		setCharacter(character);
	}
	public SidewalkPart(Collectable collectable)
	{
		setCollectable(collectable);
		setCharacter(null);
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
}
