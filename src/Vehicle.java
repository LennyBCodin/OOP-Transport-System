public abstract class Vehicle implements Locatable {
    protected String licensePlate;
    protected String driverName;

    public Vehicle(String licensePlate, String driverName) {
        this.licensePlate = licensePlate;
        this.driverName = driverName;
    }
    public String getLicensePlate() {
        return licensePlate;
    }

    public String getDriverName() {
        return driverName;
    }

    public abstract double calculateFare(double distance);
}
