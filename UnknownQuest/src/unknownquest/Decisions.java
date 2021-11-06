package unknownquest;

import java.util.Scanner;

public class Decisions {
	private String[] moves = {"walk", "where i am", "inventory", "status", "r portal", "b portal"};
	
	public Decisions(String choice, DoublyLinked stage, PlayerNpc hero) {
		//checks if choice is a valid move
		boolean isInvalid = true;
		for(int i = 0; i < moves.length; i++)
		{			
			if(choice.equals(moves[i]))
			{				
				switch (choice)
				{		
					case "walk":
						walk(stage, hero);
						break;
						
					case "where i am":
						whereIam(stage);
						break;	
						
					case "r portal":
						prevStage(stage);
						
						break;
					case "b portal":
						if(checkingLevel(hero, stage)) {
							nextStage(stage);							
						}
						
						break;
						
					case "inventory":
						hero.showInventory();
						break;
						
					case "status":
						heroStatus(hero);
				}			
					
				isInvalid = false;
			}
		}
		if(isInvalid)
		{
		System.out.println("that is not a valid move, try again \n");
		}
	}


	private boolean checkingLevel(PlayerNpc hero, DoublyLinked stage) {
		if(hero.getHeroLvl() - 1 > stage.getCurrentValue().getLvlId()) {
			return true;
		}
		
		System.out.println("you are not strong enough");
		return false;
		
	}


	private void heroStatus(PlayerNpc hero) {
		System.out.println("STATUS:  " + "Health "+ hero.getHealth() + ", Power: " + hero.getDamage() + ", Experience: " + hero.getHeroExperience()
		+ ", LVL: " + hero.getHeroLvl());		
	}


	//IF player chooses to walk
	public void walk(DoublyLinked stage, PlayerNpc hero) {
		//asking input for to go to a specific room
		int doorNumber;
		while(true) {	
			try
			{				
				System.out.println("where would you like to go?.. Pick a door number \n");	
				doorsDescription(stage);
				Scanner answer = new Scanner(System.in);
				
				if((doorNumber = answer.nextInt()) > 4)
				{
					System.out.println("tha path does not exist, choose again..\n");
					continue;
				}
			}
			catch(java.util.InputMismatchException e)
			{
				System.out.println("please enter a door number. \n");
				continue;
			}
			break;
		}
		//switching between rooms according to user input.
		GameEvents event = new GameEvents();
		switch (doorNumber)
		{		
			case 1:
			
				stage.getCurrent().getLevel().setCurrentRoom(stage.getCurrent().getLevel().getRoomOne());
				System.out.println("You head towards: " + stage.getCurrent().getLevel().getRoomOne().getName() + "\n");	
				System.out.println(stage.getCurrent().getLevel().getCurrentRoom().getDescription() + "\n");
				event.events(hero, stage);
				break;
			case 2:
				stage.getCurrent().getLevel().setCurrentRoom(stage.getCurrent().getLevel().getRoomTwo());
				System.out.println("You head towards: " + stage.getCurrent().getLevel().getRoomTwo().getName() + "\n");
				System.out.println(stage.getCurrent().getLevel().getCurrentRoom().getDescription() + "\n");
				event.events(hero, stage);
				break;
			case 3:
				stage.getCurrent().getLevel().setCurrentRoom(stage.getCurrent().getLevel().getRoomThree());
				System.out.println("You head towards: " + stage.getCurrent().getLevel().getRoomThree().getName()  + "\n");
				System.out.println(stage.getCurrent().getLevel().getCurrentRoom().getDescription() + "\n");
				event.events(hero, stage);
				break;
				
			case 4:
				stage.getCurrent().getLevel().setCurrentRoom(stage.getCurrent().getLevel().getRoomFour());
				System.out.println("You head towards: " + stage.getCurrent().getLevel().getRoomFour().getName()  + "\n");
				System.out.println(stage.getCurrent().getLevel().getCurrentRoom().getDescription() + "\n");
				event.events(hero, stage);
				break;			
		}
		
	}
	//it prints where the player currently is
	public void whereIam(DoublyLinked stage) {
		System.out.println("You are at " + stage.getCurrent().getLevel().getLevelName());
		System.out.println("At " + stage.getCurrent().getLevel().getCurrentRoom().getName());
	}
	
	//prints the different rooms descriptions
	public void doorsDescription(DoublyLinked stage) {
		stage.getCurrent().getLevel().getRoomsDescriptions();
	}
	
	public void nextStage(DoublyLinked stage) {
		if(stage.getCurrent().getNextLevel() != null) {
		stage.setCurrent(stage.getCurrent().getNextLevel());
		whereIam(stage);
		}
		else {System.out.println("you walk trought the portal, you hear a voice deep in the background, "
				+ "you wake up, jumping out of bed just to relized that everything was just a dream");
		System.exit(0);
		}
	}
	
	public void prevStage(DoublyLinked stage) {
		if(stage.getCurrent().getPrevLevel() != null) {
		stage.setCurrent(stage.getCurrent().getPrevLevel());
		whereIam(stage);
		}
		else {System.out.println("you walk trought the portal, you hear a voice deep in the background, "
				+ "you wake up, once again you are in the same place");}
	}
}
