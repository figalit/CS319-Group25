import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class GameObject {
	//private Position pos;
	protected BufferedImage image;
	
	/*public Position getPos() {
		return pos;
	}
	public void setPos(Position pos) {
		this.pos = pos;
	}*/
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(String addr){
		try
	    {
	      image = ImageIO.read(new File(addr));// the line that reads the image file
	    } 
	    catch (IOException e)
	    {
	      System.out.println("Png cannot be found");
	    }
	  }	
}