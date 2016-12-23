import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

public class Main extends Frame{
	
	public static void main(String[] args) {
		int[] A ={0,1,0,0,0,1,0,1,0,0}; 
		 	int[][] easy = {A,A,A,A,A,A,A,A,A,A};
		 	GameGrid grd = new GameGrid(easy,easy,easy);
		 	grd.generate(1);
		 	System.out.println("Done");
		 	grd.print();
		 	grd.moveCharacter(1);
		 	grd.update();
		 	System.out.println('\n');
		 	grd.print();
		 	grd.moveCharacter(3);
		 	//grd.update();
		 	System.out.println('\n');
		 	grd.print();
		 	grd.moveCharacter(2);
		 	//grd.update();
		 	System.out.println('\n');
		 	grd.print();
		 	grd.moveCharacter(4);
		 	//grd.update();
		 	System.out.println('\n');
		 	grd.print();

	}
	
}
