/*________________________________________________________________________________________________________________________
NAME: Joe Wehbe                                                                                                                                                                                                                       
ID#: 202000908                                                                                                                                                                                                                         
COURSE: Objects and Data Abstraction (CSC245)                                                                                                                                                                                          
DATE LAST MODIFIED: 11/15/2021                                                                                                                                                                                                         
OTHER FILES: Node.java, FullyParenthesized.java                                                                                                            
PROGRAM DESCRIPTION: This program implements a stack using linked lists                                        
_________________________________________________________________________________________________________________________
                                                                                                                     */

package question1;

public class Stack {
	
	// Defining variables
	private Node header;
	
	// Constructor
	public Stack() {
		header = null;
	}

	// Getter and setter for header
	public Node getHeader() {
		return header;
	}

	public void setHeader(Node header) {
		this.header = header;
	}
	
	public boolean isEmpty() {
		/* Method used to check if the linked list is empty
		   It takes no parameters and the return type is boolean.		 
		 */
		return (header == null);
	}
	
	public void push(String i) {
		/* Method used to add to the beginning of the linked list.
		   It takes a String as parameter and the return type is void.		 
		 */
		Node n = new Node(i); 
		if (isEmpty()) { 
			header = n;
		}
		
		else {
			n.setNext(header);
			header = n;
		}
	}
	
	public String pop() {
		/* Method used to delete the first node in the LL.
		   It takes no parameters and the return type is String.		 
		 */
		if (isEmpty()) {
			return "empty";
		}
		
		else {
			Node temp = header;
			header = header.getNext();
			temp.setNext(null); // deleting node
			return temp.getData();			
		}
	}
	
	public String peek() {
		/* Method used to return the element in the first node of the LL.
		   It takes no parameters and the return type is String.		 
		 */
		if (isEmpty()) {
			return "empty";
		}
		
		else {
			return header.getData();			
		}
	}

}
