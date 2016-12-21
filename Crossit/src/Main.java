public class Main extends Frame{
	
	public static void main(String[] args) {
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
	}
}
