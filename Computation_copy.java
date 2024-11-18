
/*
	Filename: Computation
	Authors: Laurel Grein, Rylee Grover, Nicole Motta, Kyrylo Holovenko
	Date created: 10/27/2024
	Date modified: 11/03/2024
	Purpose: This file will perform all calculations.
	
	Attributes:
	- InformationArray: ArrayList<Double>
	
	Methods:
	-GravitationalPull(double, double, double): double
	-HabitableZone(double, double, double, double, double, double): String
	
*/

import static java.lang.Math.cbrt;
import java.util.*;

public class Computation_copy {

	private ArrayList<Double> InformationArray;
	
	private double GravitationalPull(double m1, double m2, double r) {
		
		double g = 6.67*Math.pow(10, -11);	//gravitational constant
		
		double result = g*((m1*m2)/(Math.pow(r, 2)));	//m1= mass of star, m2= mass of planet, r= distance between planet and star
		
		return result;
	}
	
	private String HabitableZone(double mvsun, double mvstar, double d, double BCstar, double BCsun, double Lsun) {	// between inner radius and outer radius
		
		// 1. Mv = mv – 5 log(d/10)
		double Mvsun = mvsun - 5*Math.log10(d/10);
		
		double Mvstar = mvstar - 5*Math.log10(d/10);
		
		// 2. Mbolstar = Mv + BC	Mbolsun = Mv+BC
		
		double Mbolstar = Mvstar + BCstar;
		
		double Mbolsun = Mvsun + BCsun;
		
		
		// 3. Lstar/Lsun=10^((Mbolstar-Mbolsun)/-2.5)
		
		double Lstar = Lsun * Math.pow(10, (Mbolstar-Mbolsun)/-2.5);
		
		// 4. ri = sqrt(Lstar/1.1)	r0=sqrt(Lstar/0.53)
		
		double ri = Math.sqrt(Lstar/1.1);	//Lstar = absolute luminosity of the star
		
		double ro = Math.sqrt(Lstar/0.53);
		
		return ri + "_" + ro;
	}

	private double LagrangePoint1and2(double m1, double m2, double d){

		double mew = m2/(m1+m2);
		double LangPoint1 = d*(cbrt((mew/3)));

		return LangPoint1;
	}

	private double LagrangePoint3(double m1, double m2, double d){

		double mew = m2/(m1+m2);
		double LangPoint3 = (7*d/12)*mew;

		return LangPoint3;
	}
	
	
	
	public static void main(String[] args) {	//TEST MAIN
		
		Computation_copy obj = new Computation_copy();
		
		double GravitationalPull = obj.GravitationalPull(5.972*Math.pow(10, 24), 1, 6371000);
        String HabitableZone = obj.HabitableZone(1, 1, 1, 1, 1, 1);
		double LagrangePoint1and2 = obj.LagrangePoint1and2(23445, 345556, 213993);
		double LagrangePoint3 = obj.LagrangePoint3(343445, 3455, 334);
		
		System.out.println("Gravitational Pull: " + GravitationalPull);
        System.out.println("Habitable Zone: " + HabitableZone);
		System.out.println("Langrange Points 1 & 2: " + LagrangePoint1and2);
		System.out.println("Langrange Point 3: " + LagrangePoint3);
		
	}

}
