import java.awt.GridLayout;

import javax.swing.JFrame;

public class Frame extends JFrame {

	Screen s;
	
	protected Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1400,800);
		setResizable(true);
		setTitle("Cross-It!");
		
		init();
	}
	
	protected void init() {
		setLocationRelativeTo(null);
		setLayout(new GridLayout(1, 1, 0, 0));
		s = new Screen();
		add(s);
		
		setVisible(true);
	}
	
}
