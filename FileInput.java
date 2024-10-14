import java.util.ArrayList;
import java.util.Scanner;

/*Req. 4: The system will save all manually input data to a file and copy data to an array. 

Req 4.1: The system shall ask the user for the Solar System model name. 

Req. 4.2: The system shall allow the user to choose stellar classification of the central object from a menu. 

Req. 4.3: The system should prompt the user to input the desired number of planets. 

Req. 4.4: For each planet the software should ask the user to input a name, mass, radius, and distance from a central object and save it to a file. 

Req. 4.5: The system shall create an array with the user’s input data  */



public class FileInput {


    private ArrayList<Double> SimData = new ArrayList<Double>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList list = new ArrayList<>();

        System.out.println("What is the Solar System model?");

        String Model_Name = scan.nextLine();

       // System.out.println(Model_Name);

    }

    private void readInput(){
        

    }

    private void inputInArray(){
        
    }
    
    
}