package unknownquest;
import java.util.Random;

public class GameEvents {
	
	private Random randEvent = new Random();
	
	public void events(PlayerNpc hero, DoublyLinked stage) {
		int event = randEvent.nextInt(3);
		
		switch(event) {
		case 0:
			System.out.println("the " + stage.getCurrent().getLevel().getCurrentRoom().getName() + "is lonly in cold");
			break;
			
		case 1:			
			Chess vault = new Chess("wooden chess");
			vault.wooden();
			System.out.println("you found a " + vault.getDescription() + "you opened!!"
					+ "you acquired a " + vault.getItemName());
			hero.setContent(vault.getContent());
			break;
			
		case 2:
			System.out.println("you fought against evil and won keep up");
			break;
			
		}
	}
}
