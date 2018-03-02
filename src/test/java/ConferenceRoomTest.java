import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    private ConferenceRoom conferenceRoom;
    private Guest guest;

    @Before
    public void before(){
        conferenceRoom = new ConferenceRoom("Conference Room One", 20, new ArrayList<>(), ConferenceRoomType.SMALL);
    }

    @Test
    public void canGetRoomName() {
        assertEquals("Conference Room One", conferenceRoom.getRoomName());
    }

    @Test
    public void canGetRoomCapacity(){
        assertEquals(20, conferenceRoom.getCapacity());
    }

    @Test
    public void canGetConferenceRoomCapacity(){
        assertEquals(20, conferenceRoom.getConferenceRoomCapacity());
    }

    @Test
    public void canGetConferenceRoomHourlyRate(){
        assertEquals(99.99, conferenceRoom.getConferenceRoomHourlyRate(), 0.01);
    }

    @Test
    public void canGetConferenceRoomEquipment(){
        assertEquals("Large Screen TV", conferenceRoom.getConferenceRoomEquipment());
    }

    @Test
    public void roomStartEmpty(){
        assertEquals(0,conferenceRoom.getNumberOfOccupants());
    }

    @Test
    public void canAddOccupant(){
        guest = new Guest("Conference Room Add");
        conferenceRoom.addOccupant(guest);
        assertEquals(1, conferenceRoom.getNumberOfOccupants());
    }

    @Test
    public void canRemoveOccupant(){
        guest = new Guest("Conference Room Remove");
        conferenceRoom.addOccupant(guest);
        conferenceRoom.removeOccupant(guest);
        assertEquals(0, conferenceRoom.getNumberOfOccupants());
    }
}
