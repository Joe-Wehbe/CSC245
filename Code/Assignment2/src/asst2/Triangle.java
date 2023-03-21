package asst2;

public class Triangle extends Shape{ // inherits from class Shape
	
	// Defining the 3 sides of a triangle
	protected double sideA;
	protected double sideB;
	protected double sideC;
	
	// Constructor of a class
	public Triangle (String color, double XCoordinate, double YCoordinate, double sideA, double sideB, double sideC) {
		super(color, XCoordinate, YCoordinate);
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}
	
	// toString
	public String toString() {
		return "Triangle" + super.toString() + " (Side A: " + sideA + ") (Side B: " + sideB + ") (Side C: " + sideC + ")";
	}
	
	// Used to copy info about triangles to output.txt
	public String transferData() {
		return "triangle, " + color + ", " + XCoordinate + ", " + YCoordinate;
	}

	// Area and perimeter of a triangle
	public double area() {		
		 /* Heron's formula is used to calculate the area of the triangle
	       given only the 3 sides (no base and height).*/
	    	
	    	// we start by finding half the perimeter of the triangle
	    double halfPerimeter = perimeter() / (double) 2; 	    	
	    	// then we apply the following formula to find the area
	    double area = Math.sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));   	
	    return area;
	}
	
	public double perimeter() {
		return sideA + sideB + sideC;
	}

}
