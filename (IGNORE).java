import java.beans.SimpleBeanInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;



/*Req. 4: The system will save all manually input data to a file and copy data to an array. 

Req 4.1: The system shall ask the user for the Solar System model name. 

Req. 4.2: The system shall allow the user to choose stellar classification of the central object from a menu. 

Req. 4.3: The system should prompt the user to input the desired number of planets. 

Req. 4.4: For each planet the software should ask the user to input a name, mass, radius, and distance from a central object and save it to a file. 

Req. 4.5: The system shall create an array with the user’s input data  */

//private String filePath = "data.txt"; 


public class FileInput {

	private ArrayList<Double> SimData = new ArrayList<Double>();
	//private static String toStringMain;


    public static void main(String[] args) {
        ArrayList list = new ArrayList<>();
		FileInput main = new FileInput();


        System.out.println("What is the Solar System model?");
		main.parseDataFromFile("trial_system.csv");


       // System.out.println(Model_Name);

    }

    //read information from the file and put them in the arrayList
	private ArrayList<String> readFromFile(String filename) 
	{
		ArrayList<String> data = new ArrayList<>();
        //ArrayList<Double> SimData = new ArrayList<>();


        ArrayList<Object> SimData = new ArrayList<>();


		try {
			File file = new File(filename);
			Scanner scan = new Scanner(file);


			while(scan.hasNext()) {
				String line = scan.nextLine().trim();
				//data.add(line);
			}

			scan.close();

		} catch(Exception e) {
			System.out.println("Exception occured while reading from file.");
			e.printStackTrace();
		}
		return data;

	}

    public boolean parseDataFromFile(String filename) //throws FileNotFoundException
	{
		ArrayList<String> data = readFromFile(filename);
		if (data == null || data.isEmpty()) {
			return false;
		} 

		for (int i = 1; i < data.size(); i++) {
			System.out.println(data.get(i));
			String[] info = data.get(i).split(",");

			String label = info[0];
			double value = Double.parseDouble(info[1]);

			SimData.add(value);

			if(label.equalsIgnoreCase("Solar System Name")) {
				SimInfo.setName(value);
			}
			if(label.equalsIgnoreCase("Number of center object")) {
				SimInfo.setNumCenterObject(value);
			}
			if(label.equalsIgnoreCase("Mass of center object")) {
				SimInfo.setCenterObjectMass(value);
			}
			if(label.equalsIgnoreCase("Radius of center object")) {
				SimInfo.setCenterObjectRadius(value);
			}
			if(label.equalsIgnoreCase("Number of planets")) {
				simInfo.setPlanetsNum(value);

			}


			if(label.equalsIgnoreCase("length") || label.equalsIgnoreCase("diameter")) {
				simInfo.setLengDia(value);
			}
			if(label.equalsIgnoreCase("width") || label.equalsIgnoreCase("Astronauts") || label.equalsIgnoreCase("Battery capacity")) {
				simInfo.setWidtAstBat(value);
			} 
		


		}

		return false;
	}
    
    
}