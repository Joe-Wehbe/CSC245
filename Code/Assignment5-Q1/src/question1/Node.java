/*________________________________________________________________________________________________________________________
NAME: Joe Wehbe                                                                                                                                                                                                                       
ID#: 202000908                                                                                                                                                                                                                         
COURSE: Objects and Data Abstraction (CSC245)                                                                                                                                                                                          
DATE LAST MODIFIED: 11/15/2021                                                                                                                                                                                                         
OTHER FILES: FullyParenthesized.java, Stack.java                                                                                                            
PROGRAM DESCRIPTION: This program creates a node, used in the implementation of stacks using linked lists                                         
_________________________________________________________________________________________________________________________
                                                                                                                     */

package question1;

public class Node {
	
	// defining variables
	private Node next;
	private String data;
	
	// Constructor
	public Node(String data) {
		this.data = data;
		next = null;
		
	}

	// Getters and setters
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	

}
