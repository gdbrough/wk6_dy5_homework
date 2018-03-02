import java.util.ArrayList;

public class Hotel {

    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private DiningRoom diningRoom;

    public Hotel(DiningRoom diningRoom) {
        this.bedrooms = new ArrayList<>();
        this.conferenceRooms = new ArrayList<>();
        this.diningRoom = diningRoom;
    }

    public void addBedroom(Bedroom bedroom){
        this.bedrooms.add(bedroom);
    }

    public int getNumberOfBedrooms(){
        return this.bedrooms.size();
    }
}
