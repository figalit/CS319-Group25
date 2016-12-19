import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;


public class Main extends Frame{
	
	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(new Runnable(){
				@Override
				public void run(){
					new Frame();
				}
			});
		} catch (InvocationTargetException | InterruptedException e) {
			// TODO Auto-generated catch block
		} 
	}
}
