package unknownquest;

import java.util.Scanner;

public class Game {

	public Game() {	
		
		
		Level firstStage = new Level("The house", "entrance","it looks like a door", "living room", "there are a lot of furnitures", "hallway", 
				"it is dark and long", "bed room", "it is big and abed is there");		
		Node firstRooms = new Node(firstStage);
		DoublyLinked stages = new DoublyLinked();
		stages.setHead(firstRooms);
		
		System.out.println(stages.getHead().getLevel().getLevelName());
		
	}	
	
}
