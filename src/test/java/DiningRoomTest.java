import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {

    DiningRoom diningRoom;
    Guest guest;

    @Before
    public void before(){
        diningRoom = new DiningRoom("Dining Room", 200, new ArrayList<>());
    }

    @Test
    public void canGetRoomName() {
        assertEquals("Dining Room", diningRoom.getRoomName());
    }

    @Test
    public void canGetRoomCapacity(){
        assertEquals(200, diningRoom.getCapacity());
    }

    @Test
    public void roomStartEmpty(){
        assertEquals(0,diningRoom.getNumberOfOccupants());
    }

    @Test
    public void canAddOccupant(){
        guest = new Guest("Add to Dining Room");
        diningRoom.addOccupant(guest);
        assertEquals(1, diningRoom.getNumberOfOccupants());
    }

    @Test
    public void canRemoveOccupant(){
        guest = new Guest("Remove from Dining Room");
        diningRoom.addOccupant(guest);
        diningRoom.removeOccupant(guest);
        assertEquals(0, diningRoom.getNumberOfOccupants());

    }

}
