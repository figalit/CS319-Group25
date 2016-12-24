import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Credits extends SubMenu {

	private BufferedImage creditsInfo, version;
	
	protected Credits(GameEngine gameEngine ) {
		super(gameEngine);
		
		try {
			creditsInfo = ImageIO.read(getClass().getResourceAsStream("/creditsInfo.png"));		
			version = ImageIO.read(getClass().getResourceAsStream("/version.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		repaint();		
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(creditsInfo, 200, 50, 1000, 800, null);
		g.drawImage(version, 1100, -50, 200, 200, null);
	}
	
}
