import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;



/**
 * @date 19.12.2016
 * @author CrossIt developers!
 * This class controls the game, and serves as an engine of the view and the model of the game. 
 */

public class GameEngine {
	static final int INIT_NO = 0;
	static final int INIT_LIFE_COUNT = 3;
	static final int INIT_GAME_SPEED = 1500;
	private int stageNo;
	private int stageScore;
	private int totalScore;
	private int gameSpeed;
	private int currentLife;
	String msg;
	
	protected int getCurrentLife() {
		return currentLife;
	}

	protected void setCurrentLife(int currentLife) {
		this.currentLife = currentLife;
	}

	private int currentEffect;
	private GameScreenPanel gsp;

	private GameGrid gameGrid;
	private Storage storage;
	ScheduledExecutorService service ;
	UpdateGameScheduler scheduler;

	
	protected GameEngine(){
		this.stageNo = INIT_NO;
		this.stageScore = INIT_NO;
		this.totalScore = INIT_NO;
		this.gameSpeed = INIT_GAME_SPEED;
		this.currentLife = INIT_LIFE_COUNT;
		this.currentEffect = INIT_NO; // TBD
		this.storage = new Storage();
	    this.gameGrid = new GameGrid(storage.getVehicleSet(Storage.EASY),
				 storage.getVehicleSet(Storage.MED),
				 storage.getVehicleSet(Storage.HARD));
	    gameGrid.generate(1);
	    service = Executors.newSingleThreadScheduledExecutor();
	    scheduler = new UpdateGameScheduler(this);
	    msg = "";
	}
	
	protected void load(){
		gameGrid.generate(INIT_NO+1);

		currentLife = 3;

		// do some loading of the screen or maybe some listeners? 
		service.scheduleAtFixedRate(scheduler, 100, this.gameSpeed, TimeUnit.MILLISECONDS);
	}
	protected void update(){
		gameGrid.update();
		this.totalScore += 1;
		gsp.setScore(this.totalScore);
		if(checkCollision()){
			reduceLife();
			if(this.currentLife < 1){
				endGame();
			}else{
				// puts character to start of stage
				gameGrid.resetCharacter();
			}
		}
		if(gameGrid.detectCollectable() >= 0)
		{
			int collectableValue = gameGrid.detectCollectable();
			// Coin adds 20 points to the score.
			switch (collectableValue)
			{				
			case 0: // coin
				this.totalScore += 20;
				gsp.setScore(this.totalScore);
			case 1: // shield
				// this is probably not to be implemented yet.
				this.totalScore += 20;
				msg = "You received a shield. Right now we'll increase your score!";
			case 2: // one less life 
				this.currentLife -= 1;
				msg = "You received a life" ;
			case 3: // magnet
				msg = "You received a magnet. Right now we'll increase your score!";
				this.totalScore += 20;
			case 4: // teleportation
				//this.gameGrid.applyTeleportation();
				msg = "We'll increase your score!";
				this.totalScore += 20;
			case 5: // faster traffic
				msg = "We made the game faster!";
				this.gameSpeed += 200;
			case 6: // reverse control
				//this.gameGrid.reverseVehicleControl();
				msg = "we didnt reverse control";
				this.totalScore += 20;
			case 7: // extralife 
				this.currentLife += 1;
			case 8: // slow the traffic
				msg = "We made the game slower!";
				this.gameSpeed -= 200;
			default : ;
			}
		}
		if(gameGrid.checkEndOfStage()){
			endStage();
		}
		gsp.updateGameScreen();
	}
	protected boolean checkCollision(){
		if(gameGrid.detectCollision()){
			return true;
		}
		return false; 
	}
	protected void reduceLife(){
		this.currentLife = this.currentLife - 1;
	}
	
	protected void endStage(){
		// generate new stage.
		gameGrid.generate(this.stageNo + 1);
		this.stageNo++;

		this.gameSpeed = this.gameSpeed ;
		this.service.scheduleAtFixedRate(scheduler, 0, 2*this.gameSpeed, TimeUnit.MILLISECONDS);

	}
	
	protected void endGame() {
		Frame.switchPanel(new EndGameMenu(this));
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

	public GameScreenPanel getGsp() {
		return gsp;
	}

	public void setGsp(GameScreenPanel gsp) {
		this.gsp = gsp;
	}
	public int getLife(){
		return this.currentLife;
	}
	public String getMsg(){
		return this.msg;
	}
	public int getStage(){
		return this.stageNo;
	}
}
