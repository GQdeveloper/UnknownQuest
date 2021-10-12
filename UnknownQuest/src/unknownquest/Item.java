
package unknownquest;

public class Item {
    private String name;
    private int damage;
    private int healing;
    
    public Item(String name, int damage, int healing){
        this.name = name;
        this.damage = damage;
        this.healing = healing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealing() {
        return healing;
    }

    public void setHealing(int healing) {
        this.healing = healing;
    }
}
