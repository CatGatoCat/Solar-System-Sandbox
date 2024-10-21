import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:/Users/nicol/VSCode/SE300/trial_system.csv"; // Set your CSV file path here
        CSVReader reader = new CSVReader();
        List<SolarSystem> solarSystems = reader.readCSV(filePath);

        // Output all solar systems
        for (SolarSystem solarSystem : solarSystems) {
            System.out.println(solarSystem);
        }
    }
}
