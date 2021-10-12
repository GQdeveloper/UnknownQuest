package unknownquest;

public class Node {

    private Level level;
    private Node next;
    private Node prev;

    public Node(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Node getNextLevel() {
        return next;
    }

    public void setNextLevel(Node next) {
        this.next = next;
    }

    public Node getPrevLevel() {
        return prev;
    }

    public void setPrevLevel(Node prev) {
        this.prev = prev;
    }

}
