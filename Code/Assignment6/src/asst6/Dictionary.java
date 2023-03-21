/*________________________________________________________________________________________________________________________
NAME: Joe Wehbe                                                                                                                                                                                                                       
ID#: 202000908                                                                                                                                                                                                                         
COURSE: Objects and Data Abstraction (CSC245)                                                                                                                                                                                          
DATE LAST MODIFIED: 12/12/2021                                                                                                                                                                                                         
OTHER FILES: Node.java, dictionary.txt                                                                                                                
PROGRAM DESCRIPTION: This program simulates a dictionary where the user can add, delete, search, and print 
                     the content of the dictionary.                                                
_________________________________________________________________________________________________________________________
                                                                                                                     */
package asst6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dictionary {
	
	private Node root; 
	Scanner scanStr = new Scanner(System.in); // Scanner for strings
	
	// Constructor of the class
	public Dictionary() {
		root = null;
	}
	
	// Getters and Setters
	public Node getRoot() {
		return root;
	}
	
	public void setRoot(Node root) {
		this.root = root;
	}
	
	public Node add(Node r, String word, String description) {
		/* Method used to add a node to the BST, it takes a Node
		   and 2 strings as parameters and the return type is Node		 
		 */
		Node n = new Node(word, description);
		if (r == null) { // if there is no tree
			r = n; // we add the first node
			return r;
		}
		
		
		// if the first letter of the first word is less than or equal to the first first letter of the  second word
		if (n.getWord().compareTo(r.getWord()) == -1 || n.getWord().compareTo(r.getWord()) == 0) { 
			r.setLeft(add(r.getLeft(), word, description));
		}
		// if the first letter of the first word is greater than the first letter of the second word
		else {
			r.setRight(add(r.getRight(), word, description));
		}
		return r;
		
	}
	
	public void addDefinition() {
		/* Method used in choice 2 to add a node, it takes no
		  parameters and the return type is void	 
		 */
		
		// Asking for the word
		System.out.println("Enter a word: ");
		String word = scanStr.next();
		
		// Asking for the description
		System.out.println("Enter a description: ");
		String description = scanStr.next();
		
		boolean areEqual = checkEquals(root, word, description);
		
		if (areEqual == true) { // if the word and the description entered already exist
			System.out.println("Definition already exists.");
		}
		
		else { 
			root = add(root, word, description);
			System.out.println("Definitiona added.");
		}
		
		
	}
	
	public boolean checkEquals(Node r, String word, String d) {
		/* Method invoked in the method addDefinition() that checks
		  wheter two words are equal or not. It takes a Node and 
		  2 strings as parameters and the return type is boolean	 
		 */
		
		if (r == null) { // if there is no words in the tree
			return false;
		}
		
		// if the first letter of the first word is less than or equal to the first first letter of the  second word
		if (word.compareTo(r.getWord()) == -1 || word.compareTo(r.getWord()) == 0) {
			search(r.getLeft(), word);
		}
		
		// if the first letter of the first word is greater than the first letter of the second word
		if (word.compareTo(r.getWord()) == 1) {
			search(r.getRight(), word);
		} 
		
		// if the word is found
		if (word.equals(r.getWord()) && d.equals(r.getDescription())) {
			return true;
		}
		return false;
		
	}
	
	public String search(Node r, String word) {
		/* Method used to search for a specific definition, it
		  takes a Node and a string as parameters and the return type is void	 
		 */
		if (r == null) { // if there is no definitions
			return "Not found";
		}
		
		// if the word is found
		if (word.equalsIgnoreCase(r.getWord())) {
			return r.getDefinition();
		}
		// if the first letter of the first word is less than or equal to the first first letter of the  second word
		if (word.compareTo(r.getWord()) == -1 || word.compareTo(r.getWord()) == 0) {
			return search(r.getLeft(), word);
		}
		
		else  { 	// if the first letter of the first word is greater than the first letter of the second word
			return search(r.getRight(), word);
		}	
		
	}
	
	public void searchDefinition() {
		/* Helper method used in choice 4, it
		  takes no parameters and the return type is void 
		 */
		System.out.println("Enter a word: ");
		String word = scanStr.next();
		
		System.out.println(search(root, word));
	}

	public void inOrder(Node r){
		/* Method used to print the elements in 
		 the BST, it takes a node as parameter
		 and the return type is void	 
		 */
		if (r != null) {		
			inOrder(r.getLeft());
			System.out.println(r.getDefinition());
			inOrder(r.getRight());
		}
		
	}
	
	public void inOrderTrav() {
		/* Helper method used in choice 5, it
		  takes no parameters and the return type is void 
		 */
		System.out.println();
		inOrder(root);
	}
	
	public void copyFile() {
		/* Method used to add the content of the file to the binary search tree,
		   it takes no parameters and the return type is void		 
		*/
		
		// directory of the file
		String directory = "C:\\Users\\hp\\Desktop\\Fall 2021\\CSC245 (2)\\Workspaces\\AssignmentsWorkspace\\Assignment6\\src\\asst6\\dictionary.txt";
		
		File file = new File(directory); 
		
		try {
			@SuppressWarnings("resource")
			Scanner scan_file = new Scanner(file);	
			
			System.out.println();
			System.out.println("The following definitions are added: ");
			System.out.println("-----------------------------------");
			
			while (scan_file.hasNextLine()) { // iterating over the lines in the file
				
				String[] line = scan_file.nextLine().split(": ");
				System.out.print(line[0] + ": "); // word
				System.out.println(line[1]); // description
				
				// Storing the values of each lines in variables
				String word = line[0];
				String description = line[1];
				root = add(root, word, description); // adding to the BST
			}
			
		} catch(FileNotFoundException e) { // in case the file is not foud
			System.out.println("File not found.");
		}		
	}
	
	public void createDictionary() {
		/* Helper method used in choice 1, it
		  takes no parameters and the return type is void 
		 */
		
		// Asking for the name of the file
		System.out.println("Enter file name: ");
		String fileName = scanStr.next();
		
		byte flag = 1; // used to run the loop
		byte attempts = 2; 
		
		while (flag == 1) {
			if (fileName.equals("dictionary")) { // valid name entered
				copyFile();
				System.out.println();
				flag = 0; // stop the loop
			}
			else { // invalid file name entered
				System.out.println();
				System.out.println("Enter a valid file name.");
				System.out.println("Available files:");
				System.out.println("----------------");
				System.out.println("--> \"dictionary\"");
				fileName = scanStr.next();
				attempts--;
				if (attempts == 0) {
					flag = 0; // stop the loop after 3 attempts
				}
			}
		}
	}

	
	public void exitProgram() {
		/* Method used in choice 6 to exit the program, it
		  takes no parameters and the return type is void 
		 */
		System.out.println();
		System.out.println("Program terminated.");
		System.exit(0); 
	}
	
	// Main program
	public static void main(String[] args) {
		
		Dictionary d = new Dictionary();
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		byte flag = 1; // used to run the loop
		byte attempts = 4; // attempts
		
		while (flag == 1) {
		
			// MAIN MENU
			System.out.println();
			System.out.println("1. Create the dictionary\n"
					+ "2. Add a definition\n"
					+ "3. Remove a definition\n"
					+ "4. Search for a definition\n"
					+ "5. Print Dictionary\n"
					+ "6. Exit\n"
					+ "--------------------------\n"
					+ "Enter your choice:" );
				
			int choice = scanner.nextInt();
			
			while (choice < 1 || choice > 6) { // loop to force the user to enter a choice between 1 and 6
				System.out.println("Invalid choice, enter again: ");
				choice = scanner.nextInt();
				attempts--;
				
				if (attempts == 0 && choice != 1 && choice != 2 && choice != 6) { // 5 attempts done
					System.out.println("Program terminated due to 5 invalid choices");
					System.exit(0); // exit
				}				
			}
			
			// loop to force the user to add nodes to the tree in case there is not, or exit the program
			while (choice > 0 && choice < 7 && choice != 1 && choice != 2 && choice != 6 && d.root == null) {
				System.out.println("No definitions added. Available choices: ");
				System.out.println("---------------------------------");
				System.out.println("--> 1. Create the dictionary.");
				System.out.println("--> 2. Add a definition");
				System.out.println("--> 6. Exit");
				choice = scanner.nextInt();
				attempts--;
				
				if (attempts == 0 && choice != 1 && choice != 2 && choice != 6) { // 5 attempts done
					System.out.println("Program terminated due to 5 invalid choices");
					System.exit(0); // exit
				}				
			}
			switch(choice) {
			
			case 1:
				d.createDictionary();
				break;
				
			case 2:
				d.addDefinition();
				break;
				
			case 3:
				break;
				
			case 4: 
				d.searchDefinition();
				break;
				
			case 5:
				d.inOrderTrav();
				break;
				
			case 6:
				d.exitProgram();
				break;
			
			default:
				break;
			}
		}		
		
	}

}


