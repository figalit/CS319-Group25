import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenu extends Menu implements ActionListener{
	
	//Image variables
	private BufferedImage cross;
	private BufferedImage newgame;
	private BufferedImage credits;
	private BufferedImage quit;
	private BufferedImage highscores;
	private BufferedImage settings;
	
	//Button variables
	private JButton newGameButton = new JButton("");
	private JButton highscoresButton = new JButton("");
	private JButton settingsButton = new JButton("");
	private JButton creditsButton = new JButton("");
	private JButton quitButton = new JButton("");
	
	protected MainMenu() {
		super();
		//Adding the source images
		try {
			cross = ImageIO.read(getClass().getResourceAsStream("/cross.png"));
			newgame = ImageIO.read(getClass().getResourceAsStream("/newgame.png"));
			credits = ImageIO.read(getClass().getResourceAsStream("/credits.png"));
			highscores = ImageIO.read(getClass().getResourceAsStream("/highscores.png"));
			quit = ImageIO.read(getClass().getResourceAsStream("/quit.png"));
			settings = ImageIO.read(getClass().getResourceAsStream("/settings.png"));

		} catch(IOException e) {
			e.printStackTrace();
		}
		
		repaint();
		
		//Properties of the buttons
		newGameButton.setBounds(425, 375, 575, 55); //Shape and position
		newGameButton.setBorderPainted(false); //Border invisible
		newGameButton.setContentAreaFilled(false); //Area invisible
		newGameButton.setToolTipText("Start a new game");
		
		highscoresButton.setBounds(475, 480, 475, 55);
		highscoresButton.setBorderPainted(false);
		highscoresButton.setContentAreaFilled(false);
		highscoresButton.setToolTipText("Display the Highscores");
		
		settingsButton.setBounds(545, 572, 325, 52);
		settingsButton.setBorderPainted(false);
		settingsButton.setContentAreaFilled(false);
		settingsButton.setToolTipText("Show settings menu");
		

		creditsButton.setBounds(575, 660, 250, 50);
		creditsButton.setBorderPainted(false);
		creditsButton.setContentAreaFilled(false);
		creditsButton.setToolTipText("Credits");
		
		quitButton.setBounds(625, 765, 150, 45);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setToolTipText("Exit the game");
		
		//Action Listener
		newGameButton.addActionListener(this);
		creditsButton.addActionListener(this);
		settingsButton.addActionListener(this);
		highscoresButton.addActionListener(this);
		quitButton.addActionListener(this);
		
		//Adding buttons to panel
		this.add(newGameButton);
		this.add(creditsButton);
		this.add(quitButton);
		this.add(settingsButton);
		this.add(highscoresButton);
		
	}
		
	public void paint(Graphics g){
		//Background
		super.paint(g);
		//Button images
		g.drawImage(cross, 225, 60, 950, 350, null);
		g.drawImage(newgame, 350, 300, 700, 250, null);
		g.drawImage(highscores, 450, 420, 500, 200, null);
		g.drawImage(settings, 475, 510, 450, 200, null);
		g.drawImage(credits, 500, 600, 400, 200, null);
		g.drawImage(quit, 500, 700, 350, 200, null);
			
	}	

		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == newGameButton) {
				//Start game
			}
			
			if (e.getSource() == highscoresButton){
				//Switch func, located in frame
				System.out.println(this.getParent().getParent().getParent().getParent().getClass().getName());
				((Frame) this.getParent().getParent().getParent().getParent()).switchPanel(new Help());
			}
			
			if (e.getSource() == settingsButton){
				//Change to settingsPanel
			}
			
			if (e.getSource() == creditsButton){
				//Change to creditsPanel
			}

			if (e.getSource() == quitButton){
				//Exit the game
				System.exit(0);
			}
			
		}

		@Override
		public void switchPanel(Object o) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public JPanel getPanel() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public JFrame getFrame() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setFrame(JFrame f) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setPanel(JPanel p) {
			// TODO Auto-generated method stub
			
		}

}
