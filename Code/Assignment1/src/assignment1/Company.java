/*________________________________________________________________________________________________________________________
  NAME: Joe Wehbe                                                                                                                                                                                                                       
  ID#: 202000908                                                                                                                                                                                                                         
  COURSE: Objects and Data Abstraction (CSC245)                                                                                                                                                                                          
  DATE LAST MODIFIED: 9/28/2021                                                                                                                                                                                                         
  OTHER FILES: Employee.java                                                                                                                  
  PROGRAM DESCRIPTION: This program manages the employees of a company. A list that consists of many options (add employee,
                       delete employee, list employees...) is displayed at the beginning of the program where the user 
                       can choose how to manage the employees.                                                   
 _________________________________________________________________________________________________________________________
                                                                                                                       */
package assignment1;

import java.util.Scanner;

public class Company {
	
	private Employee[] employees; // Array to store employees
	private int count; // counts the number of employees in the array
	private static byte flag = 0; /* used to lock and unlock options 2,3,4 depending on
	                                 whether there are employees or not in the array */ 	
	// Constructor of the class
	public Company() {
		employees = new Employee[10]; // size set to 10 by default
		count = 0;
	}
	
	Scanner scan_num = new Scanner(System.in);
	Scanner scan_string = new Scanner(System.in);
	
	public void increaseCapacity() {
		/* Method used to increase the size of the array once it 
		   is full. It takes no parameters and the return type is void.
		   It is invoked in the method addEmployee() */
				
		if (count == employees.length) { // when the array is full
			Employee[] temp = new Employee[employees.length * 2]; // creating a temporary array
			for (int i = 0; i < count; i++) {
				temp[i] = employees[i]; // copying the elements to the temporary array
			}
			employees = temp;
		}
	}
	
	public boolean searchEmployee(String name, String hireDay) {
		/* Method used to search for a specific employee in the array,
		   it is invoked in the addEmployee() and deleteEmployee()
		   methods. It takes 2 parameters (name and hire day) to 
		   search for the employee accordingly. The return type
		   is boolean (true: found, false: not found) */
		
		for (int i = 0; i < count; i++) {			
			// an employee is searched by their name and hire day.
			if (employees[i].getName().equals(name) && employees[i].getHireDay().equals(hireDay)) {
				return true; // employee is found
			}			
		}
		return false; // employee not found
	}
	
	
	public void addEmployee() {
	   /* Method used in the first option to add an employee
	      to the array, it takes no parameters, and the 
	      return type is void. It is invoked in the main program.*/
		
		flag = 0; // flag set to 0 to unlock options 2,3,4.
		
		// Asking for the characteristics of the employee from the user
		System.out.println("Enter the name: ");
		String name = scan_string.next();
		
		System.out.println("Enter Hire Day: ");
		String hireDay = scan_string.next();
		
		System.out.println("Enter salary: ");
		double salary = scan_num.nextDouble();
		
		// instantiating and creating a new employee
		Employee employee = new Employee(name, hireDay, salary);
		
		// Searching for the employee to be added.
		boolean isFound = searchEmployee(name, hireDay);
		
		// If the employee is not found, it is added to the array
		if (isFound == false) {
			increaseCapacity(); // Method invoked to increase the capacity once the array is full
			employees[count] = employee; // adding the employee to the array
			count++; // incrementing the number of employees.
		}
		/* If the employee is found in the array, a message will be displayed
		   because we cannot have 2 employees of the same name and hire day. */
		else {
			System.out.println("Employee already exists.");
		}		
		
	}
	
	public void deleteEmployee() {
	   /* Method used in the second option to remove an employee
	      from the array, it takes no parameters, and the
	      return type is void. It is invoked in the main program.*/
		
		// If there is no employees in the company
		if (count == 0) {
			System.out.println("No employees in the company.");
			flag = 1; // set the flag to 1 to lock options 2,3 and 4.
		}
		
		// If there is at least an employee
		else {
		
			// User has to input the name and hire day.
		
		    System.out.println("Enter the name: ");
		    String name = scan_string.next();
		
		    System.out.println("Enter Hire Day: ");
		    String hireDay = scan_string.next();
		
		    // searching for the employee
		    boolean isFound = searchEmployee(name, hireDay);
		
		    // Employee not found
		    if (isFound == false) {
		    	// Nothing to delete, a message is displayed.
			    System.out.println("Employee not found.");
		    }
		    
		    // Employee found
		    else {
		    	// Deleting the employee
			    for (int i = 0; i < count; i++) {		     
			    	if (employees[i].getName().equals(name) && employees[i].getHireDay().equals(hireDay)) {
				    	employees[i] = employees[count -1]; // employee at the last index replaces the one to be deleted
				    	employees[count - 1] = null; // last index is now null
					    count--; // decrementing the number of employees
					    
					    System.out.println("The record for the employee has been deleted.");
				    }
			    }
		    }
		}
	}
	
