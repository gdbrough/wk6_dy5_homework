import java.util.ArrayList;

public class Hotel {

    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private DiningRoom diningRoom;
    private Guest guest;

    public Hotel(DiningRoom diningRoom) {
        this.bedrooms = new ArrayList<>();
        this.conferenceRooms = new ArrayList<>();
        this.diningRoom = diningRoom;
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

    public String checkInToSingleRoom(int nights, String guestName){
        guest = new Guest(guestName);
        int availableRoom = findFirstUnOccupiedBedroom("Single");
        if ((availableRoom + 1) > 0) {
            bedrooms.get(availableRoom).addOccupant(guest);
            double totalCost = bedrooms.get(availableRoom).getBedroomNightlyRate() * nights;
//            return String.format("%s checked in to %s at £%.2f per night for %d nights. Total cost: £%.2f", guest.getName(), bedrooms.get(availableRoom).getRoomName(), bedrooms.get(availableRoom).getBedroomNightlyRate(), bedrooms.get(availableRoom).getNights(), bedrooms.get(availableRoom).getTotalCost());
            return guest.getName() + " checked in to " + bedrooms.get(availableRoom).getRoomName() + " at £" + bedrooms.get(availableRoom).getBedroomNightlyRate() + " per night for " + nights + " nights. Total cost: £" + Math.round(totalCost *100) / 100.0;
        } else {
            return guest.getName() + " not checked in. No room available.";
        }
    }

    public String checkInToDoubleOrTwinRoom(String roomType, int nights, String guestNameOne, String guestNameTwo){
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

    public String checkInToFamilyRoom(int nights, String guestNameOne, String guestNameTwo, String guestNameThree, String guestNameFour){
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
