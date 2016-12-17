import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
	
	//Asagidaki method icin gerekli
	
	public Frame getFrame() {
        return this;
    }
	
	
	MainMenu menu;
	
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
		menu = new MainMenu();
		menu.setLayout(null);
		add(menu);
		setVisible(true);
	}
	
	//Bunu eski bi projeden buldum yaptigim, calistiramadim ama su an
	protected void switchPanel(JPanel p){
		getFrame().setContentPane(p);
        getFrame().validate();
	}
	
}
