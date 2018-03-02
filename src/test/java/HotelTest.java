import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    private Hotel hotel;
    private Bedroom bedroom;
    private ConferenceRoom conferenceRoom;
    private DiningRoom diningRoom;

    @Before
    public void before(){

//        hotel = new Hotel(diningRoom);
        diningRoom = new DiningRoom("Dining Room", 200, new ArrayList<>());
        bedroom = new Bedroom("Bedroom One", bedroom.getBedroomCapacity(), new ArrayList<>(), BedroomType.DOUBLE);
//        bedroom2 = new Bedroom("Bedroom Two", 2, new ArrayList<>(), BedroomType.DOUBLE);
//        bedroom3 = new Bedroom("Bedroom Three", 2, new ArrayList<>(), BedroomType.TWIN);
//        bedroom4 = new Bedroom("Bedroom Four", 2, new ArrayList<>(), BedroomType.SINGLE);
//        bedroom5 = new Bedroom("Bedroom Five", 2, new ArrayList<>(), BedroomType.FAMILY);
        conferenceRoom = new ConferenceRoom("Conference Room One", 20, new ArrayList<>(), ConferenceRoomType.SMALL);
        hotel = new Hotel(diningRoom);
    }

    @Test
    public void hotelStartsWithNoRooms(){
        assertEquals(0, hotel.getNumberOfBedrooms());
    }

}
