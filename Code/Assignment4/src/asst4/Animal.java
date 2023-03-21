package asst4;

public abstract class Animal implements Sortable { // If this class implements Sortable, all its subclass will do so.
	
	// defining variables
	protected int age;
	protected String color;
	protected String gender;
	
	// Constructor of the class
	public Animal(int age, String color, String gender) {
		this.age = age;
		this.color = color;
		this.gender = gender;
	}

	// Getters and Setters
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGender() {
		return gender;
	}
		
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	// Implementing the method compareTo() of class Sortable
    public int compareTo(Object o) {
		
		if (((Animal)o).getAge() < age) {
			return 1;
		}
		
		else if (((Animal)o).getAge() > age) {
			return -1;
		}
		return 0;
	}
	
	public abstract String toString(); // used in all subclasses to display the information of a specifi animal
	public abstract void eat(); // used in all subclasses to specify the amount of food consumed per day
	public abstract String transferData(); // used in all subclasses to copy the content of the sorted arrays to output.txt

}
