public enum ConferenceRoomType {
    SMALL(20, "Large Screen TV", 99.99),
    MEDIUM(50, "MultiMedia", 149.99),
    LARGE(100, "Stage", 199.99);

    private int capacity;
    private String equipment;
    private double hourlyRoomRate;

    ConferenceRoomType(int value, String equipment, double hourlyRoomRate){
        this.capacity = value;
        this.equipment = equipment;
        this.hourlyRoomRate = hourlyRoomRate;
    }

    public String getConferenceRoomEquipment() {
        return this.equipment;
    }

    public int getConferenceRoomCapacity() {
        return this.capacity;
    }

    public double getConferenceRoomHourlyRate() {
        return this.hourlyRoomRate;
    }
}
