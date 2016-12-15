import java.awt.Graphics;

public class Help extends Menu {
	
	protected Help () {
		repaint();
	}
	
	public void paint(Graphics g) {
		g.drawRect(100, 100, 100, 100);
		g.fillRect(150, 150, 150, 150);
	}
	
}
