import java.io.*;
import java.util.ArrayList;

public class FleetManager {
    private ArrayList<Vehicle> fleet = new ArrayList<>();
    private final String FILE_NAME = "fleet_data.txt";
    public void addVehicle(Vehicle v) {
        fleet.add(v);
    }
    public void saveFleet() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Vehicle v : fleet);
                writer.write(v.getClass().getSimpleName() + "," + v.getModel() + "," + v.getLicensePlate());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving: " + e.getMessage());
        }
    }
    public void loadFleet() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals("Truck")) fleet.add(new Truck(data[1], data[2]));
                else if (data[0].equals("Bus")) fleet.add(new Bus(data[1], data[2]));
            }
        } catch (IOException e) {
            System.out.println("Error loading: " + e.getMessage());
        }
    }

    public void displayFleet() {
        for (Vehicle v : fleet) {
            System.out.println(v); 
        }
    }
}
