import java.util.TimerTask;


public class UpdateGameScheduler extends TimerTask{
	private GameEngine gameEngine;
	
	public UpdateGameScheduler(GameEngine gameEngine){
		this.gameEngine = gameEngine;
	}
	public void run(){
		gameEngine.update();
	}
}
