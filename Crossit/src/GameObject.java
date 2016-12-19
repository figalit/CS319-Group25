import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class GameObject {
	private Position pos;
	private BufferedImage image;
	
	public Position getPos() {
		return pos;
	}
	public void setPos(Position pos) {
		this.pos = pos;
	}
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(String imageName){
		 try { image = ImageIO.read(getClass().getResourceAsStream("/" + imageName)); } 
	        catch(IOException e) {    e.printStackTrace(); }
	  }	
}