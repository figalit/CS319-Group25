import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class GameObject {
	protected BufferedImage image;
	
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(String imageName){
		 try { image = ImageIO.read(getClass().getResourceAsStream("/" + imageName)); } 
	        catch(IOException e) {    e.printStackTrace(); }
	  }	
}
