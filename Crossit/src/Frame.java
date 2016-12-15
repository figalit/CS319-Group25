import java.awt.GridLayout;

import javax.swing.JFrame;

public class Frame extends JFrame {

	Menu menu;
	
	protected Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1400, 925);
		setResizable(false);
		setTitle("Cross-It!");
		
		init();
	}
	
	protected void init() {
		setLocationRelativeTo(null);
		setLayout(new GridLayout(1, 1, 0, 0));
		menu = new Menu();
		add(menu);
		
		setVisible(true);
	}
	s
}