	public void raiseSalary() {
		/* Method used in option 3 to raise the salary of a specific
		  employee. This method takes no parameters and the return type
		  is void. It is invoked in the main program.*/
		
		// Asking from the user the name of the employee
		System.out.println("Enter the name of the employee to raise their salary: ");
	    String name = scan_string.next();
	 	    
	    int indices[] = new int[count]; /* This array stores the indices of the chosen employees
	                                       that have the same name. */
	    
	    int empCount = 0; // This counter is used for the list numbering.
	    
	    int counter = 0; /* This counter is used to point at the index in the array "indices"
	                       to which the index of the employee will be added */
	    
	    int generalCounter = 0; // This counter is used to count how many employees have the same name.
	    
	    // Loop to count the employees with the chosen name
	    for (int i = 0; i < count; i++) {
	    	if (employees[i].getName().equals(name)) {
	    		generalCounter++;
	    	}
	    }
	    
	    // if there is no employees with the chosen name
	    if (generalCounter == 0) { 
	    	System.out.println("No employees found.");
	    }
	    	    	    
	    // If there is more than one employee with the same name.
	    if (generalCounter > 1) {
	    	
		    System.out.println(); 
    	    
		    System.out.println("List of employees with the name: " + "\"" + name + "\"");
		    System.out.println("--------------------------------");
	    	
		    // Looking for all the employees that have the same name.
		    for (int i = 0; i < count; i++) {
		    	if (employees[i].getName().equals(name)) {
		    		empCount++; 
		    		System.out.println(empCount + ". " + name + ", " + employees[i].getHireDay()); // Printing the list line by line.
		    		indices[counter] = i; // storing the indices of the employees with the same name.
		    		counter++;
		    	}
		    }
	    
	        System.out.println();
	    
	        // Asking for the number of the employee in the list.
	        System.out.println("Enter the number of the employee: ");
	        int empNum = scan_num.nextInt();    
	    
	        System.out.println();
	    
	        /* empNum is the number that the user picked from the list, so indices[empNum -1] 
	           will be the number stored in "indices" that is the index of the chosen employee in the original
	           array, we can access it to raise the salary by writing: employees[indices[empNum - 1]] */
	    
	        // Displaying the salary of the chosen employee 
	        System.out.println("This employee's salary is: " + employees[indices[empNum - 1]].getSalary());
	    
	        // Asking for the percentage of the raise
	        System.out.println("Enter the percentage of the raise: ");
	        double raisePerc = scan_num.nextDouble();
	    
	        // Formula to increase the salary: salary + salary * raise / 100
	        employees[indices[empNum -1]].setSalary(employees[indices[empNum - 1]].getSalary() + employees[indices[empNum - 1]].getSalary() * raisePerc / 100);
	    
	        System.out.println("Salary increased by " + raisePerc + "%");
	        System.out.println("New salary: " + employees[indices[empNum - 1]].getSalary());
	    } 
	    
	    /* if there is only one employee with the chosen name,
	       a list will not be created, the user just has to input 
	       the raise percentage.
	     */
	    if (generalCounter == 1) {
		    	
	    	System.out.println();
	    	
	    	// The index of this employee will be 0 so: employees[indices[0]]
	    	// Displaying the salary of the chosen employee 
	        System.out.println("This employee's salary is: " + employees[indices[0]].getSalary());
	    
	        // Asking for the percentage of the raise
	        System.out.println("Enter the percentage of the raise: ");
	        double raisePerc = scan_num.nextDouble();
	    
	        // Formula to increase the salary: salary + salary * raise / 100
	        employees[indices[0]].setSalary(employees[indices[0]].getSalary() + employees[indices[0]].getSalary() * raisePerc / 100);
	    
	        System.out.println("Salary increased by " + raisePerc + "%");
	        System.out.println("New salary: " + employees[indices[0]].getSalary());
		}	    
 
	}
	
	
	public void listAll() {
		/* Method used in option 4 to list all the employees in the
		  array. This method takes no parameters and the return type
		  is void. It is invoked in the main program.*/
				
		System.out.println();
		for (int i = 0; i < count; i++) {
			System.out.println(employees[i].toString());
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
		    	System.out.println("Invalid option. Enter a valid choice: ");
		    	option = scanner.nextInt();
		    	attempts--; // decrementing the number of attempts.
		    	
		    	if (attempts == 0) { // if attempts limit reached, terminate the program.
		    		System.out.println("Program terminated due to 5 invalid choice attempts.");
		    		System.exit(0); // Exit the program
		    		
		    	}
		    }		    
		    	
		    if (option != 1 && option != 5 && company.count == 0) { // forcing the user to input 1 first to add an employee
		    	while (option != 1 && flag == 0) { 
		    		System.out.println("No employees in the company. Enter option 1 to add an employee: ");
		    		option = scanner.nextInt();
		    	    attempts--; // decrementing the number of attempts
		    			
		    		if (attempts == 0) { // if attempts limit reached, terminate the program.
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

