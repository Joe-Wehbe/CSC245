package asst2;

public class Circle extends Shape { // inherits from class Shape
	
	// Defining radius
	private double radius;
	
	// Constructor of class circle
	public Circle (String color, double XCoordinate, double YCoordinate, double radius) {
		super(color, XCoordinate, YCoordinate);
		this.radius = radius;
	}
	
	// toString()
	public String toString() {
		return "Circle" + super.toString() + " (Radius: " + radius + ")";
	}
	
	// Copies info about circles to the file output.txt
	public String transferData() {
		return "circle, " + color + ", " + XCoordinate + ", " + YCoordinate;
	}
    
	// Area and perimeter of a circle
	public double area() {		 
		return Math.PI * Math.pow(radius, 2);
	}

	public double perimeter() {		
		return 2 * Math.PI * radius;
	}

}
