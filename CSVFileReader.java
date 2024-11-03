/*
	Filename: CSVFileReader
	Author: Nicole Motta
    Collaborators: Laurel Grein, Rylee Grover, Kyrylo Holovenko
	Date created: 10/24/2024
	Date modified: 11/2/2024
	Purpose: Reads the csv file chosen by the user.
	
	Attributes:
	
	Methods:
	+readCSV(String): List<SolarSystem>
	
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CSVFileReader {
    
    public List<SolarSystem> readCSV(String filePath) {
        List<SolarSystem> solarSystems = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String name = "";
            List<Double> centralMasses = new ArrayList<>();
            List<Double> centralRadii = new ArrayList<>();
            List<Planet> planets = new ArrayList<>();
            
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                
                // Handle different sections based on keywords in the CSV
                if (data[0].contains("Solar System Name")) {
                    if (!name.isEmpty()) {
                        // Add the previous solar system to the list before starting the new one
                        solarSystems.add(new SolarSystem(name, centralMasses, centralRadii, planets));
                        planets = new ArrayList<>();
                    }
                    name = data[1];
                } else if (data[0].contains("Mass of center object")) {
                    centralMasses.add(Double.parseDouble(data[1]));
                } else if (data[0].contains("Radius of center object")) {
                    centralRadii.add(Double.parseDouble(data[1]));
                } else if (data[0].contains("Mass of planet")) {
                    double planetMass = Double.parseDouble(data[1]);
                    line = br.readLine();  // Read the next line for radius
                    String[] radiusData = line.split(",");
                    double planetRadius = Double.parseDouble(radiusData[1]);

                    line = br.readLine();
                    String[] distanceData = line.split(",");
                    double planetDistance = Double.parseDouble(distanceData[1]);

                    planets.add(new Planet(data[1], planetMass, planetRadius, planetDistance));
                }
            }

            
            // Add the last solar system after the loop ends
            if (!name.isEmpty()) {
                solarSystems.add(new SolarSystem(name, centralMasses, centralRadii, planets));
            }
        } catch (IOException e) {
            //e.printStackTrace();
        }
        
        return solarSystems;
    }
}
