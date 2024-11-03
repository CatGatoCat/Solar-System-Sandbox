/*import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Choose an option:");
            System.out.println("1. Input new Solar System data and save to file");
            System.out.println("2. Load and display Solar System data from CSV file");
            int choice = getValidIntegerInput(scanner, "Enter choice (1 or 2): ", 1, 2);

            if (choice == 1) {
                inputAndSaveSolarSystem(scanner);
            } else if (choice == 2) {
                loadAndDisplaySolarSystem();
            }
        }
    }

    // Method for inputting and saving solar system data
    public static void inputAndSaveSolarSystem(Scanner scanner) {
        System.out.print("Enter the Solar System model name: ");
        String solarSystemName = scanner.nextLine();

        int centralObjects = getValidIntegerInput(scanner, "How many central objects (stars) do you want? (1 or 2): ", 1, 2);

        List<Double> centralMasses = new ArrayList<>();
        List<Double> centralRadii = new ArrayList<>();
        for (int i = 1; i <= centralObjects; i++) {
            double mass = getValidDoubleInput(scanner, "Enter mass of central object " + i + ": ");
            centralMasses.add(mass);

            double radius = getValidDoubleInput(scanner, "Enter radius of central object " + i + ": ");
            centralRadii.add(radius);
        }

        int numberOfPlanets = getValidIntegerInput(scanner, "Enter the number of planets: ", 0, Integer.MAX_VALUE);

        List<Planet> planets = new ArrayList<>();
        for (int i = 0; i < numberOfPlanets; i++) {
            System.out.print("Enter name of planet " + (i + 1) + ": ");
            String planetName = scanner.nextLine();

            double planetMass = getValidDoubleInput(scanner, "Enter mass of " + planetName + ": ");
            double planetRadius = getValidDoubleInput(scanner, "Enter radius of " + planetName + ": ");
            double planetDistance = getValidDoubleInput(scanner, "Enter distance of " + planetName + " from central object: ");

            planets.add(new Planet(planetName, planetMass, planetRadius, planetDistance));
        }

        SolarSystem solarSystem = new SolarSystem(solarSystemName, centralMasses, centralRadii, planets);
        saveSolarSystemInputToFile(solarSystem);
    }

    // Method to load and display solar system data from a CSV file
    public static void loadAndDisplaySolarSystem() {
        String filePath = "C:/Users/nicol/VSCode/SE300/trial_system.csv"; // Set your CSV file path here
        CSVReaderFileReader reader = new CSVReaderFileReader();
        List<SolarSystemFileReader> solarSystems = reader.readCSV(filePath);

        // Output all solar systems
        for (SolarSystemFileReader solarSystem : solarSystems) {
            System.out.println(solarSystem);
        }
    }

    // Save data to file
    public static void saveSolarSystemInputToFile(SolarSystem solarSystem) {
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
            for (Planet planet : solarSystem.getPlanets()) {
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
*/