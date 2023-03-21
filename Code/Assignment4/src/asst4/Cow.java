package asst4;

public class Cow extends Animal {
	
	// Constructor of the class
	public Cow (int age, String color, String gender) {
		super(age, color, gender); // inherits the characteristics from class Animal
	}
	
	// Implementing the abstract methods of class Animal
	public void eat() {
		System.out.println("I consume 18 to 25 Kg of food a day.");
	}
	
	public String toString() {
		return " - COW >> " + "(Age: " + age + ") (Color: " + color + ") (Gender: " + gender + ")";
	}
	
	public String transferData() {
		return "cow" + ", " + color + ", " + age + ", " + gender;
	}

}
