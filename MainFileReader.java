/*
	Filename: MainFileReader
	Author: Nicole Motta
    Collaborators: Laurel Grein, Rylee Grover, Kyrylo Holovenko
	Date created: 10/20/2024
	Date modified: 11/2/2024
	Purpose: Allows the simulation to run with a csv file input.
	
	Attributes:
	
	Methods:    
    +main(String[]): void
    
*/


import java.util.List;

public class MainFileReader {
    public static void main(String[] args) {
        String filePath = "C:/Users/nicol/Documents/GitHub/Solar-System-Sandbox/trial_system.csv"; // Set your CSV file path here
        CSVFileReader reader = new CSVFileReader();
        List<SolarSystem> solarSystems = reader.readCSV(filePath);
        //List<SolarSystem> Planets = reader.readCSV(filePath);

        // Output all solar systems
        for (SolarSystem solarSystem : solarSystems) {
            
            System.out.println(solarSystem);
           //f System.out.println(Planets);
           

        }

    }
}

