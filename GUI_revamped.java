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
import javax.swing.*;
import java.io.File;
import java.util.HashMap;

public class GUI_revamped {
    private JFrame frame;
    private JPanel panel;
    private JTextField systemModelField;
    private JButton oneObjectButton, twoObjectsButton;
    private JTextField massCentralObjectField1, massCentralObjectField2;
    private JTextField radiusCentralObjectField1, radiusCentralObjectField2;
    private JTextField numberOfPlanetsField;
    private int numberOfPlanets;
    private JTextField[] planetNameFields;
    private JTextField[] planetMassFields;
    private JTextField[] planetRadiusFields;
    private JTextField[] planetDistanceFields;
    private String[] planetNames;
    private double[] planetMasses;
    private double[] planetRadii;
    private double[] planetDistances;
    private double[] planetAngles;
    private Timer timer;
    private JSlider speedSlider;

    public static void main(String[] args) {
        GUI_revamped gui = new GUI_revamped();
        gui.createFrame();
    }

    public void createFrame() {
        frame = new JFrame("GUI Revamped");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,800);
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

            planetNameFields = new JTextField[numberOfPlanets];
            planetMassFields = new JTextField[numberOfPlanets];
            planetRadiusFields = new JTextField[numberOfPlanets];
            planetDistanceFields = new JTextField[numberOfPlanets];

            for (int i = 0; i < numberOfPlanets; i++) {
                panel.add(new JLabel("Name of Planet " + (i + 1) + ":"));
                planetNameFields[i] = new JTextField();
                panel.add(planetNameFields[i]);

                panel.add(new JLabel("Mass of Planet " + (i + 1) + ":"));
                planetMassFields[i] = new JTextField();
                panel.add(planetMassFields[i]);

                panel.add(new JLabel("Radius of Planet " + (i + 1) + ":"));
                planetRadiusFields[i] = new JTextField();
                panel.add(planetRadiusFields[i]);

                panel.add(new JLabel("Distance from Planet " + (i + 1) + " to central object:"));
                planetDistanceFields[i] = new JTextField();
                panel.add(planetDistanceFields[i]);
            }

            JButton submitButton = new JButton("Submit");
            submitButton.addActionListener(e -> {
                try {
                    planetNames = new String[numberOfPlanets];
                    planetMasses = new double[numberOfPlanets];
                    planetRadii = new double[numberOfPlanets];
                    planetDistances = new double[numberOfPlanets];
                    planetAngles = new double[numberOfPlanets];

                    for (int i = 0; i < numberOfPlanets; i++) {
                        planetNames[i] = planetNameFields[i].getText();
                        planetMasses[i] = Double.parseDouble(planetMassFields[i].getText());
                        planetRadii[i] = Double.parseDouble(planetRadiusFields[i].getText());
                        planetDistances[i] = Double.parseDouble(planetDistanceFields[i].getText());
                        planetAngles[i] = Math.random() * 360; // Start each planet at a random angle
                    }
                    displayPlanets();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numerical values for planet data.");
                }
            });

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
    private void displayPlanets() {
        frame.remove(panel);
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
    
        JLabel systemModelLabel = new JLabel("System Model: " + systemModelField.getText(), JLabel.CENTER);
        systemModelLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(systemModelLabel, BorderLayout.NORTH);
    
        
        JPanel drawPanel = new DrawPanel();
        panel.add(drawPanel, BorderLayout.CENTER);
    
        frame.add(panel);
        frame.revalidate();
        frame.repaint();

        speedSlider= new JSlider(JSlider.HORIZONTAL,100,1200,600);
        speedSlider.setMajorTickSpacing(100);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);

        speedSlider.addChangeListener(e ->{
            int delay= speedSlider.getValue();
            timer.setDelay(delay);
        });

        panel.add(speedSlider, BorderLayout.SOUTH);

        frame.add(panel);
        frame.revalidate();
        frame.repaint();

        timer= new Timer(600, e->{
            for (int i=0; i<numberOfPlanets; i++)
            {
                planetAngles[i]+=(2* Math.PI/360);
                if (planetAngles[i]>=360){
                    planetAngles[i]=0;
                }
            }
            drawPanel.repaint();
        }    );
        timer.start();
    }
    
    class DrawPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    
            int width = getWidth();
            int height = getHeight();
            int centerX = width / 2;
            int centerY = height / 2;
    
            
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, width, height);
    
           
            g2d.setColor(Color.WHITE);
            for (int i = 0; i < 100; i++) {
                int starX = (int) (Math.random() * width);
                int starY = (int) (Math.random() * height);
                g2d.fillRect(starX, starY, 2, 2);
            }
    
            
            double maxDistance = 0;
            for (double d : planetDistances) {
                if (d > maxDistance) maxDistance = d;
            }
            double scaleFactor = Math.min(width, height) / (maxDistance * 2 + 100);
    
            // Draw central object (assuming the first central object's parameters)
            int centralObjectRadius = (int) (Double.parseDouble(radiusCentralObjectField1.getText()) * scaleFactor);
            g2d.setColor(Color.RED);
            g2d.fillOval(centerX - centralObjectRadius, centerY - centralObjectRadius, centralObjectRadius * 2, centralObjectRadius * 2);
    
            
            HashMap<Double, Integer> usedAngles = new HashMap<>();
    
            for (int i = 0; i < numberOfPlanets; i++) {
                double distance = planetDistances[i] * scaleFactor;
                double angle = usedAngles.getOrDefault(distance, 0);
                usedAngles.put(distance, (int) angle + 30); // Increase angle to avoid overlap
    
                
                g2d.setColor(new Color(255, 255, 255, 50)); // semi-transparent white
                g2d.drawOval(centerX - (int) distance, centerY - (int) distance, (int) distance * 2, (int) distance * 2);
    
                double radianAngle = Math.toRadians(angle);
                int planetX = (int) (centerX + distance * Math.cos(radianAngle));
                int planetY = (int) (centerY + distance * Math.sin(radianAngle));
    
                int planetRadius = (int) (planetRadii[i] * scaleFactor / 5); // Scale planet radius for visibility
    
                g2d.setColor(Color.BLUE);
                g2d.fillOval(planetX - planetRadius, planetY - planetRadius, planetRadius * 2, planetRadius * 2);
    
                
                g2d.setColor(Color.WHITE);
                g2d.drawString(planetNames[i], planetX + planetRadius + 5, planetY);
            }
        }
    }
    
    }
