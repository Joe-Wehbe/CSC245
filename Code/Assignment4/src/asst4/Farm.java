
/*________________________________________________________________________________________________________________________
NAME: Joe Wehbe                                                                                                                                                                                                                       
ID#: 202000908                                                                                                                                                                                                                         
COURSE: Objects and Data Abstraction (CSC245)                                                                                                                                                                                          
DATE LAST MODIFIED: 10/17/2021                                                                                                                                                                                                         
OTHER FILES: Animal.java, Chicken.java, Cow.java, Goat.java, Horse.java, Lamb.java, Node.java, Sortable.java, TestProgram.java, 
             input.txt, output.txt                                                                                                             
PROGRAM DESCRIPTION: This program manages the animals in a farm. A menu is diplayed where the user can add animals, search
                     for a specific type, and sort the animals by type.                                            
_________________________________________________________________________________________________________________________
                                                                                                                     */

package asst4;

import java.util.Scanner;

public class Farm {
		
	Scanner scan_num = new Scanner(System.in); // Scanner for numbers
	Scanner scan_string = new Scanner(System.in); // Scanner for strings
	
	// defining header
	private Node header;
	
	// Constructor of the class
	public Farm() {
		header = null;
	}
	
	// Getters and Setters
	public Node getHeader() {
		return header;
	}
	
	public void setHeader(Node header) {
		this.header = header;
	}
	
	public int size() {		
	/* Method that counts how many nodes are in the linked list. 
	   It takes no parameters and has int as return type */
		
		Node current = header; // setting current to the first node
		int counter = 0; // counter for the nodes
		
		while (current != null) { // loop to iterate over the nodes
			current = current.getNext(); // jumping to the next node
			counter++; // incrementing the counter
		}
		return counter;
	}
	
	
	public void add(Animal a) { 
		/* Method that actually adds an animal to the end of the linked list,
		   it is used in the addAnimal() method. It takes one parameter
		   of type Animal and has void as return type*/
		
		Node animal = new Node(a);
		
		if (header == null) { // if the linked list is empty
			header = animal; // set the header to animal
		}
		
		else {
			Node current = header; // setting current to the first node
		
			for(int i = 0; i < size() - 1; i++) { // iterating to the end of the linked list
				current = current.getNext();
			}
			current.setNext(animal); // adding the animal to the end of the linked list
		}			
	}
	
	
	public void addAnimal() {
		/* Method used in option 1 to add an animal to the linked list.
		   It takes no parameters and has void as return type*/
		
		// Menu of the animals that the user can add
		System.out.println();
		System.out.println("--> Cow");
		System.out.println("--> Goat");
		System.out.println("--> Lamb");
		System.out.println("--> Horse");
		System.out.println("--> Chicken");
		System.out.println();
				
		System.out.println("Enter animal type: ");	
		String animalType = scan_string.next().trim().toLowerCase();
		
		// Asking for the characteristics
		System.out.println("Enter age: ");
		int age = scan_num.nextInt();
		
		System.out.println("Enter color: ");
		String color = scan_string.next();
		
		System.out.println("Enter the gender: (Enter: \"male\" or \"female\") ");
	    String gender = scan_string.next();
	    
	    // if an invalid gender is entered, re-ask the user to enter it
	    while (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")) {
	    	System.out.println("Please enter \"male\" or \"female\": ");
	    	gender = scan_string.next();
	    }
		
		switch(animalType) {
		
		case "cow": // adding a cow
			
			Animal cow = new Cow(age, color, gender);
			add(cow);
			break;
			
		case "goat": // adding a goat
			
			Animal goat = new Goat(age, color, gender);
			add(goat);
			break;
			
		case "lamb": // adding a lamb
			
			Animal lamb = new Lamb(age, color, gender);
			add(lamb);
			break;
			
		case "horse": // adding a horse
			
			Animal horse = new Horse(age, color, gender);
			add(horse);
			break;
			
		case "chicken": // adding a chicken
			
			Animal chicken = new Chicken(age, color, gender);
			add(chicken);
			break;
			
		default: // if none of the above is entered	
			System.out.println("Invalid input");
			break;
			
		}
		
	}

	
	public void searchAnimal() {
		/* Method used in choice 2 to search for a specific type of
		   animals. It takes no parameters and has void as return type*/
		
		// animals that can be search for
		System.out.println();
		System.out.println("--> Cow");
		System.out.println("--> Goat");
		System.out.println("--> Lamb");
		System.out.println("--> Horse");
		System.out.println("--> Chicken");
		System.out.println();
		
		System.out.println("Enter animal type: ");	
		String animalType = scan_string.next().trim().toLowerCase();
		System.out.println();
		
		Node current = header;
		
		switch(animalType) {
		
		case "cow": // searching for all cows
			
			while (current != null ) {			
				if (current.getInfo() instanceof Cow) { // if the current node contains a cow
					System.out.println(current.getInfo().toString()); // print it
				}
				current = current.getNext(); // jump to the next node
			}

			
			break;
			
		case "goat": // searching for all goats
			
			while (current != null ) {				
				if (current.getInfo() instanceof Goat) { // if the current node contains a goat
					System.out.println(current.getInfo().toString()); // print it		
				}
				current = current.getNext(); // jump to the next node
			}
			break;
			
		case "lamb": // searching for all lambs
			
			while (current != null ) {			
				if (current.getInfo() instanceof Lamb) { // if the current node contains a lamb
					System.out.println(current.getInfo().toString()); // print it			
				}
				current = current.getNext(); // jump to the next node
				
			}
			break;
			
		case "horse": // searching for all horses
			
			while (current != null ) { 			
				if (current.getInfo() instanceof Horse) { // if the current node contains a horse
					System.out.println(current.getInfo().toString()); // print it				
				}
				current = current.getNext(); // jump to the next node	 
			}
			break;
			
		case "chicken": // searching for all cows
			
			while (current != null ) { 		
				if (current.getInfo() instanceof Chicken) { // if the current node contains a chicken
					System.out.println(current.getInfo().toString()); // print it
				}
				current = current.getNext(); // jump to the next node	
			}
			break;
			
		default: // if none of the above cases is entered, invalid		
			System.out.println("Invalid input");
			break;
			
		}
		
	}
	
	
	
