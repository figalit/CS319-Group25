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
	
	protected GameEngine(){
		this.stageNo = INIT_NO;
		this.stageScore = INIT_NO;
		this.totalScore = INIT_NO;
		this.gameSpeed = INIT_NO;
		this.currentLife = INIT_LIFE_COUNT;
		this.currentMoney = INIT_NO;
		this.currentEffect = INIT_NO; // TBD
		this.storage = new Storage();
		int[][] a = storage.getVehicleSet(Storage.EASY);
		/*for(int i = 0; i < a.length; i++){
			for(inst j = 0; j < a[i].length; j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}*/
		this.gameGrid = new GameGrid(storage.getVehicleSet(Storage.EASY),
									 storage.getVehicleSet(Storage.MED),
									 storage.getVehicleSet(Storage.HARD));
	}
	protected GameEngine(int gameSpeed, int initLifeCount, int currentEffect){
		this.stageNo = INIT_NO;
		this.stageScore = INIT_NO;
		this.totalScore = INIT_NO;
		this.gameSpeed = gameSpeed;
		this.currentLife = initLifeCount;
		this.currentMoney = INIT_NO;
		this.currentEffect = currentEffect; // the current effect of the game? 
		this.storage = new Storage();
		this.gameGrid = new GameGrid(storage.getVehicleSet(Storage.EASY),
									 storage.getVehicleSet(Storage.MED),
									 storage.getVehicleSet(Storage.HARD));
	}
	
	protected void load(){
		
	}
	protected void update(){
		
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