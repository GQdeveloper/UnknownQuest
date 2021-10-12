
package unknownquest;


public class PlayerNpc {
    private String name;
    private  int health;
    private int damage;
    private Item[] content;
    
    
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
        return content;
    }

    public void setContent(Item[] content) {
        this.content = content;
    }

   
    
}
