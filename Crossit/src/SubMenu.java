import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class SubMenu extends Menu {

	private JButton backButton = new JButton();
		
	protected SubMenu(){
		
		backButton.setBounds(625, 765, 150, 45);
		backButton.setBorderPainted(true);
		backButton.setContentAreaFilled(true);
		backButton.setToolTipText("Back to Main Menu");
		
		Listener lstnr = new Listener();
		
		backButton.addActionListener(lstnr);
		
		this.add(backButton);
		
	}
	
	private class Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == backButton) {
				
			}
		}
	}
	
}
