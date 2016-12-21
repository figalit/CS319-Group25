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
	private Character player;
	private ArrayList hats;
	
	public GameGrid(int[][] easyVehicleSet, int[][] normalVehicleSet, int[][] hardVehicleSet)
	{

		hats = new ArrayList();
		hats.add("player.png");
		this.easyVehicleSet = easyVehicleSet;
		this.normalVehicleSet = normalVehicleSet;
		this.hardVehicleSet = hardVehicleSet;
		directions = new int[10];

		setCharPosition(null);
		player = new Character(hats);
		
	}
	
	protected void generate(int no)	//generates a full stage with vehicles and bonuses according to difficulty
	{
		setCharPosition(new Position(4,9));
		for(int i = 0; i < GRID_SIZE; i++)
			if(i == 4)
				gameMatrix[i][GRID_SIZE-1] = new SidewalkPart(player);//putting character in to position
			else
				gameMatrix[i][GRID_SIZE-1] = new SidewalkPart();
		
		for(int i = 0; i < GRID_SIZE; i++)
			gameMatrix[i][0] = new SidewalkPart();
		if(no <= 5)
		{
			for(int j = 1; j < GRID_SIZE-1; j++)
			{
				int newDirection = (int)(Math.random() * 2);
				directions[j] = newDirection;
				for(int i = 0; i < GRID_SIZE; i++)
				switch(easyVehicleSet[j][i])
				{
					case 0: gameMatrix[i][j] = new RoadPart(); break;
					case 1: gameMatrix[i][j] = new RoadPart(new Motorcycle(newDirection));break;
					case 2: gameMatrix[i][j] = new RoadPart(new Car(newDirection));break;
					case 3: gameMatrix[i][j] = new RoadPart(new Bus(newDirection));break;
				}
			}
		}
		else
		{
			if(no <= 10)
			{
				for(int j = 1; j < GRID_SIZE-1; j++)
				{
					int newDirection = (int)(Math.random() * 2);
					directions[j] = newDirection;
					for(int i = 0; i < GRID_SIZE; i++)
					switch(normalVehicleSet[i][j])
					{
						case 0: gameMatrix[i][j] = new RoadPart(); break;
						case 1: gameMatrix[i][j] = new RoadPart(new Motorcycle(newDirection)); break;
						case 2: gameMatrix[i][j] = new RoadPart(new Car(newDirection)); break;
						case 3: gameMatrix[i][j] = new RoadPart(new Bus(newDirection)); break;
					}
				}
			}
			else
			{
				for(int j = 1; j < GRID_SIZE-1; j++)
				{
					int newDirection = (int)(Math.random() * 2);
					directions[j] = newDirection;
					for(int i = 0; i < GRID_SIZE; i++)
					switch(hardVehicleSet[i][j])
					{
						case 0: gameMatrix[i][j] = new RoadPart(); break;
						case 1: gameMatrix[i][j] = new RoadPart(new Motorcycle(newDirection)); break;
						case 2: gameMatrix[i][j] = new RoadPart(new Car(newDirection)); break;
						case 3: gameMatrix[i][j] = new RoadPart(new Bus(newDirection)); break;
					} 
				}
			}
		}
		//add coins and mystery boxes
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
	protected boolean moveCharacter(int direction)
	{
		switch(direction)
		{
			case 1: //up
				if(charPosition.getY() != 0)
				{ 
					charPosition.setY(charPosition.getY()-1);
					gameMatrix[charPosition.getX()][charPosition.getY()].setCharacter(gameMatrix[charPosition.getX()][charPosition.getY()+1].moveCharacter());
					return true;
				}
				return false;
			case 2: //left
				if(charPosition.getX() != 0)
				{ 
					charPosition.setX(charPosition.getX()-1);
					gameMatrix[charPosition.getX()][charPosition.getY()].setCharacter(gameMatrix[charPosition.getX()+1][charPosition.getY()].moveCharacter());
					return true;
				}
				return false;
			case 3: //down
				if(charPosition.getY() != 9)
				{ 
					charPosition.setY(charPosition.getY()+1);
					gameMatrix[charPosition.getX()][charPosition.getY()].setCharacter(gameMatrix[charPosition.getX()][charPosition.getY()-1].moveCharacter());
					return true;
				}
				return false;
			case 4: //right
				if(charPosition.getX() != 9)
				{ 
					charPosition.setX(charPosition.getX()+1);
					gameMatrix[charPosition.getX()][charPosition.getY()].setCharacter(gameMatrix[charPosition.getX()-1][charPosition.getY()].moveCharacter());
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
	
	public Position getCharPosition() {
		return charPosition;
	}

	public void setCharPosition(Position charPosition) {
		this.charPosition = charPosition;
	}
}
