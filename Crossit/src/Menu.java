import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Menu extends JPanel {

	private BufferedImage grass;
	private BufferedImage road;
	
	protected Menu() {
		
		try {
			road = ImageIO.read(getClass().getResourceAsStream("/road.png"));
			grass = ImageIO.read(getClass().getResourceAsStream("/grass.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		repaint();
	}
	
	public void paint(Graphics g){
		for(int i = 0; i < 14; i++) {
			g.drawImage(grass, i * 100, 0, 100, 90, null);
			g.drawImage(road, i * 100, 90, 100, 90, null);
			g.drawImage(road, i * 100, 180, 100, 90, null);
			g.drawImage(road, i * 100, 270, 100, 90, null);
			g.drawImage(grass, i * 100, 360, 100, 90, null);
			g.drawImage(road, i * 100, 450, 100, 90, null);
			g.drawImage(grass, i * 100, 540, 100, 90, null);
			g.drawImage(road, i * 100, 630, 100, 90, null);
			g.drawImage(road, i * 100, 720, 100, 90, null);
			g.drawImage(grass, i * 100, 810, 100, 90, null);
		}
		
	}
	
	
}
