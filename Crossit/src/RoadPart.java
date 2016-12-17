
public class RoadPart extends GameObject{
	private Collectable collectable;
	private Vehicle vehicle;
	private Character character;
	public RoadPart()
	{
		super.setImage(""); //address of object picture
		setCollectable(null);
		vehicle = null;
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
		if(vehicle != null && character != null)
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
}
