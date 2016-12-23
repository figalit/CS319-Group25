import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Figali Taho
 *
 */


public class Storage {
	static final int SIZE_OF_GRID = 10;
	static final int EASY = 1;
	static final int MED = 2;
	static final int HARD = 3;
		
	private String playGameFile;
	private String settingsFile;   

	private String highScoresFile;
	
	protected Storage(){
		this.playGameFile = "storage/play_game_file";
		this.settingsFile = "storage/settings_file";
		this.highScoresFile = "storage/high_scores_file";		
	}
	
	private Storage(String playGameFile, String settingsFile, String highScoresFile){
		this.playGameFile = playGameFile;
		this.settingsFile = settingsFile;
		this.highScoresFile = highScoresFile;
	}
	
	// The boolean hats array is the first line of the settings file.
	protected int[] getBooleanHatsArray(){
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try{
			fileReader = new FileReader(this.settingsFile);
			bufferedReader = new BufferedReader(fileReader);
			String line = "";
			if(( line  = bufferedReader.readLine()) != null){
				// make line into an int array
				String[] strArr = line.split(" ");
				int[] arr= new int[strArr.length];
				for(int i = 0; i < strArr.length; i++){
					arr[i] = Integer.parseInt(strArr[i]);
				}
				return arr;
			}
			return null;
		}catch(IOException e ){}
		finally{
			try{
				if(bufferedReader != null){
					bufferedReader.close();
				}
			}catch(IOException e){}
		}
		return null;
	}
	
	// Writes data to a file. 
	protected void writeFile(String filename, String data){
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try{
			fileWriter = new FileWriter(filename);
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(data);
		}catch(IOException e){
			System.out.println("Something went wrong when writing at " + filename + " .");
		}finally{
			try{
				if(bufferedWriter != null){
					bufferedWriter.close();
				}
			}catch(IOException e){}
		}
	}
	
	// Reads contents of a file and returns them as String
	protected String readFile(String filename){
		StringBuffer sb = new StringBuffer();
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try{
			fileReader = new FileReader(filename);
			bufferedReader = new BufferedReader(fileReader);
			String line = "";
			while(( line  = bufferedReader.readLine()) != null){
				sb.append(line);
			}
		}catch(IOException e ){}
		finally{
			try{
				if(bufferedReader != null){
					bufferedReader.close();
				}
			}catch(IOException e){}
		}
		
		return sb.toString();
	}
	
	// Returns an array of game objects according to level of difficulty. 
	protected int[][] getVehicleSet(int easy_med_hard){
		int[][] grid = new int[SIZE_OF_GRID][SIZE_OF_GRID];
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try{			
			fileReader = new FileReader(this.playGameFile);
			bufferedReader = new BufferedReader(fileReader);
			System.out.println("fine till here");
			String str = "";
			bufferedReader = new BufferedReader(new FileReader(this.playGameFile));
			if (easy_med_hard == EASY){
				// generate from the easy set
				int counter = 0;					
				while((str = bufferedReader.readLine()) != null && counter <= 9){					
					for( int j = 0; j < SIZE_OF_GRID; j++){
						char ch = str.charAt(j); 
						if(ch == '1'){
							grid[counter][j] = 1;
						}else if(ch == '0'){
							grid[counter][j] = 0;
						}else if (ch == '2'){
							grid[counter][j] = 2;
						}else if (ch == '3'){
							grid[counter][j] = 3;
						}
					}
					counter++;
				}
			}else if (easy_med_hard == MED){
				// generate from the middle set
				int counter = 0;
				int i = 0;
				while((str = bufferedReader.readLine()) != null){
					if(counter >= 10 && counter <= 19){
						for( int j = 0; j < SIZE_OF_GRID; j++){
							char ch = str.charAt(j); 
							if(ch == '1'){
								grid[i][j] = 1;
							}else if(ch == '0'){
								grid[i][j] = 0;
							}
						}
						i++;
					}
					counter++;
				}				
			}else if (easy_med_hard == HARD){
				// generate from the hard set
				int counter = 0;
				int i = 0;
				while((str = bufferedReader.readLine()) != null){
					if(counter >= 20 && counter <= 29){
						for( int j = 0; j < SIZE_OF_GRID; j++){
							char ch = str.charAt(j); 
							if(ch == '1'){
								grid[i][j] = 1;
							}else if(ch == '0'){
								grid[i][j] = 0;
							}
						}
						i++;
					}
					counter++;
				}
			}
		}catch(Exception exception){
			System.out.println("play_game_file was not found. ");
		}finally{
			try{
				if(bufferedReader != null){
					bufferedReader.close();
				}
			}catch(IOException e){}
		}
		return grid;
	}
}
