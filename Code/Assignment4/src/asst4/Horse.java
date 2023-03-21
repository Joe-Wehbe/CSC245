package asst4;

public class Horse extends Animal {
	
	// Constructor of the class
	public Horse (int age, String color, String gender) {
		super(age, color, gender); // inherits the characteristics from class Animal
	}
	
	// Implementing the abstract methods of class Animal
	public void eat() {
		System.out.println("I consume 5.4 to 6.8 kg of food a day.");	
	}
	
	public String toString() {
		return " - HORSE >> " + "(Age: " + age + ") (Color: " + color + ") (Gender: " + gender + ")";
	}
	
	public String transferData() {
		return "horse" + ", " + color + ", " + age + ", " + gender;
	}
}
