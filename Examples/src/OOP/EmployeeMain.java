package OOP;

public class EmployeeMain {

	public static void main(String[] args) throws CloneNotSupportedException{
		/*
		Employee employee = new Employee("ada", 85000, 1998,12 , 21);
		Employee employee2 = new Employee("sol", 80000, 1995,11 , 26);
		Employee employee3 = new Employee("luna", 70000, 1994,10 , 29);
		
		employee.upgradeSalary(10);
		employee2.upgradeSalary(10);
		employee3.upgradeSalary(10);
		System.out.println("Name : "+employee.getName()+"with salary : "+employee.getSalary()+
				",date finish contract: "+employee.getContractF());*/
		
		Boss bossRRHH = new Boss("jon",100000,2000,12,12);
		
		bossRRHH.setBonus(25000);
		
		
		Employee [] employees=new Employee[7];
		
		employees[0]= new Employee("ada", 85000, 1998,12 , 21);
		employees[1]= new Employee("sol", 80000, 1995,11 , 26);
		employees[2]= new Employee("luna", 70000, 1994,10 , 29);
		employees[3]=new Employee("user");
		employees[4]=bossRRHH;//polymorphism in action. substitution principle
		employees[5]= new Boss("dix",100000,2001,11,29);
		Boss bossADM=(Boss)employees[5];//casting for using class Boss method
		bossADM.setBonus(250000);
		
		Boss bossARQ=(Boss) bossADM.clone();
		
		bossARQ.setName("ark");
		bossARQ.setBonus(500000);
		bossARQ.setContractF(null);
		employees[6]=bossARQ;
		
		
		
		for(Employee employee:employees) {//variable employee automatically 
			//switches when needed to another class from class Employee to Boss
			//calling the method getSalary() from the subclass Boss when required
			employee.upgradeSalary(5);
			System.out.println("Name: "+employee.getName()+" have this salary now: "+employee.getSalary()
			+" contract finish: "+employee.getContractF());
		}
		
	}

}
