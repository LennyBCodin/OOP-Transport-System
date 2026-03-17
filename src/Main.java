public class Main {
    public static void main(String[] args) {
        // 1. Object Creation
        Passenger p1 = new Passenger("Sarah Miller", "USR-55", 30.0);
        Car standardCar = new Car("TX-100", "Robert");
        ElectricCar ecoCar = new ElectricCar("ECO-500", "Elena", 92);

        System.out.println("--- TAXIFY SYSTEM INITIALIZED ---");
        p1.showDashboard();

        try {
            // 2. Demonstrating Inheritance & Overriding
            double tripDistance = 12.5;
            double fare1 = standardCar.calculateFare(tripDistance);
            double fare2 = ecoCar.calculateFare(tripDistance);

            System.out.println("Standard Car Fare: $" + fare1);
            System.out.println("Electric Car Fare: $" + fare2);

            // 3. Demonstrating Interfaces
            ecoCar.updateLocation("Central Station");

            // 4. Demonstrating Exception Handling
            System.out.println("\nAttempting to pay for trip ($" + fare1 + ")...");
            p1.processPayment(fare1);

            System.out.println("\nAttempting an expensive trip...");
            p1.processPayment(200.0); // This will trigger the catch block

        } catch (ArithmeticException e) {
            System.err.println("ALERT: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unknown error occurred: " + e.getMessage());
        } finally {
            System.out.println("\n--- Session Ended ---");
        }
    }
}