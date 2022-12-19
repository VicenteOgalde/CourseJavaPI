package instrospection;

public class EmployeeImpl {

	public static void main(String[] args)  {
		
		Person per1 = new Person("per1");
		Person emp1= new Employee("emp1", 5000);
		//System.out.println(per1.getClass());
		//System.out.println(emp1.getClass());
		//Class cl = emp1.getClass();
		//System.out.println(cl.getName());
		
		String className="instrospection.Employee";
		
		Class cl;
		
		try {
			cl=Class.forName(className);
			System.out.println(cl.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}

}

class Person{
	
	private String name;
	
	public Person(String name){
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name){
		this.name=name;
	}
	
}
class Employee extends Person{
	
	private double salary;

	public Employee(String name,double salary) {
		super(name);
		this.salary=salary;
		
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void setBonus(double bonus) {
		this.salary = salary+bonus;
	}
}
