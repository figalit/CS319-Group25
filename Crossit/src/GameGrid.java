
	public class GameGrid {

	private GameObject[][] gameMatrix = new GameObject[10][10];
	private int stageNo;
	private int[][] easyVehicleSet;
	private int[][] normalVehicleSet;
	private int[][] hardVehicleSet;
	
	public GameGrid(int[][] easyVehicleSet, int[][] normalVehicleSet, int[][] hardVehicleSet)
	{
		
		this.easyVehicleSet = easyVehicleSet;
		this.normalVehicleSet = normalVehicleSet;
		this.hardVehicleSet = hardVehicleSet;
		generate(stageNo);
	}
	
	protected void generate(int no)	//generates a full stage with vehicles and bonuses according to difficulty
	{
		if(no <= 5)
		{
			for(int i = 0; i < 10; i++)
			{
				int newDirection = (int)Math.random();
				for(int j = 1; j < 9; j++)
				switch(easyVehicleSet[i][j])
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
			if(no <= 10)
			{
				for(int i = 0; i < 10; i++)
				{
					int newDirection = (int)Math.random();
					for(int j = 1; j < 9; j++)
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
				for(int i = 0; i < 10; i++)
				{
					int newDirection = (int)Math.random();
					for(int j = 1; j < 9; j++)
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
	}
}
