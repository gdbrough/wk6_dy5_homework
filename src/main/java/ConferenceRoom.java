import java.util.ArrayList;

public class ConferenceRoom extends Room {

    private ConferenceRoomType conferenceRoomType;

    public ConferenceRoom(String roomName, int capacity, ArrayList<Guest> occupants, ConferenceRoomType conferenceRoomType) {
        super(roomName, conferenceRoomType.getConferenceRoomCapacity(), occupants);
        this.conferenceRoomType = conferenceRoomType;
    }

    public int getConferenceRoomCapacity(){
        return this.conferenceRoomType.getConferenceRoomCapacity();
    }

    public double getConferenceRoomHourlyRate(){
        return this.conferenceRoomType.getConferenceRoomHourlyRate();
    }

    public String getConferenceRoomEquipment() {
        return this.conferenceRoomType.getConferenceRoomEquipment();
    }

}
