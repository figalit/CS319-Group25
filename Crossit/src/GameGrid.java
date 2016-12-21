import java.util.*;
public class GameGrid 
{
<<<<<<< HEAD
	private Part[][] gameMatrix = new Part[10][10];
=======
	private GameObject[][] gameMatrix = new GameObject[10][10];
>>>>>>> refs/remotes/origin/crossit-general
	private int[][] easyVehicleSet;
	private int[][] normalVehicleSet;
	private int[][] hardVehicleSet;
	private int[] directions;
	private Position charPosition;
	private Character player;
	private ArrayList hats;
	
	public GameGrid(int[][] easyVehicleSet, int[][] normalVehicleSet, int[][] hardVehicleSet)
	{
<<<<<<< HEAD
		hats.add("player.png");
=======
>>>>>>> refs/remotes/origin/crossit-general
		this.easyVehicleSet = easyVehicleSet;
		this.normalVehicleSet = normalVehicleSet;
		this.hardVehicleSet = hardVehicleSet;
		directions = new int[10];
<<<<<<< HEAD
		setCharPosition(null);
		player = new Character(hats);
=======
>>>>>>> refs/remotes/origin/crossit-general
	}
	
	protected void generate(int no)	//generates a full stage with vehicles and bonuses according to difficulty
	{
		setCharPosition(new Position(4,9));
		for(int i = 0; i < 10; i++)
			if(i == 4)
				gameMatrix[i][9] = new SidewalkPart(player);//putting character in to position
			else
				gameMatrix[i][9] = new SidewalkPart();
		
		for(int i = 0; i < 10; i++)
			gameMatrix[i][0] = new SidewalkPart();
		if(no <= 5)
		{
			for(int j = 1; j < 9; j++)
			{
				int newDirection = (int)(Math.random() * 2);
				directions[j] = newDirection;
				for(int i = 0; i < 10; i++)
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
				for(int j = 1; j < 9; j++)
				{
					int newDirection = (int)(Math.random() * 2);
					directions[j] = newDirection;
					for(int i = 0; i < 10; i++)
					switch(normalVehicleSet[i][j])
					{
						case 0: gameMatrix[i][j] = new RoadPart();
						case 1: gameMatrix[i][j] = new RoadPart(new Motorcycle(newDirection));
						case 2: gameMatrix[i][j] = new RoadPart(new Car(newDirection));
						case 3: gameMatrix[i][j] = new RoadPart(new Bus(newDirection));
					}
				}
			}
			else
			{
				for(int j = 1; j < 9; j++)
				{
					int newDirection = (int)(Math.random() * 2);
					directions[j] = newDirection;
					for(int i = 0; i < 10; i++)
					switch(hardVehicleSet[i][j])
					{
						case 0: gameMatrix[i][j] = new RoadPart();
						case 1: gameMatrix[i][j] = new RoadPart(new Motorcycle(newDirection));
						case 2: gameMatrix[i][j] = new RoadPart(new Car(newDirection));
						case 3: gameMatrix[i][j] = new RoadPart(new Bus(newDirection));
					}
				}
			}
		}
		//add coins and mystery boxes
	}
	protected void update()	//may generate 'not-deep copy' problems
	{
		Vehicle temp;
		for(int j = 1; j < 9; j++)
		{
			if( directions[j] == 0) //going left
			{	
				temp = ((RoadPart)gameMatrix[0][j]).getVehicle();
				for( int i = 0; i < 9 ; i++)
					((RoadPart)gameMatrix[i][j]).setVehicle(((RoadPart)gameMatrix[i+1][j]).getVehicle());
				((RoadPart)gameMatrix[9][j]).setVehicle(temp);
			}
			else
			{
				temp = ((RoadPart)gameMatrix[9][j]).getVehicle();
				for( int i = 9; i > 0 ; i--)
					((RoadPart)gameMatrix[i][j]).setVehicle(((RoadPart)gameMatrix[i-1][j]).getVehicle());
				((RoadPart)gameMatrix[0][j]).setVehicle(temp);
			}
		}
	}
	public void print()
	{
		for( int i = 1; i < 9 ; i++)
		{
			for( int j = 0; j < 10 ; j++)
				((RoadPart)gameMatrix[j][i]).print();
				System.out.println();
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
