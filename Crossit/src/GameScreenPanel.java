import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageConsumer;
import java.awt.image.TileObserver;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameScreenPanel extends JPanel{
	
	private ArrayList<BufferedImage> images;
	private BufferedImage road;
	
	protected GameScreenPanel() {
		
		try {
			road = ImageIO.read(getClass().getResource("/road.png"));
			//road = ImageIO.read(getClass().getResourceAsStream("/road.png"));
			images = new ArrayList<BufferedImage>();
			images.add(road);
			
			for(BufferedImage image : images)
			{
				//image.;
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		repaint();
	}
	
	public void paint(Graphics g){
		for(int i = 0; i < 14; i++) {
			g.drawImage(road, i * 100, 90, 100, 90, null);
			g.drawImage(road, i * 100, 180, 100, 90, null);
			g.drawImage(road, i * 100, 270, 100, 90, null);
			g.drawImage(road, i * 100, 450, 100, 90, null);
			g.drawImage(road, i * 100, 630, 100, 90, null);
			g.drawImage(road, i * 100, 720, 100, 90, null);
		}
		
		
	}

}
