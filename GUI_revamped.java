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
	-choices(): void
	
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI_revamped {

    // JFrame variable
    private JFrame frame;
    private JPanel panel;

    public static void main(String[] args) {
        // Create an instance of the GUI_revamped class
        GUI_revamped gui = new GUI_revamped();
        gui.createFrame();
    }

    // Method to create the frame and add the welcome screen
    public void createFrame() {
        // Initialize the JFrame
        frame = new JFrame("GUI Revamped");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Initialize the first panel as the welcome screen
        welcomeScreen();
        
        // Make the frame visible
        frame.setVisible(true);
    }

    // Method to create the welcome screen
    private void welcomeScreen() {
        // Clear previous content if any
        if (panel != null) {
            frame.remove(panel);
        }
        
        // Initialize a new panel for the welcome screen
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Welcome message
        JLabel welcomeLabel = new JLabel("Welcome to the Program!", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        // Description message
        JTextArea description = new JTextArea("Hello user! This program can help astrophycisists (like you!) to visualize your calculations.\n\nTo begin, please select your method of data input.");
        description.setEditable(false);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        
        // Continue button
        JButton continueButton = new JButton("Continue");
        continueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                choicesScreen();  // Switch to choices screen
            }
        });

        // Add components to panel
        panel.add(welcomeLabel, BorderLayout.NORTH);
        panel.add(description, BorderLayout.CENTER);
        panel.add(continueButton, BorderLayout.SOUTH);
        
        // Add panel to frame
        frame.add(panel);
        frame.revalidate();
        frame.repaint();
    }

    // Method to create the choices screen
    private void choicesScreen() {
        // Clear previous content
        frame.remove(panel);
        
        // Initialize new panel for the choices screen
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Dropdown menu for choices
        JLabel promptLabel = new JLabel("Please select an option:");
        String[] options = {"I want to input my data manually", "I have a file from a database"};
        JComboBox<String> dropdown = new JComboBox<>(options);
        
        // Button to confirm selection
        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Action to perform on confirmation
                JOptionPane.showMessageDialog(frame, "Great! Let's get started.\n" + dropdown.getSelectedItem());
            }
        });
       
        // Add components to panel
        JPanel dropdownPanel = new JPanel();
        dropdownPanel.add(promptLabel);
        dropdownPanel.add(dropdown);
        panel.add(dropdownPanel, BorderLayout.CENTER);
        panel.add(confirmButton, BorderLayout.SOUTH);
        
        // Add panel to frame
        frame.add(panel);
        frame.revalidate();
        frame.repaint();
    }
    /*
    private void insertManualData()
    {
        //find a way to get nicoles code to be put in here because she already has data inputs!
        frame.remove(panel);
        //a new panel
        panel= new JPanel();
        panel.setLayout(new BorderLayout());
        //make some questions, make some text box answers!
        

    } 
    private void insertDatabaseFile()
    {
        //create a place where the user can insert a file of their choosing
    }
     */
}
