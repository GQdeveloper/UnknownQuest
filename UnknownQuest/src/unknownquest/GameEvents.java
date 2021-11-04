package unknownquest;
import java.util.Random;
import java.util.Scanner;

public class GameEvents {
	
	private Random randEvent = new Random();
	
	public void events(PlayerNpc hero, DoublyLinked stage) {
		int event = randEvent.nextInt(100);
		
		if(event < 30) {event = 0;}
		if(event >= 30 && event <= 75) {event = 2;}
		if(event > 75) {event = 1;}
		
		switch(event)
		{
			case 0:
				System.out.println("the " + stage.getCurrent().getLevel().getCurrentRoom().getName() + "I can't see anything, eveything is dark and cold\n");
				break;
				
			case 1:	
				if(hero.getContent().size() < 6)
				{
					Chess vault = new Chess("chess");
					vault.randItems();
					System.out.println("you found a " + vault.getDescription() + "you opened it!!"
							+ " you have acquired a " + vault.getItemName() + "\n");
					hero.setContent(vault.getContent());						
				}
				else
				{
					System.out.println("You have found a chess but your inventory is full, you loss the item\n");					
				}
				break;
				
			case 2:				
				System.out.println("you have encounter an enemy\n");
				
				PlayerNpc enemy = new PlayerNpc();
				enemy.makeEnemy(stage.getCurrentValue().getLvlId());
				
				while(true)
				{					
					System.out.println("STATUS: " + hero.getName() + " health: " + hero.getHealth() +
							" -- " + enemy.getName() + " health: " + enemy.getHealth() + "\n");
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
						
					if(hero.getHealth() <= 0)
					{
						System.out.println("you have died. GAME OVER!!");
						hero.setAlive(false);
						break;
					}
					if(enemy.getHealth() == 0)
					{
						System.out.println("you have defeted the enemy\n");
						hero.setHeroExperience(hero.getHeroExperience() + enemy.getEnemyExperience());
						break;
					}
				}
				break;			
		}
	}
}
