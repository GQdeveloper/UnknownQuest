
package unknownquest;


public class Chess {
    
    private String description;
    public Item[] content;
    
    public Chess(String description, Item itemOne, Item itemTwo){
        this.description = description;
        content = new Item[2];
        content[0] = itemOne;    
        content[1] = itemTwo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Item[] getContent() {
        return content;
    }

    public void setContent(Item[] content) {
        this.content = content;
    }
    
}
