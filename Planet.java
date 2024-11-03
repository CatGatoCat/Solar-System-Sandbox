/*
	Filename: Planet
	Author: Nicole Motta
    Collaborators: Laurel Grein, Rylee Grover, Kyrylo Holovenko
	Date created: 10/04/2024
	Date modified: 10/29/2024
	Purpose: Child Class of the system.
	
	Attributes:
    -name: String
    -mass: double
    -radius: double
    -distance: double
	
	Methods:
	+<<constructor>> Planet(String, double, double, double, double)
    
    +getName(): String
    +setName(String): void

    +getMass(): double
    +setMass(double): void

    +getRadius(): double
    +setRadius(double): void

    +getDistance(): double
    +setDistance(double): void

    +toString(): String
    
*/

public class Planet {
    private String name;
    private double mass;
    private double radius;
    private double distance;

    public Planet(String name, double mass, double radius, double distance) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
        this.distance = distance;
    }

    public String getName() { return name;}
    public void setName(String name) { this.name = name; }

    public double getMass() {  return mass; }
    public void setMass(double mass) { this.mass = mass; }

    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }

    public double getDistance() { return distance; }
    public void setDistance(double distance) {  this.distance = distance; }

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
