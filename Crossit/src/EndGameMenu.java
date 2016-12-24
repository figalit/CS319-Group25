import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JTextField;

public class EndGameMenu extends SubMenu {

	private JButton restartButton = new JButton("");
	private JButton saveButton = new JButton("");
	private BufferedImage restartImg;
	private BufferedImage saveImg;
	private BufferedImage yourScore;
	private JTextField submitName = new JTextField("Enter name", 15);
	
	protected EndGameMenu(GameEngine gameEngine) {
		super(gameEngine);
		
		try {
			restartImg= ImageIO.read(getClass().getResourceAsStream("/restart.png"));
			saveImg = ImageIO.read(getClass().getResourceAsStream("/save.png"));
			yourScore = ImageIO.read(getClass().getResourceAsStream("/yourScore.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		restartButton.setBounds(915, 735, 280, 60); //Shape and position
		restartButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		restartButton.setBorderPainted(false); //Border invisible
		restartButton.setContentAreaFilled(false); //Area invisible
		restartButton.setToolTipText("Restart the game");
		
		saveButton.setBounds(610, 465, 150, 65);
		saveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		saveButton.setBorderPainted(false);
		saveButton.setContentAreaFilled(false);
		saveButton.setToolTipText("Save your score");
		
		restartButton.addActionListener(this);
		saveButton.addActionListener(this);
		
		submitName.setColumns(10);
		
		add(submitName);
		add(saveButton);
		add(restartButton);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(restartImg, 925, 710, 275, 125, null);
		g.drawImage(saveImg, 500, 400, 350, 200, null);
		g.drawImage(yourScore, 400, 50, 550, 300, null);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		super.actionPerformed(e);
		
		if (e.getSource() == restartButton) {
			//Start game
			gameEngine.load();
			Frame.switchPanel(gameEngine.getGsp());
			
		}
	}
	

}
