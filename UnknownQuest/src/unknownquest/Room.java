
package unknownquest;

public class Room {
    
    private String name;
    private String description;
    public Chess chess;
    private PlayerNpc enemy;
    private Room next;
    private Room previous;
    
    public Room (String name, String description, Chess chess){
        this.name = name;
        this.description = description; 
        this.chess = chess;
    }
    public Room (String name, String description, PlayerNpc enemy){
        this.name = name;
        this.description = description;         
        this.enemy = enemy;
    }
    
    public Room (String name, String description, Chess chess, PlayerNpc enemy){
        this.name = name;
        this.description = description; 
        this.chess = chess;
        this.enemy = enemy;
    }
    
    public Room (String name, String description){
        this.name = name;
        this.description = description;        
    }
    


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Chess getChess() {
        return chess;
    }

    public void setChess(Chess chess) {
        this.chess = chess;
    }

    public PlayerNpc getEnemy() {
        return enemy;
    }

    public void setEnemy(PlayerNpc enemy) {
        this.enemy = enemy;
    }

    public Room getNext() {
        return next;
    }

    public void setNext(Room next) {
        this.next = next;
    }

    public Room getPrevious() {
        return previous;
    }

    public void setPrevious(Room previous) {
        this.previous = previous;
    }
}
