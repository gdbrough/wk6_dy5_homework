import java.util.ArrayList;

public abstract class Room {

    private String roomName;
    private int capacity;
    private ArrayList<Guest> occupants;

    public Room(String roomName, int capacity, ArrayList<Guest> occupants) {
        this.roomName = roomName;
        this.capacity = capacity;
        this.occupants = occupants;
    }

    public String getRoomName() {
        return roomName;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getNumberOfOccupants(){
        return this.occupants.size();
    }

    public void addOccupant(Guest guest){
        this.occupants.add(guest);
    }

    public void removeOccupant(Guest guest){
        this.occupants.remove(guest);
    }

    public String getNamesOfOccupants(){
        String guestName = "";
        for (int index = 0; index < getNumberOfOccupants(); index++){
            guestName += this.occupants.get(index).getName() + ". ";
        }
        return guestName;
    }
}
