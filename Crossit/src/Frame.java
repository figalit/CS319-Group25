import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
	
	protected Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1400, 925);
		setResizable(false);
		setTitle("Cross-It!");
		
		init();
	}
	
	static Frame frame = new Frame();
	
	protected void init() {
		setLocationRelativeTo(null);
		setLayout(new GridLayout(1, 1, 0, 0));
		setVisible(true);
	}
	
	public static Frame getFrame() {
        return frame;
    }
	
	protected static void switchPanel(JPanel p){
		getFrame().setContentPane(p);
        getFrame().validate();
	}
	
}
