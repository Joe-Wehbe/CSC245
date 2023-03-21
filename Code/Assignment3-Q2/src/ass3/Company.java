/*________________________________________________________________________________________________________________________
NAME: Joe Wehbe                                                                                                                                                                                                                       
ID#: 202000908                                                                                                                                                                                                                         
COURSE: Objects and Data Abstraction (CSC245)                                                                                                                                                                                          
DATE LAST MODIFIED: 10/17/2021                                                                                                                                                                                                         
OTHER FILES: Employee.java, Manager.java                                                                                                             
PROGRAM DESCRIPTION: This program manages the employees of a company. A list that consists of many options (add employee,
                     delete employee, list employees, raise salary) is displayed at the beginning of the program where the user 
                     can choose how to manage the employees. An employee can be a manager.                                            
_________________________________________________________________________________________________________________________
                                                                                                                     */

package ass3;

import java.util.Scanner;
import java.util.Vector;

public class Company {
	
	private Vector<Employee> employees; // Vector to store employees
  	
	// Constructor of the class
	public Company() {
		employees = new Vector<Employee>(); 
	}	
	
	Scanner scan_num = new Scanner(System.in); // Scanner for numbers
	Scanner scan_string = new Scanner(System.in); // Scanner for strings
	Scanner scan_boolean = new Scanner(System.in); // Scanner for boolean
	
	public int searchEmployee(String name) {
		/* Method used to search for a specific employee in the array,
		   it is invoked in the addEmployee() and deleteEmployee()
		   methods. It takes 1 parameter (String name) to 
		   search for the employee accordingly. The return type
		   is int(index: found, -1: not found) */
		
		for (int i = 0; i < employees.size(); i++) {			
			// an employee is searched by their name.
			if (employees.get(i).getName().equals(name)) {
				return i; // employee is found
			}			
		}
		return -1; // employee not found
	}
	
	
	public void addEmployee() {
	   /* Method used in the first option to add an employee
	      to the vector, it takes no parameters, and the 
	      return type is void. It is invoked in the main program.*/
				
		// Asking for the name of the employee from the user
		System.out.println("Enter the name: ");
		String name = scan_string.next();
		
		int isFound = searchEmployee(name); // Searching if the name already exists
		
		if (isFound != -1) { // Employee with the entered name exists
			System.out.println("Employee already exists.");
		}
		
		else { // Employee with the entered name does not exist, adding
			
			// Asking from the user for the remaining characteristics of the employee
			System.out.println("Enter Hire Day: ");
			String hireDay = scan_string.next();
			
			System.out.println("Enter salary: ");
			double salary = scan_num.nextDouble();
			
			// Specifying whether the employee is a manager or not
			System.out.println("Is the employee a manager (Input: \"true\" or \"false\"): ");
			boolean isManager = scan_boolean.nextBoolean();
			
			if (isManager == true) { // if the employee is a manager
				
				// Asking for the secretary name
				System.out.println("Enter the name of the secretary: ");
				String secretaryName = scan_string.next();
				
				// Creating a new Manager
				Employee manager = new Manager(name, hireDay, salary, secretaryName);
				employees.add(manager); // adding
			}
			
			else { // If the employee is not a manager
				
			    // Creating a new employee
			    Employee employee = new Employee(name, hireDay, salary);
			    employees.add(employee); // adding 
			}
			
		}
		
		
	}
	
	public void deleteEmployee() {
	   /* Method used in the second option to remove an employee
	      from the vector, it takes no parameters, and the
	      return type is void. It is invoked in the main program.*/
		
		// If there is no employees in the company
		if (employees.size() == 0) {
			System.out.println("No employees in the company.");
		}
		
		// If there is at least an employee
		else {
		
			// User has to input the name.		
		    System.out.println("Enter the name: ");
		    String name = scan_string.next();
		
		    // searching for the employee
		    int isFound = searchEmployee(name);
		
		    // Employee not found
		    if (isFound == -1) {
		    	// Nothing to delete, a message is displayed.
			    System.out.println("Employee not found.");
		    }
		    
		    // Employee found
		    else {
		    	// Deleting the employee
			    employees.remove(isFound);			    
			    System.out.println("The record for the employee has been deleted.");				    			    
		    }
		}
	}
	
