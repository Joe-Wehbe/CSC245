package assignment1;

public class Employee {
	
	// defining variables
	private String name;
	private String hireDay;
	private double salary;
	
	// constructor of the class
	public Employee (String name, String hireDay, double salary) {
		this.name = name;
		this.hireDay = hireDay;
		this.salary = salary;
		
	}
	
	// GETTERS AND SETTERS	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getHireDay() {
		return hireDay;
	}
	
	public void setHireDay(String hireDay) {
		this.hireDay = hireDay;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	// equals() and toString()
	public boolean equals(Employee e) {
		if (e.getName() == name && e.getHireDay() == hireDay) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return ">> (name: " + name + ") (hire day: " + hireDay + ") (Salary: " + salary + ")";
	}

}
