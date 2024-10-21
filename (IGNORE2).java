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

public class SimInfo {

	private ArrayList<Simulation> SimInfo = new ArrayList<>();

	private String SystemName;
	private int CenterObjectNum;
	private double CenterObjectMass;
	private double CenterObjectRadius;
	private int PlanetsNumber;
	private double PlanetMass;
	private double PlanetRadius;

	public SimInfo()
	{
		SystemName = "";
		CenterObjectNum = 0;
		CenterObjectMass = 0;
		CenterObjectRadius = 0;
		PlanetsNumber = 0;
		PlanetMass = 0.0;
		PlanetRadius = 0;
	}

	public String getName() {return SystemName;}
	public void setName(String SysName) {
			SystemName = SysName;	
	}

	public int getNumberCenterObject() {return CenterObjectNum;}
	public void setNumCenterObject(int NumCO) {
		if(NumCO<0) {
			CenterObjectNum = 0;
		}else if(NumCO>2){
			CenterObjectNum = 0;
		}else {
			CenterObjectNum = NumCO;	
		}
	}

	public double getCenterObjectMass() {return CenterObjectMass;}
	public void setCenterObjectMass(double MassCO) {
		if(MassCO < 0) {
			CenterObjectMass = 0;
		}else {
			CenterObjectMass = MassCO;
		}

	}


	public double getCenterObjectRadius() {return CenterObjectRadius;}
	public void setCenterObjectRadius(double RadiusCO) {
		if(RadiusCO<0) {
			CenterObjectRadius = 0;
		}else {
			CenterObjectRadius = RadiusCO;
		}
	}


	public int getPlanetNumbers() {return PlanetsNumber;}
	public void setPlanetNumbers(int PlanetNum) {
		if(PlanetNum<0) {
			PlanetsNumber = 0;
		}else {
			PlanetsNumber = PlanetNum;
		}
	}

	/*for(int i=0; i<PlanetsNumber; i++){
		System.out.println(i);
	}*/

	public double getPlanetMass() {return PlanetMass;}
	public void setPlanetMass(double Mass) {
		if(Mass<0)
		{
			Mass = 0;
		}else {
			PlanetMass = Mass;
		}
	}



	public double getTimeOfBurn() {return PlanetRadius;}
	public void setTimeOfBurn(double Radius) {
		if(Radius<0) {
			PlanetRadius = 0;
		}else {
			PlanetRadius = Radius;
		}
	}


	public void addInfo(Simulation sim)
	{
		if (sim != null) {
			SimInfo.add(sim);
		}
	}

}


