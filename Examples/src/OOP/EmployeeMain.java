package OOP;

public class EmployeeMain {

	public static void main(String[] args) {
		/*
		Employee employee = new Employee("ada", 85000, 1998,12 , 21);
		Employee employee2 = new Employee("sol", 80000, 1995,11 , 26);
		Employee employee3 = new Employee("luna", 70000, 1994,10 , 29);
		
		employee.upgradeSalary(10);
		employee2.upgradeSalary(10);
		employee3.upgradeSalary(10);
		System.out.println("Name : "+employee.getName()+"with salary : "+employee.getSalary()+
				",date finish contract: "+employee.getContractF());*/
		
		Employee [] employees=new Employee[3];
		employees[0]= new Employee("ada", 85000, 1998,12 , 21);
		employees[1]= new Employee("sol", 80000, 1995,11 , 26);
		employees[2]= new Employee("luna", 70000, 1994,10 , 29);
		
		for(Employee employee:employees) {
			employee.upgradeSalary(5);
			System.out.println("Name: "+employee.getName()+" have this salary now: "+employee.getSalary());
		}
	}

}
