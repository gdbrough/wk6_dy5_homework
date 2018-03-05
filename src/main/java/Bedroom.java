import java.util.ArrayList;

public class Bedroom extends Room {

    private BedroomType bedroomType;
    private Bedroom bedroom;
    private int nights;

    public Bedroom(String roomName, int capacity, ArrayList<Guest> occupants, BedroomType bedroomType, int nights) {
        super(roomName, capacity, occupants);
        this.bedroomType = bedroomType;
        this.nights = nights;
    }

    public String getBedroomType() {
        return this.bedroomType.getDisplayName();
    }

    public int getBedroomCapacity(){
        return this.bedroomType.getBedroomCapacity();
    }

    public double getBedroomNightlyRate(){
        return this.bedroomType.getBedroomNightlyRate();
    }

    public int getNights() {
        return this.nights;
    }

    public double getTotalCost(){
        return (getBedroomNightlyRate() * getNights());
    }

}
