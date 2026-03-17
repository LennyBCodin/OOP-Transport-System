public class ElectricCar extends Car {
    private int batteryLevel;

    public ElectricCar(String licensePlate, String driverName, int batteryLevel) {
        super(licensePlate, driverName);
        this.batteryLevel = batteryLevel;
    }

    @Override
    public double calculateFare(double distance) {
        // Method Overriding: Uses parent's baseRate but applies a 'Green' discount
        double standardFare = super.calculateFare(distance);
        return standardFare * 0.9; // 10% discount for electric
    }
    
    public void checkBattery() {
        System.out.println("Current Battery: " + batteryLevel + "%");
    }
}