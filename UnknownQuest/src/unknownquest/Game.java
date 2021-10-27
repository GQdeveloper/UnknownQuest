package unknownquest;

import java.io.File;
import java.util.Scanner;

public  class Game {
	
	private DoublyLinked stages = new DoublyLinked();
	
	public Game() {
		
	}	
	
	
	public void playing(boolean runGame, Scanner input, PlayerNpc hero)  {
		if(runGame) {
			//read file to populate the level information and added to doublylinked list
			try {
				String lvlsInfo [] = new String [9]; 
				File levelsFile = new File("src/infoLevels.txt");				
				input = new Scanner(levelsFile);
				input.useDelimiter(",");	
				
				//LOOP TO ARRAY TO HOLD LEVELS INFORMATION WHEN READING FILE
				while(input.hasNext()) {					
					
					for(int i = 0; i < lvlsInfo.length; i ++) {
						String lvlArgs = input.next();						
						lvlsInfo[i] = lvlArgs;
						
					}					
					
					//USE ARRAY INFO TO POPULATE LEVELS INFORMATION
					Level firstStage = new Level(lvlsInfo[0], lvlsInfo[1],lvlsInfo[2], lvlsInfo[3], lvlsInfo[4], lvlsInfo[5], 
							lvlsInfo[6], lvlsInfo[7], lvlsInfo[8]);			
					stages.insertEnd(firstStage);
				}
				
				
				System.out.println("You are in the game \n");
				System.out.println("list lenght " + stages.listLenght());
				
			} catch(java.io.FileNotFoundException e) {
				System.out.println("wrong file path in game!! \n");
				System.exit(0);
			} catch(java.util.NoSuchElementException e) {
				System.out.println("populating levels the scanner not found a word to read, probably wrong formating in file\n");
				System.exit(0);
			}
					
			
		}
					
			//GAME'S MAIN LOOP LOGIC: taking decisions 	
			
		while(true) {
			input = new Scanner(System.in);
			System.out.println("MOVES: [walk] - [where I am] - [examine] - [fight] - [run] - [inventory]");
			System.out.println("please make a move: ");
			String answer = input.nextLine();
			
			//checking if the current room is being update it
			//System.out.println(stages.getCurrent().getLevel().getCurrentRoom().getName() + "TEST: PREVIOUS ROOM GAME FILE");
			Decisions choice = new Decisions(answer, stages, hero);			
			//System.out.println(stages.getCurrent().getLevel().getCurrentRoom().getName() + "TEST: CURRENT NEW ROOM GAME FILE");
		}
	}
	
}
