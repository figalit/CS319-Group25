import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;


public class InputManager extends JPanel implements KeyListener{
	static final int UP = 1;	
	static final int LEFT = 2;
	static final int DOWN = 3;
	static final int RIGHT = 4;

	GameEngine gameEngine;
	public InputManager(GameEngine gameEngine) {
		// TODO Auto-generated constructor stub
		this.gameEngine = gameEngine;
		addKeyListener(this);
		
	}
	public void addNotify() {
        super.addNotify();
        requestFocus();
    }

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int id = e.getID();
		System.out.println("---" + id + "---");
		switch(id)
		{
		case 401: // up
			gameEngine.move(UP);
			System.out.println("\n\nPressed UP\n\n");
			break;
		case KeyEvent.VK_LEFT: // left
			gameEngine.move(LEFT);
			break;
		case KeyEvent.VK_RIGHT: // right
			gameEngine.move(RIGHT);
			break;
		case KeyEvent.VK_DOWN: // down
			gameEngine.move(DOWN);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
