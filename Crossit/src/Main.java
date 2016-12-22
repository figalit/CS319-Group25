import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

public class Main extends Frame{
	
	public static void main(String[] args) {
		
		GameEngine engine = new GameEngine();
		GameGrid grid = engine.getGameGrid();
		grid.generate(1);
		Frame.switchPanel(new MainMenu(grid));
		
//		try{
//			SwingUtilities.invokeAndWait(new Runnable(){
//				@Override
//				public void run(){
//					Frame.switchPanel(new MainMenu());
//				}
//			}
//		}catch (InvocationTargetException | InterruptedException e){
//			e.getMessage();
//		}
		
	
	}
}
