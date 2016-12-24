import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.image.ImageConsumer;
import java.awt.image.TileObserver;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Graphics;

public class GameScreenPanel extends JPanel implements KeyListener{

	private ArrayList<BufferedImage> images;
	private BufferedImage road;   
	GameGrid gameGrid;
	Part[][] gameMatrix;
	static final int UP = 1;	
	static final int LEFT = 2;
	static final int DOWN = 3;
	static final int RIGHT = 4;
	private int score;
	private GameEngine gameEngine;
	JPanel scorePanel ;
	JLabel scoreLabel;
	JLabel lifeLabel;
	JLabel stageNo;
	JLabel message;
	
	protected GameScreenPanel(GameEngine gameEngine) {

		scorePanel = new JPanel();
		scoreLabel = new JLabel("Score: " + score);
		lifeLabel = new JLabel("Life left: " + gameEngine.getLife());
		stageNo = new JLabel("Stage: " + gameEngine.getStage());
		message = new JLabel("");
		
		scorePanel.add(lifeLabel);
		scorePanel.add(scoreLabel);
		scorePanel.add(message);
		scorePanel.add(stageNo);
		
		this.gameEngine = gameEngine;
		this.gameMatrix = gameEngine.getGameGrid().getGameMatrix();
		this.gameGrid = gameEngine.getGameGrid();
		addKeyListener(this);
		this.add(scorePanel);
		
		repaint();
		
	}
	public void addNotify() {
		super.addNotify();
		requestFocus();
	}

	public void updateGameScreen(){
		scoreLabel.setText("Score: " + score);
		lifeLabel.setText("Life left: " + gameEngine.getLife());
		message.setText("" + gameEngine.getMsg());
		stageNo.setText("" + gameEngine.getStage());
		
		paint(getGraphics());
		revalidate();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);

		for(int i = 0; i < gameMatrix.length; i++)
		{   
			for(int j = 0; j < gameMatrix[i].length; j++)
			{
				if(gameMatrix[i][j] != null)
					g.drawImage(gameMatrix[i][j].getImage(), i * 100, j * 90, 100, 90, null);
			}
		}
		for(int i = 0; i < gameMatrix.length; i++)
		{   
			for(int j = 0; j < gameMatrix[i].length; j++)
			{
				if(gameMatrix[i][j] != null)
				{
					if(gameMatrix[i][j].getVehicle() != null)
						g.drawImage(gameMatrix[i][j].getVehicle().getImage(), i * 100, j * 90, 100, 90, null);
					if(gameMatrix[i][j].getCollectable() != null)
						g.drawImage(gameMatrix[i][j].getCollectable().getImage(), i * 100, j * 90, 100, 90, null);
					if(gameMatrix[i][j].getCharacter() != null)
						g.drawImage(gameMatrix[i][j].getCharacter().getImage(), i * 100, j * 90, 100, 90, null);
				}
			}
		}

	}
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int button = e.getKeyCode();
		switch(button)
		{
		case KeyEvent.VK_UP: // up
		gameGrid.moveCharacter(UP);
		break;
		case KeyEvent.VK_LEFT: // left
		gameGrid.moveCharacter(LEFT);
		break;
		case KeyEvent.VK_RIGHT: // right
			gameGrid.moveCharacter(RIGHT);
			break;
		case KeyEvent.VK_DOWN: // down
			gameGrid.moveCharacter(DOWN);
			break;
		}
		if(gameEngine.checkCollision()){
			gameEngine.reduceLife();
			if(gameEngine.getCurrentLife() < 1){
				gameEngine.endGame();
			}else{
				// puts character to start of stage
				gameGrid.resetCharacter();
			}
		}
		updateGameScreen();
	}
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public int getScore()
	{
		return score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

}
