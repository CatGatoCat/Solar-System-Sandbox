public class Planet {
    private double mass;
    private String radius;

    public Planet(double mass, String radius) {
        this.mass = mass;
        this.radius = radius;
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

    @Override
    public String toString() {
        return "Planet{" +
                "mass=" + mass +
                ", radius='" + radius + '\'' +
                '}';
    }


    
}
