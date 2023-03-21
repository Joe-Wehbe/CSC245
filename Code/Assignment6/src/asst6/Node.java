package asst6;

public class Node {
	
	// Defining variables
	private String word;
	private String definition; // first part of a definition
	private String description; // second part of a definition
	private Node left;
	private Node right;
	
	// Constructor of the class
	public Node(String word, String description) {
		this.word = word;
		this.description = description;
		definition = word + ": " + description; // Structure of a definition
		left = right = null;
	}
	
	// Getters and Setters
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
	// Comparing the first letter of words
	public int compareTo(String word1) {
		int ascii = word.charAt(0);
		int ascii1 = word1.charAt(0);
		
		if (ascii < ascii1) {
			return -1;
		}		
		if (ascii == ascii1) {
			return 0;
		}		
		else {
			return 1;
		}
	}
	

}
