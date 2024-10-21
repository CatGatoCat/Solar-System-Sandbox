import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderFileReader {
    
    public List<SolarSystemFileReader> readCSV(String filePath) {
        List<SolarSystemFileReader> solarSystems = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String name = "";
            double centerMass = 0;
            int centerRadius = 0;
            List<PlanetFileReader> planets = new ArrayList<>();
            
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                
                // Handle different sections based on keywords in the CSV
                if (data[0].contains("Solar System Name")) {
                    if (!name.isEmpty()) {
                        // Add the previous solar system to the list before starting the new one
                        solarSystems.add(new SolarSystemFileReader(name, centerMass, centerRadius, planets));
                        planets = new ArrayList<>();
                    }
                    name = data[1];
                } else if (data[0].contains("Mass of center object")) {
                    centerMass = Double.parseDouble(data[1]);
                } else if (data[0].contains("Radius of center object")) {
                    centerRadius = Integer.parseInt(data[1]);
                } else if (data[0].contains("Mass of planet")) {
                    double planetMass = Double.parseDouble(data[1]);
                    line = br.readLine();  // Read the next line for radius
                    String[] radiusData = line.split(",");
                    String planetRadius = radiusData[1];
                    planets.add(new PlanetFileReader(planetMass, planetRadius));
                }
            }
            
            // Add the last solar system after the loop ends
            if (!name.isEmpty()) {
                solarSystems.add(new SolarSystemFileReader(name, centerMass, centerRadius, planets));
            }
        } catch (IOException e) {
            //e.printStackTrace();
        }
        
        return solarSystems;
    }
}
