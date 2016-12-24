
public class SidewalkPart extends Part {
	private int theme;
	
	public SidewalkPart(int theme)
	{
		setCollectable(null);
		setCharacter(null);
		this.vehicle = null;
		this.theme = theme;
		if(theme==0)
			super.setImage("grass.png");
		if(theme==1)
			super.setImage("desert.png");
	}
	public SidewalkPart(Character character, int theme)
	{
		setCollectable(null);
		setCharacter(character);
		this.vehicle = null;
		this.theme = theme;
		if(theme == 0)
			super.setImage("grass.png");
		if(theme==1)
			super.setImage("desert.png");
		
	}
	public SidewalkPart(Character character, Collectable collectable, int theme)
	{
		setCollectable(collectable);
		setCharacter(character);
		this.vehicle = null;
		this.theme = theme;
		if(theme == 0)
			super.setImage("grass.png");
		if(theme==1)
			super.setImage("desert.png");
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
