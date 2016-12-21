import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

public class Main extends Frame{
	
	public static void main(String[] args) {
<<<<<<< HEAD
		//Frame.switchPanel(new MainMenu());
	
	int[] A ={0,1,0,0,0,1,0,1,0,0}; 
	int[][] easy = {A,A,A,A,A,A,A,A,A,A};
	GameGrid grd = new GameGrid(easy,easy,easy);
	grd.generate(1);
	System.out.println("Done");
	grd.print();
	grd.update();
	System.out.println('\n');
	grd.print();
=======
		try {
			SwingUtilities.invokeAndWait(new Runnable(){
				@Override
				public void run(){
					Frame.switchPanel(new MainMenu());
				}
			});
		} catch (InvocationTargetException | InterruptedException e) {
			// TODO Auto-generated catch block
		}finally{
		}
>>>>>>> refs/remotes/origin/crossit-general
	}
}
