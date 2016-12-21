/**
 * @date 19.12.2016
 * @author CrossIt developers!
 * This class controls the game, and serves as an engine of the view and the model of the game. 
 */

public class GameEngine {
	static final int INIT_NO = 0;
	private int stageNo;
	private int stageScore;
	private int totalScore;
	private int gameSpeed;
	private int currentLife;
	private int currentMoney;
	private int currentEffect;
	
	private GameEngine(int gameSpeed, int initLifeCount, int currentEffect){
		this.stageNo = INIT_NO;
		this.stageScore = INIT_NO;
		this.totalScore = INIT_NO;
		this.gameSpeed = gameSpeed;
		this.currentLife = initLifeCount;
		this.currentMoney = INIT_NO;
		this.currentEffect = currentEffect; // the current effect of the game? 
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
	protected GameEngine getGameEngine(){
		return this;
	}
	
	protected int durationLeft(){
		return 0; // TODO: change this
	}
}