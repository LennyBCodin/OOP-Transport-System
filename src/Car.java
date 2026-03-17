public class Car extends Vehicle {
    protected double baseRate = 2.0;

    public Car(String licensePlate, String driverName) {
        super(licensePlate, driverName);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * baseRate;
    }

    @Override
    public void updateLocation(String newLocation) {
        System.out.println("Car " + licensePlate + " updated GPS to: " + newLocation);
    }
}