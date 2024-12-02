/*
    Filename: GUI_revamped
    Authors: Laurel Grein
    Date created: 10/27/2024
    Date modified: 10/27/2024
    Purpose: This file serve as the visual aspect of our code! :D
    
    Attributes:
    -frame: JFrame
    -label: JLabel
    -date_update: String
    -names: String
    -choice: int
    
    Methods:
    +main(String[]): void
    -createFrame(): void
    -welcomeScreen(): void
    -choicesScreen(): void
    -insertManualData(): void
    -addCentralObjectFields(numObjects): void
    -createPlanetFields(): void
    -insertDatabaseFile(): void
    
*/
import java.awt.*;
import java.io.File;
import javax.swing.*;

public class GUI_revamped {
    private JFrame frame;
    private JPanel panel;
    private JTextField systemModelField;
    private JButton oneObjectButton, twoObjectsButton;
    private JTextField massCentralObjectField1, massCentralObjectField2;
    private JTextField radiusCentralObjectField1, radiusCentralObjectField2;
    private JTextField numberOfPlanetsField;
    private int numberOfPlanets;
    private String[] planetNames;
    private double[] planetMasses;
    private double[] planetRadii;
    private double[] planetDistances;

    public static void main(String[] args) {
        GUI_revamped gui = new GUI_revamped();
        gui.createFrame();
    }

    public void createFrame() {
        frame = new JFrame("GUI Revamped");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        welcomeScreen();
        frame.setVisible(true);
    }

    private void welcomeScreen() {
        if (panel != null) {
            frame.remove(panel);
        }
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome to the Program!", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JTextArea description = new JTextArea("Hello user! This program can help astrophysicists (like you!) to visualize your calculations.\n\nTo begin, please select your method of data input.");
        description.setEditable(false);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);

        JButton continueButton = new JButton("Continue");
        continueButton.addActionListener(e -> choicesScreen());

        panel.add(welcomeLabel, BorderLayout.NORTH);
        panel.add(description, BorderLayout.CENTER);
        panel.add(continueButton, BorderLayout.SOUTH);

