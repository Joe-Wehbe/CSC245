package asst2;

public abstract class Shape {
	
	// Defining variables
	protected String color;
	protected double  XCoordinate;
	protected double  YCoordinate;
	protected final byte DIMENSION = 2;
	
	// Constructor of the class
	public Shape(String color, double XCoordinate, double YCoordinate) {
		this.color = color;
		this.XCoordinate = XCoordinate;
		this.YCoordinate = YCoordinate;
	}
	
	// Getters and setters
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public double getXcoordinate() {
		return XCoordinate;
	}
	
	public void setXcoordinate(double XCoordinate) {
		this.XCoordinate = XCoordinate;
	}
	
	public double getYcoordinate() {
		return YCoordinate;
	}
	
	public void setYcoordinate(double YCoordinate) {
		this.YCoordinate = YCoordinate;
	}
	
	// toString
	public String toString() {
		return " >> (Color: " + color + ") (x-coordinate: " + XCoordinate + ") (y-coordinate: " + YCoordinate + ")"; 
	}
	
	public abstract String transferData(); // used to copy the info in the array to the file output.txt before exiting the program.
	
	// Area and perimeter of shapes
	public abstract double area();
	public abstract double perimeter();

}
