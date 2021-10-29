
package unknownquest;

import java.util.Random;

public class Chess {
    
    private String description;
    public Item[] content = new Item[1];
    
    public Chess(String description){
        this.description = description;
        
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemName() {
        String itemName = content[0].getName();
    	return itemName;
    }
    
    public Item getContent() {
    	return content[0];
    }
    
    public void setContent(Item[] content) {
        this.content = content;
    }
    
    public void randItems() {
    	String itemName[] = {"magic water", "heal potion", "fire rock", "ice rock"};
    	Random randItem = new Random();
    	int item = randItem.nextInt(4);
	    	
    	switch(itemName[item])
    	{
    		case "magic water":
    			creatingItems(itemName[item], 5, 0);
    			break;
    		case "heal potion":
    			creatingItems(itemName[item], 0, 10);
    			break;
    		case "fire rock":
    			creatingItems(itemName[item], 15, 0);
    			break;
    		case "ice rock":
    			creatingItems(itemName[item], 14, 0);
    			break;
	    }
    	     
    }
    
    public void creatingItems(String name, int damage, int heal) {
    	Item randItem = new Item(name, damage, heal);    
        content[0] = randItem;    
    }
    	
    	
    }

