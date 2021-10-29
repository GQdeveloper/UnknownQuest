package unknownquest;
import java.util.Random;
import java.util.Scanner;
import unknownquest.HelperMethods;



public class PlayerNpc {
    private String name;
    private  int health;
    private int damage;
    private Item[] inventory = new Item[6];
    private int inventoryElements = 0;
    
    public PlayerNpc() {
    	
    } 
    
    public PlayerNpc(String name, int health, int damage ){
        this.name = name;
        this.health = health;
        this.damage = damage;        
    }
    
    public void makeEnemy(int health, int damage) {
    	String enemyNames[] = {"Goblin", "demon", "rat", "evil bat","demon dog", "vampire", "dark spirit"};
    	Random rand = new Random();
    	int randIndex = rand.nextInt(enemyNames.length);    	
    	this.name = enemyNames[randIndex];
        this.health = health;
        this.damage = damage;    
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Item[] getContent() {
        return inventory;
    }
    
    public int getInventoryElements() {
    	return inventoryElements;
    }
    
    public void inventoryManage() {
    	
    	String moves[] = {"use item", "drop item", "close"};
    	String choice = null;
    	boolean inValid = true;
    	
    	while(inValid)
    	{
	    	System.out.println("[use item] + [drop item] + [close]");
	    	Scanner in = new Scanner(System.in);
	    	choice = in.nextLine().toLowerCase();
	    	
	    	for(int i = 0; i < moves.length; i++)
	    	{
	    		if(moves[i].equals(choice))
	    		{
	    			inValid = false;	    			
	    		}
	    	}
	    	if(inValid)
	    	{
	    		System.out.println("invalid move");
	    	}
    	}
    	switch (choice)
    	{
    		case "use item":
    			useItem();    			
    			break;
    		case "drop item":
    			break;
    		case "close":
    			break;
    	}
    }
    
    
    private void useItem() {
    	boolean open = true;
    	while(open)
    	{
	    	System.out.println("what item would you like to use? ");
	    	Scanner in = new Scanner(System.in);
	    	String choice = in.nextLine().toLowerCase();
	    	
		    	switch (choice) {    	
					case "magic water":
						if(HelperMethods.getItem(inventory,inventoryElements, choice) != null)
						{
							setDamage(getDamage() + HelperMethods.getItem(inventory,inventoryElements, choice).getDamage());
							open = false;
						}
						break;
					case "heal potion":
						if(HelperMethods.getItem(inventory,inventoryElements, choice) != null)
						{
							setHealth(getHealth() + HelperMethods.getItem(inventory,inventoryElements, choice).getHealing());
							open = false;
						}
						break;
					case "fire rock":
						if(HelperMethods.getItem(inventory,inventoryElements, choice) != null)
						{
							setDamage(getDamage() + HelperMethods.getItem(inventory,inventoryElements, choice).getDamage());
							open = false;
						}
						break;
					case "ice rock":
						if(HelperMethods.getItem(inventory,inventoryElements, choice) != null)
						{
							setDamage(getDamage() + HelperMethods.getItem(inventory,inventoryElements, choice).getDamage());
							open = false;
						}
						break;
			}
    	}
		
	}

	public void showInventory() {
    	
    	String inventoryItems = "";
    	if(this.inventory[0] != null)
		{    		
	    	for(int i = 0; i < inventoryElements; i++) 
	    	{	    		 
	    		inventoryItems += "[" + inventory[i].getName() + "]";    		 		
	    	}
	    	System.out.println(inventoryItems);
	    	inventoryManage();
    	}
    	else
    	{
    		System.out.println("Inventory is empty");
    	}
    }

    
    public void setContent(Item newItem)
    {
    	if (inventoryElements != inventory.length)
    	{
    		 inventory[inventoryElements] = newItem;
   	      	 inventoryElements++;   	      	 
    	}
    	else
    	{
    		 System.out.println("Your inventory is full");
    	}
    	
    }

   
    
}
