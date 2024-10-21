    /***********************************
 * Filename: Sim_Info_Motta
 * Author: Nicole Motta
 * Collaborators: Logan Luna, Laurel Grein, Anthony Fuentes
 * Created: 4/15/2024
 * Modified: 4/21/2024
 * Purpose: The database for the values obtained from the file input
 *
 *
 * Attributes:
 * - SimInfo: ArrayList<Simulation_Motta>
 * - mass: double
 * - initialFuel: double
 * - velExhaust: double
 * - timeOfBurn: double
 * - initialVel: double
 * - LenghtOrDiam: double
 * - WidAstrBatt: double
 *
 * Methods:
 * +<<constructor>> Sim_Info_Motta()
 * +getFuel(): double
 * +setFuel(double): void
 * +getLengDia(): double
 * +setLengDia(double): void
 * +getWidtAstBat(): double
 * +setWidtAstBat(double): void
 * +getInitialVel(): double
 * +setInitialVel(double): void
 * +getVelExhaust(): double
 * +setVelExhaust(double): void
 * +getMass(): double
 * +setMass(double): void
 * +getTimeOfBurn(): double
 * +setTimeOfBurn(double): void
 * +addInfo(Simulation_Motta): void
 ***********************************/

public class Simulation {
    

	private double mass2;
	private double initialFuel2;
	private double initialVel2;
	private double velExhaust2;
	private double timeOfBurn2;	


	private double maxHeight;
	private double maxVel;
	private double totalTime;
	private double FuelUsed;
	private boolean Successful;

	private int simType;

	//constructor
	public Simulation(int choice, SimInfo val)
	{
		simType = choice;


		maxHeight = 0;
		maxVel = 0;
		totalTime = 0;
		FuelUsed = 0;
		Successful = false;
		
		setValues(val);
	}


	private void setValues(Sim_Info_Motta val) {
		mass2 = val.getMass();
		initialFuel2 = val.getFuel();
		initialVel2 = val.getInitialVel();
		velExhaust2 = val.getVelExhaust();
		timeOfBurn2 = val.getTimeOfBurn();
	}

	//setters and getters

	public double getMass2() {return mass2;}
	public double getVelExhaust2() {return velExhaust2;}
	public double getTimeOfBurn2() {return timeOfBurn2;}
	
	
	public double getMaxHeight() { return setMaxHeight(); }

	public int getSimType() {return simType; }

	public void setMaxSpeed(double MaxVel) {maxVel = MaxVel;}

	public double getMaxSpeed() { return maxVel;}
	
	public double getTotalTime() {return setTotalTime();}


	//extra calculations

	private double setMaxHeight()
	{
		if (getMaxSpeed() != 0 && initialVel2 != 0) {
			maxHeight = (Math.pow(getMaxSpeed(),2)-Math.pow(initialVel2,2))/(2*gravity);
		}

		return maxHeight;
	}

	private double FuelUsage() {

		double massFinal;

		massFinal = mass2*(Math.exp(initialVel2/(velExhaust2-1)));

		FuelUsed = initialFuel2 - massFinal;

		if(FuelUsed < 0)
		{
			FuelUsed = 0;
		}

		return FuelUsed;
	}

	private boolean Success() {

		boolean Success;

		if(getMaxHeight() > 10000) {
			Success = true;
		} else{
			Success = false;
		}

		Successful = Success;

		return Successful;
	}



	private double setTotalTime() {
		double Time = 0;
		Time = getMaxSpeed()/initialVel2;
		totalTime = Time;
		return totalTime;
	}



	//print out the calculations
	public String toString()
	{


		String s = "";



		if(simType==1) {
			s += "Satellite Simulation\n";
		}
		if(simType ==2 ) {
			s += "Rover Simulation\n";
		}
		if(simType == 3) {
			s += "Aircraft Simulation\n";
		}

		return s + "\nSuccess = " + Success() + "\nMaximum Height = " + getMaxHeight() + "\nTotal Mission Time = " + getTotalTime() + "\nFuel Usage = " + FuelUsage() + "\nMaximum Velocity = " + getMaxSpeed();

	}
	
}

