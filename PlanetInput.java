public class PlanetInput {
    private String name;
    private double mass;
    private String radius;
    private double distance;

    public PlanetInput(String name, double mass, double distance, double planetDistance) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getMass() {
        return mass;
    }
    public void setMass(double mass) {
        this.mass = mass;
    }

    public String getRadius() {
        return radius;
    }
    public void setRadius(String radius) {
        this.radius = radius;
    }

    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", mass=" + mass +
                ", radius='" + radius + '\'' +
                ", distance=" + distance +
                '}';
    }


    

}