	public void raiseSalary() {
		/* Method used in option 3 to raise the salary of a specific
		  employee. This method takes no parameters and the return type
		  is void. It is invoked in the main program, option 3.*/
			
		// Asking from the user the name of the employee
		System.out.println("Enter the name of the employee to raise their salary: ");
	    String name = scan_string.next();
	 	    
	    int isFound = searchEmployee(name); // searching for the employee
	    
	    if (isFound != -1) { // employee found
	    	
	    	// If the found employee is a manager
	    	if (employees.get(isFound) instanceof Manager) {
	    		
	    		// Asking for the percentage of the raise
	    		System.out.println("Enter the percentage of the raise: ");
	    		double raisePerc = scan_num.nextDouble();
	    		
	    		// Incrementing the salary by the percentage entered
	    		double currentSalary = employees.get(isFound).getSalary();	    		
	    		employees.get(isFound).setSalary(currentSalary + currentSalary * raisePerc / 100);
	    		
	    		// Adding the bonus since the employee is a manager
	    		double updatedSalary = employees.get(isFound).getSalary();    		
	    		employees.get(isFound).setSalary(updatedSalary + updatedSalary * ((Manager)employees.get(isFound)).addBonus());
	    		
	    		System.out.println("This employee's new salary is: " + employees.get(isFound).getSalary());

	    	}
	    	
	    	else { // If the employee is not a manager
	    		
	    		// Asking for the percentage of the raise.
	    		System.out.println("Enter the percentage of the raise: ");
	    		double raisePerc = scan_num.nextDouble();
	    		
	    		// Incrementing the salary by the percentage entered.
	    		
	    		double currentSalary = employees.get(isFound).getSalary();
	    		employees.get(isFound).setSalary(currentSalary + currentSalary * raisePerc / 100);
	    		
	    		System.out.println("This employee's new salary is: " + employees.get(isFound).getSalary());
	    	}
	    }
	    else { // If the employee is not found
	    	System.out.println("Employee not found.");
	    }
	       
 
	}
	
	public void listAll() {
		/* Method used in option 4 to list all the employees in the
		  vector. This method takes no parameters and the return type
		  is void. It is invoked in the main program.*/
				
		System.out.println();
		for (int i = 0; i < employees.size(); i++) {
			System.out.println(employees.get(i).toString());
		}
	}
	
	public void exitProgram() {
		/* Method used in option 5 to terminate the program.
		  This method takes no parameters and the return type
		  is void. It is invoked in the main program.*/
				
		System.out.println("Program terminated.");
		System.exit(0);
	}
	
	// MAIN PROGRAM
	public static void main (String[] args) {
		
		// Instantiating
		Company company = new Company();
		
		byte sentinel = 0; // variable used to keep displaying the menu.
				
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		while (sentinel == 0) {
			
			// Menu
			System.out.println();
			System.out.println("1. Add employee");
			System.out.println("2. Delete employee");
			System.out.println("3. Raise salary");
			System.out.println("4. List all");
			System.out.println("5. Exit");		
			System.out.println("-------------------");		
			System.out.println("Enter your choice: ");
			
		    int option = scanner.nextInt();
		    
		    byte attempts = 4; // 5 attempts allowed
		    
		    while (option < 1 || option > 5) { // loop to force the user to input a number between 1 and 5.
		    	System.out.println("Invalid option. Enter a valid choice: ("  + attempts + " attempts left)");
		    	option = scanner.nextInt();
		    	attempts--; // decrementing the number of attempts.
		    	
		    	if (attempts == 0 && option != 1 && option != 5) { // if attempts limit reached, terminate the program.
		    		System.out.println("Program terminated due to 5 invalid choice attempts.");
		    		System.exit(0); // Exit the program
		    		
		    	}
		    }		    
		    	
		    if (option != 1 && option != 5 && company.employees.size() == 0) { // forcing the user to input 1 first to add an employee
		    	while (option != 1) { 
		    		System.out.println("No employees in the company. Enter option 1 to add an employee: (" + attempts + " attempts left) ");
		    		option = scanner.nextInt();
		    	    attempts--; // decrementing the number of attempts
		    			
		    		if (attempts == 0 && option != 1 && option != 5) { // if attempts limit reached, terminate the program.
		    			System.out.println("Program terminated due to 5 invalid choice attempts.");
				    	System.exit(0); // Exit the program
		    		}
		    	}
		    }
		    
		    	
		    switch (option) {
		    	
		    case 1: // add employee
		    		
		    	company.addEmployee();		    		
		    	break;
		    		
		    case 2: // delete employee
		    		
		    	company.deleteEmployee();
		    	break;
		    	
		    case 3: // raise salary
		    		
		    	company.raiseSalary();
		    	break;
		    		
		    case 4: // list all employees
		    		
		    	company.listAll();
		    	break;
		    		
		    case 5: // exit program
		    		
		    	company.exitProgram();
		    	break;
		    		
		    default:
		    	break;
		    }		   
		    
	    }
		
	}

}
