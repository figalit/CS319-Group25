import java.util.*;
public class Character extends GameObject 
{
	private ArrayList hats;
	private int activeHat;
	public Character(ArrayList purchasedHats)
	{
		activeHat = 0;
		hats = purchasedHats;
		super.setImage((String)hats.get(activeHat));
	}
	
	protected void changeHat(int no)
	{
		activeHat = no;
		super.setImage((String)hats.get(activeHat));
	}
	protected void changeDirection(String no)
	{
		String temp = no + (String)hats.get(activeHat); 
		super.setImage(temp);
	}
	
	protected void addHat(String addr)
	{
		hats.add(addr);
	}
}
