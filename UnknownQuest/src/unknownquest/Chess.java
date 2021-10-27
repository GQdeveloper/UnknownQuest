
package unknownquest;


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
    
    public void wooden() {
    	Item sword = new Item("wooden sword", 3, 0);    
        content[0] = sword;         
    }
    	
    	
    }