        frame.add(panel);
        frame.revalidate();
        frame.repaint();
    }

    private void choicesScreen() {
        frame.remove(panel);
        panel = new JPanel(new BorderLayout());

        JLabel promptLabel = new JLabel("Please select an option:");
        String[] options = {"I want to input my data manually", "I have a file from a database"};
        JComboBox<String> dropdown = new JComboBox<>(options);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(e -> {
            if (dropdown.getSelectedIndex() == 0) {
                insertManualData();
            } else {
                insertDatabaseFile();
            }
        });

        JPanel dropdownPanel = new JPanel();
        dropdownPanel.add(promptLabel);
        dropdownPanel.add(dropdown);
        panel.add(dropdownPanel, BorderLayout.CENTER);
        panel.add(confirmButton, BorderLayout.SOUTH);

        frame.add(panel);
        frame.revalidate();
        frame.repaint();
    }

    private void insertManualData() {
        frame.remove(panel);
        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        panel.add(new JLabel("System model name:"));
        systemModelField = new JTextField();
        panel.add(systemModelField);

        panel.add(new JLabel("How many central objects do you want? (1 or 2)"));
        oneObjectButton = new JButton("1");
        twoObjectsButton = new JButton("2");

        oneObjectButton.addActionListener(e -> addCentralObjectFields(1));
        twoObjectsButton.addActionListener(e -> addCentralObjectFields(2));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(oneObjectButton);
        buttonPanel.add(twoObjectsButton);
        panel.add(buttonPanel);

        frame.add(panel);
        frame.revalidate();
        frame.repaint();
    }

    private void addCentralObjectFields(int numObjects) {
        panel.removeAll();
        panel.setLayout(new GridLayout(0, 2));

        panel.add(new JLabel("System model name:"));
        panel.add(systemModelField);

        if (numObjects >= 1) {
            panel.add(new JLabel("Mass of central object 1:"));
            massCentralObjectField1 = new JTextField();
            panel.add(massCentralObjectField1);

            panel.add(new JLabel("Radius of central object 1:"));
            radiusCentralObjectField1 = new JTextField();
            panel.add(radiusCentralObjectField1);
        }

        if (numObjects == 2) {
            panel.add(new JLabel("Mass of central object 2:"));
            massCentralObjectField2 = new JTextField();
            panel.add(massCentralObjectField2);

            panel.add(new JLabel("Radius of central object 2:"));
            radiusCentralObjectField2 = new JTextField();
            panel.add(radiusCentralObjectField2);
        }

        panel.add(new JLabel("Number of planets:"));
        numberOfPlanetsField = new JTextField();
        panel.add(numberOfPlanetsField);

        JButton generateFieldsButton = new JButton("Generate Planet Fields");
        generateFieldsButton.addActionListener(e -> createPlanetFields());
        panel.add(generateFieldsButton);

        frame.revalidate();
        frame.repaint();
    }

    private void createPlanetFields() {
        try {
            numberOfPlanets = Integer.parseInt(numberOfPlanetsField.getText());
            if (numberOfPlanets < 2 || numberOfPlanets > 9) {
                throw new NumberFormatException();
            }

            panel.removeAll();
            panel.setLayout(new GridLayout(0, 2));

            planetNames = new String[numberOfPlanets];
            planetMasses = new double[numberOfPlanets];
            planetRadii = new double[numberOfPlanets];
            planetDistances = new double[numberOfPlanets];

            for (int i = 1; i <= numberOfPlanets; i++) {
                panel.add(new JLabel("Name of Planet " + i + ":"));
                JTextField planetNameField = new JTextField();
                planetNames[i - 1] = planetNameField.getText();
                panel.add(planetNameField);

                panel.add(new JLabel("Mass of Planet " + i + ":"));
                JTextField planetMassField = new JTextField();
                planetMasses[i - 1] = Double.parseDouble(planetMassField.getText());
                panel.add(planetMassField);

                panel.add(new JLabel("Radius of Planet " + i + ":"));
                JTextField planetRadiusField = new JTextField();
                planetRadii[i - 1] = Double.parseDouble(planetRadiusField.getText());
                panel.add(planetRadiusField);

                panel.add(new JLabel("Distance from Planet " + i + " to central object:"));
                JTextField distanceField = new JTextField();
                planetDistances[i - 1] = Double.parseDouble(distanceField.getText());
                panel.add(distanceField);
            }

            JButton submitButton = new JButton("Submit");
            submitButton.addActionListener(e -> displayPlanets());

            panel.add(submitButton);

            frame.revalidate();
            frame.repaint();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid number of planets (between 2 and 9).");
        }
    }

    private void insertDatabaseFile() {
        frame.remove(panel);
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel instructionLabel = new JLabel("Select a file from your directory:");
        panel.add(instructionLabel, BorderLayout.NORTH);

        JButton openFileButton = new JButton("Open File");
        openFileButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                JOptionPane.showMessageDialog(frame, "Selected file: " + selectedFile.getAbsolutePath());
            }
        });

        panel.add(openFileButton, BorderLayout.CENTER);

        frame.add(panel);
        frame.revalidate();
        frame.repaint();
    }

    // New method to display planets
    private void displayPlanets() {
        frame.remove(panel);
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel systemModelLabel = new JLabel("System Model: " + systemModelField.getText(), JLabel.CENTER);
        systemModelLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(systemModelLabel, BorderLayout.NORTH);

        JPanel planetsPanel = new JPanel(new GridLayout(0, 1));

        for (int i = 0; i < numberOfPlanets; i++) {
            String planetInfo = String.format("Planet %d: %s, Mass: %.2f, Radius: %.2f, Distance: %.2f",
                    i + 1, planetNames[i], planetMasses[i], planetRadii[i], planetDistances[i]);
            JLabel planetLabel = new JLabel(planetInfo);
            planetsPanel.add(planetLabel);
        }

        panel.add(planetsPanel, BorderLayout.CENTER);

        frame.add(panel);
        frame.revalidate();
        frame.repaint();
    }
}
