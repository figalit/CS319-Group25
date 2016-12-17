import java.awt.Graphics;

import javax.swing.JButton;

public class Help extends SubMenu {
	
	protected Help () {
		super();
		repaint();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.fillRect(100, 100, 100, 100);
	}
	
	
	
	
}
