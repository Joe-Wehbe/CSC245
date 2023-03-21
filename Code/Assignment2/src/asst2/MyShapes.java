
/*________________________________________________________________________________________________________________________
NAME: Joe Wehbe                                                                                                                                                                                                                       
ID#: 202000908                                                                                                                                                                                                                         
COURSE: Objects and Data Abstraction (CSC245)                                                                                                                                                                                          
DATE LAST MODIFIED: 10/8/2021                                                                                                                                                                                                         
OTHER FILES: Shape.java, Circle.java, Square.java, Triangle.java, EquilateralTriangle.java, input.txt, output.txt                                                                                                                
PROGRAM DESCRIPTION: This program defines shapes of objects in space (triangles, squares, circles). A menu is displayed at
                     the beginning of the program where the user has many option:  adding a shape, deleting, moving,
                     finding area and perimeter, listing all shapes, and copying the content of a file containing information
                     about shapes. Once the user is done managing the shapes, before the program terminates, the content of
                     the array is copied to another file (output.txt).                                                
_________________________________________________________________________________________________________________________
                                                                                                                     */
package asst2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MyShapes {
	
	private Shape[] shapes; // Array to store shapes
	private int shapesCounter; // Counter for the shapes
	
	Scanner scan_num = new Scanner(System.in); // Scanner for numbers
	Scanner scan_str = new Scanner(System.in); // Scanner for strings
	
	// Constructor of the class
	public MyShapes() {
		shapes = new Shape[10]; // size set to 10 by default
		shapesCounter = 0; // count set to 0
	}
	
	public void increaseSize() {
		/* Method used to increase the size of the array once it 
		   is full. It takes no parameters and the return type is void.
		   It is invoked in the method add() */
		
		if (shapesCounter == shapes.length) { // if the array becomes full
			Shape[] temp = new Shape[shapes.length * 2]; // creating a temporary array		
			for (int i = 0; i < shapesCounter; i++) {
				temp[i] = shapes[i]; // copying the shapes
			}
			shapes = temp;
		}
	}
	
    public boolean searchShape(double x, double y) {
    	/* Method used to look for shapes at specified coordinates.
    	   This method takes the coordinates X and Y as parameters and
    	   has boolean as return type (true: found / false: not found)
    	   It is invoked in the methods deleteShape() and computeAandp()*/
    	
		for(int i = 0; i < shapesCounter; i++) {
			if (shapes[i].getXcoordinate() == x && shapes[i].getYcoordinate() == y) {
				return true; // Shapes found
			}
		}
		return false; // Shapes not found
	}
	
	
	public void add(Shape s) {
		/* This method actually adds a shape to the array 
		   It takes one parameter, and object of type Shape().
		   It is invoked in the method addShape()*/
		increaseSize();
		shapes[shapesCounter] = s; // adding to the array
		shapesCounter++; // incrementing counter.
	}
	
	public void addShape() {
		/* Method  used in option 1 in the main program that
		   adds a shape. It takes no parameters and the return
		   type is void. */		
		
		byte flag = 1; // variable to keep displaying the adding menu
		
		while (flag == 1) {
			
			// Adding menu
			System.out.println();
			System.out.println("A. Add a circle.\n"
					+ "B. Add a square\n"
					+ "C. Add a triangle\n"
					+ "D. Return to main menu\n"
					+ "------------------------\n"
					+ "Enter shape: ");

		    String option = scan_str.next().trim().toUpperCase();		    
		    
		    switch(option) {
		    
		    case "A": // Adding a circle
		    	
		    	System.out.println("Enter the color of the circle: ");
		    	String color = scan_str.next();
		    	
		    	System.out.println("Enter x-coordinate: ");
		    	double x = scan_num.nextDouble();
		    	
		    	// Cannot exceed 200 units long or wide.
		    	while (x > 100 || x < -100) {
		    		System.out.println("Shapes cannot exceed 200 units long or wide. Enter a valid number: ");
		    		x = scan_num.nextDouble();
		    	}
		    	
		    	System.out.println("Enter y-coordinate: ");
		    	double y = scan_num.nextDouble();
		    	
		    	// Cannot exceed 200 units long or wide.
		    	while (y > 100 || y < -100) {
		    		System.out.println("Shapes cannot exceed 200 units long or wide. Enter a valid number: ");
		    		y = scan_num.nextDouble();
		    	}
		    	
		    	System.out.println("Enter the radius: ");
		    	double radius = scan_num.nextDouble();
		    	
		    	Shape circle = new Circle(color, x, y, radius);
		    	
		    	// Radius must be positive
		    	while (radius < 0) {
					System.out.println("Enter a positive radius: ");
					radius = scan_num.nextDouble();
				}
		    	
		    	add(circle);
		    	break;
		    	
		    case "B": // Adding a square
		    	
		    	System.out.println("Enter the color of the square: ");
		    	color = scan_str.next();
		    	
		    	System.out.println("Enter x-coordinate: ");
		    	x = scan_num.nextDouble();
		    	
		    	// Cannot exceed 200 units long or wide.
		    	while (x > 100 || x < -100) {
		    		System.out.println("Shapes cannot exceed 200 units long or wide. Enter a valid number: ");
		    		x = scan_num.nextDouble();
		    	}
		    	
		    	System.out.println("Enter y-coordinate: ");
		    	y = scan_num.nextDouble();
		    	
		    	// Cannot exceed 200 units long or wide.
		    	while (y > 100 || y < -100) {
		    		System.out.println("Shapes cannot exceed 200 units long or wide. Enter a valid number: ");
		    		y = scan_num.nextDouble();
		    	}
		    	
		    	System.out.println("Enter side length: ");
		    	double sideLength = scan_num.nextDouble();
		    	
		    	// Side length must be positive
		    	while (sideLength < 0) {
					System.out.println("Enter a positive side length: ");
					sideLength = scan_num.nextDouble();
				}
		    	
		    	Shape square = new Square(color, x, y, sideLength);
		    	
		    	add(square);
		    	break;
		    	
		    case "C": // Adding a triangle
		    	
		    	System.out.println("Enter the color of the triangle: ");
		    	color = scan_str.next();
		    	
		    	System.out.println("Enter x-coordinate: ");
		    	x = scan_num.nextDouble();
		    	
		    	// Cannot exceed 200 units long or wide.
		    	while (x > 100 || x < -100) {
		    		System.out.println("Shapes cannot exceed 200 units long or wide. Enter a valid number: ");
		    		x = scan_num.nextDouble();
		    	}
		    	
		    	System.out.println("Enter y-coordinate: ");
		    	y = scan_num.nextDouble();
		    	
		    	// Cannot exceed 200 units long or wide.
		    	while (y > 100 || y < -100) {
		    		System.out.println("Shapes cannot exceed 200 units long or wide. Enter a valid number: ");
		    		y = scan_num.nextDouble();
		    	}
		   
		    	System.out.println("Enter side A: ");
		    	double sideA = scan_num.nextDouble();
		    	
		    	// Sides must be positive
		    	while (sideA < 0) {
					System.out.println("Enter a positive side: ");
					sideA = scan_num.nextDouble();
				}
		    	
		    	System.out.println("Enter side B: ");
		    	double sideB = scan_num.nextDouble();
		    	
		    	// Sides must be positive
		    	while (sideB < 0) {
					System.out.println("Enter a positive side: ");
					sideB = scan_num.nextDouble();
				}
		    	
		    	System.out.println("Enter side C: ");
		    	double sideC = scan_num.nextDouble();
		    	
		    	// Sides must be positive
		    	while (sideC < 0) {
					System.out.println("Enter a positive side: ");
					sideC = scan_num.nextDouble();
				}
		    	
		    	// If the sides are equal --> equilateral triangle
		    	if (sideA == sideB && sideB == sideC) {
		    		Shape eqTriangle = new EquilateralTriangle(color, x, y, sideA, sideB, sideC);		    		
		    		add(eqTriangle);
		    	}
		    	// Not equilateral.
		    	else {
		    		Shape triangle = new Triangle(color, x, y, sideA, sideB, sideC);	    		
		    		add(triangle);
		    		
		    	}
		    	break;
		    	
		    case "D": // Return to main menu
		    	
		    	System.out.println("Returning to main menu.");
		    	flag = 0; // Setting flag to 0 to stop displaying the adding menu
		    	break;
		    
		    default: // if none of the shapes is entered
		    	System.out.println("Invalid option.");
		    	break;
		    }
		  
		}
	}
	
	public void deleteShape() {
		/* This method deletes all shapes at the specified coordinates,
		   it is used in the second option in the main program. 
		   It takes no parameters and its return type is void*/
		
		if (shapesCounter == 0) { // If there is no shapes
			System.out.println("No shapes to delete.");
		}
		
		System.out.println("Enter x-coordinate: ");
		double x = scan_num.nextDouble();
		
		System.out.println("Enter y-coordinate: ");
    	double y = scan_num.nextDouble();
    	
    	boolean isFound = searchShape(x, y); // searching for shapes at the entered coordinates
    		
        if (isFound == true) { // shape(s) found
        	// Deleting all shapes at the entered coordinates
        	for (int i = 0; i < shapesCounter; i++) {
        		if (shapes[i].getXcoordinate() == x && shapes[i].getYcoordinate() == y) {
        			shapes[i] = shapes[shapesCounter - 1];
        			shapes[shapesCounter - 1] = null;
        			shapesCounter--;
        			i = 0; // resetting i to 0 to delete all shapes
        		}       		
        		
        	}
        	System.out.printf("All shapes at the (" + x + "," + y + ") coordinates have been deleted");
        	System.out.println();
        }
        
        else { // No shapes found at the entered coordinates
        	System.out.println("No shapes at the (" + x + "," + y + ") coordinates");
        }
    	
	}
	
	public void ComputeAandP(){
		/* This method computes the area and perimeter of every shape found
		   at the specified coordinates. It is used in the option 3 in the main
		   menu. It takes no parameters and the return type is void. */
		
		// Inputing the coordinates
		System.out.println("Enter x-coordinate: ");
		double x = scan_num.nextDouble();
		
		System.out.println("Enter y-coordinate: ");
    	double y = scan_num.nextDouble();
    	
    	System.out.println();
    	
    	boolean isFound = searchShape(x, y); // searching for shapes at the entered coordinates
    	
    	if (isFound == true) { // shapes found
    	
    	    for (int i = 0; i < shapesCounter; i++) {
    		    if (shapes[i].getXcoordinate() == x && shapes[i].getYcoordinate() == y) {
    		    	// Displaying the shapes and computing area and perimeter.
    			    System.out.println(shapes[i].toString());
    			    System.out.println("Area: " + shapes[i].area());
    			    System.out.println("Perimeter: " + shapes[i].perimeter());
    			    System.out.println();
    		    }
    	    }   		
    	}
    	else { // No shapes found
    		System.out.println("No shapes found at coordinates (" + x + "," + y + ")");
    	}
	}
	
	public void listShapes() {
		/* Method used in option 4 to list all the shapes, 
		   it takes no parameters and the return type is void.*/
		System.out.println();
		for (int i = 0; i < shapesCounter; i++) {
    		System.out.println(shapes[i].toString());
	    }
	}	
	
	public void moveObject() {
		/* This method moves an object whether vertically (y-coordinate) or
		   horizontally (x-coordinate). It takes no parameters and has void as 
		   a return type. It is used in option 5 in the menu of the main program */
		
		System.out.println();
		// Asking the user what is the type of the shape to move
		System.out.println("Enter the type of shape to move (input: \"square\" or \"triangle\"): ");
		String shapeType = scan_str.next().trim().toLowerCase();
		
		/* When the user enters the type of the shape, a list with all the shapes of this type
		   will be created, and the user has to pick one.*/	
		switch(shapeType) {
		
		case "square": // Moving a square
			
			int squareCounter = 0; // Counts how many squares found
			
			// Loop to count the number of squares found
			for(int i = 0; i < shapesCounter; i++) {
				if (shapes[i] instanceof Square) {
					squareCounter++;
				}
			}
			
			// If there is no squares
			if (squareCounter == 0) {
				System.out.println("No squares found.");
			}
			
			else { // Squares found
			
				int count = 1; // This count is used for the list numbering
				int[] squareIndices = new int[shapesCounter]; /* This array stores the indices of each square in the original array */
				System.out.println();
				System.out.println("List of squares found:");
				System.out.println("----------------------");
				for (int i = 0; i < shapesCounter; i++) {
					if (shapes[i] instanceof Square) { // if the shape is a square
						System.out.println(count + ". " + shapes[i].toString()); // printing the list line by line
						squareIndices[count-1] = i; // storing the indices of squares in the array
						count++;
					
					}
				}
 			
				System.out.println();
			
				// Asking for the number of the square to move in the list
				System.out.println("Enter the number of the square to move: ");
				int squareNum = scan_num.nextInt(); // this variable is the number picked in the list
			
				// Asking for the distance to move the square
				System.out.println("Enter the distance by which to move the square: ");
				double distance = scan_num.nextDouble();
			
				// Asking for the direction by which to move the square (vertical or horizontal)
				System.out.println("Enter the direction by which to move the square (input: \"veritcal\" or \"horizontal\"): ");
				String direction = scan_str.next().trim().toLowerCase();
			
				switch (direction) {
			
				case "vertical": // Moving the square vertically
				
					// Asking if the square is to be moved upwards or downwards
					System.out.println("Enter if the square is to be moved upwards or downwards (input: \"up\" or \"down\"): ");
					String upDown = scan_str.next().trim().toLowerCase();
								
					/* squareIndices stores the index of each square of the original array, so to
                	access a specific shape, we write [squareIndices[squareNum - 1]]*/
				
					switch (upDown) { 
				
					case "up": // Moving the square upwards
									
						/* If the distance entered moves the square out of bounds (more than 
					  	200 units long), the Y-coordinate will be set to 100 (maximum)*/
						if (shapes[squareIndices[squareNum-1]].getYcoordinate() + distance > 100) { 
							shapes[squareIndices[squareNum - 1]].setYcoordinate(100);
							System.out.println("Shapes cannot exceed 200 units long or wide. Y-coordinate is now set to 100.");
							System.out.println("This square's new coordinates are: (" + shapes[squareIndices[squareNum-1]].getXcoordinate() + "," + shapes[squareIndices[squareNum-1]].getYcoordinate() + ")");

						} // If the square will not be moved out of bounds, we add the distance to the Y coordinate.
						else {
							shapes[squareIndices[squareNum - 1]].setYcoordinate(shapes[squareIndices[squareNum-1]].getYcoordinate() + distance);
							System.out.println("This square's new coordinates are: (" + shapes[squareIndices[squareNum-1]].getXcoordinate() + "," + shapes[squareIndices[squareNum-1]].getYcoordinate() + ")");
						}
						break;
					
					case "down": // Moving the square downwards
					
						/* If the distance entered moves the square out of bounds (less than 
					  	200 units long), the Y-coordinate will be set to -100 (minimum)*/
						if (shapes[squareIndices[squareNum-1]].getYcoordinate() - distance < -100) {
							shapes[squareIndices[squareNum - 1]].setYcoordinate(-100);
							System.out.println("Shapes cannot exceed 200 units long or wide. Y-coordinate is now set to -100.");
							System.out.println("This square's new coordinates are: (" + shapes[squareIndices[squareNum-1]].getXcoordinate() + "," + shapes[squareIndices[squareNum-1]].getYcoordinate() + ")");
						}
						else { // If the square will not be moved out of bounds, we subtract the distance from the Y coordinate.					
							shapes[squareIndices[squareNum-1]].setYcoordinate(shapes[squareIndices[squareNum-1]].getYcoordinate() - distance);
							System.out.println("This square's new coordinates are: (" + shapes[squareIndices[squareNum-1]].getXcoordinate() + "," + shapes[squareIndices[squareNum-1]].getYcoordinate() + ")");
						}
						break;
					
					default:
						System.out.println("Invalid input."); // if none of "down" or "up" is entered, invalid input
						break;
					}
					break;			
				
				case "horizontal": // Moving the square horizontally
				
					// Asking the user if the square is to be moved left or right
					System.out.println("Enter if the object is to be moved left or right (input: \"left\" or \"right\"): ");
					String leftRight = scan_str.next().trim().toLowerCase();
				
					switch(leftRight) {
				
					case "right": // Moving the square right		
					
						/* If the distance entered moves the square out of bounds (more than 
					  	200 units wide), the x-coordinate will be set to 100 (maximum)*/
						if (shapes[squareIndices[squareNum-1]].getXcoordinate() + distance > 100) {
							shapes[squareIndices[squareNum - 1]].setXcoordinate(100);
							System.out.println("Shapes cannot exceed 200 units long or wide. X-coordinate is now set to 100");
							System.out.println("This square's new coordinates are: (" + shapes[squareIndices[squareNum-1]].getXcoordinate() + "," + shapes[squareIndices[squareNum-1]].getYcoordinate() + ")");

						}
						else { // If the square will not be moved out of bounds, we add the distance to the X-coordinate.
							shapes[squareIndices[squareNum-1]].setXcoordinate(shapes[squareIndices[squareNum-1]].getXcoordinate() + distance);
							System.out.println("This square's new coordinates are: (" + shapes[squareIndices[squareNum-1]].getXcoordinate() + "," + shapes[squareIndices[squareNum-1]].getYcoordinate() + ")");
						}
						break;
					
					case "left": // Moving the square left
					
						/* If the distance entered moves the square out of bounds (less than 
					  	200 units wide), the x-coordinate will be set to -100 (minimum)*/
						if (shapes[squareIndices[squareNum-1]].getXcoordinate() - distance < -100) {
							shapes[squareIndices[squareNum - 1]].setXcoordinate(-100);
							System.out.println("Shapes cannot exceed 200 units long or wide. X-coordinate is now set to -100");
							System.out.println("This square's new coordinates are: (" + shapes[squareIndices[squareNum-1]].getXcoordinate() + "," + shapes[squareIndices[squareNum-1]].getYcoordinate() + ")");

						} // If the square will not be moved out of bounds, we subtract the distance from the X-coordinate.
						shapes[squareIndices[squareNum-1]].setXcoordinate(shapes[squareIndices[squareNum-1]].getXcoordinate() - distance);
						System.out.println("This square's new coordinates are: (" + shapes[squareIndices[squareNum-1]].getXcoordinate() + "," + shapes[squareIndices[squareNum-1]].getYcoordinate() + ")");
						break;
					
					default:
						System.out.println("Invalid input."); // if none of "right" or "left" is entered, invalid input.
						break;
					}
					break;
				
				default:
					System.out.println("Invalid input."); // if none of "vertical" or "horizontal" is entered, invalid input.							
				}
				break;
			}
			break;
			
		case "triangle": // Moving a triangle
					
            int triangleCounter = 0; // Counts the number of triangles found
			
            // Loop to count the number of triangles found
			for(int i = 0; i < shapesCounter; i++) {
				if (shapes[i] instanceof Triangle) {
					triangleCounter++;
				}
			}
			
			// If there no triangles found
			if (triangleCounter == 0) {
				System.out.println("No triangles found");
			}
			
			else { // Triangles found
			
				int count = 1; // This count is used for the list numbering
				int[] triangleIndices = new int[shapesCounter]; /* This array stores the indices of each triangle in the original array */
				System.out.println();
				System.out.println("List of triangles found:");
				System.out.println("------------------------");
				for (int i = 0; i < shapesCounter; i++) {
					if (shapes[i] instanceof Triangle) { // if the shape is a triangle
						System.out.println(count + ". "+ shapes[i].toString()); // printing the list line by line
						triangleIndices[count-1] = i; // storing the indices of triangles in the array
						count++;
					}
				}
			
				System.out.println();
 			
				// Asking for the number of the triangle to move in the list
				System.out.println("Enter the number of the triangle to move: ");
				int triangleNum = scan_num.nextInt();
			
				// Asking for the distance to move the triangle
				System.out.println("Enter the distance by which to move the object: ");
				double distance = scan_num.nextDouble();
			
				// Asking for the direction by which to move the triangle (vertical or horizontal)
				System.out.println("Enter the direction by which to move the object (input: \"veritcal\" or \"horizontal\"): ");
				String direction = scan_str.next().trim().toLowerCase();
			
				switch (direction) {
			
				case "vertical": // Moving vertically
				
					// Asking if the triangle is to be moved upwards or downwards
					System.out.println("Enter if the triangle is to be moved upwards or downwards (input: \"up\" or \"down\"): ");
					String upDown = scan_str.next().trim().toLowerCase();
				
					/* squareIndices stores the index of each square of the original array, so to
                	access a specific shape, we write [squareIndices[squareNum - 1]]*/
				
					switch (upDown) {
				
					case "up": // Moving the triangle upwards
					
						/* If the distance entered moves the triangle out of bounds (more than 
					  	200 units long), the Y-coordinate will be set to 100 (maximum)*/
						if (shapes[triangleIndices[triangleNum-1]].getYcoordinate() + distance > 100) {
							shapes[triangleIndices[triangleNum - 1]].setYcoordinate(100);
							System.out.println("Shapes cannot exceed 200 units long or wide. Y-coordinate is now set to 100");
							System.out.println("This square's new coordinates are: (" + shapes[triangleIndices[triangleNum-1]].getXcoordinate() + "," + shapes[triangleIndices[triangleNum-1]].getYcoordinate() + ")");
						} // If the triangle will not be moved out of bounds, we add the distance to the Y coordinate.
						else {
							shapes[triangleIndices[triangleNum - 1]].setYcoordinate(shapes[triangleIndices[triangleNum-1]].getYcoordinate() + distance);
							System.out.println("This triangle's new coordinates are: (" + shapes[triangleIndices[triangleNum-1]].getXcoordinate() + "," + shapes[triangleIndices[triangleNum-1]].getYcoordinate() + ")");
						}
						break;
					
					case "down": // Moving the triangle downwards
					
						/* If the distance entered moves the triangle out of bounds (less than 
					  	200 units long), the Y-coordinate will be set to -100 (minimum)*/
						if (shapes[triangleIndices[triangleNum-1]].getYcoordinate() - distance < -100) {
							shapes[triangleIndices[triangleNum - 1]].setYcoordinate(-100);
							System.out.println("Shapes cannot exceed 200 units long or wide. Y-coordinate is now set to -100");
							System.out.println("This square's new coordinates are: (" + shapes[triangleIndices[triangleNum-1]].getXcoordinate() + "," + shapes[triangleIndices[triangleNum-1]].getYcoordinate() + ")");
					
						} // If the triangle will not be moved out of bounds, we subtract the distance from the Y coordinate.
						else {					
							shapes[triangleIndices[triangleNum-1]].setYcoordinate(shapes[triangleIndices[triangleNum-1]].getYcoordinate() - distance);
							System.out.println("This triangle's new coordinates are: (" + shapes[triangleIndices[triangleNum-1]].getXcoordinate() + "," + shapes[triangleIndices[triangleNum-1]].getYcoordinate() + ")");
						}
						break;
					
					default:
						System.out.println("Invalid input."); // If none of "down" or "up" is entered, invalid input
						break;
					}
					break;			
				
				case "horizontal": // Moving the triangle vertically
				
					// Asking if the triangle is to be moved left or right
					System.out.println("Enter if the object is to be moved left or right: (input: \"left\" or \"right\"): ");
					String leftRight = scan_str.next().trim().toLowerCase();
				
					switch(leftRight) {
				
					case "right": // Moving the triangle right
					
						/* If the distance entered moves the triangle out of bounds (more than 
					  	200 units wide), the X-coordinate will be set to 100 (maximum)*/
						if (shapes[triangleIndices[triangleNum-1]].getXcoordinate() + distance > 100) {
							shapes[triangleIndices[triangleNum - 1]].setXcoordinate(100);
							System.out.println("Shapes cannot exceed 200 units long or wide. X-coordinate is now set to 100");
							System.out.println("This square's new coordinates are: (" + shapes[triangleIndices[triangleNum-1]].getXcoordinate() + "," + shapes[triangleIndices[triangleNum-1]].getYcoordinate() + ")");
						}
						// If the triangle will not be moved out of bounds, we add the distance to the Y coordinate.
						else {
							shapes[triangleIndices[triangleNum-1]].setXcoordinate(shapes[triangleIndices[triangleNum-1]].getXcoordinate() + distance);
							System.out.println("This triangle's new coordinates are: (" + shapes[triangleIndices[triangleNum-1]].getXcoordinate() + "," + shapes[triangleIndices[triangleNum-1]].getYcoordinate() + ")");
						}
						break;
					
					case "left": // Moving the triangle right		
					
						/* If the distance entered moves the triangle out of bounds (less than 
					  	200 units wide), the X-coordinate will be set to -100 (minimum)*/
						if (shapes[triangleIndices[triangleNum-1]].getXcoordinate() - distance < -100) {
							shapes[triangleIndices[triangleNum - 1]].setXcoordinate(-100);
							System.out.println("Shapes cannot exceed 200 units long or wide. X-coordinate is now set to -100");
							System.out.println("This square's new coordinates are: (" + shapes[triangleIndices[triangleNum-1]].getXcoordinate() + "," + shapes[triangleIndices[triangleNum-1]].getYcoordinate() + ")");
						}
						// If the triangle will not be moved out of bounds, we subtract the distance from the X coordinate.
						else {
							shapes[triangleIndices[triangleNum-1]].setXcoordinate(shapes[triangleIndices[triangleNum-1]].getXcoordinate() - distance);
							System.out.println("This triangle's new coordinates are: (" + shapes[triangleIndices[triangleNum-1]].getXcoordinate() + "," + shapes[triangleIndices[triangleNum-1]].getYcoordinate() + ")");
						}
						break;
					
					default:
						System.out.println("Invalid input."); // If none of "left" or "right" is entered, invalid input.
						break;
					}
					break;
				
				default:
					System.out.println("Invalid input."); // If none of "vertical" or "horizontal" is entered, invalid input.
					break;							
			    }
				break;
			}
			default:
				System.out.println("Invalid input."); // if none of "square" or "triangle" is entered, invalid input.
				break;
		}
				
	}
	
	public void readFile() {
		/* This method is used just for the design, it displays the content
		   of the file so the user can see what they are adding to the array.
		   It takes no parameters and has void as return type*/
		
		// Directory of input.txt
		String input = "C:\\Users\\hp\\Desktop\\Fall 2021\\CSC245 (2)\\Workspaces\\AssignmentsWorkspace\\Assignment2\\src\\asst2\\input.txt";
		
		// Creating file
		File file = new File(input);
		
		try {
			
			@SuppressWarnings("resource")
			Scanner scan_file = new Scanner(file);
			
			System.out.println();
			System.out.println("The file input.txt contains the following information: ");
			System.out.println("------------------------------------------------------");
			
			while (scan_file.hasNextLine()) { // Loop to read lines and print
				
				String[] line = scan_file.nextLine().split(", ");

			    System.out.print(line[0] + ", "); // shape
			    System.out.print(line[1] + ", "); // color
			    System.out.print(line[2] + ", "); // x-coordinate
			    System.out.println(line[3]); // y-coordinate
			}
						
		}
		// If file not found
		catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
	
	public void addFileContent() {
		/* This method adds the content of the file input.txt to the array.
		   It adds it line by line, and the user has to input the remaining
		   fields of each shape in the line. This method takes no parameters
		   and has void as return type. */
		
		// Directory of input.txt
		String input = "C:\\Users\\hp\\Desktop\\Fall 2021\\CSC245 (2)\\Workspaces\\AssignmentsWorkspace\\Assignment2\\src\\asst2\\input.txt";
		
		// Creating new file
		File file = new File(input);
		
		try {
			
			@SuppressWarnings("resource")
			Scanner scan_file = new Scanner(file);
			
			int lineCounter = 1; // Specifies which line is being added.
			
			while (scan_file.hasNextLine()) { // loop to read and print the file
				
				System.out.println();
				System.out.println("Adding line " + lineCounter + ":");
				System.out.println("-------------");
				lineCounter++;
				
				String[] line = scan_file.nextLine().split(", ");
				
				System.out.print(line[0] + ", "); // shape
				System.out.print(line[1] + ", "); // color
				System.out.print(line[2] + ", "); // x-coordinate
				System.out.println(line[3]); // y-coordinate
				
				// Storing each line in variables
				String shapeType = line[0];
				String color = line[1];
				double x = Double.parseDouble(line[2]);
				double y = Double.parseDouble(line[3]);
				
				switch (shapeType) {
				
				case "circle": // Line contains a circle
					
					System.out.println();
					
					// Asking for the radius
					System.out.println("Enter the radius of the circle: ");
					double radius = scan_num.nextDouble();
					
					// Radius must be positive
					while (radius < 0) {
						System.out.println("Enter a positive radius: ");
						radius = scan_num.nextDouble();
					}
					
					Shape circle = new Circle(color, x, y, radius);
					
					add(circle); // adding
					break;
					
				case "square": // Line contains a square
					
					System.out.println();
					
					// Asking for the side length
					System.out.println("Enter side length: ");
					double sideLength = scan_num.nextDouble();
					
					// side length must be positive
					while (sideLength < 0) {
						System.out.println("Enter a positive side length: ");
						sideLength = scan_num.nextDouble();
					}
					
					Shape square = new Square(color, x, y, sideLength);
					
					add(square); // adding
					break;
					
				case "triangle": // Line contains a triangle
					
					System.out.println();
					
					// Asking for the sides
					System.out.println("Enter side A: ");
					double sideA = scan_num.nextDouble();
					
					// Sides must be positive
					while (sideA < 0) {
						System.out.println("Enter a positive side: ");
						sideA = scan_num.nextDouble();
					}
					
					System.out.println("Enter side B: ");
					double sideB = scan_num.nextDouble();
					
					// Sides must be positive
					while (sideB < 0) {
						System.out.println("Enter a positive side: ");
						sideB = scan_num.nextDouble();
					}
					
					System.out.println("Enter side C: ");
					double sideC = scan_num.nextDouble();
					
					// Sides must be positive
					while (sideC < 0) {
						System.out.println("Enter a positive side: ");
						sideC = scan_num.nextDouble();
					}
					
					Shape triangle = new Triangle(color, x, y, sideA, sideB, sideC);
					
					add(triangle); // adding
					break;
					
				case "equilateral triangle": // Line contains an equilateral triangle
									
					System.out.println();
					
					// Asking for a side's length
					System.out.println("Enter a side's length: ");
					double side = scan_num.nextDouble();
					
					// Must be positive
					while (side < 0) {
						System.out.println("Enter a positive side: ");
						side = scan_num.nextDouble();
					}
					
					Shape eqTriangle = new EquilateralTriangle(color, x, y, side, side ,side);
					
					add(eqTriangle); // adding
					break;
					
				default: // In case none is entered
					System.out.println("Invalid information in the line, skipping");
					break;
					
				}
				
			}
			
		}
		// If file is not found
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
	
	}

	public void exitProgram() {
		/* This method copies the content of the array to the file 
		   output.txt and exists the program. It takes no parameters
		   and has void as return type. */
		
		// In case the array is empty
		if (shapesCounter == 0) {
			System.out.println();
			System.out.println("No information found in the array to transfer to output.txt.");
			System.out.println("Program terminated.");
			System.exit(0); // exit
		}
		
		else {		 
			// directory of output.txt
		    String output = "C:\\Users\\hp\\Desktop\\Fall 2021\\CSC245 (2)\\Workspaces\\AssignmentsWorkspace\\Assignment2\\src\\asst2\\output.txt";
		
		    try {
			  
		        FileWriter fw = new FileWriter(output);
		        PrintWriter output_file = new PrintWriter(fw);
		  			    	
		    	// copying the information to output.txt
		        for (int i = 0; i < shapesCounter; i++) {	    
		    	    // Printing content of the array into the file
		    	    output_file.println(shapes[i].transferData()); /* transferData() is the method defined in each class
		    	                                                  that copies information about each shape to the file
		    	                                                  output.txt */	    			
		        }			    	
		        // closing the file
		        output_file.close();
		    
		    // If the file not found
		    } catch(FileNotFoundException exception) {	
			    System.out.println("The file " + output + " is not found");
			
			// IO exception
		    } catch(IOException exception) {
			    System.out.println("IO exception");
		    }
		
		    System.out.println();
		    System.out.println("Information in the array are transfered to the file output.txt");
		    System.out.println("Program terminated.");
		    System.exit(0); // Exit the program
	   }
	}

	public static void main (String[] agrs) {
		
		MyShapes s = new MyShapes();
		
		@SuppressWarnings("resource")
		Scanner scan_main = new Scanner(System.in);
		
		byte attempts = 4; // If it reaches 0 the program terminates
		byte sentinel = 1; // Used to keep displaying the menu
		
		while (sentinel == 1) { // Loop to keep displaying the menu
			
			// MAIN MENU
			System.out.println();
			System.out.println("1. Add a shape\n"
					+ "2. Delete a shape\n"
					+ "3. Compute Area and Perimeter\n"
					+ "4. Display All\n"
					+ "5. Move an object\n"
					+ "6. Read from file\n"
					+ "7. Exit\n"
					+ "------------------------------\n"
					+ "Enter your choice: ");	    		

			int option = scan_main.nextInt();
			
			while (option < 1 || option > 7) { // loop to force the user to enter a choice between 1 and 7
				
				System.out.println("Enter a valid option: (" + attempts + " attempts left).");
				option = scan_main.nextInt();
				attempts--; // decrementing the attempts left		
				
				// If attempts limit is reached and no valid option in entered
				if (attempts == 0 && option != 1 && option != 6 && option != 7) {
					System.out.println("Program terminated due to 5 invalid inputs.");
					System.exit(0); // exit the program
				}
			}
			
			/* Loop to force the user to choose 1 or 6, both options add to the array,
			   or 7 to exit the program. If there is no shapes in the array, the other
			   options will be locked */
			while (option != 1 && option != 6 && option != 7 && s.shapesCounter == 0) {
					
				System.out.println();
				System.out.println("No shapes added (" + attempts + " attempts left).\n"
						+ "Currently available options:\n"
						+ "1 --> to add manually\n"
						+ "6 --> to add the content of the file\n"
						+ "7 --> to exit\n"
						+ "Enter: ");
					
				option = scan_main.nextInt();
				attempts--;
				
				// Resetting the attempts to 4 if option 1 or 6 is entered
				if (option == 1 || option == 6) {
					attempts = 4;
				}
				
				// If attempts limit is reached and no valid option is entered
				if (attempts == 0 && option != 1 && option != 6 && option != 7) {
						System.out.println("Program terminated due to 5 invalid inputs.");
						System.exit(0); // exit the program
				}
			}
			
			switch (option) {
			
			case 1: // Add a shape
				s.addShape();
				break;
				
			case 2: // Delete a shape
				s.deleteShape();
				break;
				
			case 3: // Compute area and perimeter
				s.ComputeAandP();
				break;
				
			case 4: // List all the shapes
				s.listShapes();
				break;
				
			case 5: // Move a square or a triangle
				s.moveObject();
				break;
			
			case 6: // Read a file then add it to the array
				s.readFile();
				s.addFileContent();
				break;
				
			case 7: // Copy array content to output.txt then exit the program
				s.exitProgram();
				break;
				
			default:
				break;
			}
		}	
	}			
}
