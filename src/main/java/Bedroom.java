import java.util.ArrayList;

public class Bedroom extends Room {

    private BedroomType bedroomType;

    public Bedroom(String roomName, int capacity, ArrayList<Guest> occupants, BedroomType bedroomType) {
        super(roomName, bedroomType.getBedroomCapacity(), occupants);
        this.bedroomType = bedroomType;
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
}
