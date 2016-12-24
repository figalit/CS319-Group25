import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

public class Main extends Frame{

	public static void main(String[] args) {
		try{
			SwingUtilities.invokeAndWait(new Runnable(){
				
				public void run(){
					
					GameEngine gameEngine = new GameEngine();
					
					GameScreenPanel gsp = new GameScreenPanel(gameEngine);
					gameEngine.setGsp(gsp);
					Frame.switchPanel(new MainMenu(gameEngine));
					//Frame.switchPanel(gsp);
					//gsp.updateGameScreen();
					//gameEngine.load();
					
				}
			});
		}catch (InvocationTargetException | InterruptedException e){
			e.getMessage();
		}
	}
}
