import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    private Hotel hotel;
    private Bedroom bedroom;
    private ArrayList<Bedroom> bedrooms;
    private ConferenceRoom conferenceRooms;
    private DiningRoom diningRoom;
    private Guest guest;

    @Before
    public void before(){
        bedrooms = new ArrayList<>();
        diningRoom = new DiningRoom("Dining Room", 200, new ArrayList<>());
        hotel = new Hotel(diningRoom);
        hotel.addBedroom(new Bedroom("Bedroom One", 2, new ArrayList<>(), BedroomType.DOUBLE));
        hotel.addBedroom(new Bedroom("Bedroom Two", 2, new ArrayList<>(), BedroomType.DOUBLE));
        hotel.addBedroom(new Bedroom("Bedroom Three", 2, new ArrayList<>(), BedroomType.TWIN));
        hotel.addBedroom(new Bedroom("Bedroom Four", 1, new ArrayList<>(), BedroomType.SINGLE));
        hotel.addBedroom(new Bedroom("Bedroom Five", 4, new ArrayList<>(), BedroomType.FAMILY));
        hotel.addConferenceRoom(new ConferenceRoom("Conference Room One", 20, new ArrayList<>(), ConferenceRoomType.SMALL));
        hotel.addConferenceRoom(new ConferenceRoom("Conference Room Two", 50, new ArrayList<>(), ConferenceRoomType.MEDIUM));
        hotel.addConferenceRoom(new ConferenceRoom("Conference Room Three", 100, new ArrayList<>(), ConferenceRoomType.LARGE));
    }

    @Test
    public void hotelStartsWithFiveRooms(){
        assertEquals(5, hotel.getNumberOfBedrooms());
    }

    @Test
    public void hotelStartsWithThreeConferenceRooms(){
        assertEquals(3, hotel.getNumberOfConferenceRooms());
    }

    @Test
    public void canFindEmptyBedroom__Double(){
        assertEquals(0, hotel.findFirstUnOccupiedBedroom("Double"));
    }

    @Test
    public void canFindEmptyBedroom__Twin(){
        assertEquals(2, hotel.findFirstUnOccupiedBedroom("Twin"));
    }

    @Test
    public void canFindEmptyBedroom__Single(){
        assertEquals(3, hotel.findFirstUnOccupiedBedroom("Single"));
    }

    @Test
    public void canFindEmptyBedroom__Family(){
        assertEquals(4, hotel.findFirstUnOccupiedBedroom("Family"));
    }

    @Test
    public void canFindEmptyBedroom__All(){
        assertEquals("Bedroom One. Bedroom Two. Bedroom Three. Bedroom Four. Bedroom Five. ", hotel.findAllUnOccupiedBedrooms());
    }

    @Test
    public void canCheckGuestInToSingleRoom__Vacancy(){
        assertEquals("Single Guest checked in to Bedroom Four at £44.99 per night for 5 nights. Total cost: £224.95", hotel.checkInToSingleRoom(5, "Single Guest"));
    }

    @Test
    public void canCheckGuestInToSingleRoom__NoVacancy(){
        hotel.checkInToSingleRoom(1, "Successful Guest");
        assertEquals("Unsuccessful Guest not checked in. No room available.", hotel.checkInToSingleRoom(1, "Unsuccessful Guest"));
    }

    @Test
    public void canCheckGuestInToDoubleRoom__Vacancy(){
        assertEquals("First Guest and Second Guest checked in to Bedroom One.", hotel.checkInToDoubleOrTwinRoom("Double", 2, "First Guest", "Second Guest"));
    }

    @Test
    public void canCheckGuestInToDoubleRoom__RoomOneOccupied(){
        hotel.checkInToDoubleOrTwinRoom("Double", 3, "First Guest", "Second Guest");
        assertEquals("Third Guest and Fourth Guest checked in to Bedroom Two.", hotel.checkInToDoubleOrTwinRoom("Double", 2, "Third Guest", "Fourth Guest"));
    }

    @Test
    public void canCheckGuestInToDoubleRoom__NoVacancy(){
        hotel.checkInToDoubleOrTwinRoom("Double", 1, "First Guest", "Second Guest");
        hotel.checkInToDoubleOrTwinRoom("Double", 1, "Third Guest", "Fourth Guest");
        assertEquals("Fifth Guest and Sixth Guest not checked in. No room available.", hotel.checkInToDoubleOrTwinRoom("Double", 2, "Fifth Guest", "Sixth Guest"));
    }

    @Test
    public void canCheckGuestInToTwinRoom__Vacancy(){
        assertEquals("First Guest and Second Guest checked in to Bedroom Three.", hotel.checkInToDoubleOrTwinRoom("Twin", 7, "First Guest", "Second Guest"));
    }

    @Test
    public void canCheckGuestInToFamilyRoom__Vacancy(){
        assertEquals("First Guest, Second Guest, Third Guest and Fourth Guest checked in to Bedroom Five.", hotel.checkInToFamilyRoom(14, "First Guest", "Second Guest", "Third Guest", "Fourth Guest"));
    }

    @Test
    public void canGetGuestNamesFromBedroom(){
        hotel.checkInToDoubleOrTwinRoom("Double", 1, "First Guest", "Second Guest");
        hotel.checkInToDoubleOrTwinRoom("Double", 1, "Third Guest", "Fourth Guest");
        assertEquals("Third Guest. Fourth Guest. ", hotel.getNamesOfBedroomOccupants("Bedroom Two"));
    }

    @Test
    public void canCheckOutGuestFromBedroom(){
        hotel.checkInToDoubleOrTwinRoom("Double", 1, "First Guest", "Second Guest");
        assertEquals("Bedroom Two. Bedroom Three. Bedroom Four. Bedroom Five. ", hotel.findAllUnOccupiedBedrooms());
        hotel.checkOutGuestFromBedroom("Bedroom One");
        assertEquals("Bedroom One. Bedroom Two. Bedroom Three. Bedroom Four. Bedroom Five. ", hotel.findAllUnOccupiedBedrooms());
    }

}
