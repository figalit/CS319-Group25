import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Settings extends SubMenu implements ActionListener{

	private JButton theme0Button = new JButton();
	private JButton theme1Button = new JButton();
	//private JSlider volumeSlider = new JSlider(JSlider.VERTICAL, 0, 100, 50);
	//Comment out yapinca settingse girmiyo
	
	private BufferedImage theme0, theme1;
	
	protected Settings () {
		super();
		
		try {
			theme0 = ImageIO.read(getClass().getResourceAsStream("/theme0.png"));
			theme1 = ImageIO.read(getClass().getResourceAsStream("/theme1.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		repaint();
			
		//volumeSlider.setMajorTickSpacing(10);
		//volumeSlider.setPaintTicks(true);
		
		theme0Button.setBounds(835, 330, 80, 80); //Shape and position
		theme0Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		theme0Button.setBorderPainted(false); //Border invisible
		theme0Button.setContentAreaFilled(false); //Area invisible
		theme0Button.setToolTipText("Grass-ish theme");
		
		theme1Button.setBounds(1035, 330, 80, 80); //Shape and position
		theme1Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		theme1Button.setBorderPainted(false); //Border invisible
		theme1Button.setContentAreaFilled(false); //Area invisible
		theme1Button.setToolTipText("Desert-ish theme");
		
		theme0Button.addActionListener(this);
		theme1Button.addActionListener(this);
		//volumeSlider.addChangeListener((ChangeListener) this);
		
		//this.add(volumeSlider);
		this.add(theme0Button);
		this.add(theme1Button);
		
	}
		
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(theme0, 800, 300, 150, 150, null);
		g.drawImage(theme1, 1000, 300, 150, 150, null);
			
	}
	
	
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		
		if (e.getSource() == theme0Button) {
			setTheme(0);
			repaint();
		}
			
		if (e.getSource() == theme1Button) {
			setTheme(1);
			repaint();
		}
			
	}
	
}
