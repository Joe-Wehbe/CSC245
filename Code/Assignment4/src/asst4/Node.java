package asst4;

public class Node {
	
	// defining variables
	private Animal info; 
	private Node next;
	
	// Constructor of the class
	public Node(Animal info) {
		this.info = info;
		next = null;
	}
	
	// Getters and setters
	public Animal getInfo() {
		return info;
	}
	
	public void setInfo(Animal info) {
		this.info = info;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}

}
