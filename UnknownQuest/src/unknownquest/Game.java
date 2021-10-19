package unknownquest;

import java.util.Scanner;

public  class Game {
	
	public DoublyLinked stages;
	
	public Game() {
		
	}	
	
	
	public void playing(boolean runGame, Scanner input) {
		if(runGame) {
			Level firstStage = new Level("The house, first level", "door #1","it looks like a door", "door #2", "it is made of rock", "door #3", 
					"jumm.. seems weird", "door #4", "nothing especial");		
			Node firstRooms = new Node(firstStage);
			stages = new DoublyLinked();
			stages.setHead(firstRooms);
			
			System.out.println("You are in the game \n");
			}
					
			//Taking a decision			
			//input = new Scanner(System.in);
		while(true) {
			input = new Scanner(System.in);
			System.out.println("MOVES: [walk] - [where I am] - [examine] - [fight] - [run]");
			System.out.println("please make a move: ");
			String answer = input.nextLine();
			
			// checking if the current room is being update it
			//System.out.println(stages.getCurrent().getLevel().getCurrentRoom().getName() + "TEST: PREVIOUS ROOM GAME FILE");
			Decisions choice = new Decisions(answer, stages);
			
			
			System.out.println("we are back to the game class");
			//System.out.println(stages.getCurrent().getLevel().getCurrentRoom().getName() + "TEST: CURRENT NEW ROOM GAME FILE");
		}
	}
	
}
