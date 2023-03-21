package asst4;

public class Lamb extends Animal {
	
	// Constructor of the class
	public Lamb (int age, String color, String gender) {
		super(age, color, gender); // inherits the characteristics from class Animal
	}
	
	// Implementing the abstract methods of class Animal
	public void eat() {
		System.out.println("I consume 2 Kg of food a day.");
	}
	
	public String toString() {
		return " - LAMB >> " + "(Age: " + age + ") (Color: " + color + ") (Gender: " + gender + ")";
	}
	
	public String transferData() {
		return "lamb" + ", " + color + ", " + age + ", " + gender;
	}

}
