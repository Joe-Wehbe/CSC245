package asst2;

public class Square extends Shape { // inherits from class Shape
	
	// defining side length
	private double sideLength;
	
	// Constructor of the class
	public Square (String color, double XCoordinate, double YCoordinate, double sideLength) {
		super(color, XCoordinate, YCoordinate);
		this.sideLength = sideLength;
	}
	
	// toSring()
	public String toString() {
		return "Square" + super.toString() + " (Side length: " + sideLength + ")";
	}
	
	// Used to copy info about squares to the file output.txt
	public String transferData() {
		return "square, " + color + ", " + XCoordinate + ", " + YCoordinate;
	}

	// Area and perimeter of a square
	public double area() {
		return Math.pow(sideLength, 2);		
	}
	
	public double perimeter() {
		return sideLength * 4;
	}

}
