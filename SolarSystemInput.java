import java.util.List;

public class SolarSystemInput {
    private String name;
    private List<Double> centralMasses;
    private List<Double> centralRadii;
    private List<PlanetInput> planets;

    public SolarSystemInput(String name, List<Double> centralMasses, List<Double> centralRadii, List<PlanetInput> planets) {
        this.name = name;
        this.centralMasses = centralMasses;
        this.centralRadii = centralRadii;
        this.planets = planets;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getCentralMasses() {
        return centralMasses;
    }
    public void setCentralMasses(List<Double> centralMasses) {
        this.centralMasses = centralMasses;
    }

    public List<Double> getCentralRadii(){
        return centralRadii;
    }
    public void setCentralRadii(List<Double> centralRadii){
        this.centralRadii = centralRadii;
    }

    public List<PlanetInput> getPlanets() {
        return planets;
    }
    public void setPlanets(List<PlanetInput> planets) {
        this.planets = planets;
    }

    @Override
    public String toString() {
        return "SolarSystem{" +
                "name='" + name + '\'' +
                ", Central Object mass=" + centralMasses + '\'' +
                ", Central Object radius='" + centralRadii + '\'' +
                ", planets=" + planets +
                '}';
    }



    
}
