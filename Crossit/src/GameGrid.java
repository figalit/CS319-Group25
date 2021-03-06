import java.util.*;
public class GameGrid 
{

	private Part[][] gameMatrix = new Part[10][10];
	static final int GRID_SIZE = 10;
	private int[][] easyVehicleSet;
	private int[][] normalVehicleSet;
	private int[][] hardVehicleSet;
	private int[] directions;
	private Position charPosition;
	protected Character player;
	protected ArrayList hats;
	protected int theme;
	
	public int getTheme() {
		return theme;
	}

	public void setTheme(int theme) {
		this.theme = theme;
	}

	public GameGrid(int[][] easyVehicleSet, int[][] normalVehicleSet, int[][] hardVehicleSet)
	{

		hats = new ArrayList();
		hats.add("player.png");
		hats.add("player1.png");
		this.easyVehicleSet = easyVehicleSet;
		this.normalVehicleSet = normalVehicleSet;
		this.hardVehicleSet = hardVehicleSet;
		directions = new int[10];
		theme = 1;

		setCharPosition(null);
		player = new Character(hats);
		
	}
	
	protected void generate(int no)	//generates a full stage with vehicles and bonuses according to difficulty
	{
		setCharPosition(new Position(4,9));
		for(int i = 0; i < GRID_SIZE; i++)
			if(i == 4)
				gameMatrix[i][GRID_SIZE-1] = new SidewalkPart(player, theme);//putting character in to position
			else
				gameMatrix[i][GRID_SIZE-1] = new SidewalkPart(theme);
		
		for(int i = 0; i < GRID_SIZE; i++)
			gameMatrix[i][0] = new SidewalkPart(theme);
		
		int[][] currentSet;
		if(no <= 5)
			currentSet = easyVehicleSet;
		else
			if(no <= 10)
				currentSet = normalVehicleSet;
			else
				currentSet = hardVehicleSet;
		
		
			for(int j = 1; j < GRID_SIZE-1; j++)
			{
				int random = (int)(Math.random() * 9 + 1);
				int newDirection = (int)(Math.random() * 2);
				directions[j] = newDirection;
				for(int i = 0; i < GRID_SIZE; i++)
				switch(currentSet[random][i])
				{
					case 0: gameMatrix[i][j] = new RoadPart(); break;
					case 1: gameMatrix[i][j] = new RoadPart(new Motorcycle(newDirection));break;
					case 2: gameMatrix[i][j] = new RoadPart(new Car(newDirection));break;
					case 3: gameMatrix[i][j] = new RoadPart(new Bus(newDirection));break;
				}
			}
		
		
		//add coins and mystery boxes
		int a,b;
		if(no <= 5)
		{
			a = 2;
			b = 1;
		}
		else
			if(no <= 10)
			{
				a = 3;
				b = 2;
			}
			else
			{
				a = 4;
				b = 4;
			}
		putColectables(a,b);
	}
	protected void update()	//may generate 'not-deep copy' problems
	{
		Vehicle temp;
		for(int j = 1; j < GRID_SIZE-1; j++)
		{
			if( directions[j] == 0) //going left
			{	
				temp = ((RoadPart)gameMatrix[0][j]).getVehicle();
				for( int i = 0; i < GRID_SIZE-1 ; i++)
					((RoadPart)gameMatrix[i][j]).setVehicle(((RoadPart)gameMatrix[i+1][j]).getVehicle());
				((RoadPart)gameMatrix[9][j]).setVehicle(temp);
			}
			else
			{
				temp = ((RoadPart)gameMatrix[GRID_SIZE-1][j]).getVehicle();
				for( int i = GRID_SIZE-1; i > 0 ; i--)
					((RoadPart)gameMatrix[i][j]).setVehicle(((RoadPart)gameMatrix[i-1][j]).getVehicle());
				((RoadPart)gameMatrix[0][j]).setVehicle(temp);
			}
		}
	}
	public void print()
	{
		for( int i = 0; i < GRID_SIZE ; i++)
		{
			for( int j = 0; j < GRID_SIZE ; j++)
				gameMatrix[j][i].print();
				System.out.println();
		}
	}
	protected boolean detectCollision()
	{
		for( int i = 0; i < GRID_SIZE; i++)
			for( int j = 0; j < GRID_SIZE; j++)
				if(gameMatrix[i][j].detectCollision())
					return true;
		return false;
	}
	protected int detectCollectable()
	{
		for( int i = 0; i < GRID_SIZE; i++)
			for( int j = 0; j < GRID_SIZE; j++)
				if(gameMatrix[i][j].detectCollectable() >= 0)
					return gameMatrix[i][j].detectCollectable();
		return -1;
	}
	
	
	
