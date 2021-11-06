package unknownquest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;



public class PlayerNpc  {
	private boolean alive = true;
	private final int inventorySize = 6;
	 private ArrayList<Item> inventory = new ArrayList<Item>();
    private String name;
    private  int health;
    private int damage;  
    private int heroLvl = 1;
    private int heroExperience = 0;
	private int enemyExperience = 20;
	private Item magicDamage;
   
    
   
	public PlayerNpc() {
    	
    } 
    
    public PlayerNpc(String name, int health, int damage ){
        this.name = name;
        this.health = health;
        this.damage = damage;        
    }
    
    public void makeEnemy(int lvlId) {
    	String enemyNames[] = {"Goblin", "demon", "rat", "evil bat","demon dog", "vampire", "dark spirit"};
    	Random rand = new Random();
    	int randIndex = rand.nextInt(enemyNames.length);    	
    	this.name = enemyNames[randIndex];
        this.health = randIndex * 10;       
        this.damage = 6;
        
        if(lvlId > 0) {
        	 int lvlUpgrades =  lvlId * (this.enemyExperience/3);
        	 this.enemyExperience += lvlUpgrades;
        	 lvlUpgrades =  lvlId * (this.damage/3);
        	 this.damage += lvlUpgrades;
        	 lvlUpgrades = lvlId * (this.health/4);
        	 this.health += lvlUpgrades;
        }       
        
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

    public  ArrayList<Item> getContent() {
        return inventory;
    }
    
   
    
    public void inventoryManage() {
    	
    	String moves[] = {"use item", "close"};
    	String choice = null;
    	boolean inValid = true;
    	
    	while(inValid)
    	{
	    	System.out.println("[use item] + [close]");
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
    			
    		case "close":
    			break;
    	}
    }
    
    
    private void useItem() {
    	boolean open = true;
    	while(open)
    	{
	    	System.out.println("what item would you like to use? \n");
	    	Scanner in = new Scanner(System.in);
	    	String choice = in.nextLine().toLowerCase();
	    	
	    	boolean itemFound = false;
	    	for(int i = 0; i < inventory.size(); i++) {
	    		if(itemFound) {
	    			break;
	    		}
	    		
	    		if(choice.equals(inventory.get(i).getName()))
	    		{
	    			switch(choice)
	    			{
	    				
		    			case "heal potion":
		    				setHealth(getHealth() + inventory.get(i).getHealing());
		    				inventory.remove(i);
		    				itemFound = true;
		    				open = false;
		    				break;
		    				
		    			case "magic water":
		    				setDamage(getDamage() + inventory.get(i).getDamage());
		    				inventory.remove(i);
		    				itemFound = true;
		    				open = false;
		    				break;
		    				
		    			case "fire rock":
		    				this.setMagicDamage(inventory.get(i));
		    				inventory.remove(i);
		    				itemFound = true;
		    				open = false;
		    				break;
		    				
		    			case "ice rock":
		    				this.setMagicDamage(inventory.get(i));
		    				inventory.remove(i);
		    				itemFound = true;
		    				open = false;
		    				break;
	    			} 			
	    		}
	    	}
	    	if(itemFound == false) {
	    		System.out.println("You don't have that item\n");
	    	}
	    	
	    	
    	}
		
	}
     
    

	public void showInventory() {
    	
		if(inventory.isEmpty()) {
			System.out.println("Inventory is empty");
		}
		else
		{
			String content = "";
			for(int i = 0; i < inventory.size(); i++)
			{
				content += "[" + inventory.get(i).getName() + "]";
			}
			System.out.println(content);	
			inventoryManage();
		}	
		
    }

    
    public void setContent(Item newItem)
    {
    	if(inventory.size() < inventorySize) {
    		inventory.add(newItem);
    	}
    	else
    	{
    		System.out.println("Your inventory is full\n");
    	}
   	
    }

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getHeroLvl() {
		return heroLvl;
	}

	public void setHeroLvl(int heroLvl) {
		if (this.getHeroExperience() >= 100) {
			this.heroLvl = heroLvl;
			this.heroExperience = 0;
		}		
	}

	public int getHeroExperience() {
		return heroExperience;
	}

	public void setHeroExperience(int heroExperience) {			
		this.heroExperience += heroExperience;		
		if (this.getHeroExperience() >= 100) {
			this.heroLvl += 1;
			this.heroExperience = 0;
			this.setDamage(this.damage + 6); ;
			this.setHealth(120);}
	}
	
	 public int getEnemyExperience() {
			return enemyExperience;
		}

	public void setEnemyExperience(int enemyExperience) {
		this.enemyExperience = enemyExperience;
	}

	public Item getMagicDamage() {
		return magicDamage;
	}

	public void setMagicDamage(Item magicDamage) {
		this.magicDamage = magicDamage;
	}

   
    
}
