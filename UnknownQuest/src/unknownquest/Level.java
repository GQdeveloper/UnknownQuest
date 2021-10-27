
package unknownquest;


public class Level {
    
    private Room roomOne, roomTwo, roomThree, roomFour;
    private Room currentRoom;
	private String levelName;
    
    public Level(String levelName, String rOneName, String rOneDescrip, String rTwoName,
    		String rTwoDescrip, String rThreeName, String rThreeDescrip, String rFourthName, String rFourthDescrip){
    	
        this.levelName = levelName;
        this.roomOne = new Room(rOneName, rOneDescrip);
        this.roomTwo = new Room(rTwoName, rTwoDescrip);
        this.roomThree = new Room(rThreeName, rThreeDescrip);
        this.roomFour = new Room(rFourthName, rFourthDescrip);
        
        currentRoom = roomOne;        
        roomOne.setNext(roomTwo);
        roomTwo.setNext(roomThree);
        roomTwo.setPrevious(roomOne);
        roomThree.setNext(roomFour);
        roomThree.setPrevious(roomTwo);
        roomFour.setNext(roomOne);
        roomFour.setPrevious(roomThree);        
    }

    public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public Room getRoomOne() {
        return roomOne;
    }

    public void setRoomOne(Room roomOne) {
        this.roomOne = roomOne;
    }

    public Room getRoomTwo() {
        return roomTwo;
    }

    public void setRoomTwo(Room roomTwo) {
        this.roomTwo = roomTwo;
    }

    public Room getRoomThree() {
        return roomThree;
    }

    public void setRoomThree(Room roomThree) {
        this.roomThree = roomThree;
    }

    public Room getRoomFour() {
        return roomFour;
    }

    public void setRoomFour(Room roomFour) {
        this.roomFour = roomFour;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
    
    public void getRoomsDescriptions() {
    	System.out.println("1. " + roomOne.getName() + ": " + roomOne.getDescription());
    	System.out.println("2. " + roomTwo.getName() + ": " + roomTwo.getDescription());
    	System.out.println("3. " + roomThree.getName() + ": " + roomThree.getDescription());
    	System.out.println("4. " +roomFour.getName() + ": " + roomFour.getDescription());
    }
}
