package asst4;

public class Goat extends Animal {
	
	// Constructor of the class
	public Goat (int age, String color, String gender) {
		super(age, color, gender); // inherits the characteristics from class Animal
	}
	
	public void eat() {
		System.out.println("I consume 1 to 2 Kg of food a day.");
	}
	
	public String toString() {
		return " - GOAT >> " + "(Age: " + age + ") (Color: " + color + ") (Gender: " + gender + ")";
	}
	
	public String transferData() {
		return "goat" + ", " + color + ", " + age + ", " + gender;
	}

}
