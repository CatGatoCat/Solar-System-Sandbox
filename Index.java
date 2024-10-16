/*
	Filename: Index
	Authors: Laurel Grein, Rylee Grover, Nicole Motta, Kyrylo Holovenko
	Date created: 10/06/2024
	Date modified: 10/10/2024
	Purpose: This file will perform most operations.
	
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

public class Index {

    private static JFrame frame = new JFrame(); // create a frame object
    private static JLabel label = new JLabel();

    private static String date_update = "10/10/2024";  // AFTER EVERY MAJOR UPDATE CHANGE THE DATE!!!
    private static String names = "Laurel Grein, Rylee Grover, Nicole Motta, Kyrylo Holovenko";
    
    private static int choice;

    public static void main(String[] args) {
        Index obj = new Index();

        obj.createFrame();   // call method to create frame
        obj.welcomeScreen();  // call method to set label and put it into frame
        obj.choices();        // add dropdown choices
        
    } // end main

    //----------------------------------------------------------------------------------------------------------------------------------

    private void createFrame() {
        frame.setTitle("Solar System Sandbox");                       // title for the frame
        frame.setSize(1650, 1000);                                   // size for a frame in x and y directions
        frame.setResizable(false);                                   // makes frame size fixed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       // exit out of application
        frame.getContentPane().setBackground(new Color(0x123456));    // set background color
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS)); // Use BoxLayout for the frame
        frame.setVisible(true);                                      // make frame visible
    }
    //----------------------------------------------------------------------------------------------------------------------------------

    private void welcomeScreen() {
        JPanel welcome = new JPanel();
        welcome.setLayout(new FlowLayout(FlowLayout.LEFT)); // Align to the left
        welcome.setBackground(new Color(0x123456));

        label.setText("<html>Created by Team #13: " + names + "<br>Last update: " + date_update + "</html>");
        label.setForeground(Color.white);    // set text color to white
        label.setFont(new Font("MV Boli", Font.PLAIN, 20));    // set text font

        welcome.add(label);
        frame.add(welcome);
    }

    //----------------------------------------------------------------------------------------------------------------------------------
    
    private void choices() {
    	
    	JLabel labelchoice = new JLabel("Select an option from the dropdown.");
    	labelchoice.setForeground(Color.white);
    	labelchoice.setFont(new Font("MV Boli", Font.PLAIN, 20));
    	
        JPanel choices = new JPanel();
        choices.setLayout(new FlowLayout(FlowLayout.LEFT));
        choices.setBackground(Color.red);

        String[] items = {"Select an option", "Upload from file", "Type in all data", "Create a new file"};
        int[] values = {0, 1, 2, 3}; // Corresponding integer values

        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setFont(new Font("MV Boli", Font.PLAIN, 20));

        choices.add(comboBox);
        choices.add(labelchoice);
        
        frame.add(choices); // Add choices panel to the frame
        frame.revalidate();  // Refresh the frame to show the new components
        frame.repaint();     // Repaint to ensure everything is displayed correctly
        
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = comboBox.getSelectedIndex();
                choice = values[selectedIndex]; // Get the corresponding integer value

                if (choice > 0) { // Skip the first option
                	
                	switch (choice) {
                    case 1:
                        System.out.print("User chooses to upload a file");
                        break;
                    case 2:
                        System.out.print("User chooses to type in all data");
                        break;
                    case 3:
                        System.out.print("User chooses to create a new file");
                        break;
                    default:
                        // Optional: handle invalid choice (0)
                        break;
                    }
                	
                }
            }
        });	// end listener
        
    }
    
    //----------------------------------------------------------------------------------------------------------------------------------

    
}	// end class