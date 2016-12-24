import java.awt.event.KeyEvent;
import java.util.Timer;

/**
 * @date 19.12.2016
 * @author CrossIt developers!
 * This class controls the game, and serves as an engine of the view and the model of the game. 
 */

public class GameEngine {
	static final int INIT_NO = 0;
	static final int INIT_LIFE_COUNT = 3;
	private int stageNo;
	private int stageScore;
	private int totalScore;
	private int gameSpeed;
	private int currentLife;
	private int currentMoney;
	private int currentEffect;

	private GameGrid gameGrid;
	private Storage storage;
	Timer timer;
	UpdateGameScheduler scheduler;

	
	protected GameEngine(){
		this.stageNo = INIT_NO;
		this.stageScore = INIT_NO;
		this.totalScore = INIT_NO;
		this.gameSpeed = INIT_NO;
		this.currentLife = INIT_LIFE_COUNT;
		this.currentMoney = INIT_NO;
		this.currentEffect = INIT_NO; // TBD
		this.storage = new Storage();

		int[] A ={0,1,0,0,0,1,0,1,0,0}; 
	    int[][] easy = {A,A,A,A,A,A,A,A,A,A};
//github.com/figalit/CS319-Group25.git
		//int[][] a = storage.getVehicleSet(Storage.EASY);
		/*for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a[i].length; j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}*/

	    this.gameGrid = new GameGrid(easy, easy, easy);
	    gameGrid.generate(1);
		timer = new Timer();
		scheduler = new UpdateGameScheduler(this);
		//load();
	}
	
	protected GameEngine(int gameSpeed, int initLifeCount, int currentEffect){
		this.stageNo = INIT_NO;
		this.stageScore = INIT_NO;
		this.totalScore = INIT_NO;
		this.gameSpeed = gameSpeed;
		this.currentLife = initLifeCount;
		this.currentMoney = INIT_NO;
		this.currentEffect = currentEffect; // the current effect of the game? 
		//this.storage = new Storage();
		int[] A ={0,1,0,0,0,1,0,1,0,0}; 
	    int[][] easy = {A,A,A,A,A,A,A,A,A,A};
		/*this.gameGrid = new GameGrid(storage.getVehicleSet(Storage.EASY),
									 storage.getVehicleSet(Storage.MED),
									 storage.getVehicleSet(Storage.HARD));*/
	    this.gameGrid = new GameGrid(easy, easy, easy);
		timer = new Timer();
		scheduler = new UpdateGameScheduler(this);

	}
	protected void move(int where){
		switch(where)
		{
		case InputManager.UP: // up
			gameGrid.moveCharacter(InputManager.UP);
			break;
		case InputManager.LEFT: // up
			gameGrid.moveCharacter(InputManager.LEFT);
			break;
		case InputManager.RIGHT: // up
			gameGrid.moveCharacter(InputManager.RIGHT);
			break;
		case InputManager.DOWN: // up
			gameGrid.moveCharacter(InputManager.DOWN);
			break;
		}
	}
	
	protected void load(){
		// do some loading of the screen or maybe some listeners? 
		timer.schedule(scheduler, 1000, 1000);
	}
	protected void update(){
		gameGrid.update();
		gameGrid.print();
	}
	protected boolean checkCollision(){
		
		return false; // TODO: change
	}
	protected void reduceLife(){
		
	}
	protected void endGame(){
		
	}
	protected void applyCollectable(int perk){
		
	}	
	// TODO: check if this is ok.
	protected GameGrid getGameGrid()
	{
		return this.gameGrid;
	}
	protected GameEngine getGameEngine(){
		return this;
	}
	protected int durationLeft(){
		return 0; // TODO: change this
	}
}
