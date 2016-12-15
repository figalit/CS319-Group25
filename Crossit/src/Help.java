import java.awt.Graphics;

import javax.swing.JButton;

public class Help extends Menu {
	
	protected Help () {
		repaint();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.fillRect(100, 100, 100, 100);
	}
	
	JButton back = new JButton("AAA");
	
	
}
