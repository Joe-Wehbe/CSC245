package asst2;

public class EquilateralTriangle extends Triangle { // inherits from class Triangle
	
	// Constructor of the class
	public EquilateralTriangle (String color, double XCoordinate, double YCoordinate, double sideA, double sideB, double sideC) {
		super(color, XCoordinate, YCoordinate, sideA, sideB, sideC);
		sideA = sideB = sideC; // The 3 sides are equal (equilateral triangle)
	}
	
	// toString
	public String toString() {
		return "Equilateral " + super.toString() + " (Side Length: " + sideA + ")";
	}
	
	// Used to copy info about equilateral triangles to output.txt
	public String transferData() {
		return "equilateral triangle, " + color + ", " + XCoordinate + ", " + YCoordinate;
	}

}
