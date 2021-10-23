package unknownquest;

public class DoublyLinked {

    private Node head;
    private Node tail;
    private Node current;

    public DoublyLinked() {
        head = null;
        tail = null;
        current = null;
    }

    public void print() {
        setCurrent(getHead());
        if (getHead().getNextLevel() == null) {
            System.out.println(getHead().getLevel());
            return;
        }
        while (getCurrent().getNextLevel() != null) {
            System.out.println(getCurrent().getLevel());
            setCurrent(getCurrent().getNextLevel());
        }
        System.out.println(getCurrent().getLevel());
    }

    public void insertBeginning(Level level) {
        if (getHead() == null) {
            Node stage = new Node(level);
            setHead(stage);
            setCurrent(getHead());
            return;
        }
        Node stage = new Node(level);
        stage.setNextLevel(getHead());
        getHead().setPrevLevel(stage);
        setHead(stage);
        setCurrent(getHead());

    }

    public void insertEnd(Level level) {
        setCurrent(getHead());
        if (getHead() == null) {
            Node stage = new Node(level);
            setHead(stage);
            return;
        }
        while (getCurrent().getNextLevel() != null) {
            setCurrent(getCurrent().getNextLevel());
        }
        Node stage = new Node(level);
        getCurrent().setNextLevel(stage);
        stage.setPrevLevel(getCurrent());
        setTail(stage);
        setCurrent(getHead());

    }

    public void currentAtBegining() {
        if (getHead() == null) {
            return;
        }
        while (getCurrent().getPrevLevel() != null) {
            setCurrent(getCurrent().getPrevLevel());
        }
        setHead(getCurrent());
        setCurrent(getHead());
    }

    public void currentAtEnd() {
        while (getCurrent().getNextLevel() != null) {
            setCurrent(getCurrent().getNextLevel());
        }
        setTail(getCurrent());
    }

    public void moveCurrentToNext() {
        if (getCurrent() == null) {
            return;
        }
        if (getCurrent().getNextLevel() == null) {
            return;
        }
        setCurrent(getCurrent().getNextLevel());
    }

    public void moveCurrentToPrev() {
        if (getCurrent().getPrevLevel() == null) {
            return;
        }
        setCurrent(getCurrent().getPrevLevel());
    }

    public void insertingAfterCurrent(Level level) {
        if (getCurrent().getNextLevel() != null) {
            Node stage = new Node(level);
            Node currentNode = getCurrent();
            Node next = getCurrent().getNextLevel();

            currentNode.setNextLevel(stage);
            stage.setPrevLevel(currentNode);
            stage.setNextLevel(next);
            next.setPrevLevel(stage);
        }
        else {
        	Node stage = new Node(level);
            stage.setPrevLevel(getTail());
            getTail().setNextLevel(stage);
            setTail(stage);
        }
    }

    public void removing() {
        if (getCurrent() == null) {
            System.out.println("there is nothing to remove");
            return;
        }        

        if (getCurrent() != null && getCurrent() != getHead() && getCurrent() != getTail()) {
            Node next = getCurrent().getNextLevel();
            Node previous = getCurrent().getPrevLevel();
            previous.setNextLevel(next);
            next.setPrevLevel(previous);
            getCurrent().setNextLevel(null);
            getCurrent().setPrevLevel(null);
            setCurrent(null);
        } else if (getCurrent() == getHead() && getCurrent().getNextLevel() != null) {
            Node next = getCurrent().getNextLevel();
            next.setPrevLevel(null);
            setHead(next);
            getCurrent().setNextLevel(null);
            setCurrent(getHead());
        } else if (getCurrent() == getHead() && getCurrent().getNextLevel() == null) {
            setHead(null);
            setCurrent(null);
            setTail(null);

        } else if (getCurrent() == getTail()) {
            Node prev = getCurrent().getPrevLevel();
            prev.setNextLevel(null);
            setTail(prev);
            getCurrent().setPrevLevel(null);
            setCurrent(getTail());
        }
        return;
    }

    public int listLenght() {
        if (getHead() == null) {
            return 0;
        }
        int counter = 1;
        Node tempCurrent = getCurrent();
        setCurrent(getHead());
        while (getCurrent().getNextLevel() != null) {

            setCurrent(getCurrent().getNextLevel());
            counter++;
        }
        setCurrent(tempCurrent);
        return counter;
    }

    public Level getCurrentValue() {
        if (getCurrent() == null) {
            return null;
        }
        Level data = getCurrent().getLevel();
        return data;
    }

    public void setValueAtaPosition(int position, Level level) {
        setCurrent(getHead());
        int currentPos = 1;
        while (currentPos != position) {
            if (getCurrent().getNextLevel() == null) {
                System.out.println("This position does not exist");
                return;
            }
            setCurrent(getCurrent().getNextLevel());
            currentPos++;
        }
        getCurrent().setLevel(level);
    }

    public void reverseList() {
        setCurrent(getHead());
        if (getCurrent().getNextLevel() == null) {
            return;
        }
        Node temp = null;
        while (getCurrent() != null) {
            temp = getCurrent().getPrevLevel();
            getCurrent().setPrevLevel(getCurrent().getNextLevel());
            getCurrent().setNextLevel(temp);
            setCurrent(getCurrent().getPrevLevel());
        }
        setHead(temp.getPrevLevel());
        setCurrent(getHead());
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
        this.current = this.head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public Node getCurrent() {
        return current;
    }

    public void setCurrent(Node current) {
        this.current = current;
    }

}
