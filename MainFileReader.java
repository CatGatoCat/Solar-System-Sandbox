import java.util.List;

public class MainFileReader {
    public static void main(String[] args) {
        String filePath = "C:/Users/nicol/VSCode/SE300/trial_system.csv"; // Set your CSV file path here
        CSVReaderFileReader reader = new CSVReaderFileReader();
        List<SolarSystemFileReader> solarSystems = reader.readCSV(filePath);

        // Output all solar systems
        for (SolarSystemFileReader solarSystem : solarSystems) {
            System.out.println(solarSystem);
        }
    }
}
