import java.util.ArrayList;

public class Hotel {

    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private DiningRoom diningRoom;
    private Bedroom bedroom;
    private Guest guest;
    private BedroomType bedroomType;

    public Hotel(DiningRoom diningRoom) {
        this.bedrooms = new ArrayList<>();
        this.conferenceRooms = new ArrayList<>();
        this.diningRoom = diningRoom;
//        this.bedroomType = bedroomType;
        this.bedroom = bedroom;
        this.guest = guest;
    }

    public int getNumberOfBedrooms(){
        return this.bedrooms.size();
    }

    public void addBedroom(Bedroom bedroom){
        this.bedrooms.add(bedroom);
    }

    public String findAllUnOccupiedBedrooms(){
        String emptyRooms = "";
        for(Bedroom bedroom : this.bedrooms){
//            System.out.println("Room Name: " + bedroom.getRoomName());
//            System.out.println("Room Type: " + bedroom.getBedroomType());
//            System.out.println("Capacity: " + bedroom.getBedroomCapacity());
//            System.out.println("Guests: " + bedroom.getNumberOfOccupants());
            if (bedroom.getNumberOfOccupants() == 0) {
                emptyRooms += (bedroom.getRoomName() + ". ");
            }
        }
        return emptyRooms;
    }

    public int findFirstUnOccupiedBedroom(String type){
        int emptyRoomIndex = -1;
        for (int index = 0; index < getNumberOfBedrooms(); index++){
            if (bedrooms.get(index).getBedroomType() == type && bedrooms.get(index).getNumberOfOccupants() == 0) {
                emptyRoomIndex = index;
                break;
            }
        }
        return emptyRoomIndex;
    }

    public String checkInToSingleRoom(String guestName){
        guest = new Guest(guestName);
        int availableRoom = findFirstUnOccupiedBedroom("Single");
        if ((availableRoom + 1) > 0) {
            bedrooms.get(availableRoom).addOccupant(guest);
            return guest.getName() + " checked in to " + bedrooms.get(availableRoom).getRoomName() + ".";
        } else {
            return guest.getName() + " not checked in. No room available.";
        }
    }

    public String checkInToDoubleOrTwinRoom(String roomType, String guestNameOne, String guestNameTwo){
        guest = new Guest(guestNameOne);
        Guest guest2 = new Guest(guestNameTwo);
        int availableRoom = findFirstUnOccupiedBedroom(roomType);
        if ((availableRoom + 1) > 0) {
            bedrooms.get(availableRoom).addOccupant(guest);
            bedrooms.get(availableRoom).addOccupant(guest2);
            return guest.getName() + " and " + guest2.getName() + " checked in to " + bedrooms.get(availableRoom).getRoomName() + ".";
        } else {
            return guest.getName() + " and " + guest2.getName() + " not checked in. No room available.";
        }
    }

    public String checkInToFamilyRoom(String guestNameOne, String guestNameTwo, String guestNameThree, String guestNameFour){
        guest = new Guest(guestNameOne);
        Guest guest2 = new Guest(guestNameTwo);
        Guest guest3 = new Guest(guestNameThree);
        Guest guest4 = new Guest(guestNameFour);
        int availableRoom = findFirstUnOccupiedBedroom("Family");
        if ((availableRoom + 1) > 0) {
            bedrooms.get(availableRoom).addOccupant(guest);
            bedrooms.get(availableRoom).addOccupant(guest2);
            bedrooms.get(availableRoom).addOccupant(guest3);
            bedrooms.get(availableRoom).addOccupant(guest4);
            return guest.getName() + ", " + guest2.getName() + ", " + guest3.getName() + " and " + guest4.getName() + " checked in to " + bedrooms.get(availableRoom).getRoomName() + ".";
        } else {
            return guest.getName() + ", " + guest2.getName() + ", " + guest3.getName() + " and " + guest4.getName() + " not checked in. No room available.";
        }
    }

    public String getNamesOfBedroomOccupants(String roomName){
        String occupants = "";
        for (int index = 0; index < getNumberOfBedrooms(); index++){
            if (bedrooms.get(index).getRoomName() == roomName) {
                occupants = bedrooms.get(index).getNamesOfOccupants();
                break;
            }
        }
        return occupants;
    }

    public void checkOutGuestFromBedroom(String roomName){
        for (int index = 0; index < getNumberOfBedrooms(); index++){
            if (bedrooms.get(index).getRoomName() == roomName) {
                bedrooms.get(index).checkOutOccupants();
            }
        }
    }

    public int getNumberOfConferenceRooms(){
        return this.conferenceRooms.size();
    }

    public void addConferenceRoom(ConferenceRoom conferenceRooms){
        this.conferenceRooms.add(conferenceRooms);
    }

}
