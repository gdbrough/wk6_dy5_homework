import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    private Bedroom bedroom;
    private Guest guest;

    @Before
    public void before(){
        bedroom = new Bedroom("Bedroom One", 2, new ArrayList<>(), BedroomType.DOUBLE);
    }

    @Test
    public void canGetRoomName() {
        assertEquals("Bedroom One", bedroom.getRoomName());
    }

    @Test
    public void canGetRoomCapacity(){
        assertEquals(2, bedroom.getCapacity());
    }

    @Test
    public void canGetBedroomCapacity(){
        assertEquals(2, bedroom.getBedroomCapacity());
    }

    @Test
    public void roomStartEmpty(){
        assertEquals(0,bedroom.getNumberOfOccupants());
    }

    @Test
    public void canAddOccupant(){
        guest = new Guest("Bedroom Add");
        bedroom.addOccupant(guest);
        assertEquals(1, bedroom.getNumberOfOccupants());
    }

    @Test
    public void canRemoveOccupant(){
        guest = new Guest("Bedroom Remove");
        bedroom.addOccupant(guest);
        bedroom.removeOccupant(guest);
        assertEquals(0, bedroom.getNumberOfOccupants());
    }

    @Test
    public void canGetBedroomType(){
        assertEquals("Double", bedroom.getBedroomType());
    }

    @Test
    public void canGetBedroomNightlyRate(){
        assertEquals(79.99, bedroom.getBedroomNightlyRate(), 0.01);
    }

}
