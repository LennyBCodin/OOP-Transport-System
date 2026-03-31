import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        FleetManager manager = new FleetManager();
        manager.loadFleet();

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Welcome to Taxify Registration ===");

        try {
            System.out.print("Enter Passenger Name: ");
            String pName = scanner.nextLine();

            System.out.print("Enter Passenger ID: ");
            String pId = scanner.nextLine();

            System.out.print("Enter Initial Wallet Balance: ");
            double pBalance = scanner.nextDouble();
            scanner.nextLine();

            Passenger p1 = new Passenger(pName, pId, pBalance);

            System.out.println("\nSelect Vehicle Type (1: Standard Car, 2: Electric Car): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            Vehicle selectedVehicle;

            if (choice == 1) {
                selectedVehicle = new Car("TX-STD-01", "John Driver");
            } else if (choice == 2) {
                selectedVehicle = new ElectricCar("TX-ECO-99", "Sarah Green", 95);
            } else {
                throw new Exception("Invalid vehicle choice selected.");
            }
            manager.addVehicle(selectedVehicle);

            System.out.print("\nEnter distance for your trip (in km): ");
            double distance = scanner.nextDouble();

            double fare = selectedVehicle.calculateFare(distance);
            System.out.println("\nTrip Summary:");
            System.out.println("Driver: " + selectedVehicle.driverName);
            System.out.println("Calculated Fare: $" + String.format("%.2f", fare));

            System.out.println("\nAttempting to process payment...");
            p1.processPayment(fare);
            System.out.println("\n--- Current Registered Fleet ---");
            manager.displayFleet();

        } catch (InputMismatchException e) {
            System.err.println("CRITICAL ERROR: Invalid input format.");
        } catch (ArithmeticException e) {
            System.err.println("PAYMENT ERROR: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("SYSTEM ERROR: " + e.getMessage());
        } finally {
            manager.saveFleet();
            System.out.println("\n--- Data Saved & Closing Taxify Connection ---");
            scanner.close();
        }
    }
}