	 protected void putColectables(int coinNo, int colNo)
	 {
	  for(int i = 0 ; i < coinNo; i++){
		   Coin coin = new Coin();
		   int x = 1 + (int)(Math.random() * 9);
		   int y = 1 + (int)(Math.random() * 9);
		   gameMatrix[x][y].setCollectable(coin);
	  }
	  for(int i = 0 ; i < colNo; i++){
		   MysteryBox mBox = new MysteryBox();
		   int x = 1 + (int)(Math.random() * 9);
		   int y = 1 + (int)(Math.random() * 9);
		   gameMatrix[x][y].setCollectable(mBox);
	  }
	 }
	
	protected boolean moveCharacter(int direction)
	{
		switch(direction)
		{
			case 1: //up
				if(charPosition.getY() != 0)
				{ 
					charPosition.setY(charPosition.getY()-1);
					gameMatrix[charPosition.getX()][charPosition.getY()].setCharacter(gameMatrix[charPosition.getX()][charPosition.getY()+1].moveCharacter());
					player.changeDirection("1");
					return true;
				}
				return false;
			case 2: //left
				if(charPosition.getX() != 0)
				{ 
					charPosition.setX(charPosition.getX()-1);
					gameMatrix[charPosition.getX()][charPosition.getY()].setCharacter(gameMatrix[charPosition.getX()+1][charPosition.getY()].moveCharacter());
					player.changeDirection("2");
					return true;
				}
				return false;
			case 3: //down
				if(charPosition.getY() != 9)
				{ 
					charPosition.setY(charPosition.getY()+1);
					gameMatrix[charPosition.getX()][charPosition.getY()].setCharacter(gameMatrix[charPosition.getX()][charPosition.getY()-1].moveCharacter());
					player.changeDirection("3");
					return true;
				}
				return false;
			case 4: //right
				if(charPosition.getX() != 9)
				{ 
					charPosition.setX(charPosition.getX()+1);
					gameMatrix[charPosition.getX()][charPosition.getY()].setCharacter(gameMatrix[charPosition.getX()-1][charPosition.getY()].moveCharacter());
					player.changeDirection("4");
					return true;
				}
				return false;
			default: return false;
		}
	}
	protected void addHat(String addr)
	{
		player.addHat(addr);
	}
	protected void changeHat(int no)
	{
		player.changeHat(no);
	}
	
	public Position getCharPosition() {
		return charPosition;
	}

	public void setCharPosition(Position charPosition) {
		this.charPosition = charPosition;
	}
	
	protected boolean checkEndOfStage()
	{
		if(charPosition.getY() == 0 )
			return true;
		return false;
	}
	protected void resetCharacter()
	{
		gameMatrix[4][9].setCharacter(gameMatrix[charPosition.getX()][charPosition.getY()].moveCharacter());
		charPosition.setX(4);
		charPosition.setY(9);
	}
	protected void teleportCharacter()
	{
		gameMatrix[charPosition.getX()][0].setCharacter(gameMatrix[charPosition.getX()][charPosition.getY()].moveCharacter());
		charPosition.setX(charPosition.getX());
		charPosition.setY(0);
	}

	public Part[][] getGameMatrix()
	{
		return this.gameMatrix;
	}
}
