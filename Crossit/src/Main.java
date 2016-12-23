import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

public class Main extends Frame{

	public static void main(String[] args) {
		try{
			SwingUtilities.invokeAndWait(new Runnable(){
				@Override
				public void run(){
					//Frame.switchPanel(new MainMenu(grid));
					GameEngine gameEngine = new GameEngine();
					//gameEngine.load();
				}
			});
		}catch (InvocationTargetException | InterruptedException e){
			e.getMessage();
		}
	}
}
