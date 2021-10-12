package unknownquest;

import java.io.File;

public class Game {

	public Game(boolean runGame) {	
		
		
		if(runGame) {
		Level firstStage = new Level("The house", "entrance","it looks like a door", "living room", "there are a lot of furnitures", "hallway", 
				"it is dark and long", "bed room", "it is big and abed is there");		
		Node firstRooms = new Node(firstStage);
		DoublyLinked stages = new DoublyLinked();
		stages.setHead(firstRooms);
		
		System.out.println("You are in the game");
		}
		
		
		
	}	
	
}
