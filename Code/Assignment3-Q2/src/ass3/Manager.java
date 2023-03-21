package ass3;

public class Manager extends Employee{
	
	// Defining variables
	private String secretary;
	private final double BONUS = 0.02; // Used when raising the salary of a manager
	
	// Constructor of the class
	public Manager(String name, String hireDay, double salary, String secretary) {
		super(name, hireDay, salary);
		this.secretary = secretary;
	}
	
	// toString method for a manager
	public String toString() {
		return "M " + super.toString() + " (secretary: " + secretary + ")";
	}
	
	// Method used to add a 2% bonus to a manager
	public double addBonus() {
		return BONUS;
	}

}
