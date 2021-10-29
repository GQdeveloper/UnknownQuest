package unknownquest;
import java.util.Random;
import java.util.Scanner;

public class GameEvents {
	
	private Random randEvent = new Random();
	
	public void events(PlayerNpc hero, DoublyLinked stage) {
		int event = randEvent.nextInt(3);
		
		switch(event)
		{
			case 0:
				System.out.println("the " + stage.getCurrent().getLevel().getCurrentRoom().getName() + "i don't see anything, eveything is dark and cold");
				break;
				
			case 1:	
				if(hero.getInventoryElements() != hero.getContent().length)
				{
					Chess vault = new Chess("wooden chess");
					vault.randItems();
					System.out.println("you found a " + vault.getDescription() + "you opened!!"
							+ " you acquired a " + vault.getItemName());
					hero.setContent(vault.getContent());						
				}
				else
				{
					System.out.println("You have found a chess but your inventory is full, you loss the item");					
				}
				break;
				
			case 2:				
				System.out.println("you have encounter an enemy\n");
				
				PlayerNpc enemy = new PlayerNpc();
				enemy.makeEnemy(20, 6);
				
				while(true)
				{					
					System.out.println("STATUS: " + hero.getName() + " health: " + hero.getHealth() +
							" -- " + enemy.getName() + " health: " + enemy.getHealth());
					System.out.println("[attack] - [inventory]");
					Scanner in = new Scanner(System.in);
					String choice = in.next().toLowerCase();
					
						switch(choice)
						{					 
							case "attack":
								
								System.out.println(hero.getName() + " attacks\n");
								enemy.setHealth(enemy.getHealth() - hero.getDamage());
								System.out.println(enemy.getName() + " attacks\n");
								hero.setHealth(hero.getHealth() - enemy.getDamage());	
								
								break;
							case "inventory":
								hero.showInventory();
						}
						
					if(hero.getHealth() == 0 || enemy.getHealth() == 0)
					{
						System.out.println("you have defeted the " + enemy.getName());
						break;
					}
				}
				break;			
		}
	}
}
