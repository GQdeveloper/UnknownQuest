
package unknownquest;


public class PlayerNpc {
    private String name;
    private  int health;
    private int damage;
    private Item[] inventory = new Item[6];
    private int currentInventoryIndex = 0;
    
    
    public PlayerNpc(String name, int health, int damage ){
        this.name = name;
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
    
    public void showInventory() {
    	String inventoryItems = "";
    	for(int i = 0; i < inventory.length; i++) {
    		if(inventory[i] != null) {
    			inventoryItems += inventory[i].getName() + ",";
    		}    		
    	}
    	System.out.println(inventoryItems);
    }

    public void setContent(Item newItem) {
    	if (currentInventoryIndex == this.inventory.length) {
    		System.out.println("your inventory is full");
    	}
    	else {
    		  this.inventory[currentInventoryIndex] = newItem;
    	      currentInventoryIndex++;
    	}
      
    }

   
    
}
