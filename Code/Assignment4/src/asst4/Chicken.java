package asst4;

public class Chicken extends Animal {
	
	// Constructor of the class
	public Chicken (int age, String color, String gender) {
		super(age, color, gender); // inherits the characteristics from class Animal
	}
	
	// Implementing the abstract methods of class Animal
	public void eat() {
		System.out.println("I consume 0.25 kg of food a day.");	
	}
	
	public String toString() {
		return " - CHICKEN >> " + "(Age: " + age + ") (Color: " + color + ") (Gender: " + gender + ")";
	}
	
	public String transferData() {
		return "chicken" + ", " + color + ", " + age + ", " + gender;
	}

}
