

public class RoadPart extends Part{
	
	//private BufferedImage image;
	
	public RoadPart()
	{
		super.setImage(""); //address of object picture
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
		if(getVehicle() != null)
			((Motorcycle)getVehicle()).print();
		else
			System.out.print("-empty-");
	}
}
