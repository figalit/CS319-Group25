

public class RoadPart extends Part{
	
	//private BufferedImage image;
	
	public RoadPart()
	{
		super.setImage("road.png"); //address of object picture
		setCollectable(null);
		setVehicle(null);
		setCharacter(null);
	}
	public RoadPart(Vehicle vehicle)
	{
		super.setImage(""); //address of object picture
		this.setVehicle(vehicle);
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public boolean checkCollision()
	{
		if(getVehicle() != null && getCharacter() != null)
			return true;
		return false;
	}
	public Character getCharacter() {
		return character;
	}
	public void setCharacter(Character character) {
		this.character = character;
	}
	public Collectable getCollectable() {
		return collectable;
	}
	public void setCollectable(Collectable collectable) {
		this.collectable = collectable;
	}
	
	public void print()
	{
		super.print();
	}
	public Character moveCharacter()
	{
		Character temp = getCharacter();
		setCharacter(null);
		return temp;
	}
}
