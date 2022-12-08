package collectionPractice;

import java.util.HashMap;


public class MapTest {

	public static void main(String[] args) {
		
		HashMap<String, Employee> staff = new HashMap<String, Employee>();
		
		staff.put("228", new Employee("sun"));
		staff.put("148", new Employee("moon"));
		staff.put("286", new Employee("sunnie"));
		staff.put("003", new Employee("greg"));
		
		System.out.println(staff);
		
		staff.remove("003");
		staff.put("228",new Employee("green"));// replace the object
		
		staff.forEach((k,e)-> System.out.println(k+" "+e));
		
		
		

	}

}

class Employee{
	private String name;
	private double salary;
	
	public Employee(String n) {
		this.name=n;
		this.salary=2000;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee Name: " + getName() + ", Salary: " + getSalary();
	}
	
}