import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Help extends SubMenu {
	
	private BufferedImage directions, controller, helpText;
	
	protected Help () {
		super();
		
		 try { directions = ImageIO.read(getClass().getResourceAsStream("/directions.png"));
		 		controller = ImageIO.read(getClass().getResourceAsStream("/controls.png"));
		 		helpText = ImageIO.read(getClass().getResourceAsStream("/helpText.png"));
		 	} 
	        catch(IOException e) {    e.printStackTrace(); }
		
		repaint();
		
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(helpText, 600, 100, 700, 700, null);
		g.drawImage(directions, 125, 60, 350, 200, null);
		g.drawImage(controller, 50, 160, 400, 400, null);
	}
	
}
