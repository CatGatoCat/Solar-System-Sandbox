import java.util.List;

public class SolarSystemFileReader {
    private String name;
    private double centerMass;
    private int centerRadius;
    private List<PlanetFileReader> planets;

    public SolarSystemFileReader(String name, double centerMass, int centerRadius, List<PlanetFileReader> planets) {
        this.name = name;
        this.centerMass = centerMass;
        this.centerRadius = centerRadius;
        this.planets = planets;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public double getCenterMass() {
        return centerMass;
    }

    public void setCenterMass(double centerMass) {
        this.centerMass = centerMass;
    }

    public int getCenterRadius() {
        return centerRadius;
    }
    public void setCenterRadius(int centerRadius) {
        this.centerRadius = centerRadius;
    }

    public List<PlanetFileReader> getPlanets() {
        return planets;
    }
    public void setPlanets(List<PlanetFileReader> planets) {
        this.planets = planets;
    }

    @Override
    public String toString() {
        return "SolarSystem{" +
                "name='" + name + '\'' +
                ", centerMass=" + centerMass +
                ", centerRadius=" + centerRadius +
                ", planets=" + planets +
                '}';
    }


    

   

}
