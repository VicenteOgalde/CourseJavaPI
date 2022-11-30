package OOP;

import java.util.Date;
import java.util.GregorianCalendar;

public class TestForAbstractClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person[] persons= new Person[2];
		persons[0]=new Employee2("luis", 25000, 1998, 5, 22);
		persons[1]= new Student("lucho","spanish");
		
		for(Person p:persons) {
			System.out.println(p.getDescription());
		}

	}
	
}
	abstract class Person{
		private String name;
		public Person(String name) {
			this.name=name;
		}
		public Person() {}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public abstract String getDescription();
		
	}
	
	
	
 class Employee2 extends Person {
	
	
	private double salary;
	private Date contractF;
	
	public Employee2(String name,double salary,int year, int month, int day) {
		super(name);
		this.salary=salary;
		this.contractF=new GregorianCalendar(year,month-1,day).getTime();
		
	}
	public Employee2(String name) {
		this(name,30000,2000,01,01);//call the other class constructor
	}
	public Employee2() {}

	public double getSalary() {
		return this.salary;
	}
	public void setSalary(double salary) {
		this.salary=salary;
	}
	public Date getContractF() {
		return this.contractF;
	}
	public void setContractF(Date date) {
		this.contractF=date;
	}
	public void upgradeSalary(double percentage) {
		this.salary=this.salary+(this.salary*percentage/100);
	}
	@Override
	public String getDescription() {
		
		return "Employee name is: "+this.getName()+" with salary: "+this.getSalary();
	}
	

}


class Student extends Person{
	public Student(String name, String course) {
		super(name);
		this.course=course;
	}
	private String course;
	
	
	
	public String getCourse() {
		return course;
	}



	public void setCourse(String course) {
		this.course = course;
	}



	@Override
	public String getDescription() {
		return "Student name: "+this.getName()+", course: "+this.getCourse();
	}
}


