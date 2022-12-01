package oop;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Comparable<Employee>{
	
	private String name;
	private double salary;
	private Date contractF;
	
	public Employee(String name,double salary,int year, int month, int day) {
		this.name=name;
		this.salary=salary;
		this.contractF=new GregorianCalendar(year,month-1,day).getTime();
		
	}
	public Employee(String name) {
		this(name,30000,2000,01,01);//call the other class constructor
	}
	public Employee() {}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name=name;
	}
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
	public int compareTo(Employee o) {
		if(this.getSalary()<o.getSalary()) {
			return -1;
		}else if(this.getSalary()>o.getSalary()) {
			return 1;
		}else {
			return 0;
		}
		
		
	}
	

}
