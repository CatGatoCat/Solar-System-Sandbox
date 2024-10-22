import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainInput {
    public static void main(String[] args) {
        // Req 4.1: Ask for Solar System model name
        try (Scanner scanner = new Scanner(System.in)) {
            // Req 4.1: Ask for Solar System model name
            System.out.print("Enter the Solar System model name: ");
            String solarSystemName = scanner.nextLine();
            
           // System.out.println("How many central objects (stars) do you want? (1 or 2): ");
           int centralObjects = getValidIntegerInput(scanner, "How many central objects (stars) do you want? (1 or 2): ", 1, 2);

            //int centralObjects;
           // do {
                //centralObjects = scanner.nextInt();
               // centralObjects = getValidIntegerInput(scanner, "How many central objects (stars) do you want? (1 or 2): ", 1, 2);

          //  } while (centralObjects != 1 && centralObjects != 2);

            // Req 4.2.1: Input mass and radius for the central object(s)
            List<Double> centralMasses = new ArrayList<>();
            List<Double> centralRadii = new ArrayList<>();

            for (int i = 1; i <= centralObjects; i++) {
                double mass = getValidDoubleInput(scanner, "Enter mass of central object " + i + ": ");
               // System.out.print("Enter mass of central object " + i + ": ");
                //double mass = scanner.nextDouble();
                centralMasses.add(mass);

                double radius = getValidDoubleInput(scanner, "Enter radius of central object " + i + ": ");
                //System.out.print("Enter radius of central object " + i + ": ");
                //double radius = scanner.nextDouble();  // Allows input like "6,378" with commas
                centralRadii.add(radius);
            }
            
            // Req 4.3: Ask for the number of planets
           // System.out.print("Enter the number of planets: ");
            int numberOfPlanets = getValidIntegerInput(scanner, "Enter the number of planets: ", 0, Integer.MAX_VALUE);

           // int numberOfPlanets = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            // Req 4.4: Input details for each planet
            List<PlanetInput> planets = new ArrayList<>();
            for (int i = 0; i < numberOfPlanets; i++) {
                System.out.print("Enter name of planet " + (i + 1) + ": ");
                String planetName = scanner.nextLine();
               // scanner.nextLine();

                
               /* System.out.print("Enter mass of " + planetName + ": ");
                double planetMass = scanner.nextDouble();
                
                System.out.print("Enter radius of " + planetName + ": ");
                String planetRadius = scanner.next();  // Allows input like "6,378" with commas
                
                System.out.print("Enter distance of " + planetName + " from central object: ");
                double planetDistance = scanner.nextDouble();*/
                double planetMass = getValidDoubleInput(scanner, "Enter mass of " + planetName + ": ");
                double planetRadius = getValidDoubleInput(scanner, "Enter radius of " + planetName + ": ");
                double planetDistance = getValidDoubleInput(scanner, "Enter distance of " + planetName + " from central object: ");


                scanner.nextLine();  // Consume newline
                
                planets.add(new PlanetInput(planetName, planetMass, planetRadius, planetDistance));
            }
            
            // Create SolarSystem object
            SolarSystemInput solarSystem = new SolarSystemInput(solarSystemName, centralMasses, centralRadii, planets);
            
            // Req 4.5: Save input data to a file and store in array
            saveSolarSystemInputToFile(solarSystem);


        }
    }

    // Save data to file
    public static void saveSolarSystemInputToFile(SolarSystemInput solarSystem) {
        String fileName = solarSystem.getName() + ".csv"; // Save data to a .txt file

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Solar System: " + solarSystem.getName() + "\n");
            writer.write("Central Objects:\n");

            List<Double> centralMasses = solarSystem.getCentralMasses();
            List<Double> centralRadii = solarSystem.getCentralRadii();
            for (int i = 0; i < centralMasses.size(); i++) {
                writer.write("Central Object " + (i + 1) + ": \n");
                writer.write("Mass: " + centralMasses.get(i) + "\n");
                writer.write("Radius: " + centralRadii.get(i) + "\n");
            }
           
           
            writer.write("Planets:\n");

            for (PlanetInput planet : solarSystem.getPlanets()) {
                writer.write("Planet Name: " + planet.getName() + "\n");
                writer.write("Mass: " + planet.getMass() + "\n");
                writer.write("Radius: " + planet.getRadius() + "\n");
                writer.write("Distance from central object: " + planet.getDistance() + "\n");
            }
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file: " + e.getMessage());
        }
    }

    // Method to get a valid integer input from the user
    public static int getValidIntegerInput(Scanner scanner, String prompt, int min, int max) {
        int input = -1;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print(prompt);
                input = scanner.nextInt();

                if (input >= min && input <= max) {
                    isValid = true;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();  // Clear the invalid input from the scanner
            }
        }

        return input;
    }

    // Method to get a valid double input from the user
    public static double getValidDoubleInput(Scanner scanner, String prompt) {
        double input = -1;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print(prompt);
                input = scanner.nextDouble();
                isValid = true;  // If no exception occurs, the input is valid
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid decimal number.");
                scanner.next();  // Clear the invalid input from the scanner
            }
        }

        return input;
    }


}
