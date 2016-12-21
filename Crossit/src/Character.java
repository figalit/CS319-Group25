import java.util.*;
public class Character extends GameObject 
{
	private ArrayList hats;
	
	public Character(ArrayList purchasedHats)
	{
		hats = purchasedHats;
		super.setImage((String)hats.get(0));
	}
	
	protected void changeHat(int no)
	{
		super.setImage((String)hats.get(no));
	}
	
	protected void addHat(String addr)
	{
		hats.add(addr);
	}
}
