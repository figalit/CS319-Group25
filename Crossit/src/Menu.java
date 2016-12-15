import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Menu extends JPanel {

	private BufferedImage mainMenu;
	
	protected Menu() {
		
		try {
			mainMenu = ImageIO.read(getClass().getResourceAsStream("/menu final.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		repaint();
	}
	
	public void paint(Graphics g){
		g.drawImage(mainMenu, 0, 0, mainMenu.getWidth() * 2, mainMenu.getHeight() * 2, null);
		
		
	}
	
	
}
