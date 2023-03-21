
/*________________________________________________________________________________________________________________________
NAME: Joe Wehbe                                                                                                                                                                                                                       
ID#: 202000908                                                                                                                                                                                                                         
COURSE: Objects and Data Abstraction (CSC245)                                                                                                                                                                                          
DATE LAST MODIFIED: 10/17/2021                                                                                                                                                                                                         
OTHER FILES: Animal.java, Chicken.java, Cow.java, Goat.java, Horse.java, Lamb.java, Node.java, Sortable.java, Farm.java, 
             input.txt, output.txt                                                                                                             
PROGRAM DESCRIPTION: This program copies the content of a file (input.txt), adds it to an array, sorts the array,
                     then copies the content of the sorted array to another file (output.txt)                                            
_________________________________________________________________________________________________________________________
                                                                                                                     */

package asst4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class TestProgram {
	
	final static int SIZE = 5; 

	public static void sort(Sortable[] items) {
	//sorts an array of items in an increasing order as specified in the compareTo() method	
    
		for (int i = 1; i < items.length; i++ ) {
			Sortable key  = items[i];
			int position = i;
			while (position > 0 && items[position-1].compareTo(key) > 0) {
					items[position]=items[position-1];
					position--;
			}
			items[position]=key;
		}
	}
	
	
	public static void show(Sortable[] items) {
		for (int i = 0; i < items.length; i++ ) {
			 if (items[i]!= null) {
			 	System.out.print(items[i]);
			 }
		}
	}

		
    public static void main (String[] args) {
        Animal[] animals= new Animal[SIZE];

    /*  enter here code to read information from a file that you will name ”input.txt”. 
   		Each line in the file specifies an object. 
   		The first word on each line specifies the type of the object (horse, lamb, chicken, etc.). 
   		Then, the remaining tokens on the line specify the features/characteristics of the animal. 
   		Have the code create the objects and add them to the array animals. */
        
        int counter = 0; // Variable used to point at an index in the array when adding
        
        // Directory of input.txt
        String directory = "C:\\Users\\hp\\Desktop\\Fall 2021\\CSC245 (2)\\Workspaces\\AssignmentsWorkspace\\Assignment4\\src\\asst4\\input.txt";
        
        File file = new File(directory); 
       
        try {
        	
        	@SuppressWarnings("resource")
			Scanner scan_file = new Scanner(file);
        	
        	System.out.println("The following information are added to the array: ");
        	System.out.println("------------------------------------------------");
            	
        	while (scan_file.hasNextLine()) { // loop to scan each line
        	
        		String[] line = scan_file.nextLine().split(", ");
        	
        		System.out.print(line[0] + ", "); // type
        		System.out.print(line[1] + ", "); // color
        		System.out.print(line[2] + ", "); // age
        		System.out.println(line[3]); // gender
        	
        		// Storing the info in each line in a variable
        		String type = line[0].trim().toLowerCase(); // animal type
        		String color = line[1]; // color
        		int age = Integer.parseInt(line[2]); // afe
        		String gender = line[3]; // gender
        	
        		switch (type) {
        	
        		case "chicken": // if the line contains a chicken
        		
        			Animal chicken = new Chicken(age, color, gender);
        			animals[counter] = chicken; // adding to the array
        			counter++;
        			break;
        		
        		case "cow": // if the line contains a cow
        		
        			Animal cow = new Cow(age, color, gender);
        			animals[counter] = cow; // adding to the array
        			counter++;
        			break;
        		
        		case "goat": // if the line contains a goat
        		
        			Animal goat = new Goat(age, color, gender);
        			animals[counter] = goat; // adding to the array
        			counter++;
        			break;
        		
        		case "horse": // if the line contains a horse
        		
        			Animal horse = new Horse(age, color, gender);
        			animals[counter] = horse; // adding to the array
        			counter++;
        			break;
        		
        		case "lamb": // if the line contains a lamb
        		
        			Animal lamb = new Lamb(age, color, gender);
        			animals[counter] = lamb; // adding to the array
        			counter++;
        			break;
        		
        		default:
        			System.out.println("Invalid information in the line."); // In case of invalid info in the line
        			break;
        			
        		}
        	}
        } // If the file is not found
        catch (FileNotFoundException e) {
        	System.out.println("File not found.");
        }
        
        sort(animals); // sorting 
		show(animals); // printing
        
        // Directory of output.txt
        String output_directory = "C:\\Users\\hp\\Desktop\\Fall 2021\\CSC245 (2)\\Workspaces\\AssignmentsWorkspace\\Assignment4\\src\\asst4\\output.txt";
		
		try {
			
			FileWriter fw = new FileWriter(output_directory);
			PrintWriter pw = new PrintWriter(fw);
			
			// Printing the content of the sorted array to output.txt
			for (int i = 0; i < animals.length; i++) {
				pw.println(animals[i].transferData());				
			
			}
			pw.close();
			
			
		// File not found
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			
		// IO exception
		} catch (IOException e) {
			System.out.println("IO excpetion.");
		}	
		
		
	}
		
}