	public void categorize() {
		/* Method used in option 3 of the menu, it prints the content
		   of the linked list alphabetically by type. It takes no parameters
		   and the return type is void. */
		
		Node current = header;
			
		while(current != null) { // loop to print all chickens
			if (current.getInfo() instanceof Chicken) { // if the current node is a chicken
				System.out.println(current.getInfo().toString()); // print it
			}
			current = current.getNext(); // jump to next node
		}		
		current = header; // resetting current to the beginning of the linked list
		
		while(current != null) { // loop to print all cows
			if (current.getInfo() instanceof Cow) { // if the current node is a Cow
				System.out.println(current.getInfo().toString()); // print it
			}
			current = current.getNext(); // jump to next node
		}		
        current = header; // resetting current to the beginning of the linked list
		
		while(current != null) { // loop to print all goats
			if (current.getInfo() instanceof Goat) { // if the current node is a goat
				System.out.println(current.getInfo().toString()); // print it
			}
			current = current.getNext(); // jump to next node
		}
		current = header; // resetting current to the beginning of the linked list
		
		while(current != null) { // loop to print all horses
			if (current.getInfo() instanceof Horse) { // if the current node is a horse
				System.out.println(current.getInfo().toString()); // print it
			}
			current = current.getNext(); // jump to next node
		}	
		current = header; // resetting current to the beginning of the linked list
		
		while(current != null) { // loop to print all lambs
			if (current.getInfo() instanceof Lamb) { // if the current node is a lamb
				System.out.println(current.getInfo().toString()); // print it	 		
			}
			current = current.getNext(); // jump to next node
		}
	}
	
	public void exitProgram() {	
		/* Method used in option 4 of the menu, it exits the program.
		   It takes no parameters and the return type is void. */		
		System.out.println();
		System.out.println("Program terminated.");
		System.exit(0); // exit
	}
	
	public static void main(String[] args) {
		
		
		Farm farm = new Farm();	// instantiating class Farm
		
		@SuppressWarnings("resource")
		Scanner scan_main = new Scanner(System.in); // Scanner for main
		
		byte flag = 1; // variable used to keep displaying the menu
		byte attempts = 4; // attempts for invalid input
		
		while (flag == 1) { // loop to keep displaying the menu
						
			// Menu
			System.out.println();
			System.out.println("1. Add an animal");
			System.out.println("2. Search for an animal");
			System.out.println("3. Categorize");
			System.out.println("4. Exit");
			System.out.println("-----------------------");
			System.out.println("Enter your choice: ");
			
			int choice = scan_main.nextInt();
			
			while (choice < 1 || choice > 4) { // Loop to force the user to enter a choice between 1 and 4
				System.out.println("Enter a valid choice (" + attempts + " attempts left): ");
				choice = scan_main.nextInt();
				attempts--; // decreasing attempts
				
				if (attempts == 0 && choice != 1 && choice != 4) { // if attempts limit reached no valid choice is entered
					System.out.println("Program terminated due to 5 invalid inputs.");
					System.exit(0); // exit the program
				}
			}
			
			while (choice != 1 && choice != 4 && farm.size() == 0) { // Loop to force the user to enter 1 first to add an animal or 5 to exit
				System.out.println("No animals added. Enter choice 1 to add an animal or 4 to exit (" + attempts + " attempts left): ");
				choice = scan_main.nextInt();
				attempts--; // decrementing attempts
				
				if (attempts == 0 && choice != 1 && choice != 4) { // if attempts limit reached no valid choice is entered
					System.out.println("Program terminated due to 5 invalid inputs.");
					System.exit(0); // exit the program
				}
			}
			
			switch (choice) {
			
			case 1: // Add animal
				
				farm.addAnimal();
				break;
				
			case 2: // Search animal 
				
				farm.searchAnimal();
				break;
				
			case 3: // Categorize
				
				farm.categorize();
				break;
				
			case 4: // exit
				
				farm.exitProgram();
				break;
				
			default:
				break;
			}
		}	
	}
}
