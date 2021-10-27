package unknownquest;

import java.util.Scanner;

public class Decisions {
	private String[] moves = {"walk", "where I am", "examine", "fight", "run", "inventory"};
	
	public Decisions(String choice, DoublyLinked stage, PlayerNpc hero) {
		//checks if choice is a valid move
		boolean isInvalid = true;
		for(int i = 0; i < moves.length; i++) {
			
			if(choice.equals(moves[i])) {
				
				switch (choice) {		
				case "walk":
					walk(stage, hero);
					break;
					
				case "where I am":
					whereIam(stage);
					break;	
					
				case "portal":
					nextStage(stage);
					break;
					
				case "inventory":
					hero.showInventory();
					break;
				}
				isInvalid = false;
			}
		}
		if(isInvalid) {
		System.out.println("that is not a valid move, try again \n");
		}
	}


	//IF player chooses to walk
	public void walk(DoublyLinked stage, PlayerNpc hero) {
		//asking input for to go to a specific room
		int doorNumber;
		while(true) {	
			try {
				
			System.out.println("where would you like to go?.. Pick a door number \n");	
			doorsDescription(stage);
			Scanner answer = new Scanner(System.in);
			
				if((doorNumber = answer.nextInt()) > 4) {
					System.out.println("tha path does not exist, choose again..");
					continue;
				}
			}
			catch(java.util.InputMismatchException e) {
				System.out.println("please enter a door number. ");
				continue;
			}
			break;
		}
		//switching between rooms according to user input.
		switch (doorNumber) {		
		case 1:
			stage.getCurrent().getLevel().setCurrentRoom(stage.getCurrent().getLevel().getRoomOne());
			System.out.println("You walked trought door 1");
			GameEvents event = new GameEvents();
			event.events(hero, stage);
			break;
		case 2:
			stage.getCurrent().getLevel().setCurrentRoom(stage.getCurrent().getLevel().getRoomTwo());
			System.out.println("You walked trought door 2");
			break;
		case 3:
			stage.getCurrent().getLevel().setCurrentRoom(stage.getCurrent().getLevel().getRoomThree());
			System.out.println("You walked trought door 3");
			break;
			
		case 4:
			stage.getCurrent().getLevel().setCurrentRoom(stage.getCurrent().getLevel().getRoomFour());
			System.out.println("You walked trought door 4");
			break;			
		}
		
	}
	//it prints where the player currently is
	public void whereIam(DoublyLinked stage) {
		System.out.println("You are at " + stage.getCurrent().getLevel().getCurrentRoom().getName());
	}
	
	//prints the different rooms descriptions
	public void doorsDescription(DoublyLinked stage) {
		stage.getCurrent().getLevel().getRoomsDescriptions();
	}
	
	public void nextStage(DoublyLinked stage) {
		if(stage.getCurrent().getNextLevel() != null) {
		stage.setCurrent(stage.getCurrent().getNextLevel());
		}
		else {System.out.println("you walk trought the portal, you hear a voice deep in the background, "
				+ "you wake up, jumping out of bed just to relized that everything was just a dream");}
	}
}
