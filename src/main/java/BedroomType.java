public enum BedroomType {
    SINGLE(1, "Single", 44.99),
    DOUBLE(2, "Double", 79.99),
    TWIN(2, "Twin", 84.99),
    FAMILY(4, "Family", 149.99);

    private int capacity;
    private String displayName;
    private double nightlyRoomRate;

    BedroomType(int value, String displayName, double nightlyRoomRate){
        this.capacity = value;
        this.displayName = displayName;
        this.nightlyRoomRate = nightlyRoomRate;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public int getBedroomCapacity() {
        return this.capacity;
    }

    public double getBedroomNightlyRate() {
        return this.nightlyRoomRate;
    }
}
