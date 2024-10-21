import java.util.List;

public class SolarSystem {
    private String name;
    private double centerMass;
    private int centerRadius;
    private List<Planet> planets;

    public SolarSystem(String name, double centerMass, int centerRadius, List<Planet> planets) {
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

    public List<Planet> getPlanets() {
        return planets;
    }
    public void setPlanets(List<Planet> planets) {
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
