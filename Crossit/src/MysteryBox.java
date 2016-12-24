
public class MysteryBox extends Collectable {
	
	public MysteryBox()
	{
		super((int)(Math.random()* 4 + 1));
		super.setImage("mysteryBox.png");
	}
}
